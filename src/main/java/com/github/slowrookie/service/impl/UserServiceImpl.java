package com.github.slowrookie.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.github.slowrookie.persistence.AuditablePersistable;
import com.github.slowrookie.persistence.entity.User;
import com.github.slowrookie.repository.UserRepository;
import com.github.slowrookie.service.PageableService;

/**
 * 用户Service操作
 * 
 * @author 刘佳兴
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements PageableService<User> {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public User findOne(Long id){
		return userRepository.findOne(id);
	}
	
	@Override
	public List<User> findAll(Specification<User> entityQuery) {
		return userRepository.findAll(entityQuery);
	}
	
	@Override
	public Page<User> findAll(Specification<User> entityQuery, Pageable pageable) {
		return userRepository.findAll(entityQuery, pageable); 
	}

	@Override
	public User save(User entity) {
		User persistEntity = entity;
		if(!entity.isNew()){
			persistEntity = userRepository.findOne(entity.getId());
			BeanUtils.copyProperties(entity, persistEntity, AuditablePersistable.ignoreProperties);
		}
		return userRepository.save(entity);
	}
	
	@Override
	public List<User> save(Iterable<User> entities){
		List<User> result = new ArrayList<User>();
		
		for (User user : entities) {
			result.add(user);
			this.save(user);
		}
		
		return result;
	}
	
	@Override
	public void delete(Long id){
		userRepository.delete(id);
	}

	@Override
	public void detete(Iterable<User> entities) {
		userRepository.delete(entities);
	}
	
}
