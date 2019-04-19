package cn.bdqn.oaproject.service.administration;

import cn.bdqn.oaproject.pojo.CarInfo;

import java.util.List;

/**
 * 车辆信息业务操作接口
 */
public interface CarInfoService {

    /**
     * 获取所有车辆信息
     * @return
     */
    List<CarInfo> findAll()throws Exception;

    /**
     * 添加车辆信息
     * @param carInfo 车辆信息对象
     * @return 是否添加成功
     */
    boolean addNewCar(CarInfo carInfo)throws Exception;

    /**
     * 修改车辆信息
     * @param carInfo 车辆信息对象
     * @return 是否修改成功
     */
    boolean updateCarInfo(CarInfo carInfo)throws Exception;

    /**
     * 根据车辆id删除车辆信息
     * @param carId 车辆编号
     * @return
     */
    boolean deleteByCarId(Integer carId)throws Exception;

    /**
     * 根据车辆id获取车辆详情
     * @param carId
     * @return
     */
    CarInfo findByCarId(Integer carId)throws Exception;

    /**
     * 判断是否存在相同车辆编号
     * @param carNo
     * @return
     */
    CarInfo findByCarNoIsExits(Integer carNo)throws Exception;


    /**
     * 判断是否存在相同车牌号
     * @param vehicleNo
     * @return
     */
    CarInfo findByVehicleNoIsExits(Integer vehicleNo)throws Exception;
}
