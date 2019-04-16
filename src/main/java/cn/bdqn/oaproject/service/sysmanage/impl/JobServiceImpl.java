package cn.bdqn.oaproject.service.sysmanage.impl;

import cn.bdqn.oaproject.dao.sysmanage.JobDao;
import cn.bdqn.oaproject.pojo.Job;
import cn.bdqn.oaproject.service.sysmanage.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    public Page<Job> findAll(Pageable pageable) {
        Page<Job> jobs=null;
        try{
            jobs=jobDao.findAll(pageable);
        }catch (Exception e){
            e.printStackTrace();
        }
        return jobs;
    }

    @Override
    public boolean deleteById(Integer jobId) {

        try{
           jobDao.deleteById(jobId);
           return  true;
        }catch (Exception e){
            e.printStackTrace();
            return  false;
        }
    }

    @Override
    public boolean add(Job job) {
        try{
            jobDao.save(job);
            return  true;
        }catch (Exception e){
            e.printStackTrace();
            return  false;
        }
    }

    @Override
    public boolean modify(Job job) {
        try{
            jobDao.save(job);
            return  true;
        }catch (Exception e){
            e.printStackTrace();
            return  false;
        }
    }

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
