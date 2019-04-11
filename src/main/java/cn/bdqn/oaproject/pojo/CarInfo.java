package cn.bdqn.oaproject.pojo;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "CAR_INFO")
public class CarInfo {

    /**
     * 车辆id（自增）
     */
    @Id
    @Column(name = "CAR_ID")
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
}
