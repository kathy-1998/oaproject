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
    private Integer sealTypeId;

    /**
     * 章类型名称
     */
    @Column(name = "SEAL_TYPE_NAME")
    private String sealTypeName;


}
