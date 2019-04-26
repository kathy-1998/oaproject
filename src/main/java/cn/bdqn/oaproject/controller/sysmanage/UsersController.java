package cn.bdqn.oaproject.controller.sysmanage;

import cn.bdqn.oaproject.dao.sysmanage.UsersDao;
import cn.bdqn.oaproject.pojo.Dept;
import cn.bdqn.oaproject.pojo.Job;
import cn.bdqn.oaproject.pojo.Role;
import cn.bdqn.oaproject.pojo.Users;
import cn.bdqn.oaproject.service.sysmanage.UsersService;
import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.node.JsonNodeCreator;
import jdk.nashorn.internal.runtime.JSONFunctions;
import org.apache.catalina.User;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileOutputStream;
import java.util.*;

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
    public String userManage() {


        return "user_manage";
    }


    @RequestMapping("/userList.html")
    @ResponseBody
    public Object UserList(
            @RequestParam(value = "userName", required = false) String userName,
            @RequestParam(value = "realName", required = false) String realName,
            @RequestParam(value = "pageIndex", required = false) String pageindex,
            @RequestParam(value = "pageSize", required = false) Integer pageSize
    ) {

        //结果集合
        Map<String, Object> resultMap = new HashMap<>();


        if (pageindex.equals("undefined")) {
            pageindex = "1";
        }
        Pageable pageable = new PageRequest(Integer.parseInt(pageindex) - 1, pageSize);

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

        resultMap.put("userList", list);

        //当前页码
        resultMap.put("pageIndex", pageindex);
        //从页码
        resultMap.put("pageCount", list.getTotalPages());

        String json = JSON.toJSONString(resultMap, true);
        System.out.println(json);
        return resultMap;

    }


    /**
     * 删除
     */
    @RequestMapping("/del")
    @ResponseBody
    public Object delUsers(@RequestParam("id") String id) {


        boolean result = usersService.deleteById(Integer.parseInt(id));

        return result;
    }


    @RequestMapping("/getUsersbyId")
    @ResponseBody
    public Object getUsersbyId(@RequestParam("userId") Integer userId) {
        Users users = usersService.findUsersByUserId(userId);

        return users;
    }


    @RequestMapping(value = "/addUsers")
    @ResponseBody
    public Object add(@RequestParam(value = "userName", required = false) String userName,
                      @RequestParam(value = "password", required = false) String password,
                      @RequestParam(value = "realName", required = false) String realName,
                      @RequestParam(value = "deptId", required = false) Integer deptId,
                      @RequestParam(value = "sex", required = false) Integer gender,
                      @RequestParam(value = "jobId", required = false) Integer jobId,
                      @RequestParam(value = "roleId", required = false) Integer roleId,
                      @RequestParam(value = "status", required = false) Integer status,
                      @RequestParam(value = "myfile", required = false) MultipartFile file
                         ) {

                Users user = new Users();

                Job job = new Job();
                job.setJobId(jobId);

                Dept dept = new Dept();
                dept.setDeptId(deptId);

                Role role = new Role();
                role.setRoleId(roleId);

                user.setUserName(userName);
                user.setCreator(1);
                user.setCreationDate(new Date());
                user.setGender(gender);
                user.setIsdelete(1);
                user.setJob(job);
                user.setDept(dept);
                user.setUserPwd(password);
                user.setStatus(status);
                user.setRole(role);
                user.setRealName(realName);

                if(roleId!=5){
                    //表示选择的不是普通用户
                    user.setIsadmin(0);
                }

        if (file != null) {
            String fileName = file.getOriginalFilename();

            if (fileName.indexOf("\\") != -1) {
                fileName = fileName.substring(fileName.lastIndexOf("\\"));
            }
            String filePath = "src/main/resources/static/files/images/";
            File targetFile = new File(filePath);
            if (!targetFile.exists()) {
                targetFile.mkdirs();
            }

            FileOutputStream out = null;
            try {
                out = new FileOutputStream(filePath + fileName);
                out.write(file.getBytes());
                out.flush();
                out.close();
            } catch (Exception e) {
                e.printStackTrace();
                return "上传失败";
            }

            user.setUserUrl(fileName);
        }
        //执行保存

        if (usersService.add(user)) {
            return "添加成功";
        } else {
            return "添加失败";
        }


    }


    @RequestMapping(value = "/modify")
    @ResponseBody
    public Object modify(@RequestParam(value = "userName", required = false) String userName,
                         @RequestParam(value = "password", required = false) String password,
                         @RequestParam(value = "realName", required = false) String realName,
                         @RequestParam(value = "deptId", required = false) Integer deptId,
                         @RequestParam(value = "sex", required = false) Integer gender,
                         @RequestParam(value = "jobId", required = false) Integer jobId,
                         @RequestParam(value = "roleId", required = false) Integer roleId,
                         @RequestParam(value = "userId", required = false) Integer userId,
                         @RequestParam(value = "status", required = false) Integer status,
                         @RequestParam(value = "myfile", required = false) MultipartFile file
                        ) {

                Users user = new Users();
                user.setUserId(userId);
                Job job = new Job();
                job.setJobId(jobId);
                Dept dept = new Dept();
                dept.setDeptId(deptId);
                Role role = new Role();
                role.setRoleId(roleId);
                user.setUserName(userName);
                user.setMender(1);
                user.setModifyDate(new Date());
                user.setGender(gender);
                user.setIsdelete(1);
                user.setJob(job);
                user.setDept(dept);
                user.setUserPwd(password);
                user.setStatus(status);
                user.setRole(role);
                user.setRealName(realName);


                if(roleId!=5){
                //表示选择的不是普通用户
                    user.setIsadmin(0);
                }

         if (file != null) {
            String fileName = file.getOriginalFilename();

            if (fileName.indexOf("\\") != -1) {
                fileName = fileName.substring(fileName.lastIndexOf("\\"));
            }
            String filePath = "src/main/resources/static/files/images/";
            File targetFile = new File(filePath);
            if (!targetFile.exists()) {
                targetFile.mkdirs();
            }

            FileOutputStream out = null;
            try {
                out = new FileOutputStream(filePath + fileName);
                out.write(file.getBytes());
                out.flush();
                out.close();
            } catch (Exception e) {
                e.printStackTrace();
                return "上传失败";
            }

            user.setUserUrl(fileName);

            //执行修改
        }
        if (usersService.add(user)) {
            return "修改成功";
        } else {
            return "修改失败";
        }


    }


    /**
     * 查出所有领导级的用户
     */
    @RequestMapping("/leadList")
    @ResponseBody
    public  Object leadUsersList(){

        return usersService.findUsersByIsadmin(0);
    }
    @RequestMapping("/getRealNameById.find")
    @ResponseBody
    public String getRealNameById(Integer uid){
        String userName="";
        Users users=usersService.findUsersByUserId(uid);
        userName=users.getRealName();
        return userName;
    }



}

