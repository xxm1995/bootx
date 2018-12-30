package cn.bootx.security.shiro.utils;

import cn.bootx.common.domain.UserDO;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

public class ShiroUtils {
    @Autowired
    private static SessionDAO sessionDAO;

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
