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

import com.github.slowrookie.persistence.entity.User;
import com.github.slowrookie.persistence.entity.query.UserQuery;
import com.github.slowrookie.service.PageableService;

/**
 * 用户管理
 * 
 * @author 刘佳兴
 */
@RestController
public class UserController {

	@Autowired
	private PageableService<User> userService;
	
	/**
	 * 根据主键id查询
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
	@ResponseBody User findOne(@PathVariable("id") Long id) {
		User user = userService.findOne(id);
		return user;
	}
	
	/**
	 * 删除用户信息
	 * 
	 * @param id
	 */
	@RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
	void delete(@PathVariable("id") Long id){
		userService.delete(id);
	}
	
	/**
	 * 保存或者更新
	 * 
	 * @param user
	 * 		序列化的User对象
	 * @return User
	 * 		返回更新完成后的User
	 */
	@RequestMapping(value = "/users", method = RequestMethod.PUT, produces = "application/json")
	@ResponseBody User save(@RequestBody User user){
		return userService.save(user);
	}
	
	/**
	 * 批量插入
	 * 
	 * @param users
	 * @return
	 */
	@RequestMapping(value = "/users", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody List<User> saveAll(@RequestBody List<User> users){
		return userService.save(users);
	}
	
	/**
	 * 查询获取users支持全属性条件查询
	 * 
	 * @param userQuery
	 * 		用户查询对象，通过JSON传递
	 * @param pageParamater
	 * 		分页查询条件对象
	 * @return Page<User>
	 * 		返回分页数据
	 */
	@RequestMapping(value = "/users", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody Page<User> findAll(PageParamater pageParamater, UserQuery userQuery) {
		return userService.findAll(userQuery, pageParamater.getPageRequest());
	}
	
}
