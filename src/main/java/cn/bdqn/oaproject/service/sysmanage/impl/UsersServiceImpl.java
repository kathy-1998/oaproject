package cn.bdqn.oaproject.service.sysmanage.impl;

import cn.bdqn.oaproject.dao.sysmanage.UsersDao;
import cn.bdqn.oaproject.pojo.Users;
import cn.bdqn.oaproject.service.sysmanage.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * 用户业务操作接口
 */
@Service("userService")
@Transactional
public class UsersServiceImpl  implements UsersService {

    @Autowired
    UsersDao usersDao;

    @Override
    public Users findByUserName(String UserName) {
        Users users=null;
        try{
            users=usersDao.findByUserName(UserName);
        }catch (Exception e){
            e.printStackTrace();
        }
        return  users;
    }




    /**
     * 修改
     * @param userpwd
     * @param id
     * @return
     */
    @Override
    public Boolean modify(String userpwd, Integer id) {

        try{
            usersDao.modify(userpwd,new Date(),id);
            return  true;
        }catch (Exception e){
            e.printStackTrace();
            return  false;
        }

    }


    @Override
    public Page<Users> findAll(Specification<Users> specification, Pageable pageable) {

        Page<Users> users=null;
        try{
            users=usersDao.findAll(specification,pageable);
        }catch (Exception e){
            e.printStackTrace();
        }
        return  users;
    }


    @Override
    public Users findUsersByUserId(Integer userId) {
       Users users=null;
        try{
            users=usersDao.findUsersByUserId(userId);
        }catch (Exception e){
            e.printStackTrace();
        }
        return  users;
    }
}
