package com.github.slowrookie.base.service;

import java.util.List;

import com.github.slowrookie.base.persistence.entity.Menu;
import com.github.slowrookie.base.persistence.entity.Role;
import com.github.slowrookie.base.persistence.entity.RoleMenu;
import com.github.slowrookie.service.DefaultCrudService;

/**
 * 角色菜单接口扩展
 * 
 * @author 刘佳兴
 */
public interface RoleMenuService extends DefaultCrudService<RoleMenu> {

	/**
	 * 根据菜单查权限
	 * 
	 * @param menuId menu id
	 * @return List<Role> {@link Role}
	 */
	public List<Role> findRoleByMenuId(Long menuId);
	
	/**
	 * 根据权限查菜单
	 * 
	 * @param roleId role id
	 * @return List<Menu> {@link Menu}
	 */
	public List<Menu> findMenuByRoleId(Long roleId);
	
	/**
	 * 根据用户查询用户拥有的菜单
	 * 
	 * @param userId user id
	 * @return List of Menu
	 */
	public List<Menu> findMenyByUserId(Long userId, Integer type);
	
	/**
	 * 保存方法，需要先删除再插入
	 * 
	 * @param roleMenus role menu
	 * @return List of Menu
	 */
	public List<RoleMenu> saveAll(List<RoleMenu> roleMenus);
	
	/**
	 * 根据roleId删除
	 * 
	 * @param roleId role id
	 */
	public void deleteByRoleId(Long roleId);
	
}
