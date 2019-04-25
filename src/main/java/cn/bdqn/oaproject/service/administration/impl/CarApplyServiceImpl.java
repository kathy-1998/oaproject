package cn.bdqn.oaproject.service.administration.impl;

import cn.bdqn.oaproject.dao.administration.CarApplyDao;
import cn.bdqn.oaproject.pojo.CarApply;
import cn.bdqn.oaproject.pojo.WaitingTaskRecord;
import cn.bdqn.oaproject.service.administration.CarApplyService;
import cn.bdqn.oaproject.service.mydesktop.WaitingTaskRecordService;
import cn.bdqn.oaproject.service.mydesktop.impl.WaitingTaskRecordServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarApplyServiceImpl implements CarApplyService {

    @Autowired
    private CarApplyDao carApplyDao;

    @Autowired
    private WaitingTaskRecordService waitingTaskRecordService;

    /**
     * 添加用车申请记录
     * @param carApply
     * @return
     * @throws Exception
     */
    @Override
    public CarApply addCarApplyRecord(CarApply carApply) throws Exception {
        CarApply carApply1=null;
        try {
            carApply1=carApplyDao.save(carApply);
            //封装待处理任务列表
            WaitingTaskRecord record=new WaitingTaskRecord();
            /* record.setWaitingTaskRecordName(users.getRealName()+"用车申请");*/    //任务名称
            record.setWaitingTaskRecordName(carApply1.getTransportPeople()+"用车申请");//任务名称
            record.setApplyId(carApply1.getCarApplyId());       //申请记录id
            record.setApplyTime(carApply1.getCreationDate());   //申请时间
            record.setStatus(0);    //申请状态，默认0
            record.setTaskTypeId(3);    //任务类型id
            /*  record.setInitiatorId(carApply1.getCreator()); */   //发起人
            record.setUserId(2);    //审批人
            record.setInitiatorId(1);    //发起人
            record.setIsdelete(1);  //默认不删除
            //添加待处理任务记录
            waitingTaskRecordService.addInfo(record);
        }catch (Exception e){
            e.printStackTrace();
        }
        return carApply1;
    }

    /**
     * 根据申请记录id和任务类型id获取详情
     * @param carApplyId
     * @param taskId
     * @return
     * @throws Exception
     */
    @Override
    public CarApply findByCarApplyIdAndTaskId(Integer carApplyId, Integer taskId) throws Exception {
        CarApply carApply=null;
        try {
            carApply=carApplyDao.findByCarApplyIdAndTaskId(carApplyId,taskId);
        }catch (Exception e){
            e.printStackTrace();
        }
        return carApply;
    }

    /**
     * 审核用车申请
     * @param carApplyId
     * @param status
     * @return
     * @throws Exception
     */
    @Override
    public boolean approveCarApply(Integer carApplyId, Integer status) throws Exception {
        try {
            carApplyDao.updateStatus(carApplyId,status);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
