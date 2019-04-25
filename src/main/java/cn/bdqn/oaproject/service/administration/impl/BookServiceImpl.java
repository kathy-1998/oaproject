package cn.bdqn.oaproject.service.administration.impl;

import cn.bdqn.oaproject.dao.administration.BookDao;
import cn.bdqn.oaproject.pojo.Book;
import cn.bdqn.oaproject.service.administration.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("bookService")
@Transactional
public class BookServiceImpl  implements BookService {

    @Autowired
    BookDao bookDao;

    @Override
    public Book findBookById(Integer id) {

        Book book=null;
        try {
            book=bookDao.findBookByBookId(id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return book;
    }

    @Override
    public Book findBookByName(String bookName) {
        Book book=null;
        try {
            book=bookDao.findBookByBookName(bookName);
        }catch (Exception e){
            e.printStackTrace();
        }
        return book;
    }
}
