package com.github.slowrookie.base.service;

import com.github.slowrookie.base.persistence.entity.User;
import com.github.slowrookie.service.DefaultCrudService;

/**
 * 用户接口扩展
 * 
 * @author 刘佳兴
 */
public interface UserService extends DefaultCrudService<User> {

	public User findByLoginName(String loginName);
	
}
