package cn.bdqn.oaproject.pojo;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "WAITING_TASK_RECORD")
public class WaitingTaskRecord {
    private Integer waitingTaskRecordId;
    private String waitingTaskRecordName;
    private Integer taskTypeId;
    private Integer applyId;
    private Date applyTime;
    private Integer initiatorId;
    private Integer userId;
    private String applyOpinion;
    private Date finalApprovalTime;
    private Integer status;
    private Integer creator;
    private Date creationDate;
    private Integer mender;
    private Date modifyDate;
    private Integer isdelete;


}
