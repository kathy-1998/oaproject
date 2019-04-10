package cn.bdqn.oaproject.pojo;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "LEAVE_APPLY")
public class LeaveApply {
    /**
     *请假申请记录id
     */
    @Id
    @Column(name="LEAVE_APPLY_ID")
    private Integer leaveApplyId;

    /**
     *请假申请用户编号
     */
    @Column(name = "LEAVE_APPLY_USER_ID")
    private Integer leaveApplyUserId;

    /**
     * 请假申请用户姓名
     */
    @Column(name = "LEAVE_APPLY_USER_NAME")
    private String leaveApplyUserName;

    /**
     * 请假申请用户所属部门id
     */
    @Column(name = "DEPT_ID")
    private Integer deptId;

    /**
     * 请假申请起始时间
     */
    @Column(name = "START_TIME")
    private Date startTime;

    /**
     * 请假申请结束时间
     */
    @Column(name = "END_TIME")
    private Date endTime;

    /**
     * 请假天数
     */
    @Column(name = "LEAVE_DAYS")
    private Integer leaveDays;

    /**
     * 请假类型id
     */
    @Column(name = "LEAVE_TYPE_ID")
    private Integer leaveTypeId;

    /**
     * 请假事由
     */
    @Column(name = "REASON_FOR_A_LEAVE")
    private String reasonForALeave;

    /**
     * 任务类型id
     */
    @Column(name = "TASK_TYPE_ID")
    private Integer taskTypeId;

    /**
     * 申请状态（待审批、审批已通过、审批未通过）
     */
    @Column(name = "STATUS")
    private Integer status;

    /**
     * 审批人ID（对应用户表中拥有审批权限的id）
     */
    @Column(name = "USER_ID")
    private Integer userId;
    /**
     * 创建者
     */
    @Column(name="CREATOR")
    private Integer creator;

    /**
     * 创建日期
     */
    @Column(name="CREATION_DATE")
    private Date creationDate;

    /**
     * 修改者
     */
    @Column(name="MENDER")
    private Integer mender;

    /**
     * 修改日期
     */
    @Column(name="MODIFY_DATE")
    private Date modifyDate;

    /**
     * 是否删除(0:是,1:不是)
     */
    @Column(name="ISDELETE")
    private Integer isdelete;

    public Integer getLeaveApplyId() {
        return leaveApplyId;
    }

    public void setLeaveApplyId(Integer leaveApplyId) {
        this.leaveApplyId = leaveApplyId;
    }

    public Integer getLeaveApplyUserId() {
        return leaveApplyUserId;
    }

    public void setLeaveApplyUserId(Integer leaveApplyUserId) {
        this.leaveApplyUserId = leaveApplyUserId;
    }

    public String getLeaveApplyUserName() {
        return leaveApplyUserName;
    }

    public void setLeaveApplyUserName(String leaveApplyUserName) {
        this.leaveApplyUserName = leaveApplyUserName;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getLeaveDays() {
        return leaveDays;
    }

    public void setLeaveDays(Integer leaveDays) {
        this.leaveDays = leaveDays;
    }

    public Integer getLeaveTypeId() {
        return leaveTypeId;
    }

    public void setLeaveTypeId(Integer leaveTypeId) {
        this.leaveTypeId = leaveTypeId;
    }

    public String getReasonForALeave() {
        return reasonForALeave;
    }

    public void setReasonForALeave(String reasonForALeave) {
        this.reasonForALeave = reasonForALeave;
    }

    public Integer getTaskTypeId() {
        return taskTypeId;
    }

    public void setTaskTypeId(Integer taskTypeId) {
        this.taskTypeId = taskTypeId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getCreator() {
        return creator;
    }

    public void setCreator(Integer creator) {
        this.creator = creator;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Integer getMender() {
        return mender;
    }

    public void setMender(Integer mender) {
        this.mender = mender;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public Integer getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Integer isdelete) {
        this.isdelete = isdelete;
    }
}
