package cn.bdqn.oaproject.controller.sysmanage.log;


import cn.bdqn.oaproject.service.sysmanage.OperateLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/log")
public class OperateLogController {

    @Autowired
    OperateLogService operateLogService;


}
