package cn.bdqn.oaproject.service.administration.impl;

import cn.bdqn.oaproject.dao.administration.SealApplyDao;
import cn.bdqn.oaproject.pojo.SealApply;
import cn.bdqn.oaproject.service.administration.SealApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SealApplyServiceImpl implements SealApplyService {

    @Autowired
    private SealApplyDao sealApplyDao;

    /**
     * 添加用章申请
     * @param sealApply
     * @return
     * @throws Exception
     */
    @Override
    public boolean addNewSealApply(SealApply sealApply) throws Exception {
        try {
            sealApplyDao.save(sealApply);
            return  true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 根据用章申请编号和任务类型编号获取详情
     * @param sealApplyId
     * @param taskTypeId
     * @return
     * @throws Exception
     */
    @Override
    public SealApply findBySealApplyIdAndTaskTypeId(Integer sealApplyId, Integer taskTypeId) throws Exception {
        SealApply sealApply=null;
        try {
            sealApply=sealApplyDao.findBySealApplyIdAndTaskTypeId(sealApplyId,taskTypeId);
        }catch (Exception e){
            e.printStackTrace();
        }
        return sealApply;
    }

    /**
     *  审核用车申请
     * @param sealApplyId 用章申请id
     * @param status 修改申请状态
     * @return
     */
    @Override
    public boolean approveSealApply(Integer sealApplyId, Integer status) {
        try {
            sealApplyDao.updateStatus(sealApplyId,status);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }
}
