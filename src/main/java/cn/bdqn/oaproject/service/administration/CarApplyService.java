package cn.bdqn.oaproject.service.administration;

import cn.bdqn.oaproject.pojo.CarApply;
import org.springframework.data.repository.query.Param;

/**
 * 用车申请业务操作接口
 */
public interface CarApplyService {

    /**
     * 新增用车申请记录
     * @param carApply
     * @return
     */
    CarApply addCarApplyRecord(CarApply carApply)throws  Exception;

    /**
     * 根据申请记录id和任务类型id获取详情
     * @param carApplyId
     * @param taskId
     * @return
     */
    CarApply findByCarApplyIdAndTaskId(Integer carApplyId,Integer taskId)throws Exception;

    boolean approveCarApply(@Param("carApplyId") Integer carApplyId, @Param("status")Integer status)throws  Exception;

    CarApply getInfoById(Integer id);
}
