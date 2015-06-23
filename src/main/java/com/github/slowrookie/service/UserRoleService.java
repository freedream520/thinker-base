package com.github.slowrookie.service;

import java.util.List;

import com.github.slowrookie.persistence.entity.Role;
import com.github.slowrookie.persistence.entity.User;
import com.github.slowrookie.persistence.entity.UserRole;

/**
 * 用户角色方法扩展 
 * 
 * @author 刘佳兴
 */
public interface UserRoleService extends DefaultCrudService<UserRole> {

	/**
	 * 根据权限查组织
	 * 
	 * @param roleId
	 * @return List<User> {@link User}
	 */
	public List<User> findUserByRoleId(Long roleId);
	
	/**
	 * 根据用户查权限
	 * 
	 * @param userId
	 * @return List<Role> {@link Role}
	 */
	public List<Role> findRoleByUser(Long userId);
	
	
}
