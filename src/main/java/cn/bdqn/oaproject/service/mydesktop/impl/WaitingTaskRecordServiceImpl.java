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
    public void modifyInfo(Integer userId, String applyOpinion, Integer id) {
        try {
            waitingTaskRecordDao.modifyInfo(userId, applyOpinion, id);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
