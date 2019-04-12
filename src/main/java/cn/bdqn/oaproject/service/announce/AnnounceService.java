package cn.bdqn.oaproject.service.announce;

import cn.bdqn.oaproject.pojo.Announce;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * 通告类业务操作接口
 */
public interface AnnounceService {

    /**
     * 分页获取通告列表
     * @param pageable
     * @return 通告列表
     * @throws Exception
     */
     Page<Announce> findAllAnnounceByPage(Pageable pageable)throws Exception;

    /**
     * 新增通告
     * @param announce 通告对象
     * @return 是否新增成功
     * @throws Exception
     */
     boolean addAnnounce(Announce announce)throws Exception;

    /**
     * 修改通告
     * @param announce 通告对象
     * @return 是否修改成功
     * @throws Exception
     */
     boolean updateAnnounce(Announce announce)throws Exception;

    /**
     * 删除通告
     * @param id 通告编号
     * @return 是否删除成功
     * @throws Exception
     */
     boolean delAnnounce(Integer id)throws Exception;

    /**
     * 根据通告编号获取通告对象
     * @param id 通告编号
     * @return 通告对象
     * @throws Exception
     */
     Announce findAnnouceById(Integer id)throws Exception;

    /**
     * 获取通告总数量
     * @return 总数量
     * @throws Exception
     */
     Long totalCount()throws Exception;


}
