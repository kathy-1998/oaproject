package cn.bdqn.oaproject.pojo;

import javax.persistence.*;
import java.util.Objects;

/**
 * 常用网址表
 */
@Entity
@Table(name = "URL_RECORD")
public class UrlRecord {

    /**
     * 网址id
     */
    @Id
    @Column(name = "URL_RECORD_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "my_urlRecord_sql")
    @SequenceGenerator(name = "my_urlRecord_sql",sequenceName = "urlRecord_seq",initialValue = 3,allocationSize = 1)
    private Integer urlRecordId;

    /**
     * 标题
     */
    @Column(name = "URL_RECORD_TITLE")
    private String urlRecordTitle;

    /**
     * 链接
     */
    @Column(name = "LINK")
    private String link;

    /**
     * 用户编号
     */
    @Column(name = "USER_ID")
    private Integer userId;

    public Integer getUrlRecordId() {
        return urlRecordId;
    }

    public void setUrlRecordId(Integer urlRecordId) {
        this.urlRecordId = urlRecordId;
    }

    public String getUrlRecordTitle() {
        return urlRecordTitle;
    }

    public void setUrlRecordTitle(String urlRecordTitle) {
        this.urlRecordTitle = urlRecordTitle;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
