package cn.bdqn.oaproject.pojo;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

import javax.annotation.Generated;
import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

/**
 * 部门表
 */
@Entity
@Table(name = "DEPT")
public class Dept {
    /**
     * 部门编号
     */
    @Id
    @Column(name = "DEPT_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mySeqGenerator")
    @SequenceGenerator(name = "mySeqGenerator", sequenceName = "t_dept_sequence", initialValue = 3, allocationSize = 1)

    private Integer deptId;


    /**
     *部门名称
     */
    @Column(name = "DEPT_NAME")
    private String deptName;

    /**
     *部门负责人（对应用户表中的用户编号）
     */
    @Column(name = "USER_ID")
    private Integer userId;

    /**
     *联系电话
     */
    @Column(name = "CONTACT_NUMBER")
    private String contactNumber;

    /**
     *移动电话
     */
    @Column(name = "PHONE")
    private String phone;

    /**
     *传真
     */
    @Column(name = "ELECTRICAL_TRANSMISSION")
    private String electricalTransmission;
    /**
     * 创建者
     */
    @Column(name="CREATOR",updatable=false)
    private Integer creator;

    /**
     * 创建日期
     */
    @Column(name="CREATION_DATE",updatable=false)
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

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getElectricalTransmission() {
        return electricalTransmission;
    }

    public void setElectricalTransmission(String electricalTransmission) {
        this.electricalTransmission = electricalTransmission;
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
