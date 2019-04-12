package cn.bdqn.oaproject.dao.announce;
import cn.bdqn.oaproject.pojo.Announce;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 通告表数据操作
 */
@Repository
public interface AnnounceDao extends JpaRepository<Announce,Integer> {

    /**
     * 分页获取通告列表
     * @param pageable 根据紧急一般排序后，再根据时间倒叙排序
     * @return
             */
    Page<Announce> findAllByIsdeleteNot(Pageable pageable,Integer isDelete);

    /**
     * 新增通告 与修改通用
     * @param s
     * @param <S>
     * @return 通告对象
     */
    @Override
    <S extends Announce> S save(S s);

    /**
     * 根据编号删除通告
     * @param noticeNo 通告编号
     * @return 受影响的函数
     */
    int deleteByNoticeNo(Integer noticeNo);

    /**
     * 根据id获取通告详情
     * @param noticNo 通告编号
     * @return 通告对象
     */
    Announce findByNoticeNo(Integer noticNo);

    /**
     * 获取总个数
     * @return
     */
    long countByIsdeleteNot(Integer isDelete);




}
