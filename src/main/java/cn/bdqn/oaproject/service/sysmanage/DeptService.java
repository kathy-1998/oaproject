package cn.bdqn.oaproject.service.sysmanage;

import cn.bdqn.oaproject.pojo.Dept;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 部门业务操作接口
 */
public interface DeptService {


    /**
     * 查询所有部门
     * @return
     */
    List<Dept> findAll();

    /**
     *   删除部门
     */

    boolean deleteById(Integer id);


    /**
     * 添加或者修改
     */
    boolean Add(Dept dept);


}
