package cn.bdqn.oaproject.controller.administration;

import cn.bdqn.oaproject.pojo.BoardroomType;
import cn.bdqn.oaproject.service.administration.BoardroomTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
    public String getAllRoomType(){
        try {
            List<BoardroomType> boardroomTypes=boardroomTypeService.findAll();
            for (BoardroomType t:boardroomTypes){
                System.out.println(t.getTypeId()+"\t"+t.getTypeName());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return "Conference_room_manage";

    }



}



