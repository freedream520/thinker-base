package com.github.slowrookie.exception;

import org.springframework.data.mapping.PropertyReferenceException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 统一错误处理（收集中...）
 * 
 * @author 刘佳兴
 */
@ControllerAdvice
public class ExceptionHandlerAdvice {

	/**
	 * 找不参数的错误处理
	 * 
	 * @param e
	 * @return
	 */
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(PropertyReferenceException.class)
	@ResponseBody
	public String handleNoPropery(PropertyReferenceException e){
		return e.getMessage();
	}
	
}
