package cn.bdqn.oaproject.controller.administration;

import cn.bdqn.oaproject.pojo.BoardroomType;
import cn.bdqn.oaproject.service.administration.BoardroomTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/roomtype")
public class BoardroomTypeController {

    @Autowired
    private BoardroomTypeService boardroomTypeService;

    /**
     * 获取所有会议类型
     * @return
     */
    @RequestMapping(value="/getallroomtype",method = RequestMethod.GET)
    @ResponseBody
    public Object getAllRoomType(){
        List<BoardroomType> boardroomTypes=null;
        try {
            boardroomTypes=boardroomTypeService.findAll();
        }catch (Exception e){
            e.printStackTrace();
        }
        return boardroomTypes;

    }



}



