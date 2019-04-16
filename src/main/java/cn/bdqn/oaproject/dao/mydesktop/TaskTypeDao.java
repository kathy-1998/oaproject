package cn.bdqn.oaproject.dao.mydesktop;

import cn.bdqn.oaproject.pojo.TaskType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 任务类型数据操作
 */
public interface TaskTypeDao extends JpaRepository<TaskType,Integer> {

    /**
     * 查询全部信息
     * @return
     */
    @Override
    List<TaskType> findAll();
}
