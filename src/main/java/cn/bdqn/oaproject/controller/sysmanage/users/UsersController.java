package cn.bdqn.oaproject.controller.sysmanage.users;

import cn.bdqn.oaproject.dao.sysmanage.UsersDao;
import cn.bdqn.oaproject.pojo.Users;
import cn.bdqn.oaproject.service.sysmanage.UsersService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.criteria.Predicate;

@Controller
@RequestMapping("/users")
public class UsersController {

    @Autowired
    UsersService usersService;



}
