package cn.bdqn.oaproject.pojo;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "URL_RECORD")
public class UrlRecord {
    private Integer urlRecordId;
    private String urlRecordTitle;
    private String link;
    private Integer userId;


}
