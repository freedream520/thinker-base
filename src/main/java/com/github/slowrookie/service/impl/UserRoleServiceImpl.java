package com.github.slowrookie.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.github.slowrookie.persistence.entity.Role;
import com.github.slowrookie.persistence.entity.User;
import com.github.slowrookie.persistence.entity.UserRole;
import com.github.slowrookie.repository.DefaultRepository;
import com.github.slowrookie.repository.UserRoleRepository;
import com.github.slowrookie.service.UserRoleService;

/**
 * 用户权限服务
 * 
 * @author 刘佳兴
 */
@Service("userRoleService")
@Transactional
public class UserRoleServiceImpl extends DefaultCrudServiceImpl<UserRole> implements UserRoleService {
	
	@Override
	public List<User> findUserByRoleId(Long roleId){
		return ((UserRoleRepository)defaultRepository).findUserByRoleId(roleId);
	}
	
	@Override
	public List<Role> findRoleByUser(Long userId){
		return ((UserRoleRepository)defaultRepository).findRoleByUserId(userId);
	}
	
	@Override
	@Autowired
	@Qualifier(value = "userRoleRepository")
	public void setDefaultRepository(DefaultRepository<UserRole> userRoleRepository) {
		this.defaultRepository = userRoleRepository;
	}

	
}
