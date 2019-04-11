package cn.bdqn.oaproject.service.administration.impl;

import cn.bdqn.oaproject.dao.administration.BoardroomDao;
import cn.bdqn.oaproject.pojo.Boardroom;
import cn.bdqn.oaproject.service.administration.BoardroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BoardroomServiceImpl implements BoardroomService {

    @Autowired
    private BoardroomDao boardroomDao;

    /**
     * 获取所有会议室信息
     * @return
     */
    @Override
    public List<Boardroom> findAllBoardroom() {
        List<Boardroom> boardrooms=null;
        try {
            boardrooms=boardroomDao.findAllByIsdeleteNot(0);
        }catch (Exception e){
            e.printStackTrace();
        }
        return boardrooms;
    }

    /**
     * 添加会议室
     * @param boardroom 会议室对象
     * @return 是否成功
     */
    @Override
    public boolean addNewBoardroom(Boardroom boardroom) {
        try {
            boardroomDao.save(boardroom);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 修改会议室信息
     * @param boardroom 会议室信息
     * @return
     */
    @Override
    public boolean updateBoardroom(Boardroom boardroom) {
        try {
            boardroomDao.save(boardroom);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 根据编号删除会议室
     * @param id 会议室编号
     * @return 是否成功
     */
    @Override
    public boolean delBoardroom(Integer id) {
        try {
            boardroomDao.deleteByMeetingroomNo(id);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 根据会议室编号获取会议室对象
     * @param id
     * @return
     */
    @Override
    public Boardroom findByMeetingroomNo(Integer id) {
        Boardroom boardroom=null;
        try{
            boardroom=boardroomDao.findByMeetingroomNo(id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return boardroom;
    }
}
