package cn.bdqn.oaproject.dao.sysmanage;

import cn.bdqn.oaproject.pojo.OperateLog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperateLogDao extends JpaRepository<OperateLog,Integer> {


    /**
     * 分页条件查
     * @param specification
     * @param pageable
     * @return
     */
    Page<OperateLog> findAll(Specification<OperateLog> specification, Pageable pageable);


    /**
     * service有添加和修改方法
     */


}
