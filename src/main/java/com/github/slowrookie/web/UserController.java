package com.github.slowrookie.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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

	@RequestMapping(value = "/users", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody Page<User> findAll(@RequestParam(required = false) Map<String, String> rquestParamMap) {
		UserQuery userQuery = new UserQuery();
		int page = 0;
		int size = 0;
		PageRequest pageRequest = new PageRequest(page, size);
		
		return userService.findAll(userQuery, pageRequest);
	}
	
	
	@RequestMapping(value = "/users", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody User save(@RequestBody User user){
		return userService.save(user);
	}
	
}
