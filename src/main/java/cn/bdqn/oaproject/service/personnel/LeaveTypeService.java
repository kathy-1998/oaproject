package cn.bdqn.oaproject.service.personnel;

import cn.bdqn.oaproject.pojo.LeaveType;

import java.util.List;

/**
 * 请假类型业务操作接口
 */
public interface LeaveTypeService {


    List<LeaveType> findAll();
}
