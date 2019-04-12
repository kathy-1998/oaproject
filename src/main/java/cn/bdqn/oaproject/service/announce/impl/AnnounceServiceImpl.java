package cn.bdqn.oaproject.service.announce.impl;

import cn.bdqn.oaproject.dao.announce.AnnounceDao;
import cn.bdqn.oaproject.pojo.Announce;
import cn.bdqn.oaproject.service.announce.AnnounceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AnnounceServiceImpl implements AnnounceService {

    @Autowired
    private AnnounceDao announceDao;

    /**
     * 分页获取通告列表
     * @param pageable
     * @return
     * @throws Exception
     */
    @Override
    public Page<Announce> findAllAnnounceByPage(Pageable pageable) throws Exception {
        Page<Announce> announcePage=null;
        try {
            announcePage=announceDao.findAllByIsdeleteNot(pageable,0);
        }catch (Exception e){
            e.printStackTrace();
        }
        return announcePage;
    }

    /**
     * 新增通告
     * @param announce 通告对象
     * @return
     * @throws Exception
     */
    @Override
    public boolean addAnnounce(Announce announce) throws Exception {
        try {
            announceDao.save(announce);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 修改通告
     * @param announce 通告对象
     * @return
     * @throws Exception
     */
    @Override
    public boolean updateAnnounce(Announce announce) throws Exception {
        try {
           /* Announce a= this.findAnnouceById(announce.getNoticeNo()); //获取要修改的通告对象
            a.setModifyDate(announce.getModifyDate());
            a.setMender(announce.getMender());
            a.setCreationDate(announce.getCreationDate());
            a.setStartTime(announce.getStartTime());
            a.setEndTime(a.getEndTime());
            a.setNoticeContent(announce.getNoticeContent());
            a.setNoticeStatus(announce.getNoticeStatus());
            a.setNoticeNo(announce.getNoticeNo());
            a.setIsdelete(announce.getIsdelete());
            a.setNoticeTitle(announce.getNoticeTitle());
            a.setCreator(announce.getCreator());
            a.setReleaseTime(announce.getReleaseTime());*/

            announceDao.save(announce);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 删除通告
     * @param id 通告编号
     * @return
     * @throws Exception
     */
    @Override
    public boolean delAnnounce(Integer id) throws Exception {
        try {
            announceDao.deleteByNoticeNo(id);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 根据编号获取通告编号
     * @param id 通告编号
     * @return
     * @throws Exception
     */
    @Override
    public Announce findAnnouceById(Integer id) throws Exception {
        Announce announce=null;
        try {
            announce=announceDao.findByNoticeNo(id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return announce;
    }

    /**
     * 获取总记录数
     * @return
     * @throws Exception
     */
    @Override
    public Long totalCount() throws Exception {
        Long result=null;
        try {
            result=announceDao.countByIsdeleteNot(0);
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
}
