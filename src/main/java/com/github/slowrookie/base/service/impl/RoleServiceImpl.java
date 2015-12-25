package com.github.slowrookie.base.service.impl;

import javax.transaction.Transactional;

import com.github.slowrookie.service.impl.DefaultCrudServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.slowrookie.base.persistence.entity.Role;
import com.github.slowrookie.repository.DefaultRepository;

/**
 * 权限服务
 * 
 * @author 刘佳兴
 */
@Service("roleService")
@Transactional
public class RoleServiceImpl extends DefaultCrudServiceImpl<Role> {
	
	@Autowired
	public RoleServiceImpl(DefaultRepository<Role> roleRepository) {
		super(roleRepository);
	}

}
