package cn.bdqn.oaproject.service.mydesktop;

import cn.bdqn.oaproject.pojo.TaskType;

import java.util.List;

/**
 * 任务类型业务操作接口
 */
public interface TaskTypeService {

    /**
     * 查询全部信息
     * @return
     */
    List<TaskType> findAll();
}
