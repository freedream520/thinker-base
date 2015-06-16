package com.github.slowrookie.interceptor;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.github.slowrookie.persistence.AuditablePersistable;

/**
 * 使用AOP
 * 
 * @author 刘佳兴
 */
@Aspect
@Component
public class AuditableInterceptor {
	
	/**
	 * 在调用*Service类中的*persist判断是否填充公共方法
	 * 
	 * @param joinPoint
	 * 		切入点对象
	 */
	@Before("execution(* com..*Service.*save*(..))")
	public void beforeSave(JoinPoint joinPoint) {
		if(null != joinPoint.getArgs()){
			setAuditables(Arrays.asList(joinPoint.getArgs()));
		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void setAuditables(Collection<Object> elements){
		for (Object element : elements) {
			setAuditable(element);
			if(element instanceof Iterable){
				setAuditables((Collection)element);
			}
		}
	}
	
	private void setAuditable(Object entity){
		if(entity instanceof AuditablePersistable && ((AuditablePersistable) entity).isNew()){
			((AuditablePersistable) entity).setCreatedBy(1L);
			((AuditablePersistable) entity).setLastModifiedBy(1L);
			((AuditablePersistable) entity).setCreatedDate(new Date());
			((AuditablePersistable) entity).setLastModifiedDate(new Date());
		}
	}
	
}
