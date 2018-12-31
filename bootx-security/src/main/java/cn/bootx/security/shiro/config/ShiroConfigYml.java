package cn.bootx.security.shiro.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
* shiro配置相关提示,用于yml中自动提示
* @author xxm  
* @date 2018/12/31 16:12 
* @version V1.0   
*/
@Component
@ConfigurationProperties(prefix = "bootx.security.shiro")
public class ShiroConfigYml {
    /**是否开启shiro*/
    private boolean enable;

    public boolean isEnable() {
        return enable;
    }

    /**
     * 是否开启shiro
     * @param enable 开启or不开启
     */
    public void setEnable(boolean enable) {
        this.enable = enable;
    }
}
