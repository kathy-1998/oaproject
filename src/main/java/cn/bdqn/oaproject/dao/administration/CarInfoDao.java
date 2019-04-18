package cn.bdqn.oaproject.dao.administration;

import cn.bdqn.oaproject.pojo.CarInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 车辆信息数据操作
 */
@Repository
public interface CarInfoDao extends JpaRepository<CarInfo,Integer> {

    /**
     * 获取所有车辆信息
     * @return
     */
    List<CarInfo> findAll();

    /**
     * 添加和修改车辆信息
     * @param s
     * @param <S>
     * @return
     */
    @Override
    <S extends CarInfo> S save(S s);

    /**
     * 根据车辆id删除车辆信息
     * @param carId
     */
    void deleteByCarId(Integer carId);

    /**
     * 根据车辆id获取车辆详情
     * @param carId
     * @return
     */
    CarInfo findByCarId(Integer carId);

    /**
     * 根据车辆编号获取车辆信息
     * @param carNo
     * @return
     */
    CarInfo findByCarNo(Integer carNo);


    /**
     * 根据车牌号获取车辆信息
     * @param vehicleNo
     * @return
     */
    CarInfo findByVehicleNo(Integer vehicleNo);



}
