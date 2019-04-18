package cn.bdqn.oaproject.controller.personnel;


import cn.bdqn.oaproject.pojo.LeaveApply;
import cn.bdqn.oaproject.service.personnel.LeaveApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Date;
import java.text.SimpleDateFormat;

@Controller
@RequestMapping("/leaveApply")
public class LeaveApplyController {


    @Autowired
    LeaveApplyService leaveApplyService;

    /**
     * 跳转到请假申请页面
     * @return
     */
    @RequestMapping("/leaveApply.html")
    public String leaveApply(){

        return "ask_for_leave_apply";
    }


    @RequestMapping("/AddleaveApply.do")
    @ResponseBody
    public Object AddleaveApply(  @RequestParam(value = "startTime", required = false) String startTime,
                                  @RequestParam(value = "endTime", required = false) String endTime,
                                  @RequestParam(value = "realName", required = false) String realName,
                                  @RequestParam(value = "userId", required = false) Integer userId,
                                  @RequestParam(value = "deptId", required = false) Integer deptId,
                                  @RequestParam(value = "leaveDays", required = false) Integer leaveDays,
                                  @RequestParam(value = "leaveTypeId", required = false) Integer leaveTypeId,
                                  @RequestParam(value = "reasonForALeave", required = false) String reason,
                                  @RequestParam(value = "spr", required = false) Integer spr
                                    ){


        LeaveApply leaveApply=new LeaveApply();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");


        Date date=null;
        Date date01=null;
        try{
            date=new Date(format.parse(startTime).getTime());
            date01=new Date(format.parse(endTime).getTime());

            java.util.Date date02 = new Date(date.getTime());//sql.Date转util.Date
            java.util.Date date03 = new Date(date01.getTime());//sql.Date转util.Date

            leaveApply.setStartTime(date02);
            leaveApply.setEndTime(date03);
            leaveApply.setStatus(0);
            leaveApply.setTaskTypeId(1);
            leaveApply.setCreator(1);
            leaveApply.setCreationDate(new  java.util.Date());
            leaveApply.setIsdelete(1);
            leaveApply.setLeaveApplyUserId(userId);
            leaveApply.setLeaveApplyUserName( realName);
            leaveApply.setLeaveTypeId(leaveTypeId);
            leaveApply.setDeptId(deptId);
            leaveApply.setLeaveDays(leaveDays);
            leaveApply.setReasonForALeave(reason);
            leaveApply.setUserId(spr);

            if(leaveApplyService.add(leaveApply)){
                return  "true";
            }

        }catch (Exception e){
            e.printStackTrace();
        }




        return "false";
    }


}
