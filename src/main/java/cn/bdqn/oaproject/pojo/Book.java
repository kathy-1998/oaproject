package cn.bdqn.oaproject.pojo;

import javax.persistence.*;
import java.util.Objects;

/**
 * 图书表
 */
@Entity
@Table(name="BOOK")
public class Book {
    /**
     * 图书id
     */
    @Id
    @Column(name="BOOK_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookId;

    /**
     * 图书名称
     */
    @Column(name="BOOK_NAME")
    private String bookName;

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
}
