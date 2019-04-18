package cn.bdqn.oaproject.dao.personnel;

import cn.bdqn.oaproject.pojo.LeaveApply;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 请假申请数据操作接口
 */
public interface LeaveApplyDao extends JpaRepository<LeaveApply,Integer> {



}
