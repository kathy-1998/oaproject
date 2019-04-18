package cn.bdqn.oaproject.controller.personnel;


import cn.bdqn.oaproject.service.personnel.LeaveTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/LeaveType")
public class LeaveTypeController {

    @Autowired
    LeaveTypeService leaveTypeService;

    @RequestMapping("/LeaveTypeList")
    @ResponseBody
    public  Object LeaveTypeList(){
        return  leaveTypeService.findAll();
    }
}
