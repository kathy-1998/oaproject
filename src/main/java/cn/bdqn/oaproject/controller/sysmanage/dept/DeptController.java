package cn.bdqn.oaproject.controller.sysmanage.dept;

import cn.bdqn.oaproject.pojo.Dept;
import cn.bdqn.oaproject.pojo.Users;
import cn.bdqn.oaproject.service.sysmanage.DeptService;
import cn.bdqn.oaproject.service.sysmanage.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/dept")
public class DeptController {

    @Autowired
    DeptService deptService;


    @Autowired
    UsersService usersService;


   @RequestMapping("/Organizational_structure_manage.html")
    public  String Organizational_structure_manage(){


       return  "Organizational_structure_manage";
   }


    @RequestMapping("/list.html")
    @ResponseBody
    public  Object list(){

     List<Dept> depts=deptService.findAll();

     return depts;
    }


    @RequestMapping("/add")
    @ResponseBody
    public  Object Add(@RequestParam(value = "deptName",required = false)String deptName,
                       @RequestParam(value = "userId",required = false)Integer userId,
                       @RequestParam(value = "phone",required = false)String phone,
                       @RequestParam(value = "ContactNumber",required = false)String ContactNumber,
                       @RequestParam(value = "cz",required = false)String cz){
     Dept dept=new Dept();
     dept.setDeptName(deptName);
     dept.setUserId(userId);
     dept.setCreator(1);
     dept.setCreationDate(new Date());
     dept.setPhone(phone);
     dept.setContactNumber(ContactNumber);
     dept.setElectricalTransmission(cz);

    boolean flag=deptService.Add(dept);


        return  flag;
    }



    @RequestMapping("/modify")
    @ResponseBody
    public  Object modify(@RequestParam(value = "deptName",required = false)String deptName,
                          @RequestParam(value = "userId",required = false)Integer userId,
                          @RequestParam(value = "phone",required = false)String phone,
                          @RequestParam(value = "ContactNumber",required = false)String ContactNumber,
                          @RequestParam(value = "cz",required = false)String cz,
                          @RequestParam(value = "deptId",required = false)Integer id
                          ){
    //修改
      Dept dept=new Dept();
        dept.setDeptId(id);
         dept.setDeptName(deptName);
        dept.setUserId(userId);

        dept.setMender(1);
        dept.setModifyDate(new Date());
        dept.setPhone(phone);
        dept.setContactNumber(ContactNumber);
        dept.setElectricalTransmission(cz);

        return    deptService.modify(dept);
    }


    @RequestMapping("/del")
    @ResponseBody
    public  Object del(@RequestParam(value = "deptId",required = false)Integer id){


        return    deptService.deleteById(id);
    }


    @RequestMapping("/getUsersbyName")
    @ResponseBody
    public Object getUsersByName(@RequestParam("userName") String userName) {


       Users users=usersService.findByUserName(userName);

       if(users==null){
           return  0;
       }else{
           return  users.getUserId();
       }
    }

    @RequestMapping("/getUsersbyId")
    @ResponseBody
    public Object getUsersbyId(@RequestParam("userId") Integer userId) {
      Users users=usersService.findUsersByUserId(userId);

       return   users;
    }


    @RequestMapping("/getDept")
    @ResponseBody
    public Object getDeptByid(@RequestParam("deptId") Integer deptId) {


        return  deptService.getDeptsByDeptId(deptId);
    }


}
