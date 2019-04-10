package cn.bdqn.oaproject.pojo;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Users {
    private Integer userId;
    private String userName;
    private String userPwd;
    private String realName;
    private Integer gender;
    private Integer deptId;
    private Integer roleId;
    private Integer jobId;
    private Integer status;
    private String userUrl;
    private Integer creator;
    private Date creationDate;
    private Integer mender;
    private Date modifyDate;
    private Integer isdelete;
    private Integer isadmin;


}
