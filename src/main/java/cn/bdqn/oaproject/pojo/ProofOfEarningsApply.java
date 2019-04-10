package cn.bdqn.oaproject.pojo;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "PROOF_OF_EARNINGS_APPLY")
public class ProofOfEarningsApply {
    private Integer proofOfEarningsApplyId;
    private Integer applyUserId;
    private String applyUserName;
    private Integer deptId;
    private Integer jobId;
    private String applyForReason;
    private Integer taskTypeId;
    private Integer status;
    private Integer userId;
    private Integer creator;
    private Date creationDate;
    private Integer mender;
    private Date modifyDate;
    private Integer isdelete;


}
