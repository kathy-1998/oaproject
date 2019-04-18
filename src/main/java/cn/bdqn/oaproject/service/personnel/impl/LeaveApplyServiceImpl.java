package cn.bdqn.oaproject.service.personnel.impl;

import cn.bdqn.oaproject.dao.personnel.LeaveApplyDao;
import cn.bdqn.oaproject.pojo.LeaveApply;
import cn.bdqn.oaproject.pojo.WaitingTaskRecord;
import cn.bdqn.oaproject.service.mydesktop.WaitingTaskRecordService;
import cn.bdqn.oaproject.service.personnel.LeaveApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * 请假申请业务操作接口
 */
@Service("leaveApplyService")
@Transactional
public class LeaveApplyServiceImpl implements LeaveApplyService {

    @Autowired
    LeaveApplyDao leaveApplyDao;

    @Autowired
    WaitingTaskRecordService waitingTaskRecordService;

    @Override
    public boolean add(LeaveApply leaveApply) {

        try{
            leaveApplyDao.save(leaveApply);

            //并向待处理任务中添加一条
            WaitingTaskRecord waitingTaskRecord=new WaitingTaskRecord();

            waitingTaskRecord.setWaitingTaskRecordName(leaveApply.getLeaveApplyUserName()+"请假申请"); //任务名称
            waitingTaskRecord.setTaskTypeId(leaveApply.getTaskTypeId());  //任务类型
            waitingTaskRecord.setApplyId(leaveApply.getLeaveApplyId()); //申请记录id
            waitingTaskRecord.setApplyTime(leaveApply.getCreationDate()); //申请时间
            waitingTaskRecord.setIsdelete(1);   //是否删除,默认1
            waitingTaskRecord.setInitiatorId(leaveApply.getLeaveApplyUserId());    //申请人
            waitingTaskRecord.setUserId(leaveApply.getUserId());  //审批人
            waitingTaskRecord.setStatus(leaveApply.getStatus());  //状态
            waitingTaskRecord.setCreationDate(new Date());  //任务创建时间
            waitingTaskRecord.setCreator(leaveApply.getLeaveApplyUserId());
            waitingTaskRecordService.addInfo(waitingTaskRecord);



            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
