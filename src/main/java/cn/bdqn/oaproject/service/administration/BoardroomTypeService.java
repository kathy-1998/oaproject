package cn.bdqn.oaproject.service.administration;

import cn.bdqn.oaproject.pojo.BoardroomType;

import java.util.List;

/**
 * 会议室类型业务操作接口
 */
public interface BoardroomTypeService {
    /**
     * 获取所有会议室类型
     * @return
     */
    List<BoardroomType> findAll() throws  Exception;


}
