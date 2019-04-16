package cn.bdqn.oaproject.controller.mydesktop.urlRecord;

import cn.bdqn.oaproject.pojo.UrlRecord;
import cn.bdqn.oaproject.pojo.Users;
import cn.bdqn.oaproject.service.mydesktop.UrlRecordService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/urlRecord")
public class UrlRecordController {

    @Autowired
    private UrlRecordService urlRecordService;

    /**
     * 获取全部信息
     * @return
     */
    @RequestMapping(value = "/urlRecord.find",method = RequestMethod.GET)
    @ResponseBody
    public String getUrlInfo(HttpSession session){
        String json="";
        Users users=(Users)session.getAttribute("User");
        Pageable pageable=new PageRequest(0,2);
        Page<UrlRecord> pageList=null;
        Specification specification=new Specification<UrlRecord>() {
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery criteriaQuery, CriteriaBuilder cb) {
                List<Predicate> predicates = new ArrayList<>();
                predicates.add(cb.equal(root.get("userId").as(Integer.class),users.getUserId()));
                return cb.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        };
        pageList=urlRecordService.findAll(specification,pageable);
        json= JSON.toJSONString(pageList);
        System.out.println(json);
        return json;
    }
    @RequestMapping(value = "/urlRecordById.find")
    @ResponseBody
    public String getUrlInfoById(Integer rid){
        String json="";
        UrlRecord urlRecord=urlRecordService.getInfoById(rid);
        json=JSON.toJSONString(urlRecord);
        System.out.println(json);
        return json;
    }
    /**
     * 添加网址信息
     * @param session
     * @param urlTitle
     * @param urlLink
     * @return
     */
    @RequestMapping(value = "/add.do",method = RequestMethod.GET)
    @ResponseBody
    public String addInfo(HttpSession session,String urlTitle,String urlLink){
        String flag="No";
        UrlRecord urlRecord=new UrlRecord();
        urlRecord.setUserId(((Users)session.getAttribute("User")).getUserId());
        urlRecord.setUrlRecordId(2);
        urlRecord.setUrlRecordTitle(urlTitle);
        urlRecord.setLink(urlLink);
        if(urlRecordService.save(urlRecord)){
            flag="Yes";
        }
        return flag;
    }

    /**
     * 修改网址信息
     * @param urlTitle
     * @param urlLink
     * @param rid
     * @return
     */
    @RequestMapping(value = "/update.do",method = RequestMethod.GET)
    @ResponseBody
    public String updateInfo(String urlTitle,String urlLink,Integer rid){
        String flag="No";
        UrlRecord urlRecord=new UrlRecord();
        urlRecord.setUrlRecordId(rid);
        urlRecord.setUrlRecordTitle(urlTitle);
        urlRecord.setLink(urlLink);
        if(urlRecordService.update(urlRecord)){
            flag="Yes";
        }
        return flag;
    }

    /**
     * 删除网址信息
     * @param rid
     * @return
     */
    @RequestMapping(value = "/delete.do",method = RequestMethod.GET)
    @ResponseBody
    public String deleteInfo(Integer rid){
        String flag="No";
        if(urlRecordService.delete(rid)){
            flag="Yes";
        }
        return flag;
    }
}
