package cn.bdqn.oaproject.dao.personnel;

import cn.bdqn.oaproject.pojo.VehicleType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/***
 * 交通类型数据操作接口
 */
public interface VehicleTypeDao  extends JpaRepository<VehicleType,Integer> {

    List<VehicleType> findAll();

}
