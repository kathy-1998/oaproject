package cn.bdqn.oaproject.controller.sysmanage;


import cn.bdqn.oaproject.service.sysmanage.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/job")
public class JobController {

    @Autowired
    JobService jobService;


    /**
     * 查询所有职位
     * @return
     */
    @RequestMapping("/jobList")
    @ResponseBody
    public Object jobList(){
        return jobService.findAll();
    }




}
