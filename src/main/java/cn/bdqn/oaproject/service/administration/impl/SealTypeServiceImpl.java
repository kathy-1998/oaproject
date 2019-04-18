package cn.bdqn.oaproject.service.administration.impl;

import cn.bdqn.oaproject.dao.administration.SealTypeDao;
import cn.bdqn.oaproject.pojo.SealType;
import cn.bdqn.oaproject.service.administration.SealTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SealTypeServiceImpl implements SealTypeService {

    @Autowired
    private SealTypeDao sealTypeDao;

    /**
     * 获取所有用章类型
     * @return
     * @throws Exception
     */
    @Override
    public List<SealType> findAllSealType() throws Exception {
        List<SealType> list=null;
        try {
            list=sealTypeDao.findAll();
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
}
