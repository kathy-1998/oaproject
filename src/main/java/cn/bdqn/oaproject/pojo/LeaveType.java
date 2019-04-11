package cn.bdqn.oaproject.pojo;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "LEAVE_TYPE")
public class LeaveType {
    /**
     * 请假类型id
     */
    @Id
    @Column(name="LEAVE_TYPE_ID")
    private Integer leaveTypeId;

    /**
     * 请假类型名称
     */
    @Column(name = "LEAVE_TYPE_NAME")
    private String leaveTypeName;

    public Integer getLeaveTypeId() {
        return leaveTypeId;
    }

    public void setLeaveTypeId(Integer leaveTypeId) {
        this.leaveTypeId = leaveTypeId;
    }

    public String getLeaveTypeName() {
        return leaveTypeName;
    }

    public void setLeaveTypeName(String leaveTypeName) {
        this.leaveTypeName = leaveTypeName;
    }
}
