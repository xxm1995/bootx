package cn.bootx.system.handler;

import cn.bootx.common.domain.UserDO;
import cn.bootx.security.shiro.utils.ShiroUtils;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
  * 表属性默认注入处理器
  * @author xxm  
  * @date 2018/11/5 15:07 
  * @version V1.0   
  */
@Component
public class TableFieldHandler implements MetaObjectHandler {
    private static final  Logger logger = LoggerFactory.getLogger( TableFieldHandler.class );
    @Override
    public void insertFill(MetaObject metaObject) {
        Date date = new Date(  );
        UserDO user = ShiroUtils.getUser();
        String updateBy = user!=null?user.getName():"";
        Long updateById = user!=null?user.getUserId():-1;

        this.setFieldValByName("userIdCreate", updateById, metaObject);
        this.setFieldValByName("gmtCreate", date, metaObject);
        this.setFieldValByName("gmtModified", date, metaObject);

        this.setFieldValByName("createDate", date, metaObject);
        this.setFieldValByName("createBy", updateBy, metaObject);
        this.setFieldValByName("updateDate", date, metaObject);
        this.setFieldValByName("updateBy", updateBy, metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        Date date = new Date(  );
        UserDO user = ShiroUtils.getUser();
        String updateBy = user!=null?user.getName():"";
        this.setFieldValByName("gmtModified", date, metaObject);

        this.setFieldValByName("updateDate", date, metaObject);
        this.setFieldValByName("updateBy", updateBy, metaObject);
    }
}
