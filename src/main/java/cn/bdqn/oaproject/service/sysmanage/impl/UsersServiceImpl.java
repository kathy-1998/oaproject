package cn.bdqn.oaproject.service.sysmanage.impl;

import cn.bdqn.oaproject.dao.sysmanage.UsersDao;
import cn.bdqn.oaproject.pojo.Users;
import cn.bdqn.oaproject.service.sysmanage.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
            usersDao.modify(userpwd,id);
            return  true;
        }catch (Exception e){
            e.printStackTrace();
            return  false;
        }

    }
}
