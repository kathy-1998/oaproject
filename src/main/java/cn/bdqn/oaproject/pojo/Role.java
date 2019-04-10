package cn.bdqn.oaproject.pojo;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Date;

@Entity
public class Role {
    private Integer roleId;
    private String roleName;
    private Integer roleSort;
    private Integer creator;
    private Date creationDate;
    private Integer mender;
    private Date modifyDate;
    private Integer isdelete;


}
