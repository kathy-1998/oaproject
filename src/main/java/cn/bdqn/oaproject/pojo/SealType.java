package cn.bdqn.oaproject.pojo;

import javax.persistence.*;
import java.util.Objects;

/**
 * 用章类型表
 */
@Entity
@Table(name = "SEAL_TYPE")
public class SealType {
    /**
     * 章类型id
     */
    @Id
    @Column(name = "SEAL_TYPE_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer sealTypeId;

    /**
     * 章类型名称
     */
    @Column(name = "SEAL_TYPE_NAME")
    private String sealTypeName;

    public Integer getSealTypeId() {
        return sealTypeId;
    }

    public void setSealTypeId(Integer sealTypeId) {
        this.sealTypeId = sealTypeId;
    }

    public String getSealTypeName() {
        return sealTypeName;
    }

    public void setSealTypeName(String sealTypeName) {
        this.sealTypeName = sealTypeName;
    }
}
