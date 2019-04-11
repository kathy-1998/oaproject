package cn.bdqn.oaproject.pojo;

import javax.persistence.*;

@Entity
@Table(name = "TASK_TYPE")
public class TaskType {
    /**
     * task_type
     */
    @Id
    @Column(name = "TASK_TYPE_ID")
    private Integer taskTypeId;

    /**
     * 类型名称
     */
    @Column(name = "TASK_TYPE_NAME")
    private String taskTypeName;

    public Integer getTaskTypeId() {
        return taskTypeId;
    }

    public void setTaskTypeId(Integer taskTypeId) {
        this.taskTypeId = taskTypeId;
    }

    public String getTaskTypeName() {
        return taskTypeName;
    }

    public void setTaskTypeName(String taskTypeName) {
        this.taskTypeName = taskTypeName;
    }
}
