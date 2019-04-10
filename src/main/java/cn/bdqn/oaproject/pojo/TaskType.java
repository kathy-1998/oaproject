package cn.bdqn.oaproject.pojo;

import javax.persistence.*;

@Entity
@Table(name = "TASK_TYPE")
public class TaskType {
    private Integer taskTypeId;
    private String taskTypeName;


}
