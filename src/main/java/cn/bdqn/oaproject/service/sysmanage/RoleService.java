package cn.bdqn.oaproject.service.sysmanage;

import cn.bdqn.oaproject.pojo.Role;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

/**
 * 角色业务操作接口
 */
public interface RoleService {

    /**
     * 添加角色/
     */
   boolean Add(Role role);

    /**
     * 修改角色
     */
    boolean modify(Role role);


    /**
     * 删除角色
     * @param integer
     */

    boolean deleteById(Integer integer);

    Page<Role> findAll(Pageable pageable);

    List<Role> findAll();

    Role findRoleByRoleId(Integer roleId);
}
