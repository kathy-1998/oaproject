package cn.bdqn.oaproject.controller.administration;


import cn.bdqn.oaproject.pojo.BookBorrow;
import cn.bdqn.oaproject.service.administration.BookBorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Date;
import java.text.SimpleDateFormat;

@Controller
@RequestMapping("/BookBorrow")
public class BookBorrowController {


    @Autowired
    BookBorrowService bookBorrowService;

    /**
     * 跳转到图书借阅页面
     */
    @RequestMapping("/Library_application.html")
    public  String Library_application(){

     return "Library_application";

    }


    /**
     * 添加
     */

    @RequestMapping("/Add")
    @ResponseBody
    public  Object Add(@RequestParam(value = "realName",required =false ) String  realName,
                       @RequestParam(value = "bookName",required =false ) String bookName,
                       @RequestParam(value = "time",required = false) String time,
                       @RequestParam(value = "bookId",required =false ) Integer bookId ,
                       @RequestParam(value = "deptId",required =false ) Integer deptId ,
                       @RequestParam(value = "userId",required = false) Integer userId,
                       @RequestParam(value = "spr",required =false ) Integer spr){

        BookBorrow bookBorrow=new BookBorrow();


        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");


        Date date=null;
        try {
            date = new Date(format.parse(time).getTime());

            java.util.Date date02 = new Date(date.getTime());//sql.Date转util.Date

            bookBorrow.setBorrowTime(date02);
             bookBorrow.setCreationDate(new java.util.Date());
             bookBorrow.setCreator(userId);
             bookBorrow.setBookName(bookName);
             bookBorrow.setBookId(bookId);
             bookBorrow.setTaskTypeId(5);
             bookBorrow.setIsdelete(1);
             bookBorrow.setStatus(0);
             bookBorrow.setBorrowUserId(userId);
             bookBorrow.setDeptId(deptId);
             bookBorrow.setUserId(spr);
             bookBorrow.setBorrowUserName(realName);

             if (bookBorrowService.Add(bookBorrow)){

                 return  "true";
             }

        }catch (Exception e){
            e.printStackTrace();;
        }



        return  "false";
    }

}
