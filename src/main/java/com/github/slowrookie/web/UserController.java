package com.github.slowrookie.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.slowrookie.common.QueryParameterUtils;
import com.github.slowrookie.entity.User;
import com.github.slowrookie.entity.query.UserQuery;
import com.github.slowrookie.service.UserService;

/**
 * 用户管理
 * 
 * @author 刘佳兴
 */
@RestController
public class UserController {

	@Autowired
	private UserService userService;

	/**
	 * 查询获取users支持全属性条件查询
	 * 
	 * @param userQuery
	 * 		用户查询对象，通过JSON传递
	 * @param page
	 * 		第几页
	 * @param size
	 * 		每页数据量
	 * @param order
	 * 		排序
	 * @return Page<User>
	 * 		返回分页数据
	 */
	@RequestMapping(value = "/users", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody 
	public Page<User> findAll(@RequestParam(required = false) Map<String, String> params) {
		//获取分页信息
		Pageable pageable = QueryParameterUtils.getPageable(params);
		//填充查询对象
		UserQuery userQuery = new UserQuery();
		QueryParameterUtils.getSpecification(params, userQuery);
		
		return userService.findAll(userQuery, pageable);
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
	@ResponseBody 
	public User persist(@RequestBody User user){
		return userService.persist(user);
	}
	
	
}
