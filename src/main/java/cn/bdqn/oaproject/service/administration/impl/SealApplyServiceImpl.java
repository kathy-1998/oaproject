package cn.bdqn.oaproject.service.administration.impl;

import cn.bdqn.oaproject.dao.administration.SealApplyDao;
import cn.bdqn.oaproject.pojo.SealApply;
import cn.bdqn.oaproject.pojo.WaitingTaskRecord;
import cn.bdqn.oaproject.service.administration.SealApplyService;
import cn.bdqn.oaproject.service.mydesktop.WaitingTaskRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SealApplyServiceImpl implements SealApplyService {

    @Autowired
    private SealApplyDao sealApplyDao;

    @Autowired
    private WaitingTaskRecordService waitingTaskRecordService;
    /**
     * 添加用章申请
     * @param sealApply
     * @return
     * @throws Exception
     */
    @Override
    public boolean addNewSealApply(SealApply sealApply) throws Exception {
        SealApply seal=null;
        try {
            seal=sealApplyDao.save(sealApply);
            WaitingTaskRecord record=new WaitingTaskRecord();
            record.setWaitingTaskRecordName(seal.getUserName()+"用章申请");//任务名称
            record.setApplyId(seal.getSealApplyId());       //申请记录id
            record.setApplyTime(seal.getApplyTime());   //申请时间
            record.setStatus(0);    //申请状态，默认0
            record.setTaskTypeId(4);    //任务类型id
            /*  record.setInitiatorId(carApply1.getCreator()); */   //发起人
            record.setUserId(seal.getUserId());    //审批人
            record.setInitiatorId(seal.getApplyUserId());    //发起人
            record.setStatus(1);
            record.setIsdelete(1);  //默认不删除
            //添加待处理任务记录
            waitingTaskRecordService.addInfo(record);
            return  true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 根据用章申请编号和任务类型编号获取详情
     * @param sealApplyId
     * @param taskTypeId
     * @return
     * @throws Exception
     */
    @Override
    public SealApply findBySealApplyIdAndTaskTypeId(Integer sealApplyId, Integer taskTypeId) throws Exception {
        SealApply sealApply=null;
        try {
            sealApply=sealApplyDao.findBySealApplyIdAndTaskTypeId(sealApplyId,taskTypeId);
        }catch (Exception e){
            e.printStackTrace();
        }
        return sealApply;
    }

    /**
     *  审核用车申请
     * @param sealApplyId 用章申请id
     * @param status 修改申请状态
     * @return
     */
    @Override
    public boolean approveSealApply(Integer sealApplyId, Integer status) {
        try {
            sealApplyDao.updateStatus(sealApplyId,status);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }
}
