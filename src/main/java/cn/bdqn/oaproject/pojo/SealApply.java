package cn.bdqn.oaproject.pojo;

import javax.persistence.*;
import java.util.Date;

/**
 * 用章申请表
 */
@Entity
@Table(name = "SEAL_APPLY")
public class SealApply {
    /**
     * 申请记录id
     */
    @Id
    @Column(name = "SEAL_APPLY_ID")
    private Integer sealApplyId;

    /**
     * 申请用户编号（对应当前登录用户编号）
     */
    @Column(name = "APPLY_USER_ID")
    private Integer applyUserId;

    /**
     * 申请用户姓名
     */
    @Column(name = "USER_NAME")
    private String userName;

    /**
     *申请部门id（对应部门表中的部门编号）
     */
    @Column(name = "DEPT_ID")
    private Integer deptId;

    /**
     * 申请时间
     */
    @Column(name = "APPLY_TIME")
    private Date applyTime;

    /**
     * 用章类型id（对应用章类型表中的类型编号）
     */
    @Column(name = "SEAL_TYPE_ID")
    private Integer sealTypeId;

    /**
     * 用章事由
     */
    @Column(name = "THE_ORIGIN_OF_AN_INCIDENT")
    private String theOriginOfAnIncident;

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

    public Integer getSealApplyId() {
        return sealApplyId;
    }

    public void setSealApplyId(Integer sealApplyId) {
        this.sealApplyId = sealApplyId;
    }

    public Integer getApplyUserId() {
        return applyUserId;
    }

    public void setApplyUserId(Integer applyUserId) {
        this.applyUserId = applyUserId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public Date getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    public Integer getSealTypeId() {
        return sealTypeId;
    }

    public void setSealTypeId(Integer sealTypeId) {
        this.sealTypeId = sealTypeId;
    }

    public String getTheOriginOfAnIncident() {
        return theOriginOfAnIncident;
    }

    public void setTheOriginOfAnIncident(String theOriginOfAnIncident) {
        this.theOriginOfAnIncident = theOriginOfAnIncident;
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
