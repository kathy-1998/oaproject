package cn.bdqn.oaproject.dao.personnel;

import cn.bdqn.oaproject.pojo.LeaveApply;
import cn.bdqn.oaproject.pojo.LeaveType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 请假类型数据操作接口
 */
public interface LeaveTypeDao extends JpaRepository<LeaveType,Integer> {

    @Override
    List<LeaveType> findAll();
}
