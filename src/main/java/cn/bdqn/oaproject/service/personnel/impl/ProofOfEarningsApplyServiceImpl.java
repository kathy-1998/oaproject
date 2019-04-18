package cn.bdqn.oaproject.service.personnel.impl;

import cn.bdqn.oaproject.dao.personnel.ProofOfEarningsApplyDao;
import cn.bdqn.oaproject.pojo.ProofOfEarningsApply;
import cn.bdqn.oaproject.pojo.WaitingTaskRecord;
import cn.bdqn.oaproject.service.mydesktop.WaitingTaskRecordService;
import cn.bdqn.oaproject.service.personnel.ProofOfEarningsApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;


@Service("proofOfEarningsApplyService")
@Transactional
public class ProofOfEarningsApplyServiceImpl implements ProofOfEarningsApplyService {

    @Autowired
    ProofOfEarningsApplyDao proofOfEarningsApplyDao;

    @Autowired
    WaitingTaskRecordService waitingTaskRecordService;

    @Override
    public boolean add(ProofOfEarningsApply proofOfEarningsApply) {


        try{
            proofOfEarningsApplyDao.save(proofOfEarningsApply);


            WaitingTaskRecord waitingTaskRecord=new WaitingTaskRecord();
            waitingTaskRecord.setWaitingTaskRecordName(proofOfEarningsApply.getApplyUserName()+"收入申请"); //任务名称
            waitingTaskRecord.setTaskTypeId(proofOfEarningsApply.getTaskTypeId());  //任务类型
            waitingTaskRecord.setApplyId(proofOfEarningsApply.getProofOfEarningsApplyId()); //申请记录id
            waitingTaskRecord.setApplyTime(proofOfEarningsApply.getCreationDate()); //申请时间
            waitingTaskRecord.setIsdelete(1);   //是否删除,默认1
            waitingTaskRecord.setInitiatorId(proofOfEarningsApply.getApplyUserId());    //申请人
            waitingTaskRecord.setUserId(proofOfEarningsApply.getUserId());  //审批人
            waitingTaskRecord.setStatus(proofOfEarningsApply.getStatus());  //状态
            waitingTaskRecord.setCreationDate(new Date());  //任务创建时间
            waitingTaskRecord.setCreator(proofOfEarningsApply.getApplyUserId());    //任务创建者


            //执行添加待处理
            waitingTaskRecordService.addInfo(waitingTaskRecord);

            return  true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}

