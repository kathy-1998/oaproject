package cn.bdqn.oaproject.pojo;

import javax.persistence.*;
import java.util.Date;

/**
 * 会议室
 */
@Entity
@Table(name="BOARDROOM")
public class Boardroom {

    /**
     * 会议室编号
     */
    @Id
    @Column(name="MEETINGROOM_NO")
    private Integer meetingroomNo;

    /**
     * 会议室名称
     */
    @Column(name="MEETINGROOM_NAME")
    private String meetingroomName;

    /**
     * 会议室描述
     */
    @Column(name="MEETINGROOM_DESCRIBE")
    private String meetingroomDescribe;

    /**
     * 创建者
     */
    @Column(name="CREATOR")
    private Integer creator;

    /**
     * 	创建日期
     *
     */
    @Column(name="CREATION_DATE")
    private Date creationDate;

    /**
     * 修改者
     */
    @Column(name="MENDER")
    private Integer mender;

    /**
     * 修改日期
     */
    @Column(name="MODIFY_DATE")
    private Date modifyDate;

    /**
     * 是否删除
     */
    @Column(name="ISDELETE")
    private Integer isdelete;


    public Integer getMeetingroomNo() {
        return meetingroomNo;
    }

    public void setMeetingroomNo(Integer meetingroomNo) {
        this.meetingroomNo = meetingroomNo;
    }

    public String getMeetingroomName() {
        return meetingroomName;
    }

    public void setMeetingroomName(String meetingroomName) {
        this.meetingroomName = meetingroomName;
    }

    public String getMeetingroomDescribe() {
        return meetingroomDescribe;
    }

    public void setMeetingroomDescribe(String meetingroomDescribe) {
        this.meetingroomDescribe = meetingroomDescribe;
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
