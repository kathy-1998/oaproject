package cn.bdqn.oaproject.service.administration;

import cn.bdqn.oaproject.pojo.SealApply;
import org.springframework.data.repository.query.Param;

/**
 * 用章申请业务操作接口
 */
public interface SealApplyService {

    /**
     * 添加用章申请记录
     * @param sealApply
     * @return
     */
    boolean addNewSealApply(SealApply sealApply) throws Exception;

    /**
     * 根据用章申请记录id和任务类型id获取用章申请详情
     * @param sealApplyId
     * @param taskTypeId
     * @return
     */
    SealApply findBySealApplyIdAndTaskTypeId(Integer sealApplyId, Integer taskTypeId)throws Exception;

    /**
     * 对申请进行审批操作
     * @param sealApplyId 用章申请id
     * @param status 修改申请状态
     */
    boolean approveSealApply(@Param("sealTypeId") Integer sealApplyId, @Param("status")Integer status);

    SealApply getInfoById(Integer id);
}
