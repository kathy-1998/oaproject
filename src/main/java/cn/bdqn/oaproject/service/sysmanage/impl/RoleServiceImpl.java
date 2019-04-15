package cn.bdqn.oaproject.service.sysmanage.impl;

import cn.bdqn.oaproject.dao.sysmanage.RoleDao;
import cn.bdqn.oaproject.dao.sysmanage.UsersDao;
import cn.bdqn.oaproject.pojo.Role;
import cn.bdqn.oaproject.pojo.Users;
import cn.bdqn.oaproject.service.sysmanage.RoleService;
import cn.bdqn.oaproject.service.sysmanage.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * 用户业务操作接口
 */
@Service("roleService")
@Transactional
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleDao roleDao;

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
    public List<Role> findAll() {
        List<Role> roles=null;
        try{
            roles=roleDao.findAll();
        }catch (Exception e){
            e.printStackTrace();
        }
        return  roles;
    }

    @Override
    public boolean Add(Role role){

        try{
            roleDao.save(role);
            return  true;
        }catch (Exception e){
            e.printStackTrace();
            return false;

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
}
