package com.github.slowrookie.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.slowrookie.persistence.entity.User;
import com.github.slowrookie.repository.DefaultRepository;
import com.github.slowrookie.repository.UserRepository;
import com.github.slowrookie.service.UserService;

/**
 * 用户服务
 * 
 * @author 刘佳兴
 */
@Service("userService")
@Transactional
public class UserServiceImpl extends DefaultCrudServiceImpl<User> implements UserService {
	
	@Autowired
	public UserServiceImpl(DefaultRepository<User> userRepository) {
		super(userRepository);
	}

	@Override
	public User findByLoginName(String loginName) {
		User user = ((UserRepository)this.defaultRepository).findByLoginName(loginName);
		return user;
	}
	
	

}
