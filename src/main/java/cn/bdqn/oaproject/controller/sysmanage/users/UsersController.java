package cn.bdqn.oaproject.controller.sysmanage.users;

import cn.bdqn.oaproject.dao.sysmanage.UsersDao;
import cn.bdqn.oaproject.pojo.Users;
import cn.bdqn.oaproject.service.sysmanage.UsersService;
import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.node.JsonNodeCreator;
import jdk.nashorn.internal.runtime.JSONFunctions;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/users")
public class UsersController {

    @Autowired
    UsersService usersService;


    /**
     * 登录
     */
    @RequestMapping("/doLogin.do")
    @ResponseBody
    public String getUserByUserName(HttpSession session, String userName, String userPwd) {
        System.out.println(userName + ":" + userPwd);
        Users users = usersService.findByUserName(userName);
        String json = "";
        if (users != null) {
            System.out.println("**" + users.getUserPwd());
            if (userPwd.equals(users.getUserPwd())) {
                session.setAttribute("User", users);
                json = JSON.toJSONString(users);
                System.out.println(json);
            } else {
                json = "{}";
            }
        }
        System.out.println(json);
        return json;
    }

    /**
     * 获取当前登录用户
     *
     * @param session 会话
     * @return json
     */
    @RequestMapping("/sessionInfo.do")
    @ResponseBody
    public String getSessionInfo(HttpSession session) {
        Users users = (Users) session.getAttribute("User");
        String json = JSON.toJSONString(users);
        return json;
    }

    /**
     * 修改密码
     *
     * @param pwd
     * @param pid
     * @return Yes为成功
     */
    @RequestMapping("/updatePwd.do")
    @ResponseBody
    public String updatePwd(String pwd, Integer pid) {
        boolean flag = usersService.modify(pwd, pid);
        if (flag) {
            return "Yes";
        } else {
            return "No";
        }
    }

    /**
     * 退出登录
     *
     * @param session
     * @return
     */
    @RequestMapping("/logout.do")
    public String logout(HttpSession session) {
        session.removeAttribute("User");
        Users users = (Users) session.getAttribute("User");
        if (users == null) {
            return "login";
        } else {
            return "framework";
        }
    }


    @RequestMapping("/userManage.html")
    public  String userManage(){



        return "user_manage";
    }



    @RequestMapping("/userList.html")
    @ResponseBody
    public Object UserList(
                            @RequestParam(value = "userName",required = false)String userName,
                           @RequestParam(value = "realName",required = false)String realName,
                            @RequestParam(value = "pageIndex",required = false)String pageindex,
                            @RequestParam(value = "pageSize",required = false)Integer pageSize
                           ) {

        //结果集合
        Map<String,Object> resultMap=new HashMap<>();


        if(pageindex.equals("undefined")){
            pageindex ="1";
        }
        Pageable pageable = new PageRequest(Integer.parseInt(pageindex)-1, pageSize);

        Page<Users> list = null;

        //specification是jpa用来动态查询的一个接口
        Specification specification = new Specification<Users>() {

            public Predicate toPredicate(Root root, CriteriaQuery criteriaQuery, CriteriaBuilder cb) {
                List<Predicate> predicates = new ArrayList<>();

                //判断用户名
                if (!userName.equals("undefined") && !userName.equals("")) {
                    predicates.add(cb.like(root.get("userName").as(String.class), "%" + userName + "%"));
                }
                //判断真实姓名
                if (!realName.equals("undefined") && !realName.equals("")) {
                    predicates.add(cb.like(root.get("realName").as(String.class), "%" + realName + "%"));
                }

             /*   predicates.add(cb.equal(root.get("isdelete").as(Integer.class),1));*/
                return cb.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        };

        list = usersService.findAll(specification, pageable);

        resultMap.put("userList",list);

        //当前页码
        resultMap.put("pageIndex",pageindex);
        //从页码
        resultMap.put("pageCount",list.getTotalPages());

        String json=JSON.toJSONString(resultMap,true);
        System.out.println(json);
        return resultMap;

    }


    /**
     * 删除
     */
    @RequestMapping("/del")
    @ResponseBody
    public  Object delUsers(@RequestParam("id") String id){


         boolean result=usersService.deleteById(Integer.parseInt(id));

        return  result;
    }


    @RequestMapping("/getUsersbyId")
    @ResponseBody
    public Object getUsersbyId(@RequestParam("userId") Integer userId) {
        Users users=usersService.findUsersByUserId(userId);

        return   users;
    }





}

