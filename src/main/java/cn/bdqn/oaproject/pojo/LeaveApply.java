package cn.bdqn.oaproject.pojo;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "LEAVE_APPLY")
public class LeaveApply {

    private Integer leaveApplyId;
    private Integer leaveApplyUserId;
    private String leaveApplyUserName;
    private Integer deptId;
    private Date startTime;
    private Date endTime;
    private Integer leaveDays;
    private Integer leaveTypeId;
    private String reasonForALeave;
    private Integer taskTypeId;
    private Integer status;
    private Integer userId;
    private Integer creator;
    private Date creationDate;
    private Integer mender;
    private Date modifyDate;
    private Integer isadmin;


}
