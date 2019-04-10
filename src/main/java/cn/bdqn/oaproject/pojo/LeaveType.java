package cn.bdqn.oaproject.pojo;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "LEAVE_TYPE")
public class LeaveType {
    private Integer leaveTypeId;
    private String leaveTypeName;


}
