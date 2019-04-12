package cn.bdqn.oaproject.controller.administration;

import cn.bdqn.oaproject.pojo.Boardroom;
import cn.bdqn.oaproject.service.administration.BoardroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value = "/room")
public class BoardroomController {

    @Autowired
    private BoardroomService boardroomService;

    /**
     * 获取所有会议室信息
     * @return
     */
    @RequestMapping(value = "/getallroom",method = RequestMethod.GET)
    public String getAllBoardroom(){
        try {
            List<Boardroom> boardrooms=boardroomService.findAllBoardroom();
            for (Boardroom boardroom:boardrooms){
                System.out.println(boardroom.getMeetingroomNo()+"\t"+boardroom.getMeetingroomName());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return "Conference_room_manage";
    }

    /**
     * 添加会议室
     * @param boardroom
     * @return
     */
    @RequestMapping(value = "/saveroom",method = RequestMethod.POST)
    public String saveBoardroom(Boardroom boardroom){
        try {
            boardroom=new Boardroom();
            boardroom.setMeetingroomNo(4);
            boardroom.setMeetingroomName("A102");
            boardroom.setMeetingroomDescribe("一楼会议室");
            boardroom.setCreator(1);
            boardroom.setCreationDate(new Date());
            //进行添加
            boardroomService.addNewBoardroom(boardroom);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "Conference_room_manage";
    }


    /**
     * 修改会议室
     * @param boardroom
     * @return
     */
    @RequestMapping(value = "/updateroom",method = RequestMethod.POST)
    public String updateBoardroom(Boardroom boardroom){
        try {
            boardroom=new Boardroom();
            boardroom.setMeetingroomNo(4);
            boardroom.setMeetingroomName("A103");
            boardroom.setMeetingroomDescribe("一楼会议室");
            boardroom.setMender(2);
            boardroom.setModifyDate(new Date());
            //进行修改
            boardroomService.updateBoardroom(boardroom);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "Conference_room_manage";
    }


    /**
     * 删除会议室
     * @param meetingroomNo 会议室编号
     * @return
     */
    @RequestMapping(value = "/delroom",method = RequestMethod.POST)
    public String delBoardroom(@RequestParam("id")String meetingroomNo){
        try {
            //进行删除
            boardroomService.delBoardroom(4);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "Conference_room_manage";
    }

    /**
     * 根据编号获取会议室对象信息
     * @param meetingroomNo
     * @return
     */
    @RequestMapping(value = "/getroombyid",method = RequestMethod.GET)
    public String findByMettingroomNo(@RequestParam("id")String meetingroomNo){
        try {
            Boardroom boardroom=boardroomService.findByMeetingroomNo(3);
            System.out.println(boardroom.getMeetingroomNo()+"\t"+boardroom.getMeetingroomName());
        }catch (Exception e){
            e.printStackTrace();
        }
        return "Conference_room_manage";
    }




}
