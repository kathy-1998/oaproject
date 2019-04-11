package cn.bdqn.oaproject.pojo;

import javax.persistence.*;
import java.util.Date;

/**
 * 图书借阅申请记录表
 */
@Entity
@Table(name = "BOOK_BORROW")
public class BookBorrow {

    /**
     * 借阅记录id
     */
    @Id
    @Column(name="BOOK_BORROW_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookBorrowId;

    /**
     * 借阅用户编号（对应当前登录用户编号）
     */
    @Column(name="BORROW_USER_ID")
    private Integer borrowUserId;

    /**
     * 借阅用户姓名
     */
    @Column(name="BORROW_USER_NAME")
    private String borrowUserName;

    /**
     * 借阅部门id（对应部门表中的部门编号）
     */
    @Column(name="DEPT_ID")
    private Integer deptId;

    /**
     * 借阅时间
     */
    @Column(name="BORROW_TIME")
    private Date borrowTime;

    /**
     * 借阅图书编号
     */
    @Column(name="BOOK_ID")
    private Integer bookId;

    /**
     * 借阅图书编号
     */
    @Column(name="BOOK_NAME")
    private String bookName;

    /**
     * 任务类型id
     */
    @Column(name="TASK_TYPE_ID")
    private Integer taskTypeId;

    /**
     * 申请状态（待审批、审批已通过、审批未通过）
     */
    @Column(name="STATUS")
    private Integer status;

    /**
     * 审批人ID（对应用户表中拥有审批权限的id）
     */
    @Column(name="USER_ID")
    private Integer userId;

    /**
     * 创建者
     */
    @Column(name="CREATOR")
    private Integer creator;

    /**
     * 创建日期
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
     * 是否删除(0:是,1:不是)
     */
    @Column(name="ISDELETE")
    private Integer isdelete;


    public Integer getBookBorrowId() {
        return bookBorrowId;
    }

    public void setBookBorrowId(Integer bookBorrowId) {
        this.bookBorrowId = bookBorrowId;
    }

    public Integer getBorrowUserId() {
        return borrowUserId;
    }

    public void setBorrowUserId(Integer borrowUserId) {
        this.borrowUserId = borrowUserId;
    }

    public String getBorrowUserName() {
        return borrowUserName;
    }

    public void setBorrowUserName(String borrowUserName) {
        this.borrowUserName = borrowUserName;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public Date getBorrowTime() {
        return borrowTime;
    }

    public void setBorrowTime(Date borrowTime) {
        this.borrowTime = borrowTime;
    }

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

    public Integer getTaskTypeId() {
        return taskTypeId;
    }

    public void setTaskTypeId(Integer taskTypeId) {
        this.taskTypeId = taskTypeId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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
