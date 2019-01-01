package cn.bootx.security.shiro.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Configuration;

/**   
* shiro 自动配置类
* @author xxm  
* @date 2018/12/30 16:56 
* @version V1.0   
*/
//未自己设置shiro配置bean时生效
@ConditionalOnMissingBean(ShiroConfigSupport.class)
@Configuration
public class ShiroAutoConfig extends ShiroDefaultConfig {

}
