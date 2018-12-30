package cn.bootx.security.shiro.entity;

import org.apache.shiro.authc.AuthenticationToken;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
  * 微信token认证
  * @author xxm  
  * @date 2018/11/21 16:24
  * @version V1.0   
  */
@Component()
@Scope("prototype")
//@ConfigurationProperties("cb.wx.miniApps")
public class WxToken implements AuthenticationToken {
    private final String grantType = "authorization_code";
    /** 小程序 appId */
    @Value("${cb.wx.miniApps.appid}")
    private String appid;
    /** 小程序 appSecret */
    @Value("${cb.wx.miniApps.secret}")
    private String secret;
    /** 登录时获取的 code */
    private String code;

    public WxToken() {

    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getAppid() {
        return appid;
    }

    public String getSecret() {
        return secret;
    }

    public String getGrantType() {
        return grantType;
    }

    @Override
    public Object getPrincipal() {
        return this.code;
    }

    @Override
    public Object getCredentials() {
        return "";  //密码返回"",不进行认证
    }

    @Override
    public String toString() {
        return "WxToken{" +
                "code='" + code + '\'' +
                ", appid='" + appid + '\'' +
                ", secret='" + secret + '\'' +
                ", grantType='" + grantType + '\'' +
                '}';
    }
}
