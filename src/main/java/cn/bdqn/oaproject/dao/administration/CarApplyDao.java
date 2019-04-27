package cn.bdqn.oaproject.dao.administration;

import cn.bdqn.oaproject.pojo.CarApply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * 用车申请数据操作
 */
@Repository
public interface CarApplyDao extends JpaRepository<CarApply,Integer> {

    /**
     * 添加用车申请记录
     * @param s
     * @param <S>
     * @return
     */
    @Override
    <S extends CarApply> S save(S s);

    /**
     * 根据申请记录id和任务类型id获取详情
     * @param carApplyId
     * @param taskId
     * @return
     */
    CarApply findByCarApplyIdAndTaskId(Integer carApplyId,Integer taskId);


    /**
     * 修改用车申请状态
     * @param carApplyId
     * @param status
     */
    @Modifying
    @Query("update CarApply c set c.status=:status where c.carApplyId=:carApplyId")
    void updateStatus(@Param("carApplyId") Integer carApplyId, @Param("status")Integer status);

    @Query("select c from CarApply c where c.carApplyId=?1")
    CarApply findInfoById(Integer id);
}
