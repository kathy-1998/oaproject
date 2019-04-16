package cn.bdqn.oaproject.controller.sysmanage.Role;


import cn.bdqn.oaproject.pojo.Role;
import cn.bdqn.oaproject.pojo.Users;
import cn.bdqn.oaproject.service.sysmanage.RoleService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    RoleService roleService;



    @RequestMapping("/role_manage.html")
    public  Object role_manage(){

        return  "role_manage";
    }



    @RequestMapping("/roleList")
    @ResponseBody
    public  Object roleList(){

        return  roleService.findAll();
    }


    @RequestMapping("/PageroleList")
    @ResponseBody
    public  Object PageroleList(  @RequestParam(value = "pageIndex", required = false) String pageindex,
                                  @RequestParam(value = "pageSize", required = false) Integer pageSize){


        if (pageindex.equals("undefined")) {
            pageindex = "1";
        }

        Sort sort=new Sort(Sort.Direction.ASC,"roleSort");


        Pageable pageable = new PageRequest(Integer.parseInt(pageindex) - 1, pageSize,sort);

       Page<Role> roles=roleService.findAll(pageable);

        String json= JSON.toJSONString(roles,true);

        System.out.println(json);

        return roles;
    }


    @RequestMapping("/addRole")
    @ResponseBody
    public  Object addRole(@RequestParam(value = "sort", required = false) Integer sort,
                             @RequestParam(value = "roleName", required = false) String roleName){



        Role role=new Role();
        role.setCreator(1);
        role.setCreationDate(new Date());
        role.setIsdelete(1);
        role.setRoleSort(sort);
        role.setRoleName(roleName);

        if(roleService.Add(role)){
            return "true";
        }else{
            return  "false";
        }



    }


    @RequestMapping("/updateRole")
    @ResponseBody
    public  Object updateRole(  @RequestParam(value = "pageIndex", required = false) String pageindex,
                             @RequestParam(value = "pageSize", required = false) Integer pageSize,
                             @RequestParam(value = "sort", required = false) Integer sort,
                                @RequestParam(value = "roleId", required = false) Integer roleId,
                             @RequestParam(value = "roleName", required = false) String roleName){
        Role role=new Role();
         role.setMender(1);
        role.setModifyDate(new Date());
        role.setIsdelete(1);
        role.setRoleSort(sort);
        role.setRoleName(roleName);
        role.setRoleId(roleId);

        if(roleService.Add(role)){
            return "true";
        }else{
            return  "false";
        }


    }



    @RequestMapping("/del")
    @ResponseBody
    public  Object del(@RequestParam(value = "roleId", required = false) Integer roleId){
        return  roleService.deleteById(roleId);
    }


    @RequestMapping("/getRoleById")
    @ResponseBody
    public  Object getRoleById(@RequestParam(value = "roleId", required = false) Integer roleId){

        Role role=roleService.findRoleByRoleId(roleId);

        return  role;
    }







}

