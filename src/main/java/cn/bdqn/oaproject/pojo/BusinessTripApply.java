package cn.bdqn.oaproject.pojo;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "BUSINESS_TRIP_APPLY")
public class BusinessTripApply {

    @Id
    private Integer businessTripApplyId;
    private Integer businessTripApplyUserId;
    private String businessTripApplyUserName;
    private Integer deptId;
    private Date startTime;
    private Date endTime;
    private String placeOfbusinessTrip;
    private Integer vehicleTypeId;
    private String travelReason;
    private String workTask;
    private Integer borrowingBalance;
    private Integer taskTypeId;
    private Integer status;
    private Integer userId;
    private Integer creator;
    private Date creationDate;
    private Integer mender;
    private Date modifyDate;
    private Integer isdelete;

}
