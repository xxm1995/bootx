package cn.bootx.api.service;

import cn.bootx.common.domain.UserDO;
import com.baomidou.mybatisplus.extension.service.IService;

/**   
* 用户类操作接口
* @author xxm  
* @date 2018/12/30 17:19
* @version V1.0   
*/
public interface UserService<T> extends IService<T> {
    /**
     * 新建一个用户
     * @return boolean
     */
    boolean save(UserDO userDO);
}
