package cn.bdqn.oaproject.service.administration.impl;

import cn.bdqn.oaproject.dao.administration.BoardroomTypeDao;
import cn.bdqn.oaproject.pojo.BoardroomType;
import cn.bdqn.oaproject.service.administration.BoardroomTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 会议室类型业务操作实现类
 */
@Service
@Transactional
public class BoardroomTypeServiceImpl implements BoardroomTypeService {

    @Autowired
    private BoardroomTypeDao boardroomTypeDao;

    /**
     * 获取全部会议室类型
     * @return
     */
    @Override
    public List<BoardroomType> findAll() throws Exception{
        List<BoardroomType> list=null;
        try {
            list=boardroomTypeDao.findAllByIsdeleteNot(0);
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
}
