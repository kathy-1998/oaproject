package cn.bdqn.oaproject.pojo;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;
import java.util.Objects;

/**
 * 出差申请记录表
 */
@Entity
@Table(name = "BUSINESS_TRIP_APPLY")
public class BusinessTripApply {

    /**
     * 出差申请记录id
     */
    @Id
    @Column(name="BUSINESS_TRIP_APPLY_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer businessTripApplyId;

    /**
     *出差申请用户编号
     */
    @Column(name="BUSINESS_TRIP_APPLY_USER_ID")
    private Integer businessTripApplyUserId;

    /**
     *出差申请用户名称
     */
    @Column(name="BUSINESS_TRIP_APPLY_USER_NAME")
    private String businessTripApplyUserName;

    /**
     *出差申请用户所属部门
     */
    @Column(name="DEPT_ID")
    private Integer deptId;

    /**
     *出差申请起始时间
     */
    @Column(name="START_TIME")
    private Date startTime;

    /**
     *出差申请结束时间
     */
    @Column(name="END_TIME")
    private Date endTime;

    /**
     *出差地点
     */
    @Column(name="PLACE_OFBUSINESS_TRIP")
    private String placeOfbusinessTrip;

    /**
     *交通工具类型id
     */
    @Column(name="VEHICLE_TYPE_ID")
    private Integer vehicleTypeId;

    /**
     *出差事由
     */
    @Column(name="TRAVEL_REASON")
    private String travelReason;

    /**
     *工作任务
     */
    @Column(name="WORK_TASK")
    private String workTask;

    /**
     *借款金额
     */
    @Column(name="BORROWING_BALANCE")
    private Integer borrowingBalance;

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

    public Integer getBusinessTripApplyId() {
        return businessTripApplyId;
    }

    public void setBusinessTripApplyId(Integer businessTripApplyId) {
        this.businessTripApplyId = businessTripApplyId;
    }

    public Integer getBusinessTripApplyUserId() {
        return businessTripApplyUserId;
    }

    public void setBusinessTripApplyUserId(Integer businessTripApplyUserId) {
        this.businessTripApplyUserId = businessTripApplyUserId;
    }

    public String getBusinessTripApplyUserName() {
        return businessTripApplyUserName;
    }

    public void setBusinessTripApplyUserName(String businessTripApplyUserName) {
        this.businessTripApplyUserName = businessTripApplyUserName;
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

    public String getPlaceOfbusinessTrip() {
        return placeOfbusinessTrip;
    }

    public void setPlaceOfbusinessTrip(String placeOfbusinessTrip) {
        this.placeOfbusinessTrip = placeOfbusinessTrip;
    }

    public Integer getVehicleTypeId() {
        return vehicleTypeId;
    }

    public void setVehicleTypeId(Integer vehicleTypeId) {
        this.vehicleTypeId = vehicleTypeId;
    }

    public String getTravelReason() {
        return travelReason;
    }

    public void setTravelReason(String travelReason) {
        this.travelReason = travelReason;
    }

    public String getWorkTask() {
        return workTask;
    }

    public void setWorkTask(String workTask) {
        this.workTask = workTask;
    }

    public Integer getBorrowingBalance() {
        return borrowingBalance;
    }

    public void setBorrowingBalance(Integer borrowingBalance) {
        this.borrowingBalance = borrowingBalance;
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
