package cn.bdqn.oaproject.dao.administration;

import cn.bdqn.oaproject.pojo.Boardroom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 会议室数据操作
 */
@Repository
public interface BoardroomDao extends JpaRepository<Boardroom,Integer> {

    /**
     * 获取所有会议室
     * @param isDelete
     * @return
     */
    List<Boardroom> findAllByIsdeleteNot(Integer isDelete);

    /**
     * 新增会议室
     * @param s 会议室对象
     * @param <S>
     * @return
     */
    @Override
    <S extends Boardroom> S save(S s);

    /**
     * 根据会议室编号删除会议室
     * @param id 会议室编号
     */
    void  deleteByMeetingroomNo(Integer id);




}
