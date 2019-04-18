package cn.bdqn.oaproject.service.personnel;

import cn.bdqn.oaproject.pojo.VehicleType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 交通工具类型业务操作接口
 */
public interface VehicleTypeService   {



    List<VehicleType> findAll();
}
