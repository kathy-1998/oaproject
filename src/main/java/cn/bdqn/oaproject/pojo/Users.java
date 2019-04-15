package cn.bdqn.oaproject.pojo;

import javax.persistence.*;
import java.util.Date;

/**
 * 用户表
 */
@Entity
@Table(name = "USERS")
public class Users {
    /**
     * 用户编号
     */
    @Id
    @Column(name = "USER_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mySeqGenerator")
    @SequenceGenerator(name = "mySeqGenerator", sequenceName = "t_users_sequence", initialValue = 4, allocationSize = 1)
    private Integer userId;

    /**
     * 用户名
     */
    @Column(name = "USER_NAME")
    private String userName;

    /**
     * 用户密码
     */
    @Column(name = "USER_PWD")
    private String userPwd;

    /**
     * 真实姓名
     */
    @Column(name = "REAL_NAME")
    private String realName;

    /**
     * 性别
     */
    @Column(name = "GENDER")
    private Integer gender;

    /**
     * 部门编号
     */
  /*  @Column(name = "DEPT_ID")
    private Integer deptId;*/


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "dept_id")
    private  Dept dept;




    /**
     * 角色编号
     */
   /* @Column(name = "ROLE_ID")
    private Integer roleId;*/

   @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_Id")
    private  Role role;

   public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

  /*  public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }*/

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    /**
     * 职称编号
     */
   /* @Column(name = "JOB_ID")
    private Integer jobId;*/
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "job_id")
    private  Job job;

    /**
     * 用户状态(0:正常、1:冻结）
     */
    @Column(name = "STATUS")
    private Integer status;

    /**
     * 用户头像URL
     */
    @Column(name = "USER_URL")
    private String userUrl;
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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

/*    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }*/

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }



    /*
    public Integer getJobId() {
        return jobId;
    }

    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }*/

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getUserUrl() {
        return userUrl;
    }

    public void setUserUrl(String userUrl) {
        this.userUrl = userUrl;
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
