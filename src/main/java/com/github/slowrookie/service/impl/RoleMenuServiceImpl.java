package com.github.slowrookie.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.slowrookie.persistence.entity.Menu;
import com.github.slowrookie.persistence.entity.Role;
import com.github.slowrookie.persistence.entity.RoleMenu;
import com.github.slowrookie.repository.DefaultRepository;
import com.github.slowrookie.repository.RoleMenuRepository;
import com.github.slowrookie.service.RoleMenuService;

/**
 * 角色菜单服务
 * 
 * @author 刘佳兴
 */
@Service("RoleMenuService")
@Transactional
public class RoleMenuServiceImpl extends DefaultCrudServiceImpl<RoleMenu> implements RoleMenuService {
	
	@Autowired
	public RoleMenuServiceImpl(DefaultRepository<RoleMenu> roleMenuRepository) {
		super(roleMenuRepository);
	}

	@Override
	public List<Role> findRoleByMenuId(Long menuId) {
		return ((RoleMenuRepository)defaultRepository).findRoleByMenuId(menuId);
	}

	@Override
	public List<Menu> findMenuByRoleId(Long roleId) {
		return ((RoleMenuRepository)defaultRepository).findMenuByRoleId(roleId);
	}

	@Override
	public List<Menu> findMenyByUserId(Long userId) {
		return ((RoleMenuRepository)defaultRepository).findMenuByUserId(userId);
	}
	
	@Override
	public void deleteByRoleId(Long roleId) {
		((RoleMenuRepository)defaultRepository).deleteByRoleId(roleId);
	}

	@Override
	public List<RoleMenu> saveAll(List<RoleMenu> roleMenus) {
		//先删除
		Long id = roleMenus.get(0).getRole().getId();
		this.deleteByRoleId(id);
		//再插入
		return super.save(roleMenus);
	}
	
	
}
