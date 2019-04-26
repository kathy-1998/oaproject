package cn.bdqn.oaproject.service.mydesktop.impl;

import cn.bdqn.oaproject.dao.mydesktop.WaitingTaskRecordDao;
import cn.bdqn.oaproject.pojo.WaitingTaskRecord;
import cn.bdqn.oaproject.service.mydesktop.WaitingTaskRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
@Service("waitingTaskRecordService")
@Transactional
public class WaitingTaskRecordServiceImpl implements WaitingTaskRecordService {

    @Autowired
    private WaitingTaskRecordDao waitingTaskRecordDao;
    @Override
    public Page<WaitingTaskRecord> findAll(Specification<WaitingTaskRecord> specification, Pageable pageable) {
        Page<WaitingTaskRecord> page=null;
        try {
            page =waitingTaskRecordDao.findAll(specification,pageable);
        }catch (Exception e){
            e.printStackTrace();
        }
        return page;
    }

    @Override
    public List<WaitingTaskRecord> findInfoById(Integer userId) {
        List<WaitingTaskRecord> list=null;
        try {
            list =waitingTaskRecordDao.findInfoById(userId);
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean modifyInfo(Integer userId, String applyOpinion, Date finalApprovalTime, Integer id) {
        try {
            waitingTaskRecordDao.modifyInfo(userId, applyOpinion,finalApprovalTime,id);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<WaitingTaskRecord> getInfoById(Integer id) {
        List<WaitingTaskRecord> waitingTaskRecord=null;
        try {
            waitingTaskRecord=waitingTaskRecordDao.getInfoById(id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return waitingTaskRecord;
    }

    @Override
    public boolean addInfo(WaitingTaskRecord waitingTaskRecord) {
        try {
            waitingTaskRecordDao.save(waitingTaskRecord);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
