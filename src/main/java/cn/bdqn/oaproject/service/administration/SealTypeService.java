package cn.bdqn.oaproject.service.administration;

import cn.bdqn.oaproject.pojo.SealType;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用章类型业务操作接口
 */
@Service
public interface SealTypeService {

    /**
     * 获取所有用章类型
     * @return
     */
    List<SealType> findAllSealType()throws  Exception;
}
