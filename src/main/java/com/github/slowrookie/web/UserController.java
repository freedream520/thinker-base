package com.github.slowrookie.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.slowrookie.entity.User;
import com.github.slowrookie.entity.query.UserQuery;
import com.github.slowrookie.service.UserService;

/**
 * 用户管理
 * @author liujiaxingemail@gmail.com
 *
 */
@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/users", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody Page<User> findAll(@RequestBody(required = false) UserQuery userQuery, @RequestParam(required = false) Integer page,
			@RequestParam(required = false) Integer size, @RequestParam(required = false) String order) {
		if(page == null) page = 0;
		if(size == null) size = 1000;
		Sort sort = new Sort(order.split(",")); 
		PageRequest pageRequest = new PageRequest(page, size, sort);
		return userService.findAll(userQuery, pageRequest);
	}
	
	
	@RequestMapping(value = "/user", method = RequestMethod.PUT, produces = "application/json")
	@ResponseBody User save(@RequestBody User user){
		return userService.save(user);
	}
	
}
