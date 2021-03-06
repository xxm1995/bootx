package cn.bootx.system.handler;

import cn.bootx.common.domain.UserDO;
import cn.bootx.security.utils.SecurityUtils;
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
        UserDO user = null;
        try {
            user = SecurityUtils.getUser();
        } catch (Exception e) {
            logger.warn( "未取到当前用户",e );
        }
        String userId = user!=null?user.getId():null;
        // 创建时自动填充
        this.setFieldValByName("createDate", date, metaObject);
        this.setFieldValByName("createBy", userId, metaObject);
        this.setFieldValByName("updateDate", date, metaObject);
        this.setFieldValByName("updateBy", userId, metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        Date date = new Date(  );
        UserDO user = null;
        try {
            user = SecurityUtils.getUser();
        } catch (Exception e) {
            logger.warn( "未取到当前用户",e );
        }
        String userId = user!=null?user.getId():null;
        // 更新时自动填充
        this.setFieldValByName("updateDate", date, metaObject);
        this.setFieldValByName("updateBy", userId, metaObject);
    }
}
