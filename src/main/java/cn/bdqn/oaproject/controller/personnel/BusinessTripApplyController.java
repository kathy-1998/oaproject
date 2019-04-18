package cn.bdqn.oaproject.controller.personnel;


import cn.bdqn.oaproject.pojo.BusinessTripApply;
import cn.bdqn.oaproject.service.personnel.BusinessTripApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.sql.Date;

@Controller
@RequestMapping("/BusinessTripApply")
public class BusinessTripApplyController {


    @Autowired
    BusinessTripApplyService businessTripApplyService;


    /**
     * 跳转到出差申请页面
     * @return
     */
    @RequestMapping("/BusinessTripApply.html")
    public  String  BusinessTripApply(){

        return  "onbusiness_apply";
    }


    /**
     * 添加请假申请
     * @return
     */
    @RequestMapping("/AddBusinessTripApply.do")
    @ResponseBody
    public  Object  AddBusinessTripApply(    @RequestParam(value = "startTime", required = false) String startTime,
                                             @RequestParam(value = "endTime", required = false) String endTime,
                                             @RequestParam(value = "realName", required = false) String realName,
                                             @RequestParam(value = "userId", required = false) Integer userId,
                                             @RequestParam(value = "deptId", required = false) Integer deptId,
                                             @RequestParam(value = "placeOfbusinessTrip", required = false) String placeOfbusinessTrip,
                                             @RequestParam(value = "vehicleTypeId", required = false) Integer vehicleTypeId,
                                             @RequestParam(value = "reason", required = false) String reason,
                                             @RequestParam(value = "workTask", required = false) String workTask,
                                             @RequestParam(value = "money", required = false) Integer money,
                                             @RequestParam(value = "spr", required = false) Integer spr


                                             ){



        BusinessTripApply businessTripApply=new BusinessTripApply();

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");


        Date date=null;
        Date date01=null;
        try{
          date=new Date(format.parse(startTime).getTime());
          date01=new Date(format.parse(endTime).getTime());

            java.util.Date date02 = new Date(date.getTime());//sql.Date转util.Date
            java.util.Date date03 = new Date(date01.getTime());//sql.Date转util.Date

            businessTripApply.setStartTime(date02); //开始日期
            businessTripApply.setEndTime(date03);   //结束日期


            businessTripApply.setIsdelete(1);
            businessTripApply.setCreationDate(new java.util.Date());
            businessTripApply.setCreator(1);
            businessTripApply.setBusinessTripApplyUserName(realName);
            businessTripApply.setBusinessTripApplyUserId(userId);
            businessTripApply.setUserId(spr);

            businessTripApply.setTaskTypeId(2);
            businessTripApply.setTravelReason(reason);
            businessTripApply.setBorrowingBalance(money);
            businessTripApply.setWorkTask(workTask);
            businessTripApply.setPlaceOfbusinessTrip(placeOfbusinessTrip);
            businessTripApply.setDeptId(deptId);
            businessTripApply.setStatus(0);
            businessTripApply.setVehicleTypeId(vehicleTypeId);
         if(businessTripApplyService.add(businessTripApply)){
             return  true;
         }

        }catch (Exception e){
            e.printStackTrace();
        }

        return  "false";
    }



}
