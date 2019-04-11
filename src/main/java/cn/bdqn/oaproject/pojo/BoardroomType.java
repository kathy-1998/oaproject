package cn.bdqn.oaproject.pojo;

import javax.persistence.*;
import java.util.Date;

/**
 * 会议类型
 */
@Entity
@Table(name = "BOARDROOM_TYPE")
public class BoardroomType {

    /**
     * 类型编号
     */
    @Id
    @Column(name="TYPE_ID")
    private Integer typeId;

    /**
     * 类型名称
     */
    @Column(name="TYPE_NAME")
    private String typeName;

    @Column(name="CREATOR")
    private Integer creator;

    @Column(name="CREATION_DATE")
    private Date creationDate;

    @Column(name="MENDER")
    private Integer mender;

    @Column(name="MODIFY_DATE")
    private Date modifyDate;

    @Column(name="ISDELETE")
    private Integer isdelete;


    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Integer getCreator() {
        return creator;
    }

    public void setCreator(Integer creator) {
        this.creator = creator;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Integer getMender() {
        return mender;
    }

    public void setMender(Integer mender) {
        this.mender = mender;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public Integer getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Integer isdelete) {
        this.isdelete = isdelete;
    }
}
