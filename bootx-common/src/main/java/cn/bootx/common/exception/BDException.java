package cn.bootx.common.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * 自定义异常
 */
@Getter
@Setter
public class BDException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
    private String msg;
    private int code = 500;
    
    public BDException(String msg) {
		super(msg);
		this.msg = msg;
	}
	
	public BDException(String msg, Throwable e) {
		super(msg, e);
		this.msg = msg;
	}
	
	public BDException(String msg, int code) {
		super(msg);
		this.msg = msg;
		this.code = code;
	}
	
	public BDException(String msg, int code, Throwable e) {
		super(msg, e);
		this.msg = msg;
		this.code = code;
	}
}
