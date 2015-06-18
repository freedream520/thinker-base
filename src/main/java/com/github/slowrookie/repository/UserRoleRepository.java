package com.github.slowrookie.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.github.slowrookie.persistence.entity.Role;
import com.github.slowrookie.persistence.entity.User;
import com.github.slowrookie.persistence.entity.UserRole;


public interface UserRoleRepository extends JpaRepository<UserRole, Long>, JpaSpecificationExecutor<UserRole> {

	@Query("select u.user from UserRole u where u.role.id = ?1")
	public List<User> findUserByRoleId(Long roleId);
	
	@Query("select u.role from UserRole u where u.user.id = ?1")
	public List<Role> findRoleByUserId(Long userId);
	
}
