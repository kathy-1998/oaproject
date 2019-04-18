package cn.bdqn.oaproject.controller.personnel;


import cn.bdqn.oaproject.service.personnel.VehicleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/VehicleType")
public class VehicleTypeController {


    @Autowired
    VehicleTypeService vehicleTypeService;

    /**
     * 获取所有交通工具
     */

    @RequestMapping("/findAllList")
    @ResponseBody
    public  Object finAllVehicleType(){
        return vehicleTypeService.findAll();
    }
}
