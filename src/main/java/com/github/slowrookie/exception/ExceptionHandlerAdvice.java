package com.github.slowrookie.exception;

import java.util.Set;

import javax.persistence.EntityNotFoundException;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.mapping.PropertyReferenceException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 统一错误处理（收集中...）
 * 在日志中打印错误信息，以便于日志分析
 * 根据错误类型确定返回的具体提示信息
 * 
 * @author 刘佳兴
 */
@ControllerAdvice
public class ExceptionHandlerAdvice {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	/**
	 * 参数的错误处理
	 * 
	 * @param e
	 * 		PropertyReferenceException
	 * @return {@link ErrorInformation}
	 */
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(PropertyReferenceException.class)
	@ResponseBody ErrorInformation handleNoPropery(PropertyReferenceException e){
		logger.error("handleNoPropery", e);
		return new ErrorInformation(HttpStatus.NOT_FOUND.value(), e.getMessage());
	}
	
	/**
	 * hibernate字段校验信息
	 * 
	 * @param e
	 * 		ConstraintViolationException
	 * @return {@link ErrorInformation}
	 */
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(ConstraintViolationException.class)
	@ResponseBody ErrorInformation handleHibernateValdation(ConstraintViolationException e){
		logger.error("handleHibernateValdation", e);
		Set<ConstraintViolation<?>> constraintViolations = e.getConstraintViolations();
		String message = "";
		for (ConstraintViolation<?> constraintViolation : constraintViolations) {
			message += constraintViolation.getPropertyPath() + constraintViolation.getMessage() + "; ";
		}
		return new ErrorInformation(HttpStatus.NOT_FOUND.value(), message);
	}
	
	/**
	 * 唯一主键
	 * 
	 * @param e
	 * 		DataIntegrityViolationException
	 * @return {@link ErrorInformation}
	 */
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(DataIntegrityViolationException.class)
	@ResponseBody ErrorInformation handleDataIntegrityViolation(DataIntegrityViolationException e){
		logger.error("handleDataIntegrityViolation", e);
		return new ErrorInformation(HttpStatus.NOT_FOUND.value(), e.getMessage());
	}
	
	/**
	 * 返回值为空
	 * 
	 * @param e
	 * 		EntityNotFoundException
	 * @return {@link ErrorInformation}
	 */
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(EntityNotFoundException.class)
	@ResponseBody ErrorInformation handleEntityNotFound(EntityNotFoundException e){
		logger.error("handleEntityNotFound", e);
		return new ErrorInformation(HttpStatus.NOT_FOUND.value(), e.getMessage());
	}
	
	
}
