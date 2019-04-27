package cn.bdqn.oaproject.dao.administration;

import cn.bdqn.oaproject.pojo.BookBorrow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * 图书借阅申请数据操作
 */
@Repository
public interface BookBorrowDao  extends JpaRepository<BookBorrow,Integer> {

    @Query("select b from BookBorrow b where b.bookBorrowId=?1")
    BookBorrow findInfoById(Integer id);
}
