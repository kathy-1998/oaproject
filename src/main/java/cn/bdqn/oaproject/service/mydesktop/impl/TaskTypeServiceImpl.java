package cn.bdqn.oaproject.service.mydesktop.impl;

import cn.bdqn.oaproject.dao.mydesktop.TaskTypeDao;
import cn.bdqn.oaproject.pojo.TaskType;
import cn.bdqn.oaproject.service.mydesktop.TaskTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service("taskTypeService")
@Transactional
public class TaskTypeServiceImpl implements TaskTypeService {

    @Autowired
    private TaskTypeDao taskTypeDao;

    @Override
    public List<TaskType> findAll() {
        List<TaskType> list=null;
        try {
            list=taskTypeDao.findAll();
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
}
