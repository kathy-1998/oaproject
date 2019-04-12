package cn.bdqn.oaproject.service.sysmanage.impl;

import cn.bdqn.oaproject.dao.sysmanage.DeptDao;
import cn.bdqn.oaproject.pojo.Dept;
import cn.bdqn.oaproject.service.sysmanage.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("deptService")
@Transactional
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptDao deptDao;

    @Override
    public List<Dept> findAll() {
        List<Dept> list=null;
        try {
            list=deptDao.findAll();
        }catch (Exception e){
            e.printStackTrace();
        }
        return  list;
    }

    @Override
    public boolean deleteById(Integer id) {

        try {
            deptDao.deleteById(id);
            return  true;
        }catch (Exception e){
            e.printStackTrace();
            return  false;
        }

    }

    @Override
    public boolean Add(Dept dept) {
        try {
            deptDao.save(dept);
            return  true;
        }catch (Exception e){
            e.printStackTrace();
            return  false;
        }
    }
}
