package cn.bdqn.oaproject.controller.mydesktop;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class myDesktopController {

    @RequestMapping(value = "/login.html",method = RequestMethod.GET)
    public String loginPage(){
        return "login";
    }
    @RequestMapping(value = "/framework.html",method = RequestMethod.GET)
    public String indexPage(){
        return "framework";
    }
    @RequestMapping(value = "/Mydesktop.html",method = RequestMethod.GET)
    public String myDesktopPage(){
        return "Mydesktop";
    }
    @RequestMapping(value = "/Commonly_used_web_site.html",method = RequestMethod.GET)
    public String urlRecordPage(){
        return "Commonly_used_web_site";
    }
    @RequestMapping(value = "/waiting_task.html",method = RequestMethod.GET)
    public String waitingPage(){
        return "waiting_task";
    }
}
