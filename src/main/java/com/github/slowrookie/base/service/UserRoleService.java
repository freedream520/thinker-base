package com.github.slowrookie.base.service;

import java.util.List;

import com.github.slowrookie.base.persistence.entity.Role;
import com.github.slowrookie.base.persistence.entity.User;
import com.github.slowrookie.base.persistence.entity.UserRole;
import com.github.slowrookie.service.DefaultCrudService;

/**
 * 用户角色接口扩展 
 * 
 * @author 刘佳兴
 */
public interface UserRoleService extends DefaultCrudService<UserRole> {

	/**
	 * 根据权限查组织
	 * 
	 * @param roleId role id
	 * @return List<User> {@link User}
	 */
	public List<User> findUserByRoleId(Long roleId);
	
	/**
	 * 根据用户查权限
	 * 
	 * @param userId user id
	 * @return List<Role> {@link Role}
	 */
	public List<Role> findRoleByUser(Long userId);

	/**
	 * 先删后插
	 * 
	 * @param userRoles user and role
	 * @return List of User and Role
	 */
	public List<UserRole> saveAll(List<UserRole> userRoles);
	
	/**
	 * 根据userId删除
	 * 
	 * @param userId user id
	 */
	public void deleteByUserId(Long userId);
	
	
}
