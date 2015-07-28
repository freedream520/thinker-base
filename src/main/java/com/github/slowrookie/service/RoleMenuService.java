package com.github.slowrookie.service;

import java.util.List;

import com.github.slowrookie.persistence.entity.Menu;
import com.github.slowrookie.persistence.entity.Role;
import com.github.slowrookie.persistence.entity.RoleMenu;

/**
 * 角色菜单接口扩展
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
	
	/**
	 * 根据用户查询用户拥有的菜单
	 * 
	 * @param userId
	 * @return
	 */
	public List<Menu> findMenyByUserId(Long userId);
	
	/**
	 * 保存方法，需要先删除再插入
	 * 
	 * @param entities
	 * @return
	 */
	public List<RoleMenu> saveAll(List<RoleMenu> roleMenus);
	
	/**
	 * 根据roleId删除
	 * 
	 * @param roleId
	 */
	public void deleteByRoleId(Long roleId);
	
}
