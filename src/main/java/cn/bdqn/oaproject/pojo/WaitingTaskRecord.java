package cn.bdqn.oaproject.pojo;

import javax.persistence.*;
import java.util.Date;

/**
 * 待处理任务记录表
 */
@Entity
@Table(name = "WAITING_TASK_RECORD")
public class WaitingTaskRecord {
    /**
     * 任务id（自增）
     */
    @Id
    @Column(name = "WAITING_TASK_RECORD_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer waitingTaskRecordId;
    /**
     * 任务名称
     */
    @Column(name = "WAITING_TASK_RECORD_NAME")
    private String waitingTaskRecordName;

    /**
     * 任务类型id
     */
    @Column(name = "TASK_TYPE_ID")
    private Integer taskTypeId;

    /**
     * 申请记录id
     */
    @Column(name = "APPLY_ID")
    private Integer applyId;

    /**
     * 申请记录中的申请时间
     */
    @Column(name = "APPLY_TIME")
    private Date applyTime;

    /**
     * 发起人
     */
    @Column(name = "INITIATOR_ID")
    private Integer initiatorId;

    /**
     * 审批人id
     */
    @Column(name = "USER_ID")
    private Integer userId;

    /**
     * 审批意见（审核时进行修改）
     */
    @Column(name = "APPLY_OPINION")
    private String applyOpinion;

    /**
     * 最后审批时间
     */
    @Column(name = "FINAL_APPROVAL_TIME")
    private Date finalApprovalTime;

    /**
     * 任务审批状态（待审核、审核通过、审核未通过）
     */
    @Column(name = "STATUS")
    private Integer status;
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

    public Integer getWaitingTaskRecordId() {
        return waitingTaskRecordId;
    }

    public void setWaitingTaskRecordId(Integer waitingTaskRecordId) {
        this.waitingTaskRecordId = waitingTaskRecordId;
    }

    public String getWaitingTaskRecordName() {
        return waitingTaskRecordName;
    }

    public void setWaitingTaskRecordName(String waitingTaskRecordName) {
        this.waitingTaskRecordName = waitingTaskRecordName;
    }

    public Integer getTaskTypeId() {
        return taskTypeId;
    }

    public void setTaskTypeId(Integer taskTypeId) {
        this.taskTypeId = taskTypeId;
    }

    public Integer getApplyId() {
        return applyId;
    }

    public void setApplyId(Integer applyId) {
        this.applyId = applyId;
    }

    public Date getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    public Integer getInitiatorId() {
        return initiatorId;
    }

    public void setInitiatorId(Integer initiatorId) {
        this.initiatorId = initiatorId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getApplyOpinion() {
        return applyOpinion;
    }

    public void setApplyOpinion(String applyOpinion) {
        this.applyOpinion = applyOpinion;
    }

    public Date getFinalApprovalTime() {
        return finalApprovalTime;
    }

    public void setFinalApprovalTime(Date finalApprovalTime) {
        this.finalApprovalTime = finalApprovalTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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
