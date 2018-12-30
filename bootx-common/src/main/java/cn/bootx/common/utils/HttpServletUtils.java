package cn.bootx.common.utils;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

/**
 * http工具类
 * @author xxm
 * @date 2018/12/20 11:28
 * @version V1.0
 */
public class HttpServletUtils {
    /**
     * 判断是否是ajax请求
     * @param request 请求
     * @return bool
     */
    public static boolean jsAjax(ServletRequest request){
        String header = ((HttpServletRequest) request).getHeader("X-Requested-With");
        String Authorization = ((HttpServletRequest) request).getHeader("Authorization");
        if("XMLHttpRequest".equalsIgnoreCase(header)||Authorization != null){
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
}
