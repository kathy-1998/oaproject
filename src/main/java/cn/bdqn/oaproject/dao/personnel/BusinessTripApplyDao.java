package cn.bdqn.oaproject.dao.personnel;

import cn.bdqn.oaproject.pojo.BusinessTripApply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * 出差申请数据操作接口
 */
public interface BusinessTripApplyDao extends JpaRepository<BusinessTripApply,Integer> {


    @Query("select b from BusinessTripApply b where b.businessTripApplyId=?1")
    BusinessTripApply findInfoById(Integer id);


}
