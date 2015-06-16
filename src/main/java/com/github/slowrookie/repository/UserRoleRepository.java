package com.github.slowrookie.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.github.slowrookie.persistence.entity.Role;
import com.github.slowrookie.persistence.entity.User;
import com.github.slowrookie.persistence.entity.UserRole;


public interface UserRoleRepository extends JpaRepository<UserRole, Long>, JpaSpecificationExecutor<UserRole> {

	public List<User> findUserByRoleId(Long roleId);
	
	public List<Role> findRoleByUserId(Long userId);
	
}
