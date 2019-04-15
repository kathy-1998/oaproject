package cn.bdqn.oaproject.controller.sysmanage.Role;


import cn.bdqn.oaproject.service.sysmanage.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    RoleService roleService;

    @RequestMapping("/roleList")
    @ResponseBody
    public  Object roleList(){

        return  roleService.findAll();
    }


}

