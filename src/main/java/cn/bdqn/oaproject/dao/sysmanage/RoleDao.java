package cn.bdqn.oaproject.dao.sysmanage;

import cn.bdqn.oaproject.pojo.Dept;
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
     * 添加角色
     * @param s
     * @param <S>
     * @return
     */
    @Override
    <S extends Role> S save(S s);


    /**
     * 删除角色
     * @param integer
     */
    @Override
    void deleteById(Integer integer);


    /**
     * 修改角色
     * @param roleName
     * @param roleId
     */
    @Modifying
    @Query("update  Role set roleName = ?1,rolesort=?2,modifyDate = ?3,mender = ?4 where  roleId= ?4")
     void  modify(String roleName, Integer rolesort, Date time, Integer roleId);


    /**
     * 分页查询角色列表
     * @param pageable
     * @return
     */
    @Override
    Page<Role> findAll(Pageable pageable);
}
