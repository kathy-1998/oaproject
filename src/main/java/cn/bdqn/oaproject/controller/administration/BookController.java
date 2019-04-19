package cn.bdqn.oaproject.controller.administration;


import cn.bdqn.oaproject.pojo.Book;
import cn.bdqn.oaproject.service.administration.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/book")
public class BookController {



   @Autowired
    BookService bookService;


   @RequestMapping("/findBookById")
   @ResponseBody
    public  Object  findBookById(  @RequestParam(value = "bookId", required = false) Integer bookId){


        Book book=bookService.findBookById(bookId);
        if(book==null){
            return  "false";
        }

        return book;
    }
    @RequestMapping("/findBookByName")
    @ResponseBody
    public  Object  findBookByName(  @RequestParam(value = "bookName", required = false) String bookName){


        Book book=bookService.findBookByName(bookName);
        if(book==null){
            return  "false";
        }
        return book;
    }
}
