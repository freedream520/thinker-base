package com.github.slowrookie.service;

import java.util.List;

import com.github.slowrookie.persistence.entity.Menu;
import com.github.slowrookie.persistence.entity.Role;
import com.github.slowrookie.persistence.entity.RoleMenu;

/**
 * 角色菜单扩展方法
 * 
 * @author 刘佳兴
 */
public interface RoleMenuService extends DefaultCrudService<RoleMenu> {

	/**
	 * 根据菜单查权限
	 * 
	 * @param menuId
	 * @return List<Role> {@link Role}
	 */
	public List<Role> findRoleByMenuId(Long menuId);
	
	/**
	 * 根据权限查菜单
	 * 
	 * @param roleId
	 * @return List<Menu> {@link Menu}
	 */
	public List<Menu> findMenuByRoleId(Long roleId);
	
	
}
