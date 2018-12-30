package cn.bootx.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.catalina.User;
/**   
* 登录类操作接口
* @author xxm  
* @date 2018/12/30 17:19
* @version V1.0   
*/
public interface LoginService<T> extends IService<T> {
    User loginByUseerName(String username,String password);
}
