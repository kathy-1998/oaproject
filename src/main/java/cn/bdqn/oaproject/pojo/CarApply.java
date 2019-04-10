package cn.bdqn.oaproject.pojo;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "CAR_APPLY")
public class CarApply {
    private Integer carApplyId;
    private Integer carNo;
    private String transportPeople;
    private String driver;
    private String entourage;
    private Integer deptNo;
    private Date startTime;
    private Date endTime;
    private String destination;
    private Integer mileage;
    private String theOriginOfAnIncident;
    private Integer taskId;
    private Integer status;
    private Integer theApproverId;
    private Integer creator;
    private Date creationDate;
    private Integer mender;
    private Date modifyDate;
    private Integer isdelete;


}
