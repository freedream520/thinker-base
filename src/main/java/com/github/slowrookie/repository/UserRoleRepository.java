package com.github.slowrookie.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.github.slowrookie.persistence.entity.Role;
import com.github.slowrookie.persistence.entity.User;
import com.github.slowrookie.persistence.entity.UserRole;

/**
 * 用户权限持久化接口
 * 
 * @author 刘佳兴
 */
public interface UserRoleRepository extends DefaultRepository<UserRole> {

	@Query("select u.user from UserRole u where u.role.id = ?1")
	public List<User> findUserByRoleId(Long roleId);
	
	@Query("select u.role from UserRole u where u.user.id = ?1")
	public List<Role> findRoleByUserId(Long userId);

	public void deleteByUserId(Long userId);
	
}
