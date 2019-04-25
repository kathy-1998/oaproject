package cn.bdqn.oaproject.dao.administration;

import cn.bdqn.oaproject.pojo.BookBorrow;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 图书借阅申请数据操作
 */
public interface BookBorrowDao  extends JpaRepository<BookBorrow,Integer> {
}
