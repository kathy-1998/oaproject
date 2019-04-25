package cn.bdqn.oaproject.service.administration.impl;

import cn.bdqn.oaproject.dao.administration.BoardroomOrderDao;
import cn.bdqn.oaproject.pojo.BoardroomOrder;
import cn.bdqn.oaproject.pojo.WaitingTaskRecord;
import cn.bdqn.oaproject.service.administration.BoardroomOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class BoardroomOrderServiceImpl implements BoardroomOrderService {

    @Autowired
    private BoardroomOrderDao boardroomOrderDao;

    /**
     * 添加会议室预订记录
     *
     * @param boardroomOrder 预订记录对象
     * @return
     */
    @Override
    public boolean addRoomOrder(BoardroomOrder boardroomOrder) {
        try {
            BoardroomOrder boardroomOrder1=boardroomOrderDao.save(boardroomOrder);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 根据记录编号删除
     *
     * @param id 会议室预订编号
     * @return
     */
    @Override
    public boolean deleteByReservationNo(Integer id) {
        try {
            boardroomOrderDao.deleteByReservationNo(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 根据预订编号获取详情
     *
     * @param reservationNo 会议室预订记录编号
     * @return
     */
    @Override
    public BoardroomOrder findByReservationNo(Integer reservationNo) {
        BoardroomOrder boardroomOrder = null;
        try {
            boardroomOrder = boardroomOrderDao.findByReservationNo(reservationNo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return boardroomOrder;
    }

    /**
     * 根据条件获取预订记录
     *
     * @param boardroomOrder
     * @return
     */
    @Override
    public List<BoardroomOrder> findAll(BoardroomOrder boardroomOrder) {
        List<BoardroomOrder> list = null;
        try {
            //specification是jpa用来动态查询的一个接口
            Specification specification = new Specification<BoardroomOrder>() {
                @Override
                public Predicate toPredicate(Root root, CriteriaQuery criteriaQuery, CriteriaBuilder cb) {
                    List<Predicate> predicates = new ArrayList<>();
                    //判断预订起始时间
                    if (null != boardroomOrder.getStartTime()&&null != boardroomOrder.getEndTime()) {
                        predicates.add(cb.between(root.get("startTime"), boardroomOrder.getStartTime(),boardroomOrder.getEndTime()));
                    }

                    //判断预订人
                    if (null != boardroomOrder.getOrderPerson()&&boardroomOrder.getOrderPerson()>0) {
                        predicates.add(cb.like(root.get("orderPerson"), "%" + boardroomOrder.getOrderPerson() + "%"));
                    }
                    if(null!=boardroomOrder.getBoardroom().getMeetingroomName()&&!boardroomOrder.getBoardroom().getMeetingroomName().equals("")){
                    //判断会议室名称
                        predicates.add(cb.like(root.get("boardroom").get("meetingroomName"), "%" + boardroomOrder.getBoardroom().getMeetingroomName() + "%"));
                    }
                    //判断会议类型
                    if (null != boardroomOrder.getTypeId()&&boardroomOrder.getTypeId()>0) {
                        predicates.add(cb.equal(root.get("typeId"),  boardroomOrder.getTypeId()));
                    }
                    return cb.and(predicates.toArray(new Predicate[predicates.size()]));
                }
            };
            list = boardroomOrderDao.findAll(specification);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
