package cn.bdqn.oaproject.pojo;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "CAR_INFO")
public class CarInfo {
    private Integer carId;
    private String vehicleNo;
    private String carType;
    private Integer carNo;
    private String remark;


}
