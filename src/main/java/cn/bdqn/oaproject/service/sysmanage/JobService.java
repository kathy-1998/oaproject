package cn.bdqn.oaproject.service.sysmanage;

import cn.bdqn.oaproject.pojo.Job;

import java.util.List;

/**
 * 职位业务操作接口
 */
public interface JobService {

    List<Job> findAll();
}
