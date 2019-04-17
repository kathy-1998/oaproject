package cn.bdqn.oaproject.controller.personnel;


import cn.bdqn.oaproject.pojo.ProofOfEarningsApply;
import cn.bdqn.oaproject.service.personnel.ProofOfEarningsApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/incomeApply")
public class IncomeApplyController {


    @Autowired
    ProofOfEarningsApplyService proofOfEarningsApplyService;

    /**
     * 访问收入申请页面时
     *
     * @return
     */
    @RequestMapping("/IncomeApply.html")
    public String IncomeApply() {
        return "Revenue_proof_process";
    }


    @RequestMapping("/AddIncomeApply.html")
    @ResponseBody
    public Object add(@RequestParam(value = "applyuserName", required = false) String userName,
                      @RequestParam(value = "sprId", required = false) Integer sprId,
                      @RequestParam(value = "reason", required = false) String reason,
                      @RequestParam(value = "deptName", required = false) String deptName,
                      @RequestParam(value = "jobName", required = false) String jobName,
                      @RequestParam(value = "applyuserId", required = false) Integer applyuserId,
                      @RequestParam(value = "deptId", required = false) Integer deptId,
                      @RequestParam(value = "jobId", required = false) Integer jobId) {


        //往收入申请表中添加一条记录，如果添加成功，则向待处理任务列表中也添加一条记录
        ProofOfEarningsApply proofOfEarningsApply = new ProofOfEarningsApply();

        proofOfEarningsApply.setCreator(1);
        proofOfEarningsApply.setApplyForReason(reason);
        proofOfEarningsApply.setDeptId(deptId);
        proofOfEarningsApply.setJobId(jobId);
        proofOfEarningsApply.setIsdelete(1);
        proofOfEarningsApply.setApplyUserName(userName);
        proofOfEarningsApply.setUserId(sprId);
        proofOfEarningsApply.setTaskTypeId(6);
        proofOfEarningsApply.setApplyUserId(applyuserId);
        proofOfEarningsApply.setCreationDate(new Date());
        proofOfEarningsApply.setStatus(0);
     if(proofOfEarningsApplyService.add(proofOfEarningsApply)){
           return  "true";
        }else{
           return "false";
       }











    }


}
