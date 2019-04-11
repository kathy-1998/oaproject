package cn.bdqn.oaproject.service.administration;

import cn.bdqn.oaproject.pojo.Boardroom;

import java.util.List;

/**
 * 会议室业务操作接口
 */
public interface BoardroomService {

    /**
     *  获取所有会议室
     * @return 会议室列表
     */
    List<Boardroom> findAllBoardroom()throws  Exception;

    /**
     * 新增会议室
     * @param boardroom 会议室对象
     * @return
     */
    boolean addNewBoardroom(Boardroom boardroom)throws  Exception;

    /**
     * 修改会议室
     * @param boardroom
     * @return
     */
    boolean updateBoardroom(Boardroom boardroom)throws  Exception;

    /**
     * 删除会议室
     * @param id
     * @return
     */
    boolean delBoardroom(Integer id)throws  Exception;

    /**
     * 根据会议室编号获取会议室对象
     * @param id
     * @return
     */
    Boardroom findByMeetingroomNo(Integer id);




}
