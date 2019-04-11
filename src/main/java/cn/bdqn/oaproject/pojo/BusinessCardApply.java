package cn.bdqn.oaproject.pojo;

import javax.persistence.*;
import java.util.Date;

/**
 * 名片印制申请记录表
 */
@Entity
@Table(name = "BUSINESS_CARD_APPLY")
public class BusinessCardApply {

    /**
     * 申请印制记录id
     */
    @Id
    @Column(name="BUSINESS_CARD_APPLY_ID")
    private Integer businessCardApplyId;

    /**
     * 申请用户id
     */
    @Column(name="APPLY_ID")
    private Integer applyId;

    /**
     * 申请用户姓名
     */
    @Column(name="APPLY_NAME")
    private String applyName;

    /**
     * 申请部门id
     */
    @Column(name="APPLY_DEPT_ID")
    private Integer applyDeptId;

    /**
     * 申请人职位id
     */
    @Column(name="JOB_ID")
    private Integer jobId;

    /**
     *手机号
     */
    @Column(name="PHONE")
    private String phone;

    /**
     *座机号
     */
    @Column(name="LANDLINENO")
    private String landlineno;

    /**
     *印制数量
     */
    @Column(name="QUANTITY")
    private Integer quantity;

    /**
     *备注
     */
    @Column(name="REMARK")
    private String remark;

    /**
     *任务类型id
     */
    @Column(name="TASK_TYPE_ID")
    private Integer taskTypeId;

    /**
     *申请状态（待审批、审批已通过、审批未通过）
     */
    @Column(name="STATUS")
    private Integer status;

    /**
     *审批人ID（对应用户表中拥有审批权限的id）
     */
    @Column(name="USER_ID")
    private Integer userId;

    /**
     *创建者
     */
    @Column(name="CREATOR")
    private Integer creator;

    /**
     *创建日期
     */
    @Column(name="CREATION_DATE")
    private Date creationDate;

    /**
     *修改者
     */
    @Column(name="MENDER")
    private Integer mender;

    /**
     *修改日期
     */
    @Column(name="MODIFY_DATE")
    private Date modifyDate;

    /**
     *是否删除
     */
    @Column(name="ISDELETE")
    private Integer isdelete;

    public Integer getBusinessCardApplyId() {
        return businessCardApplyId;
    }

    public void setBusinessCardApplyId(Integer businessCardApplyId) {
        this.businessCardApplyId = businessCardApplyId;
    }

    public Integer getApplyId() {
        return applyId;
    }

    public void setApplyId(Integer applyId) {
        this.applyId = applyId;
    }

    public String getApplyName() {
        return applyName;
    }

    public void setApplyName(String applyName) {
        this.applyName = applyName;
    }

    public Integer getApplyDeptId() {
        return applyDeptId;
    }

    public void setApplyDeptId(Integer applyDeptId) {
        this.applyDeptId = applyDeptId;
    }

    public Integer getJobId() {
        return jobId;
    }

    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLandlineno() {
        return landlineno;
    }

    public void setLandlineno(String landlineno) {
        this.landlineno = landlineno;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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
