package cn.bdqn.oaproject.pojo;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "SEAL_TYPE")
public class SealType {
    private Integer sealTypeId;
    private String sealTypeName;


}
