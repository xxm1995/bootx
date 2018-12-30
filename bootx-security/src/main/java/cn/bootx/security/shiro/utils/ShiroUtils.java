package cn.bootx.security.shiro.utils;

import cn.bootx.common.domain.UserDO;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

/**   
* shiro安全接口
* @author xxm  
* @date 2018/12/30 17:04 
* @version V1.0   
*/
public class ShiroUtils {
    /**
     * 获取Subject
     * @return Subject
     */
    public static Subject getSubjct() {
        return SecurityUtils.getSubject();
    }

    /**
     * 获取用户
     * @return CbUserDO
     */
    public static UserDO getUser() {
        Object object = getSubjct().getPrincipal();
        return (UserDO)object;
    }

    /**
     * 获取用户id
     * @return Long
     */
    public static String getUserId() {
        return getUser().getId();
    }

    /**
     * 退出登录
     */
    public static void logout() {
        getSubjct().logout();
    }
}
