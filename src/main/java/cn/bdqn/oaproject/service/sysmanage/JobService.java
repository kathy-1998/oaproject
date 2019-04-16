package cn.bdqn.oaproject.service.sysmanage;

import cn.bdqn.oaproject.pojo.Job;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * 职位业务操作接口
 */
public interface JobService {

    List<Job> findAll();


    Page<Job> findAll(Pageable pageable);


    boolean deleteById(Integer jobId);

    boolean add(Job job);

    boolean modify(Job job);


}
