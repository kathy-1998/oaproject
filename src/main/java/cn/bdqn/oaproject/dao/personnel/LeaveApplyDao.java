package cn.bdqn.oaproject.dao.personnel;

import cn.bdqn.oaproject.pojo.LeaveApply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * 请假申请数据操作接口
 */
public interface LeaveApplyDao extends JpaRepository<LeaveApply,Integer> {


    @Query("select l from LeaveApply l where l.leaveApplyId=?1")
    LeaveApply findInfoById(Integer id);

}
