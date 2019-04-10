package cn.bdqn.oaproject.pojo;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Time;
import java.util.Date;
import java.util.Objects;

@Entity
public class Job {
    private Integer jobId;
    private String jobName;
    private Integer creator;
    private Date creationDate;
    private Integer mender;
    private Date modifyDate;
    private Integer isdelete;

}
