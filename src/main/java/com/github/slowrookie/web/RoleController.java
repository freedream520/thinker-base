package com.github.slowrookie.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.slowrookie.persistence.entity.Role;
import com.github.slowrookie.persistence.entity.query.RoleQuery;
import com.github.slowrookie.service.PageableService;

/**
 * 权限管理
 * 
 * @author 刘佳兴
 */

@RestController
public class RoleController {
	
	@Autowired
	private PageableService<Role> roleService;

	/**
	 * 根据主键id查询
	 * 
	 * @param id
	 * @return {@link Role}
	 */
	@RequestMapping(value = "/role/{id}", method = RequestMethod.GET)
	@ResponseBody Role findOne(@PathVariable("id") Long id) {
		return roleService.findOne(id);
	}
	
	/**
	 * 删除用户信息
	 * 
	 * @param id
	 */
	@RequestMapping(value = "/role/{id}", method = RequestMethod.DELETE)
	@ResponseBody void delete(@PathVariable("id") Long id){
		roleService.delete(id);
	}
	
	/**
	 * 保存或者更新
	 * 
	 * @param role
	 * 		序列化的User对象
	 * @return User
	 * 		返回更新完成后的role {@link Role}
	 */
	@RequestMapping(value = "/roles", method = RequestMethod.PUT, produces = "application/json")
	@ResponseBody Role save(@RequestBody Role role){
		return roleService.save(role);
	}
	
	/**
	 * 批量插入
	 * 
	 * @param roles List<Role>
	 * @return List<Role> {@link Role}
	 */
	@RequestMapping(value = "/roles", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody List<Role> saveAll(@RequestBody List<Role> roles){
		return roleService.save(roles);
	}

	/**
	 * 查询获取users支持全属性条件查询
	 * 
	 * @param roleQuery
	 * 		用户查询对象，通过JSON传递
	 * @param pageParamater
	 * 		分页查询条件对象
	 * @return Page<Role> {@link Role}
	 * 		返回分页数据
	 */
	@RequestMapping(value = "/roles", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody public Page<Role> findAll(PageParamater pageParamater, RoleQuery roleQuery) {
		return roleService.findAll(roleQuery, pageParamater.getPageRequest());
	}

	
}
