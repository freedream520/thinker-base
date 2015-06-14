package com.github.slowrookie.exception;

/**
 * 错误处理的返回信息
 * 
 * @author 刘佳兴
 */
public class ErrorInformation {

	//编码
	private Integer code;
	
	//错误信息
	private String message;

	public Integer getCode() {
		return code;
	}
	
	public ErrorInformation(Integer code, String message) {
		super();
		this.code = code;
		this.message = message;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
