package cn.bdqn.oaproject.service.administration.impl;

import cn.bdqn.oaproject.dao.administration.CarInfoDao;
import cn.bdqn.oaproject.pojo.CarInfo;
import cn.bdqn.oaproject.service.administration.CarInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CarInfoServiceImpl implements CarInfoService {

    @Autowired
    private CarInfoDao carInfoDao;


    /**
     * 获取所有车辆信息
     * @return
     */
    @Override
    public List<CarInfo> findAll() throws Exception{
        List<CarInfo> list=null;
        try {
            list=carInfoDao.findAll();
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 新增车辆信息
     * @param carInfo 车辆信息对象
     * @return
     * @throws Exception
     */
    @Override
    public boolean addNewCar(CarInfo carInfo) throws Exception{
        try {
            carInfoDao.save(carInfo);
            return true;
        }catch (Exception e){

            e.printStackTrace();
            return false;
        }
    }

    /**
     * 修改车辆信息
     * @param carInfo 车辆信息对象
     * @return
     * @throws Exception
     */
    @Override
    public boolean updateCarInfo(CarInfo carInfo)throws Exception {
        try {
            carInfoDao.save(carInfo);
            return true;
        }catch (Exception e){

            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteByCarId(Integer carId) throws Exception{
        try {
            carInfoDao.deleteByCarId(carId);
            return true;
        }catch (Exception e){

            e.printStackTrace();
            return false;
        }
    }

    /**
     * 根据车辆id获取详情
     * @param carId
     * @return
     * @throws Exception
     */
    @Override
    public CarInfo findByCarId(Integer carId) throws Exception{
        CarInfo carInfo=null;
        try {
            carInfo=carInfoDao.findByCarId(carId);
        }catch (Exception e){
            e.printStackTrace();
        }
        return carInfo;
    }

    /**
     * 判断是否存在相同车辆编号
     * @param carNo
     * @return
     * @throws Exception
     */
    @Override
    public CarInfo findByCarNoIsExits(Integer carNo)throws Exception {
        CarInfo carInfo=null;
        try {
            carInfo=carInfoDao.findByCarNo(carNo);
        }catch (Exception e){
            e.printStackTrace();
        }
        return carInfo;
    }

    /**
     * 判断是否存在相同车牌号
     * @param vehicleNo
     * @return
     * @throws Exception
     */
    @Override
    public CarInfo findByVehicleNoIsExits(Integer vehicleNo)throws Exception {
        CarInfo carInfo=null;
        try {
            carInfo=carInfoDao.findByVehicleNo(vehicleNo);
        }catch (Exception e){
            e.printStackTrace();
        }
        return carInfo;
    }
}
