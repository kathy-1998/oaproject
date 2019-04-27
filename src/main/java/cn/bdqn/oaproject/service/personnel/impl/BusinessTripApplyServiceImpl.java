package cn.bdqn.oaproject.service.personnel.impl;

import cn.bdqn.oaproject.dao.personnel.BusinessTripApplyDao;
import cn.bdqn.oaproject.pojo.BusinessTripApply;
import cn.bdqn.oaproject.pojo.WaitingTaskRecord;
import cn.bdqn.oaproject.service.mydesktop.WaitingTaskRecordService;
import cn.bdqn.oaproject.service.personnel.BusinessTripApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

/**
 * 出差申请业务操作接口
 */

@Controller
@RequestMapping("/BusinessTripApply")
public class BusinessTripApplyServiceImpl implements BusinessTripApplyService {

    @Autowired
    BusinessTripApplyDao businessTripApplyDao;

    @Autowired
    WaitingTaskRecordService waitingTaskRecordService;

    @Override
    public boolean add(BusinessTripApply businessTripApply) {

       try {
           businessTripApplyDao.save(businessTripApply);
           //并向待处理任务中添加一条
           WaitingTaskRecord waitingTaskRecord=new WaitingTaskRecord();

           waitingTaskRecord.setWaitingTaskRecordName(businessTripApply.getBusinessTripApplyUserName()+"出差申请"); //任务名称
           waitingTaskRecord.setTaskTypeId(businessTripApply.getTaskTypeId());  //任务类型
           waitingTaskRecord.setApplyId(businessTripApply.getBusinessTripApplyId()); //申请记录id
           waitingTaskRecord.setApplyTime(businessTripApply.getCreationDate()); //申请时间
           waitingTaskRecord.setIsdelete(1);   //是否删除,默认1
           waitingTaskRecord.setInitiatorId(businessTripApply.getBusinessTripApplyUserId());    //申请人
           waitingTaskRecord.setUserId(businessTripApply.getUserId());  //审批人
           waitingTaskRecord.setStatus(businessTripApply.getStatus());  //状态
           waitingTaskRecord.setCreationDate(new Date());  //任务创建时间
           waitingTaskRecord.setCreator(businessTripApply.getBusinessTripApplyUserId());
           waitingTaskRecordService.addInfo(waitingTaskRecord);
           return true;
       }catch (Exception e){
           e.printStackTrace();
           return false;
       }

    }

    @Override
    public BusinessTripApply getInfoById(Integer id) {
        return businessTripApplyDao.findInfoById(id);
    }
}
