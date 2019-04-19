package cn.bdqn.oaproject.dao.administration;

import cn.bdqn.oaproject.pojo.Book;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 图书数据操作接口
 */
public interface BookDao  extends JpaRepository<Book,Integer> {

Book findBookByBookId(Integer bookId);

    Book findBookByBookName(String bookName);


}
