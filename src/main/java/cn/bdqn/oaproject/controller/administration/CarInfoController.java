package cn.bdqn.oaproject.controller.administration;

import  java.util.*;
import cn.bdqn.oaproject.pojo.CarInfo;
import cn.bdqn.oaproject.pojo.Users;
import cn.bdqn.oaproject.service.administration.CarInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * 车辆信息web层
 */
@Controller
@RequestMapping("/carinfo")
public class CarInfoController {

    @Autowired
    private CarInfoService carInfoService;

    /**
     * 获取所有车辆信息列表
     * @return
     */
    @RequestMapping(value="/allcars",method = RequestMethod.GET)
    @ResponseBody
    public Object getAllCars(){
        List<CarInfo> carList=null;
        try {
            carList=carInfoService.findAll();
        }catch (Exception e){
            e.printStackTrace();
        }
        return carList;
    }

    /**
     * 新增车辆信息
     * @param vehicleNo 车牌号
     * @param carType 车型
     * @param carNo 车辆编号
     * @param remark 备注
     * @return
     */
    @RequestMapping(value="/savecar",method = RequestMethod.POST)
    @ResponseBody
    public Object saveCarInfo(@RequestParam("vehicleNo")String vehicleNo,
                              @RequestParam("carType")String carType,
                              @RequestParam("carNo")String carNo,
                              @RequestParam("remark")String remark){
        Map<String,Object> resultMap=new HashMap<String, Object>();
        try {
            CarInfo carInfo=new CarInfo();
            carInfo.setCarNo(Integer.parseInt(carNo));  //车辆编号
            carInfo.setCarType(carType);    //车型
            carInfo.setVehicleNo(vehicleNo);    //车牌号
            carInfo.setRemark(remark);  //备注
            //进行新增操作并判断是否新增成功
            boolean flag=carInfoService.addNewCar(carInfo);
            if(flag){
                resultMap.put("result","success");
            }else {
                resultMap.put("result","failed");
            }

        }catch (Exception e){
            resultMap.put("result","error");
            e.printStackTrace();
        }
        return resultMap;
    }


    /**
     * 修改车辆信息
     * @param  carId 车辆标识id
     * @param vehicleNo 车牌号
     * @param carType 车型
     * @param carNo 车辆编号
     * @param remark 备注
     * @return
     */
    @RequestMapping(value="/updatecar",method = RequestMethod.POST)
    @ResponseBody
    public Object updateCarInfo(@RequestParam("carId")String carId,
                                @RequestParam("vehicleNo")String vehicleNo,
                                @RequestParam("carType")String carType,
                                @RequestParam("carNo")String carNo,
                                @RequestParam("remark")String remark){
        Map<String,Object> resultMap=new HashMap<String, Object>();
        try {
            CarInfo carInfo=new CarInfo();
            carInfo.setCarId(Integer.parseInt(carId));  //车辆标识id
            carInfo.setCarNo(Integer.parseInt(carNo));  //车辆编号
            carInfo.setCarType(carType);    //车型
            carInfo.setVehicleNo(vehicleNo);    //车牌号
            carInfo.setRemark(remark);  //备注
            //进行新增操作并判断是否新增成功
            boolean flag=carInfoService.addNewCar(carInfo);
            if(flag){
                resultMap.put("result","success");
            }else {
                resultMap.put("result","failed");
            }

        }catch (Exception e){
            resultMap.put("result","error");
            e.printStackTrace();
        }
        return resultMap;
    }


    /**
     * 根据车辆id删除车辆
     * @param carId
     * @return
     */
    @RequestMapping(value = "/delcar")
    @ResponseBody
    public Object delCarInfo(@RequestParam("carId") String carId){
        Map<String,Object> resultMap=new HashMap<String, Object>();
        try {
            //进行删除操作
            boolean flag=carInfoService.deleteByCarId(Integer.parseInt(carId));
            //判断是否删除成功
            if(flag){
                resultMap.put("result","success");
            }else {
                resultMap.put("result","failed");
            }
        }catch (Exception e){
            resultMap.put("result","error");
            e.printStackTrace();
        }
        return  resultMap;
    }


    /**
     * 根据车辆id获取车辆信息
     * @param carId
     * @return
     */
    @RequestMapping(value = "/findbyid",method = RequestMethod.GET)
    @ResponseBody
    public Object findCarByCarId(@RequestParam("carId")String carId){
        CarInfo carInfo=null;
        try {
            carInfo=carInfoService.findByCarId(Integer.parseInt(carId));
        }catch (Exception e){
            e.printStackTrace();
        }
        return carInfo;
    }

    /**
     * 根据车辆编号获取车辆信息
     * @param carNo
     * @return
     */
    @RequestMapping(value = "/findbycarno",method = RequestMethod.GET)
    @ResponseBody
    public Object findExitsCarNo(@RequestParam("carNo")String carNo){
        CarInfo carInfo=null;
        try {
            carInfo=carInfoService.findByCarNoIsExits(Integer.parseInt(carNo));
        }catch (Exception e){
            e.printStackTrace();
        }
        return carInfo;
    }


    /**
     * 根据车牌号获取车辆信息
     * @param vehicleNo
     * @return
     */
    @RequestMapping(value = "/findbycarno",method = RequestMethod.GET)
    @ResponseBody
    public Object findExitsVehicleNo(@RequestParam("vehicleNo")String vehicleNo){
        CarInfo carInfo=null;
        try {
            carInfo=carInfoService.findByVehicleNoIsExits(Integer.parseInt(vehicleNo));
        }catch (Exception e){
            e.printStackTrace();
        }
        return carInfo;
    }









}
