package cn.bdqn.oaproject.dao.administration;

import cn.bdqn.oaproject.pojo.SealApply;
import org.hibernate.sql.Update;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * 用章申请记录数据操作
 */
@Repository
public interface SealApplyDao extends JpaRepository<SealApply,Integer> {

    /**
     * 添加用章申请记录
     * @param s
     * @param <S>
     * @return
     */
    @Override
    <S extends SealApply> S save(S s);

    /**
     * 根据用章申请记录id和任务类型id获取用章申请详情
     * @param sealApplyId
     * @param taskTypeId
     * @return
     */
    SealApply findBySealApplyIdAndTaskTypeId(Integer sealApplyId,Integer taskTypeId);

    /**
     * 对申请进行审批操作
     * @param sealApplyId 用章申请id
     * @param status 修改申请状态
     */
    @Modifying
    @Query("update SealApply s set s.status=:status where s.sealApplyId=:sealApplyId")
    void updateStatus(@Param("sealApplyId") Integer sealApplyId,@Param("status")Integer status);



}
