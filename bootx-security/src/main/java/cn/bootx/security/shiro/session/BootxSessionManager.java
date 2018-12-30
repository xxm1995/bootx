package cn.bootx.security.shiro.session;

import cn.bootx.common.utils.StringUtils;
import org.apache.shiro.web.servlet.ShiroHttpServletRequest;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.apache.shiro.web.util.WebUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.Serializable;

import static org.apache.shiro.web.servlet.ShiroHttpServletRequest.REFERENCED_SESSION_ID_SOURCE;
import static org.springframework.http.HttpHeaders.AUTHORIZATION;
 /**   
  * 自定义SessionManager,继承 DefaultWebSessionManager
  * @author xxm  
  * @date 2018/11/21 17:07
  * @version V1.0   
  */
public class BootxSessionManager extends DefaultWebSessionManager {
    /**
     * 重写 SessionId 获取方式
     * @param request 请求
     * @param response 响应
     * @return id
     */
    @Override
    protected Serializable getSessionId(ServletRequest request, ServletResponse response) {
        String id = WebUtils.toHttp( request ).getHeader( AUTHORIZATION );
        //如果请求头中有 Authorization 则其值为sessionId
        if (!StringUtils.isEmpty( id )) {
            request.setAttribute( REFERENCED_SESSION_ID_SOURCE, REFERENCED_SESSION_ID_SOURCE );
            request.setAttribute( ShiroHttpServletRequest.REFERENCED_SESSION_ID, id );
            request.setAttribute( ShiroHttpServletRequest.REFERENCED_SESSION_ID_IS_VALID, Boolean.TRUE );
            return id;
        } else {
            //否则按默认规则从cookie取sessionId
            return super.getSessionId( request, response );
        }
    }
}
