package cn.bdqn.oaproject.service.mydesktop;

import cn.bdqn.oaproject.pojo.WaitingTaskRecord;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

/**
 * 待处理任务业务操作接口
 */
public interface WaitingTaskRecordService {

    /**
     * 分页查询
     * @param specification
     * @param pageable
     * @return
     */
    Page<WaitingTaskRecord> findAll(Specification<WaitingTaskRecord> specification, Pageable pageable);

    /**
     * 查询全部
     * @param userId
     * @return
     */
    List<WaitingTaskRecord> findInfoById(Integer userId);

    /**
     * 审批
     * @param userId
     * @param applyOpinion
     * @param id
     */
    void modifyInfo(Integer userId,String applyOpinion,Integer id);


    /**
     * 添加待处理任务
     */
    boolean addInfo(WaitingTaskRecord waitingTaskRecord);

}
