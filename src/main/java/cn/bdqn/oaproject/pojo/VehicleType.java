package cn.bdqn.oaproject.pojo;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "VEHICLE_TYPE")
public class VehicleType {

    /**
     * 类型id
     */
    @Id
    @Column(name = "VEHICLE_TYPE_ID")
    private Integer vehicleTypeId;

    /**
     * 类型名称
     */
    @Column(name = "VEHICLE_TYPE_NAME")
    private String vehicleTypeName;

    public Integer getVehicleTypeId() {
        return vehicleTypeId;
    }

    public void setVehicleTypeId(Integer vehicleTypeId) {
        this.vehicleTypeId = vehicleTypeId;
    }

    public String getVehicleTypeName() {
        return vehicleTypeName;
    }

    public void setVehicleTypeName(String vehicleTypeName) {
        this.vehicleTypeName = vehicleTypeName;
    }
}
