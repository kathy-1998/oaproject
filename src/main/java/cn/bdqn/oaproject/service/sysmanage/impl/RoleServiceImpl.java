package cn.bdqn.oaproject.service.sysmanage.impl;

import cn.bdqn.oaproject.dao.sysmanage.RoleDao;
import cn.bdqn.oaproject.pojo.Job;
import cn.bdqn.oaproject.pojo.Role;
import cn.bdqn.oaproject.service.sysmanage.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * 角色业务操作接口
 */

@Service("roleService")
@Transactional
public class RoleServiceImpl implements RoleService {


    @Autowired
    RoleDao roleDao;

    @Override
    public boolean modify(Role role) {
        try{

            roleDao.save(role);
            return  true;
        }catch (Exception e){
            e.printStackTrace();
            return  false;
        }
    }

    @Override
    public Role findRoleByRoleId(Integer roleId) {

        Role role=null;
        try{

            role=roleDao.findRoleByRoleId(roleId);
        }catch (Exception e){
            e.printStackTrace();

        }
        return role;
    }

    @Override
    public boolean Add(Role role) {
        try{

            roleDao.save(role);
            return  true;
        }catch (Exception e){
            e.printStackTrace();
            return  false;
        }
    }

    @Override
    public boolean deleteById(Integer integer) {
        try{

           roleDao.deleteById(integer);
           return  true;
        }catch (Exception e){
            e.printStackTrace();
            return  false;
        }
    }

    @Override
    public Page<Role> findAll(Pageable pageable) {
        Page<Role> roles=null;
        try{

            roles=roleDao.findAll(pageable);
        }catch (Exception e){
            e.printStackTrace();
        }
        return  roles;
    }

    @Override
    public List<Role> findAll() {
        List<Role> roles=new ArrayList<Role>();
        try{

            roles=roleDao.findAll();
        }catch (Exception e){
            e.printStackTrace();
        }
        return  roles;
    }
}
