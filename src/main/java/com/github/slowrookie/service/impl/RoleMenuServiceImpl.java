package com.github.slowrookie.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.github.slowrookie.persistence.entity.Menu;
import com.github.slowrookie.persistence.entity.Role;
import com.github.slowrookie.persistence.entity.RoleMenu;
import com.github.slowrookie.repository.DefaultRepository;
import com.github.slowrookie.repository.RoleMenuRepository;
import com.github.slowrookie.service.RoleMenuService;

@Service("RoleMenuService")
@Transactional
public class RoleMenuServiceImpl extends DefaultCrudServiceImpl<RoleMenu> implements RoleMenuService {
	
	@Override
	public List<Role> findRoleByMenuId(Long menuId) {
		return ((RoleMenuRepository)defaultRepository).findRoleByMenuId(menuId);
	}

	@Override
	public List<Menu> findMenuByRoleId(Long roleId) {
		return ((RoleMenuRepository)defaultRepository).findMenuByRoleId(roleId);
	}

	@Override
	@Autowired
	@Qualifier(value = "roleMenuRepository")
	public void setDefaultRepository(DefaultRepository<RoleMenu> roleMenuRepository) {
		this.defaultRepository = roleMenuRepository;
	}
	
}
