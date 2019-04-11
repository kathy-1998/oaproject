package cn.bdqn.oaproject.controller.sysmanage.users;

import cn.bdqn.oaproject.dao.sysmanage.UsersDao;
import cn.bdqn.oaproject.pojo.Users;
import cn.bdqn.oaproject.service.sysmanage.UsersService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/users")
public class UsersController {

    @Autowired
    UsersService usersService;

    @RequestMapping(value = "/user_manage.html")
    public String user_manage(@RequestParam(value = "username",required = false)String username,
                              @RequestParam(value = "realName",required = false)String realName,
                              @RequestParam(value = "pageindex",required = false)Integer pageindex,
                              @RequestParam(value = "pageSize",required = false)Integer pageSize){
        //结果集
        Page<Users> resultList = null;


        if(null == pageindex){
            pageindex=0;
        }
        if(null == pageSize){
            pageSize=1;
        }

        //条件
        //jpa自动的分页  pageble是接口,pageRequest是接口的实现类
        Pageable pageable=new PageRequest(pageindex,pageSize);


        //specification是jpa用来动态查询的一个接口
        Specification querySpecifi = new Specification<Users>() {
            @Override
            public Predicate toPredicate(Root<Users> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {

                List<Predicate> predicates = new ArrayList<>();

                if(null != username){
                    predicates.add(criteriaBuilder.like(root.get("userName"), "%"+username+"%"));
                }
                if(null != realName){
                    predicates.add(criteriaBuilder.like(root.get("realName"), "%"+realName+"%"));
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        };
             resultList =  usersService.findAll(querySpecifi,pageable);


        return "user_manage.html";
    }
}
