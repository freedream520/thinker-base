package com.github.slowrookie.base.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.slowrookie.helper.TreeHelper;
import com.github.slowrookie.base.persistence.entity.Menu;
import com.github.slowrookie.base.persistence.entity.Role;
import com.github.slowrookie.base.persistence.entity.RoleMenu;
import com.github.slowrookie.base.service.RoleMenuService;

import javax.servlet.http.HttpServletRequest;

/**
 * 角色菜单管理
 * 
 * @author 刘佳兴
 */
@RestController
public class RoleMenuController {
	
	@Autowired
	private RoleMenuService roleMenuService;

	/**
	 * 根据主键id查询
	 * 
	 * @param id 唯一ID
	 * @return RoleMenu
	 */
	@RequestMapping(value = "/roleMenu/{id}", method = RequestMethod.GET)
	@ResponseBody RoleMenu findOne(@PathVariable("id") Long id) {
		return roleMenuService.findOne(id);
	}
	
	/**
	 * 删除权限关联信息
	 * 
	 * @param id 唯一ID
	 */
	@RequestMapping(value = "/roleMenu/{id}", method = RequestMethod.DELETE)
	void delete(@PathVariable("id") Long id){
		roleMenuService.delete(id);
	}
	
	/**
	 * 保存或者更新
	 * 
	 * @param RoleMenu
	 * 		序列化的User对象
	 * @return RoleMenu
	 * 		返回更新完成后的RoleMenu
	 */
	@RequestMapping(value = "/roleMenus", method = RequestMethod.PUT, produces = "application/json")
	@ResponseBody RoleMenu save(HttpServletRequest request, @RequestBody RoleMenu RoleMenu){
		return roleMenuService.save(RoleMenu);
	}
	
	/**
	 * 批量插入
	 * 
	 * @param RoleMenus 列表信息
	 * @return 列表信息
	 */
	@RequestMapping(value = "/roleMenus", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody List<RoleMenu> saveAll(@RequestBody List<RoleMenu> RoleMenus){
		return roleMenuService.saveAll(RoleMenus);
	}
	
	/**
	 * 查询所有
	 *
	 * @return 列表信息
	 */
	@RequestMapping(value = "/roleMenus", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody List<RoleMenu> findAll(){
		return roleMenuService.findAll();
	}
	
	/**
	 * 根据roleId查询Menu
	 * 
	 * @param roleId
	 * 		角色ID
	 * @return List<User>
	 */
	@RequestMapping(value = "/roleMenus/role/{roleId}", method = RequestMethod.GET)
	@ResponseBody List<Menu> findMenuByRoleId(@PathVariable Long roleId){
		return roleMenuService.findMenuByRoleId(roleId);
	}
	
	/**
	 * 根据menuId查询Role
	 * 
	 * @param menuId
	 * 		菜单ID
	 * @return List<Role>
	 */
	@RequestMapping(value = "/roleMenus/menu/{menuId}", method = RequestMethod.GET)
	@ResponseBody List<Role> findRoleByMenuId(@PathVariable Long menuId){
		return roleMenuService.findRoleByMenuId(menuId);
	}
	

	/**
	 * 根据userId查询{@link Menu}
	 * 
	 * @param userId
	 * 		用户ID
	 * @return List<Menu>
	 */
	@RequestMapping(value = "/roleMenus/user/{userId}", method = RequestMethod.GET)
	@ResponseBody List<Menu> findMenuByUserId(@PathVariable Long userId, Integer type){
		if(type == null) type = 0;
		return roleMenuService.findMenyByUserId(userId, type);
	}
	
	/**
	 * 根据用户查询{@link Menu}树
	 * 
	 * @param userId
	 * 		用户ID
	 * @return List<Menu>
	 */
	@RequestMapping(value = "/roleMenus/tree/user/{userId}", method = RequestMethod.GET)
	@ResponseBody Menu findMenuTreeByUserId(@PathVariable Long userId, Integer type){
		if(type == null) type = 0;
		List<Menu> menus = roleMenuService.findMenyByUserId(userId, type);
		TreeHelper<Menu> helper = new TreeHelper<>(menus);
		return helper.generateTee();
	}
	
}
