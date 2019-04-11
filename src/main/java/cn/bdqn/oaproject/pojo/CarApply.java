package cn.bdqn.oaproject.pojo;

import javax.persistence.*;
import java.util.Date;

/**
 * 用车申请记录表
 */
@Entity
@Table(name = "CAR_APPLY")
public class CarApply {

    /**
     * 申请记录id
     */
    @Id
    @Column(name="CAR_APPLY_ID")
    private Integer carApplyId;

    /**
     *
     */
    @Column(name="CAR_NO")
    private Integer carNo;

    /**
     *用车人
     */
    @Column(name="TRANSPORT_PEOPLE")
    private String transportPeople;

    /**
     *司机
     */
    @Column(name="DRIVER")
    private String driver;

    /**
     *随行人员
     */
    @Column(name="ENTOURAGE")
    private String entourage;

    /**
     *用车部门编号（当前登录用户所属部门编号）
     */
    @Column(name="DEPT_NO")
    private Integer deptNo;

    /**
     *用车起始时间
     */
    @Column(name="START_TIME")
    private Date startTime;

    /**
     *用车截至时间
     */
    @Column(name="END_TIME")
    private Date endTime;

    /**
     *目的地
     */
    @Column(name="DESTINATION")
    private String destination;

    /**
     *申请里程（km）
     */
    @Column(name="MILEAGE")
    private Integer mileage;

    /**
     *用车事由
     */
    @Column(name="THE_ORIGIN_OF_AN INCIDENT")
    private String theOriginOfAnIncident;

    /**
     *任务类型id
     */
    @Column(name="TASK_ID")
    private Integer taskId;

    /**
     *用车申请状态（待审批、审批已通过、审批未通过）
     */
    @Column(name="STATUS")
    private Integer status;

    /**
     *审批人ID（对应用户表中拥有审批权限的id）
     */
    @Column(name="THE_APPROVER_ID")
    private Integer theApproverId;
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

    public Integer getCarApplyId() {
        return carApplyId;
    }

    public void setCarApplyId(Integer carApplyId) {
        this.carApplyId = carApplyId;
    }

    public Integer getCarNo() {
        return carNo;
    }

    public void setCarNo(Integer carNo) {
        this.carNo = carNo;
    }

    public String getTransportPeople() {
        return transportPeople;
    }

    public void setTransportPeople(String transportPeople) {
        this.transportPeople = transportPeople;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getEntourage() {
        return entourage;
    }

    public void setEntourage(String entourage) {
        this.entourage = entourage;
    }

    public Integer getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(Integer deptNo) {
        this.deptNo = deptNo;
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

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    public String getTheOriginOfAnIncident() {
        return theOriginOfAnIncident;
    }

    public void setTheOriginOfAnIncident(String theOriginOfAnIncident) {
        this.theOriginOfAnIncident = theOriginOfAnIncident;
    }

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getTheApproverId() {
        return theApproverId;
    }

    public void setTheApproverId(Integer theApproverId) {
        this.theApproverId = theApproverId;
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
