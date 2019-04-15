package cn.bdqn.oaproject.pojo;

import cn.bdqn.oaproject.dao.sysmanage.RoleDao;
import cn.bdqn.oaproject.service.sysmanage.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.List;

/**
 * 车辆信息表
 */
@Entity
@Table(name = "CAR_INFO")
public class CarInfo {

    /**
     * 车辆id（自增）
     */
    @Id
    @Column(name = "CAR_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer carId;

    /**
     * 车牌号（唯一）
     */
    @Column(name = "VEHICLE_NO")
    private String vehicleNo;

    /**
     *车型
     */
    @Column(name = "CAR_TYPE")
    private String carType;

    /**
     *车辆编号（管理员手动输入）
     */
    @Column(name = "CAR_NO")
    private Integer carNo;

    /**
     *备注
     */
    @Column(name = "REMARK")
    private String remark;

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public String getVehicleNo() {
        return vehicleNo;
    }

    public void setVehicleNo(String vehicleNo) {
        this.vehicleNo = vehicleNo;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public Integer getCarNo() {
        return carNo;
    }

    public void setCarNo(Integer carNo) {
        this.carNo = carNo;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * 用户业务操作接口
     */
    @Service("roleService")
    @Transactional
    public static class RoleServiceImpl implements RoleService {

        @Autowired
        RoleDao roleDao;

        @Override
        public boolean deleteById(Integer integer) {


            try{
                roleDao.deleteById(integer);
                return  true;
            }catch (Exception e){
                e.printStackTrace();
                return  false;
            }
        }


        @Override
        public List<Role> findAll() {
            List<Role> roles=null;
            try{
                roles=roleDao.findAll();
            }catch (Exception e){
                e.printStackTrace();
            }
            return  roles;
        }

        @Override
        public boolean Add(Role role){

            try{
                roleDao.save(role);
                return  true;
            }catch (Exception e){
                e.printStackTrace();
                return false;

            }

        }

        @Override
        public Page<Role> findAll(Pageable pageable) {


            Page<Role> roles=null;
            try{
                roles=roleDao.findAll(pageable);
            }catch (Exception e){
                e.printStackTrace();
            }
            return  roles;
        }
    }
}
