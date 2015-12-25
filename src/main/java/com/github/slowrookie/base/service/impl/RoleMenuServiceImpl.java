package com.github.slowrookie.base.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import com.github.slowrookie.service.impl.DefaultCrudServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.slowrookie.base.persistence.entity.Menu;
import com.github.slowrookie.base.persistence.entity.Role;
import com.github.slowrookie.base.persistence.entity.RoleMenu;
import com.github.slowrookie.repository.DefaultRepository;
import com.github.slowrookie.base.repository.RoleMenuRepository;
import com.github.slowrookie.base.service.RoleMenuService;

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
	public List<Menu> findMenyByUserId(Long userId, Integer type) {
		return ((RoleMenuRepository)defaultRepository).findMenuByUserId(userId, type);
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
		if(null == roleMenus.get(0).getMenu().getId()){
			return new ArrayList<RoleMenu>();
		}
		//再插入
		return super.save(roleMenus);
	}
	
	
}
