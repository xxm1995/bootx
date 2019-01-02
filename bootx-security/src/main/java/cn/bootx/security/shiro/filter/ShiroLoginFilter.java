package cn.bootx.security.shiro.filter;

import cn.bootx.common.constant.ConstantCodePool;
import cn.bootx.common.page.R;
import cn.bootx.security.utils.HttpServletUtils;
import com.alibaba.fastjson.JSONObject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

 /**
  * shiro自定义过滤器, ajax请求返回json,其他重定向
  * @author xxm
  * @date 2018/12/10 14:21
  * @version V1.0
  */
public class ShiroLoginFilter extends FormAuthenticationFilter {
    /**
     * 在访问controller前判断是否登录，返回json，不进行重定向。
     * @param request 请求
     * @param response 响应
     * @return true-继续往下执行，false-该filter过滤器已经处理，不继续执行其他过滤器
     * @throws Exception 异常
     */
    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws IOException {
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        if (HttpServletUtils.jsAjax( request )) {
            httpServletResponse.setCharacterEncoding("UTF-8");
            httpServletResponse.setContentType("application/json");
            httpServletResponse.getWriter().
                    write(JSONObject.toJSON(R.ERROR().code(ConstantCodePool.NOT_LOGIN).msg(  "未登录")).toString());
        } else {
            //非ajax请求重定向为登录页面
            httpServletResponse.sendRedirect("/login");
        }
        return false;
    }

}
