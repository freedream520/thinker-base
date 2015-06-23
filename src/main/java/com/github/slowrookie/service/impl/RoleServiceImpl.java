package com.github.slowrookie.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.github.slowrookie.persistence.entity.Role;
import com.github.slowrookie.repository.DefaultRepository;

/**
 * 权限Service操作
 * 
 * @author 刘佳兴
 */
@Service("roleService")
@Transactional
public class RoleServiceImpl extends DefaultCrudServiceImpl<Role> {
	
	@Override
	@Autowired
	@Qualifier(value = "roleRepository")
	public void setDefaultRepository(DefaultRepository<Role> roleRepository) {
		this.defaultRepository = roleRepository;
	}
	
}
