package cn.bdqn.oaproject.service.mydesktop;

import cn.bdqn.oaproject.pojo.UrlRecord;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

/**
 * 常用网址业务操作接口
 */
public interface UrlRecordService {
    /**
     * 分页获取信息
     * @param specification
     * @param pageable
     * @return
     */
    Page<UrlRecord> findAll(Specification<UrlRecord> specification, Pageable pageable);

    /**
     * 添加网址信息
     * @param url
     * @return
     */
    boolean save(UrlRecord url);

    /**
     * 修改网址信息
     * @param url
     * @return
     */
    boolean update(UrlRecord url);

    /**
     * 删除网址信息
     * @param id
     * @return
     */
    boolean delete(Integer id);

    /**
     * 根据Id查询信息
     * @param id
     * @return
     */
    UrlRecord getInfoById(Integer id);
}
