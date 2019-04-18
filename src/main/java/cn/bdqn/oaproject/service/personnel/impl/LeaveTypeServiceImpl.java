package cn.bdqn.oaproject.service.personnel.impl;

import cn.bdqn.oaproject.dao.personnel.LeaveApplyDao;
import cn.bdqn.oaproject.dao.personnel.LeaveTypeDao;
import cn.bdqn.oaproject.pojo.LeaveApply;
import cn.bdqn.oaproject.pojo.LeaveType;
import cn.bdqn.oaproject.service.personnel.LeaveTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 请假类型业务操作接口
 */
@Service("leaveTypeService")
@Transactional
public class LeaveTypeServiceImpl implements LeaveTypeService {

    @Autowired
    LeaveTypeDao leaveTypeDao;

    @Override
    public List<LeaveType> findAll() {
        List< LeaveType> leaveTypes=null;
        try{
            leaveTypes=leaveTypeDao.findAll();
        }catch (Exception e){
            e.printStackTrace();
        }
        return leaveTypes;
    }
}
