package cn.bdqn.oaproject.pojo;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;
import java.util.Objects;

@Entity
public class Dept {
    private Integer deptId;
    private String deptName;
    private Integer userId;
    private String contactNumber;
    private String phone;
    private String electricalTransmission;
    private Integer creator;
    private Date creationDate;
    private Integer mender;
    private Date modifyDate;
    private Integer isdelete;


}
