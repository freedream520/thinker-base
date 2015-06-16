package com.github.slowrookie.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.slowrookie.persistence.entity.Role;
import com.github.slowrookie.persistence.entity.User;
import com.github.slowrookie.persistence.entity.UserRole;
import com.github.slowrookie.repository.UserRoleRepository;
import com.github.slowrookie.service.UserRoleService;

@Service("userRoleService")
@Transactional
public class UserRoleServiceImpl implements UserRoleService {

	@Autowired
	private UserRoleRepository userRoleRepository;
	
	@Override
	public List<User> findUserByRoleId(Long roleId){
		return userRoleRepository.findUserByRoleId(roleId);
	}
	
	@Override
	public List<Role> findRoleByUser(Long userId){
		return userRoleRepository.findRoleByUserId(userId);
	}
	
	@Override
	public UserRole save(UserRole userRole){
		return userRoleRepository.save(userRole);
	}

	@Override
	public UserRole findOne(Long id) {
		return userRoleRepository.findOne(id);
	}

	@Override
	public List<UserRole> save(Iterable<UserRole> entities) {
		return userRoleRepository.save(entities);
	}

	@Override
	public void delete(Long id) {
		userRoleRepository.delete(id);
	}

	@Override
	public void detete(Iterable<UserRole> entities) {
		userRoleRepository.delete(entities);
	}
	
}
