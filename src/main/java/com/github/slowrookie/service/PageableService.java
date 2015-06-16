package com.github.slowrookie.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import com.github.slowrookie.persistence.IdentityPersistable;

/**
 * 面向接口编程，添加分页查询
 * 
 * @author 刘佳兴
 *
 * @param <T extends IdentityPersistable>
 */
public interface PageableService<T extends IdentityPersistable> extends CrudService<T> {

	/**
	 * 持久类对象的分页查询
	 * 
	 * @param entityQuery
	 * 		实现了 Specification<T> 借口的类
	 * @param pageable
	 * 		分页对象
	 * @return Page<T>
	 */
	public Page<T> findAll( Specification<T> entityQuery, Pageable pageable);
	
}
