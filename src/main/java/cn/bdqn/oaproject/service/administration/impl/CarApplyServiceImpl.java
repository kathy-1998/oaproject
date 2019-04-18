package cn.bdqn.oaproject.service.administration.impl;

import cn.bdqn.oaproject.dao.administration.CarApplyDao;
import cn.bdqn.oaproject.pojo.CarApply;
import cn.bdqn.oaproject.service.administration.CarApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarApplyServiceImpl implements CarApplyService {

    @Autowired
    private CarApplyDao carApplyDao;

    /**
     * 添加用车申请记录
     * @param carApply
     * @return
     * @throws Exception
     */
    @Override
    public boolean addCarApplyRecord(CarApply carApply) throws Exception {
        try {
            carApplyDao.save(carApply);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 根据申请记录id和任务类型id获取详情
     * @param carApplyId
     * @param taskId
     * @return
     * @throws Exception
     */
    @Override
    public CarApply findByCarApplyIdAndTaskId(Integer carApplyId, Integer taskId) throws Exception {
        CarApply carApply=null;
        try {
            carApply=carApplyDao.findByCarApplyIdAndTaskId(carApplyId,taskId);
        }catch (Exception e){
            e.printStackTrace();
        }
        return carApply;
    }

    /**
     * 审核用车申请
     * @param carApplyId
     * @param status
     * @return
     * @throws Exception
     */
    @Override
    public boolean approveCarApply(Integer carApplyId, Integer status) throws Exception {
        try {
            carApplyDao.updateStatus(carApplyId,status);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }
}
