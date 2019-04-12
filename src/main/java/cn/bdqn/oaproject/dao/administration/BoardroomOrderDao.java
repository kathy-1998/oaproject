package cn.bdqn.oaproject.dao.administration;

import cn.bdqn.oaproject.pojo.BoardroomOrder;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 会议室预订数据操作
 */
@Repository
public interface BoardroomOrderDao extends JpaRepository<BoardroomOrder,Integer>, JpaSpecificationExecutor<BoardroomOrder> {

    /**
     * 新增会议室预订记录
     * @param s
     * @param <S>
     * @return
     */
    @Override
    <S extends BoardroomOrder> S save(S s);

    /**
     * 根据会议室编号删除会议室预订记录
     * @param id
     */
    void deleteByReservationNo(Integer id);

    /**
     * 根据会议室预订编号查询预订详情
     * @param reservationNo
     * @return
     */
    BoardroomOrder findByReservationNo(Integer reservationNo);

    /**
     *  查询会议室预订信息（根据预订起始时间，预订结束时间，预订人模糊查、会议室名称模糊查、会议室类型）
     * @param condition
     * @return
     */
    List<BoardroomOrder> findAll(Specification<BoardroomOrder> condition);






}
