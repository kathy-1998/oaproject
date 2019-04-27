package cn.bdqn.oaproject.service.personnel;

import cn.bdqn.oaproject.pojo.LeaveApply;

/**
 * 请假申请业务操作接口
 */
public interface LeaveApplyService {

    boolean add(LeaveApply leaveApply);

    LeaveApply getInfoById(Integer id);
}
