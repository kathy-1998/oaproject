package cn.bdqn.oaproject.controller.sysmanage.log;


import cn.bdqn.oaproject.pojo.OperateLog;
import cn.bdqn.oaproject.pojo.Role;
import cn.bdqn.oaproject.pojo.Users;
import cn.bdqn.oaproject.service.sysmanage.OperateLogService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/log")
public class OperateLogController {

    @Autowired
    OperateLogService operateLogService;


    /**
     * 访问页面
     */

    @RequestMapping("/operation_log.html")
    public  Object operation_log(){

        return "operation_log";
    }


    @RequestMapping("/logList.html")
    @ResponseBody
    public Object logList(
                   /*         @RequestParam(value = "userName", required = false) String userName,
                            @RequestParam(value = "startTime", required = false) String startTime,
                            @RequestParam(value = "endTime", required = false) String endTime ,
                            @RequestParam(value = "pageIndex", required = false) String pageindex,
                            @RequestParam(value = "pageSize", required = false) Integer pageSize*/
                             ) {

        String pageindex="0";

        String userName="";


        Date startTime=new Date("2019/4/1");

        Date endTime=new Date("2019/4/19");



        if (pageindex.equals("undefined")) {
            pageindex = "1";
        }
        Pageable pageable = new PageRequest(0, 2);

        Page<Users> list = null;

        //specification是jpa用来动态查询的一个接口
        Specification specification = new Specification<OperateLog>() {

            public Predicate toPredicate(Root root, CriteriaQuery criteriaQuery, CriteriaBuilder cb) {
                List<Predicate> predicates = new ArrayList<>();

                //判断用户名
                if (!userName.equals("undefined") && !userName.equals("")) {
                    predicates.add(cb.like(root.get("users").get("userName").as(String.class), "%" + userName + "%"));
                }


                predicates.add(cb.between(root.get("creationDate"),startTime,endTime));

                return cb.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        };

        list = operateLogService.findAll(specification, pageable);

        String json= JSON.toJSONString(list,true);

        System.out.println(json);


        return list;

    }












}
