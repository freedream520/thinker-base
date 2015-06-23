package com.github.slowrookie.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
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
	public UserRole save(UserRole entity){
		UserRole persistEntity = entity;
		if(!entity.isNew()){
			persistEntity = userRoleRepository.findOne(entity.getId());
			BeanUtils.copyProperties(entity, persistEntity);
		}
		return userRoleRepository.save(entity);
	}

	@Override
	public UserRole findOne(Long id) {
		return userRoleRepository.findOne(id);
	}

	@Override
	public List<UserRole> save(Iterable<UserRole> entities) {
		
		List<UserRole> result = new ArrayList<UserRole>();
		
		for (UserRole userRole : entities) {
			result.add(userRole);
			this.save(userRole);
		}
		
		return result;
		
	}

	@Override
	public void delete(Long id) {
		userRoleRepository.delete(id);
	}

	@Override
	public void detete(Iterable<UserRole> entities) {
		userRoleRepository.delete(entities);
	}

	@Override
	public List<UserRole> findAll(Specification<UserRole> entityQuery) {
		return userRoleRepository.findAll(entityQuery);
	}
	
}
