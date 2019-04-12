package cn.bdqn.oaproject.pojo;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;

/**
 * 通告表
 */
@Entity
@Table(name="ANNOUNCE")
@DynamicUpdate(true)
public class Announce {

    /**
     * 通告编号
     */
    @Id
    @Column(name="NOTICE_NO")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "my_announce_seq")
    @SequenceGenerator(name = "my_announce_seq",sequenceName = "announce_seq",initialValue = 3,allocationSize = 1)
    private Integer noticeNo;

    /**
     * 通告标题
     */
    @Column(name="NOTICE_TITLE")
    private String noticeTitle;

    /**
     * 通告类型：0紧急，1一般
     */
    @Column(name="NOTICE_TYPE")
    private Integer noticeType;

    /**
     * 通告状态（0:未发布、1:已发布、2:过期）
     */
    @Column(name="NOTICE_STATUS")
    private Integer noticeStatus;

    /**
     * 通告内容
     */
    @Column(name="NOTICE_CONTENT")
    private String noticeContent;

    /**
     * 起始时间
     */
    @Column(name="START_TIME")
    private Date startTime;

    /**
     * 截至时间
     */
    @Column(name="END_TIME")
    private Date endTime;

    /**
     * 发布时间
     */
    @Column(name="RELEASE_TIME")
    private Date releaseTime;

    /**
     * 创建者
     */
    @Column(name="CREATOR",updatable = false)
    private Integer creator;

    /**
     * 创建日期
     */
    @Column(name="CREATION_DATE",updatable = false)
    private Date creationDate;

    /**
     * 创建日期
     */
    @Column(name="MENDER")
    private Integer mender;

    /**
     * 修改日期
     */
    @Column(name="MODIFY_DATE")
    private Date modifyDate;

    /**
     * 是否删除(0:是,1:不是)
     */
    @Column(name="ISDELETE")
    private Integer isdelete;



    public Integer getNoticeNo() {
        return noticeNo;
    }

    public void setNoticeNo(Integer noticeNo) {
        this.noticeNo = noticeNo;
    }

    public String getNoticeTitle() {
        return noticeTitle;
    }

    public void setNoticeTitle(String noticeTitle) {
        this.noticeTitle = noticeTitle;
    }

    public Integer getNoticeType() {
        return noticeType;
    }

    public void setNoticeType(Integer noticeType) {
        this.noticeType = noticeType;
    }

    public Integer getNoticeStatus() {
        return noticeStatus;
    }

    public void setNoticeStatus(Integer noticeStatus) {
        this.noticeStatus = noticeStatus;
    }

    public String getNoticeContent() {
        return noticeContent;
    }

    public void setNoticeContent(String noticeContent) {
        this.noticeContent = noticeContent;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(Date releaseTime) {
        this.releaseTime = releaseTime;
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
