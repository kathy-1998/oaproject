package cn.bdqn.oaproject.dao.sysmanage;

import cn.bdqn.oaproject.pojo.Dept;
import cn.bdqn.oaproject.pojo.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.*;

import java.util.List;

public interface DeptDao extends JpaRepository<Dept,Integer> {


    /**
     * 查询所有部门
     * @return
     */
    List<Dept> findAll();

    /**
     *   删除部门
     */
    @Override
    void deleteById(Integer id);






}
