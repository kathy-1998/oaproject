package cn.bdqn.oaproject.pojo;

import javax.persistence.*;
import java.util.Date;

/**
 * 操作日志表
 */
@Entity
@Table(name = "OPERATE_LOG")
public class OperateLog {

    /**
     * 日志编号
     */
    @Id
    @Column(name = "LOG_NO")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mySeqGenerator")
    @SequenceGenerator(name = "mySeqGenerator", sequenceName = "t_log_sequence", initialValue = 3, allocationSize = 1)
    private Integer logNo;

    /**
     * 用户编号
     */
    @Column(name = "USER_ID")
    private Integer userId;

    /**
     * 角色编号
     */
    @Column(name = "ROLE_ID")
    private Integer roleId;

    /**
     * 日志内容
     */
    @Column(name = "LOG_CONTENTS")
    private String logContents;

    /**
     * 备注
     */
    @Column(name = "REMARK")
    private String remark;
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

    public Integer getLogNo() {
        return logNo;
    }

    public void setLogNo(Integer logNo) {
        this.logNo = logNo;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getLogContents() {
        return logContents;
    }

    public void setLogContents(String logContents) {
        this.logContents = logContents;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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
