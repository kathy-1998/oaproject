package cn.bdqn.oaproject.service.mydesktop.impl;

import cn.bdqn.oaproject.dao.mydesktop.UrlRecordDao;
import cn.bdqn.oaproject.pojo.UrlRecord;
import cn.bdqn.oaproject.service.mydesktop.UrlRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("urlRecordService")
@Transactional
public class UrlRecordServiceImpl implements UrlRecordService {

    @Autowired
    private UrlRecordDao urlRecordDao;

    @Override
    public Page<UrlRecord> findAll(Specification<UrlRecord> specification, Pageable pageable) {
        Page<UrlRecord> page=null;
        try {
            page = urlRecordDao.findAll(specification,pageable);
        }catch (Exception e){
            e.printStackTrace();
        }
        return page;
    }

    @Override
    public boolean save(UrlRecord url) {
        try {
            urlRecordDao.save(url);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(UrlRecord url) {
        try {
            urlRecordDao.modifyUrlInfo(url.getUrlRecordTitle(),url.getLink(),url.getUrlRecordId());
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(Integer id) {
        try {
            urlRecordDao.deleteById(id);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public UrlRecord getInfoById(Integer id) {
        UrlRecord urlRecord=null;
        try {
            urlRecord=urlRecordDao.getInfoById(id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return urlRecord;
    }
}
