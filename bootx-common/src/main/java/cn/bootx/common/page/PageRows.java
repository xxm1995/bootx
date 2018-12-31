package cn.bootx.common.page;


import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 分页对象
 * @author xxm
 * @date 2018/12/30 12:42
 * @version V1.0
 */
@Data
public class PageRows implements Serializable {
	private static final long serialVersionUID = 1L;
	private long total;
	private long current;
	private List<?> rows;

	public PageRows(List<?> list, long total) {
		this.rows = list;
		this.total = total;
	}

	/**
	 * 传入 分页模型 对象,
	 * @param pageQuery 分页模型
	 */
	public PageRows(PageQuery pageQuery) {
		this.current = pageQuery.getCurrent();
		this.rows = pageQuery.getRecords();
		this.total = pageQuery.getTotal();
	}
}
