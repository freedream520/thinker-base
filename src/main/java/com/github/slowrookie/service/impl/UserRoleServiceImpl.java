package com.github.slowrookie.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@Autowired
	public UserRoleServiceImpl(DefaultRepository<UserRole> userRoleRepository) {
		super(userRoleRepository);
	}

	@Override
	public List<User> findUserByRoleId(Long roleId){
		return ((UserRoleRepository)defaultRepository).findUserByRoleId(roleId);
	}
	
	@Override
	public List<Role> findRoleByUser(Long userId){
		return ((UserRoleRepository)defaultRepository).findRoleByUserId(userId);
	}
	
	@Override
	public void deleteByUserId(Long userId) {
		((UserRoleRepository)defaultRepository).deleteByUserId(userId);
	}

	@Override
	public List<UserRole> saveAll(List<UserRole> userRoles) {
	
		//先删除
		Long id = userRoles.get(0).getUser().getId();
		this.deleteByUserId(id);
		//再插入
		return super.save(userRoles);
		
	}
	
	
	
}
