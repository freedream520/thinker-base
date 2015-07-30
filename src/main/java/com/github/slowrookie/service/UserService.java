package com.github.slowrookie.service;

import com.github.slowrookie.persistence.entity.User;

/**
 * 用户接口扩展
 * 
 * @author 刘佳兴
 */
public interface UserService extends DefaultCrudService<User> {

	public User checkPassword(String loginName, String password);
	
}
