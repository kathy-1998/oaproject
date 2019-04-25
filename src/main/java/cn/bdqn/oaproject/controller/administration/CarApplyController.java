package cn.bdqn.oaproject.controller.administration;

import cn.bdqn.oaproject.pojo.CarApply;
import cn.bdqn.oaproject.pojo.Users;
import cn.bdqn.oaproject.pojo.WaitingTaskRecord;
import cn.bdqn.oaproject.service.administration.CarApplyService;
import cn.bdqn.oaproject.service.mydesktop.WaitingTaskRecordService;
import cn.bdqn.oaproject.utils.stringToDateConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("carapply")
public class CarApplyController {

    @Autowired
    private CarApplyService carApplyService;

    @Autowired
    private WaitingTaskRecordService waitingTaskRecordService;


    @RequestMapping(value = "/savecarapply")
    @ResponseBody
    public Object saveCarApply(@RequestParam("carNo") String carNo,
                               @RequestParam("transportPeople") String transportPeople,
                               @RequestParam("driver") String driver,
                               @RequestParam("entourage")String entourage,
                               @RequestParam("startTime") String startTime,
                               @RequestParam("endTime") String endTime,
                               @RequestParam("destination") String destination,
                               @RequestParam("mileage") String mileage,
                               @RequestParam("theOriginOfAnIncident")String theOriginOfAnIncident,
                               @RequestParam("theApproverId")String theApproverId,
                               HttpSession session){
        //获取当前登录 用户
     /*  Users users=(Users) session.getAttribute("User");*/
        Map<String,Object> resultMap=new HashMap<>();   //存放结果集
        //进行添加操作
        try {
            //封装为对象
            CarApply carApply=new CarApply();
            carApply.setCarNo(Integer.parseInt(carNo));
            carApply.setTransportPeople(transportPeople);
            carApply.setDestination(destination);
            carApply.setEntourage(entourage);
            carApply.setDriver(driver);
            carApply.setTheApproverId(Integer.parseInt(theApproverId));
            carApply.setMileage(Integer.parseInt(mileage));
            carApply.setTheOriginOfAnIncident(theOriginOfAnIncident);
            carApply.setStartTime(stringToDateConverter.strToDate(startTime,"yyyy-MM-dd HH:mm:ss"));
            carApply.setEndTime(stringToDateConverter.strToDate(endTime,"yyyy-MM-dd HH:mm:ss"));
            carApply.setIsdelete(1);
           /* carApply.setDeptNo(users.getDept().getDeptId());    //设置当前用户所属部门编号
            carApply.setCreator(users.getUserId());*/
            carApply.setStatus(0);   //默认未审批
            carApply.setTaskId(3);  //任务id
            carApply.setDeptNo(1);
            carApply.setCreator(1);
            carApply.setCreationDate(new Date());

            //添加到用车申请记录表
            CarApply carApply1=carApplyService.addCarApplyRecord(carApply);
            if(carApply1!=null){
                resultMap.put("result","success");
            }else {
                resultMap.put("result","failed");
            }
        }catch (Exception e){
            resultMap.put("result","error");
            e.printStackTrace();
        }
        return resultMap;
    }

    /**
     * 根据用车申请记录id和任务类型id获取详情
     * @param carId
     * @param taskId
     * @return
     */
    @RequestMapping(value = "/findcarapply",method = RequestMethod.GET)
    @ResponseBody
    public Object findByCarIdAndTaskId(@RequestParam("carId")String carId,@RequestParam("taskId")String taskId){
        CarApply carApply=null;
        try {
            carApply=carApplyService.findByCarApplyIdAndTaskId(Integer.parseInt(carId),Integer.parseInt(taskId));
        }catch (Exception e){
            e.printStackTrace();
        }
        return carApply;
    }


    /**
     * 审核用车申请
     * @param carApplyId 用车申请id
     * @param status 审核结果编号
     * @return
     */
    @RequestMapping("/checksealapply")
    @ResponseBody
    public Object checkSealApply(@RequestParam("carApplyId")String carApplyId,@RequestParam("status") String status){
        Map<String,Object> resultMap=new HashMap<>();
        try {
            //进行审核
            boolean flag=carApplyService.approveCarApply(Integer.parseInt(carApplyId),Integer.parseInt(status));
            if(flag){
                resultMap.put("result","success");
            }else {
                resultMap.put("result","failed");
            }
        }catch (Exception e){
            resultMap.put("result","error");
            e.printStackTrace();
        }
        return resultMap;
    }



}
