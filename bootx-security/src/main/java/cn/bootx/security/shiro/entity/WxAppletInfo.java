package cn.bootx.security.shiro.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**   
* 微信小程序相关信息
* @author xxm  
* @date 2018/12/31 14:58
* @version V1.0   
*/
@Component
public class WxAppletInfo {
    /** 小程序 appId */
    private static String appid;
    /** 小程序 appSecret */
    private static String secret;

    @Value("${bootx.weixin.applet.appid:}")
    public void setAppid(String appid) {
        WxAppletInfo.appid = appid;
    }
    @Value("${bootx.weixin.applet.secret:}")
    public void setSecret(String secret) {
        WxAppletInfo.secret = secret;
    }

    public static String getAppid() {
        return appid;
    }

    public static String getSecret() {
        return secret;
    }
}
