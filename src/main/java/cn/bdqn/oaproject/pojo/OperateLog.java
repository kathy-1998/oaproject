package cn.bdqn.oaproject.pojo;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "OPERATE_LOG")
public class OperateLog {
    private Integer logNo;
    private Integer userId;
    private Integer roleId;
    private String logContents;
    private String remark;
    private Integer creator;
    private Date creationDate;
    private Integer mender;
    private Date modifyDate;
    private Integer isdelete;


}
