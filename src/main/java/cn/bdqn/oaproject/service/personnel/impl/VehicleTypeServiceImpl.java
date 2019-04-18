package cn.bdqn.oaproject.service.personnel.impl;

import cn.bdqn.oaproject.dao.personnel.VehicleTypeDao;
import cn.bdqn.oaproject.pojo.VehicleType;
import cn.bdqn.oaproject.service.personnel.VehicleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 交通工具类型业务操作接口
 */
@Service("vehicleTypeService")
@Transactional
public class VehicleTypeServiceImpl  implements VehicleTypeService {


    @Autowired
    VehicleTypeDao vehicleTypeDao;

    @Override
    public List<VehicleType> findAll() {
        List<VehicleType> vehicleTypes=null;
        try{
            vehicleTypes=vehicleTypeDao.findAll();
        }catch (Exception e){
            e.printStackTrace();
        }
        return vehicleTypes;
    }
}
