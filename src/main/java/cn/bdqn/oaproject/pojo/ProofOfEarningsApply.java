package cn.bdqn.oaproject.pojo;

import javax.persistence.*;
import java.util.Date;

/**
 * 收入证明申请记录表
 */
@Entity
@Table(name = "PROOF_OF_EARNINGS_APPLY")
public class ProofOfEarningsApply {

    /**
     * 申请记录id
     */
    @Id
    @Column(name = "PROOF_OF_EARNINGS_APPLY_ID")
    private Integer proofOfEarningsApplyId;

    /**
     * 申请用户编号
     */
    @Column(name="APPLY_USER_ID")
    private Integer applyUserId;

    /**
     * 申请用户姓名
     */
    @Column(name="APPLY_USER_NAME")
    private String applyUserName;

    /**
     * 申请用户所属部门id
     */
    @Column(name="DEPT_ID")
    private Integer deptId;

    /**
     * 申请用户所属职位id
     */
    @Column(name="JOB_ID")
    private Integer jobId;

    /**
     * 申请事由
     */
    @Column(name="APPLY_FOR_REASON")
    private String applyForReason;

    /**
     * 任务类型id
     */
    @Column(name="TASK_TYPE_ID")
    private Integer taskTypeId;

    /**
     * 申请状态（待审批、审批已通过、审批未通过）
     */
    @Column(name="STATUS")
    private Integer status;

    /**
     * 审批人ID（对应用户表中拥有审批权限的id）
     */
    @Column(name="USER_ID")
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

    public Integer getProofOfEarningsApplyId() {
        return proofOfEarningsApplyId;
    }

    public void setProofOfEarningsApplyId(Integer proofOfEarningsApplyId) {
        this.proofOfEarningsApplyId = proofOfEarningsApplyId;
    }

    public Integer getApplyUserId() {
        return applyUserId;
    }

    public void setApplyUserId(Integer applyUserId) {
        this.applyUserId = applyUserId;
    }

    public String getApplyUserName() {
        return applyUserName;
    }

    public void setApplyUserName(String applyUserName) {
        this.applyUserName = applyUserName;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public Integer getJobId() {
        return jobId;
    }

    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }

    public String getApplyForReason() {
        return applyForReason;
    }

    public void setApplyForReason(String applyForReason) {
        this.applyForReason = applyForReason;
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
