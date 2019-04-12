package cn.bdqn.oaproject.controller.administration;

import cn.bdqn.oaproject.pojo.BoardroomOrder;
import cn.bdqn.oaproject.service.administration.BoardroomOrderService;
import cn.bdqn.oaproject.utils.stringToDateConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    @RequestMapping(value = "saveroomorder",method = RequestMethod.POST)
    public String addBoardroomOrder(BoardroomOrder boardroomOrder){
        boardroomOrder=new BoardroomOrder();
        boardroomOrder.setMeetingroomNo(1);
        boardroomOrder.setOrderPerson(2);
        try {
            boardroomOrder.setStartTime(stringToDateConverter.strToDate("2019-4-13 14:30:33","yyyy-MM-dd HH:mm:ss"));
            boardroomOrder.setEndTime(stringToDateConverter.strToDate("2019-4-13 14:45:00","yyyy-MM-dd HH:mm:ss"));
        }catch (Exception e){
            e.printStackTrace();
        }
        boardroomOrder.setCreator(1);
        boardroomOrder.setCreationDate(new Date());

        //进行添加
        boolean flag=boardroomOrderService.addRoomOrder(boardroomOrder);
        System.out.println(flag);
        return "Conference_room_manage";
    }

    /**
     * 根据条件动态获取会议室预订记录
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @param orderPerson 预订人
     * @param meetingroomName 会议室名称
     * @param typeId 会议类型id
     * @return
     */
    @RequestMapping(value = "/allorder",method = RequestMethod.GET)
    public String findAll(@RequestParam(value="startTime",required = false)String startTime,
                          @RequestParam(value="endTime",required = false)String endTime,
                          @RequestParam(value="orderPerson",required = false)String orderPerson,
                          @RequestParam(value="meetingroomName",required = false)String meetingroomName,
                          @RequestParam(value="typeId",required = false)String typeId){
        List<BoardroomOrder> list=null;
        try {
            //specification是jpa用来动态查询的一个接口
            Specification specification=new Specification<BoardroomOrder>() {
                @Override
                public Predicate toPredicate(Root root, CriteriaQuery criteriaQuery, CriteriaBuilder cb) {
                    List<Predicate> predicates=new ArrayList<>();
                    //判断预订起始时间
                    if(null!=startTime){
                        predicates.add(cb.greaterThanOrEqualTo(root.get("startTime").as(Date.class),startTime));
                    }
                    //判断预订截止时间
                    if(null!=endTime){
                        predicates.add(cb.greaterThanOrEqualTo(root.get("endTime").as(Date.class),endTime));
                    }
                    //判断预订人
                    if(null!=orderPerson){
                        predicates.add(cb.like(root.get("orderPersoon"),"%"+orderPerson+"%"));
                    }
                    //判断会议室名称
                    if(null!=meetingroomName){
                        predicates.add(cb.like(root.get("boardroom").get("meetingroomName"),"%"+meetingroomName+"%"));
                    }
                    //判断会议类型
                    if(null!=typeId){
                        predicates.add(cb.equal(root.get("typeId"),typeId));
                    }
                    return cb.and(predicates.toArray(new Predicate[predicates.size()]));
                }
            };
            list=boardroomOrderService.findAll(specification);
            for (BoardroomOrder b:list){
                System.out.println(b.getMeetingroomNo()+"\n"+b.getBoardroom().getMeetingroomName());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return "Conference_room_manage";
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
