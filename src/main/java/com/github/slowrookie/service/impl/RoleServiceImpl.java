package com.github.slowrookie.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.github.slowrookie.persistence.entity.Role;
import com.github.slowrookie.repository.RoleRepository;
import com.github.slowrookie.service.PageableService;

/**
 * 权限Service操作
 * 
 * @author 刘佳兴
 */
@Service("roleService")
@Transactional
public class RoleServiceImpl implements PageableService<Role> {
	
	@Autowired
	private RoleRepository roleRepository;

	@Override
	public Role findOne(Long id){
		return roleRepository.findOne(id);
	}
	
	public Role save(Role role) {
		return roleRepository.save(role);
	}
	
	@Override
	public void delete(Long id){
		roleRepository.delete(id);
	}

	@Override
	public List<Role> save(Iterable<Role> entities) {
		return roleRepository.save(entities);
	}

	@Override
	public Page<Role> findAll(Specification<Role> entityQuery, Pageable pageable) {
		return roleRepository.findAll(entityQuery, pageable); 
	}

	@Override
	public void detete(Iterable<Role> entities) {
		roleRepository.delete(entities);
	}
	
}
