package cn.bdqn.oaproject.dao.sysmanage;

import cn.bdqn.oaproject.pojo.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Repository
public interface UsersDao extends JpaRepository<Users,Integer>,JpaSpecificationExecutor<Users>{



    /**
     * 根据用户名判断用户是否存在
     * @param UserName
     * @return
     */
    Users findByUserName(String UserName);

    @Modifying
    @Query("update Users set userPwd = ?1, modifyDate = ?2,mender = ?3 where userId = ?3")
    void modify(String userpwd,Date date,Integer id);


    @Override
    Page<Users> findAll(Specification<Users> specification, Pageable pageable);


    /**
     * 根据角色id返回该下用户个数
     * @param RoleId
     * @return
     */
    long countUsersByRoleId(Integer RoleId);

}
