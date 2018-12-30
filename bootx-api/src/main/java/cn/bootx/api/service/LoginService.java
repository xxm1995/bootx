package cn.bootx.api.service;

import cn.bootx.common.domain.UserDO;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* 登录类操作接口
* @author xxm  
* @date 2018/12/30 17:19
* @version V1.0   
*/
public interface LoginService<T> extends IService<T> {
    /**
     * 根据账号密码进行登录
     * @param username 账号
     * @param password 密码
     * @return UserDO 用户
     */
    UserDO loginByUseerName(String username, String password);
    /**
     * 根据账号密码进行登录
     * @param userDO 用户类
     * @return UserDO 用户
     */
    UserDO loginByUseerName(UserDO userDO);
}
