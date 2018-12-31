package cn.bootx.common.page;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;

import java.util.Map;

/**
  * 分页模型，增加查询的条件
  * @author xxm  
  * @date 2018/11/1 16:27 
  * @version V1.0   
  */
@Data
public class PageQuery<T> extends Page<T> {
    /** 增加条件 */
    private Map query;
}
