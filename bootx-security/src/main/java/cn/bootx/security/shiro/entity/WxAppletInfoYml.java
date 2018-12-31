package cn.bootx.security.shiro.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**   
* 微信小程序相关信息
* @author xxm  
* @date 2018/12/31 14:58
* @version V1.0   
*/
@Component
@ConfigurationProperties(prefix = "bootx.weixin.applet")
public class WxAppletInfoYml {
    /** 小程序 appId */
    private String appid;
    /** 小程序 appSecret */
    private String secret;

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }
}
