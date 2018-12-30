package cn.bootx.common.page;

import lombok.ToString;
import org.springframework.cglib.beans.BeanMap;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 响应实体类
 * @author xxm
 * @date 2018/12/30 13:36
 * @version V1.0
 */
@ToString
@SuppressWarnings( "all" )
public final class R implements Serializable {
	private static final long serialVersionUID = 1L;
	private int code;
	private String msg;
	private Map<String,Object> data;
	/**
	 * 构造方法
	 * @param code 响应码
	 * @param msg 提示语
	 */
	private R(int code, String msg) {
		this.code = code;
		this.msg = msg;
		this.data = new LinkedHashMap<>(  );
	}

	/**
	 *	创建一个默认的成功响应
	 * @return R
	 */
	public static R OK() {
		return new R(200,"ok");
	}

	/**
	 *	创建一个默认的失败响应
	 * @return R
	 */
	public static R ERROR() {
		return new R(500,"error");
	}

	/**
	 * 设置响应码
	 * @param code
	 * @return R
	 */
	public R code(int code){
		this.code = code;
		return this;
	}

	/**
	 * 设置响应提示
	 * @param msg
	 * @return R
	 */
	public R msg(String msg){
		this.msg = msg;
		return this;
	}

	/**
	 * 添加一个响应体数据
	 * @param key
	 * @param value
	 * @return R
	 */
	public R put(String key,Object value){
		this.data.put( key,value );
		return this;
	}

	/**
	 * 把一个map集合追加响应体中
	 * 效果等同于map.putAll
	 * @param map 集合对象
	 * @return R
	 */
	public R putAll(Map map){
		if (map != null){
			this.data.putAll( map );
		}
		return this;
	}

	/**
	 * 把一个对象转换成map集合,然后追加响应体中
	 * @param object 对象
	 * @return R
	 */
	public R putObj(Object object){
		if (object!=null){
			//使用spring BeanMap
			BeanMap beanMap = BeanMap.create( object );
			this.data.putAll( beanMap );
		}
		return this;
	}

	/**
	 * 清除设置的data数据
	 * 效果等同于map.clear
	 * @return R
	 */
	public R clear(){
		this.data.clear();
		return this;
	}
}