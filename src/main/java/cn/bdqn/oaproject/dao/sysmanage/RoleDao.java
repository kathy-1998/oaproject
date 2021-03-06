package cn.bdqn.oaproject.dao.sysmanage;

import cn.bdqn.oaproject.pojo.Dept;
import cn.bdqn.oaproject.pojo.Job;
import cn.bdqn.oaproject.pojo.Role;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface RoleDao extends JpaRepository<Role,Integer> {



    /**
     * 删除角色
     * @param integer
     */
    @Override
    void deleteById(Integer integer);


    /**
     * 分页查询角色列表
     * @param pageable
     * @return
     */
    @Override
    Page<Role> findAll(Pageable pageable);

    Role findRoleByRoleId(Integer roleId);
}
