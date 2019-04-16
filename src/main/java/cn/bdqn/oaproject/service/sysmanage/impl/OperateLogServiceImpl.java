package cn.bdqn.oaproject.service.sysmanage.impl;


import cn.bdqn.oaproject.dao.sysmanage.OperateLogDao;
import cn.bdqn.oaproject.pojo.OperateLog;
import cn.bdqn.oaproject.pojo.Users;
import cn.bdqn.oaproject.service.sysmanage.OperateLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("operateLogService")
@Transactional
public class OperateLogServiceImpl implements OperateLogService {

    @Autowired
    OperateLogDao operateLogDao;

    @Override
    public boolean add(OperateLog operateLog) {
        try{
            operateLogDao.save(operateLog);
            return  true;
        }catch (Exception e){
            e.printStackTrace();
            return  false;
        }
    }


    @Override
    public Page<OperateLog> findAll(Specification<OperateLog> specification, Pageable pageable) {

        Page<OperateLog> operateLogs=null;
        try{
            operateLogs=operateLogDao.findAll(specification,pageable);
        }catch (Exception e){
            e.printStackTrace();
        }
        return  operateLogs;
    }
}
