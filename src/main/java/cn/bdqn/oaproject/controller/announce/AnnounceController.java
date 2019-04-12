package cn.bdqn.oaproject.controller.announce;

import cn.bdqn.oaproject.pojo.Announce;
import cn.bdqn.oaproject.service.announce.AnnounceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@Controller
@RequestMapping(value = "/anno")
public class AnnounceController {

    @Autowired
    private AnnounceService announceService;

    /**
     * 测试获取所有通告
     */
    @RequestMapping(value = "/announcelist",method = RequestMethod.GET)
    public String getAllAnnounce(Model model){
        //封装多属性排序
        Sort sort=new Sort(Sort.Direction.ASC,"noticeType").
                and(new Sort(Sort.Direction.DESC,"releaseTime"));
        //分页类
        Pageable pageable=new PageRequest(0,2, sort);
        try {
             Page<Announce> announcePage=announceService.findAllAnnounceByPage(pageable);
             model.addAttribute("alist",announcePage);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "Notification_list";
    }

    /**
     * 添加通告
     * @param announce
     * @return
     */
    @RequestMapping(value = "saveannounce.do",method = RequestMethod.POST)
    public String addNewAnnounce(Announce announce){
        try {
            //测试
            announce=new Announce();
            announce.setNoticeTitle("关于五一放假通知");
            announce.setNoticeContent("五一改为四天假期。");
            announce.setCreationDate(new Date());
            announce.setCreator(1);
            boolean flag=announceService.addAnnounce(announce);
            System.out.println(flag);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "Notification_list";
    }


    /**
     * 修改通告
     * @param announce
     * @return
     */
    @RequestMapping(value = "updateannounce.do",method = RequestMethod.POST)
    public String updateAnnounce(Announce announce){
        try {
            //测试
            announce=new Announce();
            announce.setNoticeNo(3);
            announce.setNoticeTitle("关于五一放假通知!!!!");
            announce.setNoticeContent("五一改为四天假期la 。");
            announce.setMender(2);
            announce.setModifyDate(new Date());
            boolean flag=announceService.updateAnnounce(announce);
            System.out.println(flag);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "Notification_list";
    }

    /**
     * 删除通告
     * @param noticeNo
     * @return
     */
    @RequestMapping(value = "/delannounce.do",method = RequestMethod.POST)
    public String deleteAnnounce(@RequestParam("id")String noticeNo){
        try {
            boolean flag=announceService.delAnnounce(3);
            System.out.println(flag);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "Notification_list";
    }

    /**
     * 根据通告编号获取通告对象
     * @param noticeNo 通告编号
     */
    @RequestMapping(value="/getbyid",method = RequestMethod.GET)
    public String findAnnounceById(@RequestParam("id")String noticeNo){
        try {
            Announce announce=new Announce();
            announce=announceService.findAnnouceById(20002);
            System.out.println(announce.getNoticeTitle()+"\t"+announce.getNoticeContent());
        }catch (Exception e){
            e.printStackTrace();
        }
        return "Notification_list";
    }



}
