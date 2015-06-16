package com.github.slowrookie.service;

import java.util.List;

import com.github.slowrookie.persistence.IdentityPersistable;

/**
 * 面向接口编程，规范基本的Crud接口
 * 
 * @author 刘佳兴
 */
public interface CrudService<T extends IdentityPersistable> {
	
	/**
	 * 根据id查找
	 * 
	 * @param id
	 * @return
	 */
	public T findOne(Long id);
	
	/**
	 * 持久化方法，包含更新和新增操作
	 * 
	 * @param AuditablePersistable
	 * 		保存信息
	 * @return User
	 * 		返回保存后的用户信息
	 */
	public T save(T auditable);
	
	/**
	 * 批量插入数据
	 * 
	 * @param entities
	 * @return
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
	
}
