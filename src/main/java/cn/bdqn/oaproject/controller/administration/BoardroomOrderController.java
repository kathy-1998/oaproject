package cn.bdqn.oaproject.controller.administration;

import cn.bdqn.oaproject.pojo.Boardroom;
import cn.bdqn.oaproject.pojo.BoardroomOrder;
import cn.bdqn.oaproject.pojo.Users;
import cn.bdqn.oaproject.service.administration.BoardroomOrderService;
import cn.bdqn.oaproject.utils.stringToDateConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("/roomorder")
public class BoardroomOrderController {

    @Autowired
    private BoardroomOrderService boardroomOrderService;

    /**
     * 添加记录
     * @param boardroomOrder
     * @return
     */
    @RequestMapping(value = "saveroomorder")
    @ResponseBody
    public Object addBoardroomOrder(@ModelAttribute  BoardroomOrder boardroomOrder, HttpSession session){
        Map<String,Object> resultMap=new HashMap<>();
        //获取当前登录用户
        /*Users users=(Users) session.getAttribute("User");
        boardroomOrder.setCreator(users.getUserId());*/
        boardroomOrder.setIsdelete(1);
        boardroomOrder.setCreator(1);
        boardroomOrder.setCreationDate(new Date());

        try {
            //进行添加
            boolean flag=boardroomOrderService.addRoomOrder(boardroomOrder);
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
     * 根据条件动态获取会议室预订记录
     * boardroomOrder
     * @return
     */
    @RequestMapping(value = "/allorder",method = RequestMethod.GET)
    @ResponseBody
    public Object findAll(String startTime,String endTime,String orderPerson,String meetingroomName,String typeId) throws ParseException {
        //封装条件对象
        BoardroomOrder boardroomOrder=new BoardroomOrder();
        boardroomOrder.setBoardroom(new Boardroom());
        boardroomOrder.getBoardroom().setMeetingroomName(meetingroomName);
        boardroomOrder.setOrderPerson(orderPerson==null?0:Integer.parseInt(orderPerson));
        boardroomOrder.setTypeId(typeId==null?0:Integer.parseInt(typeId));
        boardroomOrder.setStartTime(new SimpleDateFormat("yyyy-MM-dd HH:ss").parse(startTime));
        boardroomOrder.setEndTime(new SimpleDateFormat("yyyy-MM-dd HH:ss").parse(endTime));

        List<BoardroomOrder> list=null;
        System.out.println("startTime===================="+startTime);
        System.out.println("endTime==============="+endTime);
        try {
            list=boardroomOrderService.findAll(boardroomOrder);
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 根据记录编号删除会议室预订编号
     * @param id 记录编号
     * @return
     */
    @RequestMapping(value = "/delorder")
    public String delBoardroomOrder(@RequestParam("id")String id){
        try {
            boardroomOrderService.deleteByReservationNo(3);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "Conference_room_manage";
    }


    @RequestMapping(value = "/findorder",method = RequestMethod.GET)
    public String findOrder(@RequestParam("id")String id){
        try {
            BoardroomOrder order=boardroomOrderService.findByReservationNo(3);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "Conference_room_manage";
    }








}
