package cn.bdqn.oaproject.dao.administration;

import cn.bdqn.oaproject.pojo.BoardroomType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 会议室类型数据操作
 */
@Repository
public interface BoardroomTypeDao extends JpaRepository<BoardroomType,Integer> {

    /**
     * 获取所有会议室类型
     * @param isDelete
     * @return
     */
    List<BoardroomType> findAllByIsdeleteNot(Integer isDelete);


}
