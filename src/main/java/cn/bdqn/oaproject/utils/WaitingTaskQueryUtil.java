package cn.bdqn.oaproject.utils;

import cn.bdqn.oaproject.service.personnel.LeaveApplyService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 待处理任务查询工具类
 */
public class WaitingTaskQueryUtil {

    @Autowired
    private LeaveApplyService leaveApplyService;
    /**
     * 根据任务类型Id以及申请记录Id查询当前待处理任务的详细信息
     * @param typeId
     * @param applyId
     * @return
     */
    public Object getInfoByTypeIdAndApplyId(Integer typeId,Integer applyId){
        Object obj=null;
        switch (typeId){
            case 1:

                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
        }
        return obj;
    }
}
