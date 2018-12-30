package cn.bootx.security.utils;

import cn.bootx.common.domain.UserDO;
import cn.bootx.security.shiro.utils.ShiroUtils;

import static cn.bootx.security.shiro.utils.ShiroUtils.getSubjct;
/**   
*  统一安全接口
* @author xxm
* @date 2018/12/30 17:06 
* @version V1.0   
*/
public class SecurityUtils {

    /**
     * 获取用户
     * @return CbUserDO
     */
    public static UserDO getUser() {
        return ShiroUtils.getUser();
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
