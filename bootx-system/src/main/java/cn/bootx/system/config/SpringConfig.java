package cn.bootx.system.config;

import cn.bootx.system.handler.StringToDateConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.support.GenericConversionService;
import org.springframework.web.bind.support.ConfigurableWebBindingInitializer;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import javax.annotation.PostConstruct;

 /**   
  * spring 相关配置
  * @author xxm  
  * @date 2018/12/4 11:04 
  * @version V1.0   
  */
@Configuration
public class SpringConfig {
    @Autowired
    private RequestMappingHandlerAdapter handlerAdapter;
    /**
     * spring表单的时间转换器
     */
    @PostConstruct
    public void initEditableValidation(){
        ConfigurableWebBindingInitializer initializer=(ConfigurableWebBindingInitializer) handlerAdapter.getWebBindingInitializer();
        assert initializer != null;
        if (initializer.getConversionService()!=null){
            GenericConversionService genericConversionService=(GenericConversionService) initializer.getConversionService();
            genericConversionService.addConverter(new StringToDateConverter());
        }
    }
}
