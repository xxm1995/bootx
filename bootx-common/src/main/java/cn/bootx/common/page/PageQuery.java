package cn.bootx.common.page;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.Arrays;
import java.util.Map;

/**
  * 分页模型，增加查询的条件
  * @author xxm  
  * @date 2018/11/1 16:27 
  * @version V1.0   
  */
public class PageQuery<T> extends Page<T> {
    /** 增加条件 */
    private Map query;
    public Map getQuery() {
        return query;
    }

    public void setQuery(Map query) {
        this.query = query;
    }

    @Override
    public String toString() {
        return "PagePuls{" +
                "query=" + query +
                ", current=" + getCurrent() +
                ", size=" + getSize() +
                ", total=" + getTotal() +
                ", ascs=" + Arrays.toString( super.ascs() ) +
                ", descs=" + Arrays.toString( super.descs() ) +
                '}';
    }
}
