package com.github.slowrookie.service;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import com.github.slowrookie.persistence.IdentityPersistable;

/**
 * 面向接口编程，规范基本的Crud接口
 * 所有实体类通过接口规范需要实现的接口，每个实体都应至少提供CrudService的相关服务
 * 
 * @author 刘佳兴
 */
public interface CrudService<T extends IdentityPersistable> {
	
	/**
	 * 根据id查找
	 * 
	 * @param id
	 * @return T
	 */
	public T findOne(Long id);
	
	/**
	 * 持久化方法，包含更新和新增操作
	 * 
	 * @param AuditablePersistable
	 * 		保存信息
	 * @return T
	 * 		返回保存后的用户信息
	 */
	public T save(T auditable);
	
	/**
	 * 批量插入数据
	 * 
	 * @param entities
	 * @return List<T>
	 */
	public List<T> save(Iterable<T> entities);
	
	/**
	 * 删除用户数据
	 * 
	 * @param id
	 * 		用户的主键id
	 */
	public void delete(Long id);
	
	/**
	 * 批量删除
	 * 
	 * @param entities
	 */
	public void detete(Iterable<T> entities);
	
	/**
	 * 根据查询条件查询所有
	 * 
	 * @param entityQuery
	 * @return
	 */
	public List<T> findAll(Specification<T> entityQuery);
	
}
