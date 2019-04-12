package cn.bdqn.oaproject.service.administration.impl;

import cn.bdqn.oaproject.dao.administration.BoardroomOrderDao;
import cn.bdqn.oaproject.pojo.BoardroomOrder;
import cn.bdqn.oaproject.service.administration.BoardroomOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BoardroomOrderServiceImpl implements BoardroomOrderService {

    @Autowired
    private BoardroomOrderDao boardroomOrderDao;

    /**
     * 添加会议室预订记录
     * @param boardroomOrder 预订记录对象
     * @return
     */
    @Override
    public boolean addRoomOrder(BoardroomOrder boardroomOrder) {
        try {
            boardroomOrderDao.save(boardroomOrder);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 根据记录编号删除
     * @param id 会议室预订编号
     * @return
     */
    @Override
    public boolean deleteByReservationNo(Integer id) {
        try {
            boardroomOrderDao.deleteByReservationNo(id);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 根据预订编号获取详情
     * @param reservationNo 会议室预订记录编号
     * @return
     */
    @Override
    public BoardroomOrder findByReservationNo(Integer reservationNo) {
        BoardroomOrder boardroomOrder=null;
        try {
            boardroomOrder=boardroomOrderDao.findByReservationNo(reservationNo);
        }catch (Exception e){
            e.printStackTrace();
        }
        return boardroomOrder;
    }

    /**
     * 根据条件获取预订记录
     * @param condition
     * @return
     */
    @Override
    public List<BoardroomOrder> findAll(Specification<BoardroomOrder> condition) {
        List<BoardroomOrder> list=null;
        try {
            list=boardroomOrderDao.findAll(condition);
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
}
