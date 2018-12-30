package cn.bootx.system.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;

/**
 * 项目配置
 * @author xxm
 * @date 2018/12/19 17:13
 * @version V1.0
 */
@EnableAutoConfiguration(exclude = {
        org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class
})
@ServletComponentScan
@EnableCaching
@Configuration
public class ApplicationConfig {
}
