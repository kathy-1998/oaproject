package cn.bdqn.oaproject.controller.mydesktop.taskType;

import cn.bdqn.oaproject.pojo.TaskType;
import cn.bdqn.oaproject.service.mydesktop.TaskTypeService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/taskType")
public class TaskTypeController {

    @Autowired
    private TaskTypeService taskTypeService;


    /**
     * 查询信息
     * @return
     */
    @RequestMapping("/getType.find")
    @ResponseBody
    public String getInfo(){
        String json="";
        List<TaskType> list=taskTypeService.findAll();
        json= JSON.toJSONString(list);
        System.out.println(json);
        return json;
    }
}
