package cn.bdqn.oaproject.dao.mydesktop;

import cn.bdqn.oaproject.pojo.WaitingTaskRecord;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * 待处理任务数据操作
 */
public interface WaitingTaskRecordDao extends JpaRepository<WaitingTaskRecord,Integer>, JpaSpecificationExecutor<WaitingTaskRecord> {

    /**
     * 分页获取信息
     * @param specification
     * @param pageable
     * @return
     */
    @Override
    Page<WaitingTaskRecord> findAll(Specification<WaitingTaskRecord> specification, Pageable pageable);

    /**
     * 查询发起人或者审批人都是当前用户的待处理事务
     * @param userId
     * @return
     */
    @Query("select w from WaitingTaskRecord w where w.initiatorId=?1 or w.userId=?1")
    List<WaitingTaskRecord> findInfoById(Integer userId);

    /**
     * 审批
     * @param userId
     * @param applyOpinion
     * @param id
     */
    @Modifying
    @Query("update WaitingTaskRecord w set w.userId=?1,w.applyOpinion = ?2 where w.waitingTaskRecordId =?3")
    void modifyInfo(Integer userId,String applyOpinion,Integer id);


}
