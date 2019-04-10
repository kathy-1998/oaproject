package cn.bdqn.oaproject.pojo;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "VEHICLE_TYPE")
public class VehicleType {
    private Integer vehicleTypeId;
    private String vehicleTypeName;


}
