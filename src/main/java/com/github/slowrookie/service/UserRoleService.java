package com.github.slowrookie.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.slowrookie.persistence.entity.Role;
import com.github.slowrookie.persistence.entity.User;
import com.github.slowrookie.persistence.entity.UserRole;
import com.github.slowrookie.repository.UserRoleRepository;

@Service
@Transactional
public class UserRoleService {

	@Autowired
	private UserRoleRepository userRoleRepository;
	
	public List<User> findUserByRoleId(Long roleId){
		return userRoleRepository.findUserByRoleId(roleId);
	}
	
	public List<Role> getRoleByUser(Long userId){
		return userRoleRepository.findRoleByUserId(userId);
	}
	
	public UserRole save(UserRole userRole){
		return userRoleRepository.save(userRole);
	}
	
	public void save(List<UserRole> userRoles){
		
	}
	
}
