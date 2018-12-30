package common.page;


import java.io.Serializable;
import java.util.List;

 /**   
  * 分页对象
  * @author xxm  
  * @date 2018/12/30 12:42
  * @version V1.0   
  */
public class PageRows implements Serializable {
	private static final long serialVersionUID = 1L;
	private long total;
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
		this.rows = pageQuery.getRecords();
		this.total = pageQuery.getTotal();
	}
	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public List<?> getRows() {
		return rows;
	}

	public void setRows(List<?> rows) {
		this.rows = rows;
	}

}
