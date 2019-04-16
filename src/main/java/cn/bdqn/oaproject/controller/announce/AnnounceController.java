package cn.bdqn.oaproject.controller.announce;

import cn.bdqn.oaproject.pojo.Announce;
import cn.bdqn.oaproject.pojo.Users;
import cn.bdqn.oaproject.service.announce.AnnounceService;
import cn.bdqn.oaproject.utils.stringToDateConverter;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/anno")
public class AnnounceController {

    @Autowired
    private AnnounceService announceService;



    /**
     * 进入通告列表页面
     * @return
     */
    @RequestMapping(value="/annomain",method = RequestMethod.GET)
    public String annoMain(){
            return "Notification_list_1";
    }

    /**
     * 分页获取所有通告
     * @param pageIndex 当前页码
     * @param pageSize 每页显示记录数
     * @return 符合条件的通告列表
     */
    @RequestMapping(value = "/announcelist",method = RequestMethod.GET)
    @ResponseBody
    public Object getAllAnnounce(@RequestParam("pageIndex") String pageIndex,
                                 @RequestParam("pageSize") String pageSize,HttpSession session){

        Map<String,Object> resultMap=new HashMap<String,Object>();
        //获取当前登录用户
        Users user=(Users)session.getAttribute("User");
        //封装多属性排序
        Sort sort=new Sort(Sort.Direction.ASC,"noticeType").
                and(new Sort(Sort.Direction.DESC,"releaseTime"));
        //判断当前页码
        int page_index=1;
        if(pageIndex!=null){
            page_index=Integer.parseInt(pageIndex);
        }
        //判断每页显示记录数
        int page_size=1;
        if(pageSize!=null){
            page_size=Integer.parseInt(pageSize);
        }

        //分页类
        Pageable pageable=new PageRequest(page_index-1,page_size, sort);
        Page<Announce> announcePage=null;

        try {
            announcePage=announceService.findAllAnnounceByPage(pageable);
            resultMap.put("announcePage",announcePage);
            resultMap.put("user",user);
            System.out.println(JSON.toJSONString(announcePage,true));
        }catch (Exception e){
            e.printStackTrace();
        }
        return resultMap;
    }

    /**
     * 添加通告
     * @param noticeTitle 标题
     * @param noticeType 通告类型
     * @param startTime 显示起始时间
     * @param endTime  显示截至时间
     * @param releaseTime 发布时间
     * @param noticeContent 通告内容
     * @param noticeStatus 通告状态
     * @param session 获取当前登录用户
     * @return 添加执行结果
     */
    @RequestMapping(value = "saveannounce.do",method = RequestMethod.POST)
    @ResponseBody
    public Object addNewAnnounce(@RequestParam("noticeTitle")String noticeTitle,
                                 @RequestParam("noticeType")String noticeType,
                                 @RequestParam("startTime")String startTime,
                                 @RequestParam("endTime")String endTime,
                                 @RequestParam("releaseTime")String releaseTime,
                                 @RequestParam("noticeContent")String noticeContent,
                                 @RequestParam("noticeStatus")String noticeStatus,
                                 HttpSession session){
        Map<String,Object> resultMap=new HashMap<String,Object>() ;
        Announce announce=new Announce();
        try {
            //获取当前登录用户
            Users user=(Users)session.getAttribute("User");
            //设置创建用户
          /*  announce.setCreator(user.getUserId());*/
            //赋值
            announce.setStartTime(stringToDateConverter.strToDate(startTime,"yyyy-MM-dd HH:mm:ss"));
            announce.setEndTime(stringToDateConverter.strToDate(endTime,"yyyy-MM-dd HH:mm:ss"));
            announce.setReleaseTime(stringToDateConverter.strToDate(releaseTime,"yyyy-MM-dd HH:mm:ss"));
            announce.setNoticeStatus(Integer.parseInt(noticeStatus));
            announce.setNoticeContent(noticeContent);
            announce.setNoticeTitle(noticeTitle);
            announce.setNoticeType(Integer.parseInt(noticeType));
            announce.setCreator(1);
            //设置创建时间
            announce.setCreationDate(new Date());
            announce.setIsdelete(1);
            //进行添加操作
            boolean flag=announceService.addAnnounce(announce);

            System.out.println(flag);
            //判断是否添加成功
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
     * 修改通告
     * @param noticeTitle 标题
     * @param noticeType 通告类型
     * @param startTime 显示起始时间
     * @param endTime  显示截至时间
     * @param releaseTime 发布时间
     * @param noticeContent 通告内容
     * @param session 获取当前登录用户
     * @return 修改执行结果
     */
    @RequestMapping(value = "updateannounce.do",method = RequestMethod.POST)
    @ResponseBody
    public Object updateAnnounce(@RequestParam("noticeTitle")String noticeTitle,
                                 @RequestParam("noticeType")String noticeType,
                                 @RequestParam("startTime")String startTime,
                                 @RequestParam("endTime")String endTime,
                                 @RequestParam("releaseTime")String releaseTime,
                                 @RequestParam("noticeContent")String noticeContent,
                                 @RequestParam("noticeNo")String noticeNo,
                                 HttpSession session){
        Map<String,Object> resultMap=new HashMap<String,Object>() ;
        Announce announce=new Announce();
        try {
            announce.setNoticeNo(Integer.parseInt(noticeNo));
            announce.setStartTime(stringToDateConverter.strToDate(startTime,"yyyy-MM-dd HH:mm:ss"));
            announce.setEndTime(stringToDateConverter.strToDate(endTime,"yyyy-MM-dd HH:mm:ss"));
            announce.setReleaseTime(stringToDateConverter.strToDate(releaseTime,"yyyy-MM-dd HH:mm:ss"));
            announce.setNoticeContent(noticeContent);
            announce.setNoticeTitle(noticeTitle);
            announce.setNoticeType(Integer.parseInt(noticeType));
            announce.setIsdelete(1);
            //设置创建者为当前登录用户
            announce.setMender(2);
            //设置修改日期
            announce.setModifyDate(new Date());
            boolean flag=announceService.updateAnnounce(announce);
            //判断是否修改成功
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
     * 删除通告
     * @param noticeNo
     * @return
     */
    @RequestMapping(value = "/delannounce.do")
    @ResponseBody
    public Object deleteAnnounce(@RequestParam("id")String noticeNo){
        Map<String,Object> resultMap=new HashMap<String,Object>();
        try {
            boolean flag=announceService.delAnnounce(noticeNo==null?0:Integer.parseInt(noticeNo));
            //判断是否删除成功
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
     * 根据通告编号获取通告对象
     * @param noticeNo 通告编号
     */
    @RequestMapping(value="/getdetail",method = RequestMethod.GET)
    @ResponseBody
    public Object findAnnounceById(@RequestParam("id")String noticeNo){
        Announce announce=new Announce();
        try {
            announce=announceService.findAnnouceById(Integer.parseInt(noticeNo));
        }catch (Exception e){
            e.printStackTrace();
        }
        return announce;
    }

    /**
     * 获取详情
     * @param noticeNo 通告编号
     */
    @RequestMapping(value="/getbyid",method = RequestMethod.GET)
    public String findAnnounce(@RequestParam("id")String noticeNo,Model model){
        Announce announce=new Announce();
        try {
            announce=announceService.findAnnouceById(Integer.parseInt(noticeNo));
            model.addAttribute("announce",announce);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "Notice_details_page";
    }

}
