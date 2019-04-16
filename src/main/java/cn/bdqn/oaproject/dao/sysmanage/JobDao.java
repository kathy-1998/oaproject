package cn.bdqn.oaproject.dao.sysmanage;

import cn.bdqn.oaproject.pojo.Job;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobDao extends JpaRepository<Job,Integer> {


    @Override
    List<Job> findAll();




}
