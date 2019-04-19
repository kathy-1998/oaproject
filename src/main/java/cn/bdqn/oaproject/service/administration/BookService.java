package cn.bdqn.oaproject.service.administration;

import cn.bdqn.oaproject.pojo.Book;

/**
 * 图书业务操作接口
 */
public interface BookService {


  Book findBookById(Integer id);
    Book findBookByName(String bookName);
}
