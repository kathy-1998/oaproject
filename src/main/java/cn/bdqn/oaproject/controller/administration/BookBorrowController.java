package cn.bdqn.oaproject.controller.administration;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/BookBorrow")
public class BookBorrowController {


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
    public  Object Add(){


        return  "";
    }

}
