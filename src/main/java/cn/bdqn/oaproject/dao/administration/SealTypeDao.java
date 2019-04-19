package cn.bdqn.oaproject.dao.administration;

import cn.bdqn.oaproject.pojo.SealType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用章类型数据操作
 */
@Repository
public interface SealTypeDao extends JpaRepository<SealType,Integer> {

    /**
     * 获取所有用章类型
     * @return
     */
    List<SealType> findAll();
}
