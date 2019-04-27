package cn.bdqn.oaproject.utils;

import cn.bdqn.oaproject.service.administration.BookBorrowService;
import cn.bdqn.oaproject.service.administration.CarApplyService;
import cn.bdqn.oaproject.service.administration.SealApplyService;
import cn.bdqn.oaproject.service.personnel.BusinessTripApplyService;
import cn.bdqn.oaproject.service.personnel.LeaveApplyService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 待处理任务查询工具类
 */
public class WaitingTaskQueryUtil {

    @Autowired
    private LeaveApplyService leaveApplyService;

    @Autowired
    private SealApplyService sealApplyService;

    @Autowired
    private CarApplyService carApplyService;

    @Autowired
    private BusinessTripApplyService businessTripApplyService;

    @Autowired
    private BookBorrowService bookBorrowService;
    /**
     * 根据任务类型Id以及申请记录Id查询当前待处理任务的详细信息
     * @param typeId
     * @param applyId
     * @return
     */
    public Object getInfoByTypeIdAndApplyId(Integer typeId,Integer applyId) throws Exception{
        Object obj=null;

        System.out.println("任务类型:"+typeId+",："+applyId);
        switch (typeId){
            case 1:  //请假申请
                obj=leaveApplyService.getInfoById(applyId);
                break;
            case 2:  //出差申请
                obj=businessTripApplyService.getInfoById(applyId);
                break;
            case 3: //用车申请
                obj=carApplyService.getInfoById(applyId);
                break;
            case 4:  //用章申请
                obj=sealApplyService.findBySealApplyIdAndTaskTypeId(applyId,typeId);
                break;
            case 5:  //图书借阅申请
                obj=bookBorrowService.getInfoById(applyId);
                break;
        }
        return obj;
    }
}
