package cn.bdqn.oaproject.service.administration;

import cn.bdqn.oaproject.pojo.BoardroomOrder;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

/**
 * 会议室预订业务操作接口
 */
public interface BoardroomOrderService {

    /**
     * 添加会议室预订记录
     * @param boardroomOrder 预订记录对象
     * @return true表示成功，false失败
     */
    boolean addRoomOrder(BoardroomOrder boardroomOrder);

    /**
     * 根据会议室编号删除会议室预订记录
     * @param id 会议室预订编号
     * @return true表示成功，false失败
     */
    boolean deleteByReservationNo(Integer id);

    /**
     * 根据会议室预订编号查询预订详情
     * @param reservationNo 会议室预订记录编号
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
