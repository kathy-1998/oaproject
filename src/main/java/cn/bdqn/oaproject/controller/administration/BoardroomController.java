package cn.bdqn.oaproject.controller.administration;

import cn.bdqn.oaproject.pojo.Boardroom;
import cn.bdqn.oaproject.pojo.Users;
import cn.bdqn.oaproject.service.administration.BoardroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.security.cert.TrustAnchor;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/room")
public class BoardroomController {

    @Autowired
    private BoardroomService boardroomService;

    @RequestMapping(value = "/main")
    public String main(){
        return "Conference_room_manage";
    }


    /**
     * 获取所有会议室信息
     * @return
     */
    @RequestMapping(value = "/getallroom",method = RequestMethod.GET)
    @ResponseBody
    public Object getAllBoardroom(){
        List<Boardroom> boardrooms=null;
        try {
            boardrooms=boardroomService.findAllBoardroom();
        }catch (Exception e){
            e.printStackTrace();
        }
        return boardrooms;
    }

    /**
     * 添加会议室
     * @param meetingroomName 会议室名称
     * @param meetingroomDescribe  会议室描述
     * @param session
     * @return
     */
    @RequestMapping(value = "/saveroom")
    @ResponseBody
    public Object saveBoardroom(@RequestParam("meetingroomName")String meetingroomName,
                                @RequestParam("meetingroomDescribe")String meetingroomDescribe,
                                HttpSession session){
        Map<String,Object> resultMap=new HashMap<>();
      /*  Users users=(Users) session.getAttribute("Users");*/
        try {
            Boardroom boardroom=new Boardroom();
            boardroom.setMeetingroomName(meetingroomName);
            boardroom.setMeetingroomDescribe(meetingroomDescribe);
           /* boardroom.setCreator(users.getUserId());*/
            boardroom.setCreator(1);
            boardroom.setCreationDate(new Date());
            boardroom.setIsdelete(1);
            //进行添加
            boolean flag=boardroomService.addNewBoardroom(boardroom);
            if(flag){
                resultMap.put("result","success");
            }else {
                resultMap.put("result","failed");
            }
        }catch (Exception e){
            resultMap.put("result","error");
            e.printStackTrace();
        }
        return resultMap;
    }


    /**
     * 修改会议室
     * @param meetingroomName 会议室名称
     * @param meetingroomDescribe 会议室描述
     * @param meetingroomNo 会议室编号
     * @param session
     * @return
     */
    @RequestMapping(value = "/updateroom")
    @ResponseBody
    public Object updateBoardroom(@RequestParam("meetingroomName")String meetingroomName,
                                  @RequestParam("meetingroomDescribe")String meetingroomDescribe,
                                  @RequestParam("meetingroomNo")String meetingroomNo,
                                  HttpSession session){
        Map<String,Object> resultMap=new HashMap<>();
     /*   Users users=(Users) session.getAttribute("Users");*/
        try {
           Boardroom boardroom=new Boardroom();
            boardroom.setMeetingroomNo(Integer.parseInt(meetingroomNo));
            boardroom.setMeetingroomName(meetingroomName);
            boardroom.setMeetingroomDescribe(meetingroomDescribe);
           /* boardroom.setMender(users.getUserId());*/
            boardroom.setModifyDate(new Date());
            boardroom.setMender(2);
            boardroom.setIsdelete(1);
            //进行修改
            boolean flag=boardroomService.updateBoardroom(boardroom);
            if(flag){
                resultMap.put("result","success");
            }else {
                resultMap.put("result","failed");
            }
        }catch (Exception e){
            resultMap.put("result","error");
            e.printStackTrace();
        }
        return resultMap;
    }


    /**
     * 删除会议室
     * @param meetingroomNo 会议室编号
     * @return
     */
    @RequestMapping(value = "/delroom")
    @ResponseBody
    public Object delBoardroom(@RequestParam("id")String meetingroomNo){
        Map<String,Object> resultMap=new HashMap<>();
        try {
            //进行删除
           boolean flag= boardroomService.delBoardroom(Integer.parseInt(meetingroomNo));
            if(flag){
                resultMap.put("result","success");
            }else {
                resultMap.put("result","failed");
            }
        }catch (Exception e){
            resultMap.put("result","error");
            e.printStackTrace();
        }
        return resultMap;
    }

    /**
     * 根据编号获取会议室对象信息
     * @param meetingroomNo
     * @return
     */
    @RequestMapping(value = "/getroombyid",method = RequestMethod.GET)
    @ResponseBody
    public Object findByMettingroomNo(@RequestParam("id")String meetingroomNo){
        Boardroom boardroom=null;
        try {
             boardroom=boardroomService.findByMeetingroomNo(Integer.parseInt(meetingroomNo));

        }catch (Exception e){
            e.printStackTrace();
        }
        return boardroom;
    }

    /**
     * 获取可预订的所有会议室列表
     * @return
     */
    @RequestMapping("/findMayOrderRoom")
    @ResponseBody
    public Object findMayOrderRoom(@RequestParam("roomsNo")Integer[] roomsNo){
        List<Boardroom> list=null;
        try {
            list=boardroomService.findAllByMeetingroomNoIsNotIn(roomsNo);
            System.out.println("roomsNo============size========="+list.size());
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }





}
