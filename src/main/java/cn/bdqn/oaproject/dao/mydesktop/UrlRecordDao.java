package cn.bdqn.oaproject.dao.mydesktop;

import cn.bdqn.oaproject.pojo.UrlRecord;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.*;

import java.util.Optional;

/**
 * 常用网址数据操作
 */
public interface UrlRecordDao extends JpaRepository<UrlRecord,Integer>, JpaSpecificationExecutor<UrlRecord> {

    /**
     * 根据用户编号分页获取全部网址
     * @param specification
     * @param pageable
     * @return
     */
    @Override
    Page<UrlRecord> findAll(Specification<UrlRecord> specification, Pageable pageable);

    /**
     * 添加网址信息
     * @param s
     * @param <S>
     * @return
     */
    @Override
    <S extends UrlRecord> S save(S s);

    /**
     * 根据Id修改网址信息
     * @param
     */
    @Modifying
    @Query("update UrlRecord u set u.urlRecordTitle=?1,u.link=?2 where u.urlRecordId=?3")
    void modifyUrlInfo(String urlRecordTitle,String link,Integer urlRecordId);

    /**
     * 根据Id删除信息
     * @param urlRecordId
     */
    @Override
    void deleteById(Integer urlRecordId);

    /**
     * 根据Id获取信息
     * @param id
     * @return
     */
    @Query("select u from UrlRecord u where u.urlRecordId=?1")
    UrlRecord getInfoById(Integer id);
}
