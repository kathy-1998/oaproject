package cn.bdqn.oaproject.pojo;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "BUSINESS_CARD_APPLY")
public class BusinessCardApply {
    private Integer businessCardApplyId;
    private Integer applyId;
    private String applyName;
    private Integer applyDeptId;
    private Integer jobId;
    private String phone;
    private String landlineno;
    private Integer quantity;
    private String remark;
    private Integer taskTypeId;
    private Integer status;
    private Integer userId;
    private Integer creator;
    private Date creationDate;
    private Integer mender;
    private Date modifyDate;
    private Integer isdelete;



}
