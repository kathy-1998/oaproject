package cn.bdqn.oaproject.service.sysmanage;

import cn.bdqn.oaproject.pojo.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 * 用户业务操作接口
 */
public interface UsersService {

    Users findByUserName(String UserName);

    Boolean modify(String userpwd,Integer id );

    Page<Users> findAll(Specification<Users> specification, Pageable pageable);

}
