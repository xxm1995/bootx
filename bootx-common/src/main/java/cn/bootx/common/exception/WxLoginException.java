package cn.bootx.common.exception;

import org.apache.shiro.authc.AuthenticationException;

/**
 * 微信登录出错
 * 继承 AuthenticationException 是为了和shiro兼容,
 * 不然shiro会将异常重新包装成AuthenticationException,
 * 这个自定义的异常就无法在controller中捕获了
 * @author xxm
 * @date 2018/12/10 15:40
 * @version V1.0
 */
public class WxLoginException extends AuthenticationException {
    public WxLoginException(String info) {
        super(info);
    }
    public WxLoginException(){}
}
