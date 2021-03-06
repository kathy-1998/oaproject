package cn.bdqn.oaproject.controller.mydesktop.waitingTaskRecord;


import cn.bdqn.oaproject.pojo.*;
import cn.bdqn.oaproject.service.mydesktop.WaitingTaskRecordService;
import cn.bdqn.oaproject.utils.WaitingTaskQueryUtil;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
@RequestMapping("/waiting")
public class WaitingTaskRecordController {

    @Autowired
    private WaitingTaskRecordService waitingTaskRecordService;


    /**
     * 根据当前用户获取待处理信息
     * @param session
     * @return
     */
    @RequestMapping("/getInfo.find")
    @ResponseBody
    public String getInfo(HttpSession session, Date applyTime,Integer taskTypeId,@RequestParam(value = "pageIndex", required = false) String pageindex,
                          @RequestParam(value = "pageSize", required = false) Integer pageSize){
        String json="";
        Users users=(Users) session.getAttribute("User");
        if (pageindex.equals("undefined")) {
            pageindex = "1";
        }
        //结果集合
        Map<String, Object> resultMap = new HashMap<>();
        Pageable pageable=new PageRequest(Integer.parseInt(pageindex) - 1, pageSize);
        Page<WaitingTaskRecord> pageList=null;
        Specification specification=new Specification<WaitingTaskRecord>() {
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery criteriaQuery, CriteriaBuilder cb) {
                List<Predicate> predicates = new ArrayList<>();
                if(!applyTime.equals("undefined") || !applyTime.equals("")){
                    predicates.add(cb.between(root.get("applyTime").as(Date.class),applyTime,applyTime));
                }
                if(!taskTypeId.equals("undefined") || taskTypeId!=0){
                    predicates.add(cb.equal(root.get("taskTypeId").as(Integer.class),taskTypeId));
                }
                predicates.add(cb.equal(root.get("userId").as(Integer.class),users.getUserId()));
                return cb.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        };
        pageList=waitingTaskRecordService.findAll(specification,pageable);

        resultMap.put("waiting", pageList);

        //当前页码
        resultMap.put("pageIndex", pageindex);
        //从页码
        resultMap.put("pageCount", pageList.getTotalPages());
        json= JSON.toJSONString(resultMap);
        System.out.println(resultMap);
        return json;
    }

    @RequestMapping("/getInfoById.find")
    @ResponseBody
    public String getInfoById(HttpSession session){
        String json="";
        Users users=(Users) session.getAttribute("User");
        List<WaitingTaskRecord> waitingTaskRecord=waitingTaskRecordService.getInfoById(users.getUserId());
        json=JSON.toJSONString(waitingTaskRecord);
        System.out.println(json);
        return json;
    }

    /**
     * 审批
     * @return
     */
    @RequestMapping("/examine.do")
    @ResponseBody
    public String examine(Integer id,HttpSession session,String applyOpinion){
        String message="No";
        Users users=(Users) session.getAttribute("User");
        if(waitingTaskRecordService.modifyInfo(users.getUserId(),applyOpinion,new Date(),id)){
            message="Yes";
        }
        return message;
    }

    @RequestMapping("/findInfoById.find")
    @ResponseBody
    public String findInfoByTypeIdAndApplyId(Integer applyId,Integer typeId){
        String json="";
        Object obj= null;
        WaitingTaskQueryUtil waitingTaskQueryUtil=new WaitingTaskQueryUtil();
        List<Object> objects=new ArrayList<Object>();
        try {
            obj=waitingTaskQueryUtil.getInfoByTypeIdAndApplyId(typeId,applyId);
            if(obj instanceof LeaveApply){
                LeaveApply leaveApply=(LeaveApply) obj;
                objects.add(leaveApply);
                objects.add("请假申请");
            }
            if(obj instanceof BusinessTripApply){
                BusinessTripApply businessTripApply=(BusinessTripApply) obj;
                objects.add(businessTripApply);
                objects.add("出差申请");
            }
            if(obj instanceof CarApply){
                CarApply carApply=(CarApply) obj;
                objects.add(carApply);
                objects.add("用车申请");
            }
            if(obj instanceof SealApply){
                SealApply sealApply=(SealApply) obj;
                objects.add(sealApply);
                objects.add("用章申请");
            }
            if(obj instanceof BookBorrow){
                BookBorrow bookBorrow=(BookBorrow) obj;
                objects.add(bookBorrow);
                objects.add("图书借阅");
            }
            json=JSON.toJSONString(objects);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(json);
        return json;
    }
}
