package cn.bdqn.oaproject.pojo;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "SEAL_APPLY")
public class SealApply {
    private Integer sealApplyId;
    private Integer applyUserId;
    private String userName;
    private Integer deptId;
    private Date applyTime;
    private Integer sealTypeId;
    private String theOriginOfAnIncident;
    private Integer taskTypeId;
    private Integer status;
    private Integer userId;
    private Integer creator;
    private Date creationDate;
    private Integer mender;
    private Date modifyDate;
    private Integer isdelete;


}
