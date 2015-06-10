package com.github.slowrookie.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.github.slowrookie.entity.User;
import com.github.slowrookie.entity.query.UserQuery;
import com.github.slowrookie.repository.UserRepository;

@Service
@Transactional
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	public Page<User> findAll(UserQuery userQuery, Pageable pageable) {
		return userRepository.findAll(userQuery, pageable); 
	}
	
	public User save(User user) {
		return userRepository.save(user);
	}
}
