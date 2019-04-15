package cn.bdqn.oaproject.service.sysmanage;

import cn.bdqn.oaproject.pojo.OperateLog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

/**
 * 操作日志业务操作接口
 */
public interface OperateLogService{


    boolean add(OperateLog operateLog);


    boolean modify(OperateLog operateLog);

    Page<OperateLog> findAll(Specification<OperateLog> specification, Pageable pageable);


}
