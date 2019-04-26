package cn.bdqn.oaproject.controller.administration;

import cn.bdqn.oaproject.pojo.SealApply;
import cn.bdqn.oaproject.pojo.SealType;
import cn.bdqn.oaproject.pojo.Users;
import cn.bdqn.oaproject.service.administration.SealApplyService;
import cn.bdqn.oaproject.service.administration.SealTypeService;
import cn.bdqn.oaproject.service.sysmanage.UsersService;
import cn.bdqn.oaproject.utils.stringToDateConverter;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/sealapply")
public class SealApplyController {

    @Autowired
    private SealApplyService sealApplyService;

    @Autowired
    private SealTypeService sealTypeService;
    
    @Autowired
    private UsersService usersService;
    /**
     * 添加用章申请记录
     * @param applyTime 用章申请时间
     * @param sealTypeId 用章类型编号
     * @param theOriginOfAnIncident 用章事由
     * @param userId 审批人id
     * @param session 获取当前登录用户
     * @return
     */
    @RequestMapping(value = "/savesealapply.do",method = RequestMethod.POST)
    @ResponseBody
    public String saveSealApplyRecord(@RequestParam("applyTime")String applyTime,
                                      @RequestParam("sealTypeId")String sealTypeId,
                                      @RequestParam("theOriginOfAnIncident")String theOriginOfAnIncident,
                                      @RequestParam("userId")String userId,
                                      HttpSession session){
        Map<String,Object> resultMap=new HashMap<>();
        //获取当前登录用户
        Users users=(Users)session.getAttribute("User");
        try {
            //封装对象
            SealApply sealApply=new SealApply();
            sealApply.setUserName(users.getRealName());
            sealApply.setApplyUserId(users.getUserId());
            sealApply.setTaskTypeId(4);
            sealApply.setApplyTime(stringToDateConverter.strToDate(applyTime,"yyyy-MM-dd"));
            sealApply.setSealTypeId(Integer.parseInt(sealTypeId));
            sealApply.setTheOriginOfAnIncident(theOriginOfAnIncident);
            sealApply.setDeptId(users.getDept().getDeptId());
            sealApply.setUserId(Integer.parseInt(userId));  //审批人id
            sealApply.setCreator(users.getUserId());  //当前登录用户id
            sealApply.setCreationDate(new Date());
            sealApply.setIsdelete(1);
            //进行添加操作并判断操作是否成功
            if(sealApplyService.addNewSealApply(sealApply)){
                resultMap.put("result","success");
            }else {
                resultMap.put("result","failed");
            }

        }catch (Exception e){
            resultMap.put("result","error");
            e.printStackTrace();
        }
        String json=JSON.toJSONString(resultMap);
        System.out.println(json);
        return json;
    }

    /**
     * 根据用章申请id和任务类型id获取详情
     * @param sealApplyId 用章申请id
     * @param taskTypeId 任务类型id
     * @return
     */
    @RequestMapping(value = "/findsealtype",method = RequestMethod.POST)
    @ResponseBody
    public Object findBySealAppId(@RequestParam("sealApplyId")String sealApplyId,
                                  @RequestParam("taskTypeId")String taskTypeId){
        SealApply sealApply=null;
        try {

            sealApply=sealApplyService.findBySealApplyIdAndTaskTypeId(Integer.parseInt(sealApplyId),
                    Integer.parseInt(taskTypeId));
        }catch (Exception e){
            e.printStackTrace();
        }
        return sealApply;
    }

    /**
     * 审核用章申请
     * @param sealApplyId 用章申请id
     * @param status 审核结果编号
     * @return
     */
    @RequestMapping("/checksealapply")
    @ResponseBody
    public Object checkSealApply(@RequestParam("sealApplyId")String sealApplyId,@RequestParam("status") String status){
        Map<String,Object> resultMap=new HashMap<>();
        try {
            //进行审核
            boolean flag=sealApplyService.approveSealApply(Integer.parseInt(sealApplyId),Integer.parseInt(status));
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

    /**
     * 获取用户信息
     * @param session
     * @return
     */
    @RequestMapping("/getUserInfo.find")
    @ResponseBody
    public String getUserInfo(HttpSession session){
        Users users=(Users) session.getAttribute("User");
        String json= JSON.toJSONString(users);
        System.out.println(json);
        return json;
    }

    /**
     * 获取用章类型
     * @return
     */
    @RequestMapping("/getSealType.find")
    @ResponseBody
    public String getSealType(){
        List<SealType> list=null;
        try {
            list=sealTypeService.findAllSealType();
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(JSON.toJSONString(list));
        return JSON.toJSONString(list);
    }

    @RequestMapping("/getAdmin.find")
    @ResponseBody
    public String getAdmin(){
        List<Users> list=usersService.findUsersByIsadmin(1);
        System.out.println(JSON.toJSONString(list));
        return JSON.toJSONString(list);
    }



}
