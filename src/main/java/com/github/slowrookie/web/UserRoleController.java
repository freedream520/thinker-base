package com.github.slowrookie.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.slowrookie.persistence.entity.Role;
import com.github.slowrookie.persistence.entity.User;
import com.github.slowrookie.persistence.entity.UserRole;
import com.github.slowrookie.service.UserRoleService;

@RestController
public class UserRoleController {
	
	@Autowired
	private UserRoleService userRoleService;

	/**
	 * 根据主键id查询
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/userRole/{id}", method = RequestMethod.GET)
	@ResponseBody UserRole getEntity(@PathVariable("id") Long id) {
		return userRoleService.findOne(id);
	}
	
	/**
	 * 删除用户信息
	 * 
	 * @param id
	 */
	@RequestMapping(value = "/userRole/{id}", method = RequestMethod.DELETE)
	void remove(@PathVariable("id") Long id){
		userRoleService.delete(id);
	}
	
	/**
	 * 保存或者更新
	 * 
	 * @param userRole
	 * 		序列化的User对象
	 * @return User
	 * 		返回更新完成后的User
	 */
	@RequestMapping(value = "/userRoles", method = RequestMethod.PUT, produces = "application/json")
	@ResponseBody Long persist(@RequestBody UserRole userRole){
		return userRoleService.save(userRole).getId();
	}
	
	/**
	 * 批量插入
	 * 
	 * @param userRoles
	 * @return
	 */
	@RequestMapping(value = "/userRoles", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody List<UserRole> persistAll(@RequestBody List<UserRole> userRoles){
		return userRoleService.save(userRoles);
	}
	
	/**
	 * 查询所有
	 * 
	 * @param userRoles
	 * @return
	 */
	@RequestMapping(value = "/userRoles", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody List<UserRole> findAll(){
		return userRoleService.findAll(null);
	}
	
	/**
	 * 根据roleId查询User
	 * 
	 * @param roleId
	 * 		角色ID
	 * @return List<User>
	 */
	@RequestMapping(value = "/userRoles/users/{roleId}", method = RequestMethod.GET)
	@ResponseBody List<User> findUserByRoleId(@PathVariable Long roleId){
		List<User> users = userRoleService.findUserByRoleId(roleId);
		return users; 
	}
	
	/**
	 * 根据roleId查询User
	 * 
	 * @param userId
	 * 		用户ID
	 * @return List<Role>
	 */
	@RequestMapping(value = "/userRoles/roles/{userId}", method = RequestMethod.GET)
	@ResponseBody List<Role> findRoleByUserId(@PathVariable Long userId){
		return userRoleService.findRoleByUser(userId);
	}
	
}
