package cn.bdqn.oaproject.service.sysmanage.impl;

import cn.bdqn.oaproject.dao.sysmanage.JobDao;
import cn.bdqn.oaproject.pojo.Job;
import cn.bdqn.oaproject.service.sysmanage.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("jobService")
@Transactional
public class JobServiceImpl  implements JobService {

    @Autowired
    JobDao jobDao;

    @Override
    public List<Job> findAll() {
        List<Job> jobs=new ArrayList<Job>();
        try{
            jobs=jobDao.findAll();
        }catch (Exception e){
            e.printStackTrace();
        }
        return jobs;
    }
}
