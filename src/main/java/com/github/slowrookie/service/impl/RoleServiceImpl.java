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
	
	public Role save(Role entity) {
		Role persistEntity = entity;
		if(!entity.isNew()){
			persistEntity = roleRepository.findOne(entity.getId());
			BeanUtils.copyProperties(entity, persistEntity, AuditablePersistable.ignoreProperties);
		}
		return roleRepository.save(entity);
	}
	
	@Override
	public void delete(Long id){
		roleRepository.delete(id);
	}

	@Override
	public List<Role> save(Iterable<Role> entities) {
		List<Role> result = new ArrayList<Role>();
		
		for (Role role : entities) {
			result.add(role);
			this.save(role);
		}
		
		return result;
	}

	@Override
	public Page<Role> findAll(Specification<Role> entityQuery, Pageable pageable) {
		return roleRepository.findAll(entityQuery, pageable); 
	}

	@Override
	public void detete(Iterable<Role> entities) {
		roleRepository.delete(entities);
	}

	@Override
	public List<Role> findAll(Specification<Role> entityQuery) {
		return roleRepository.findAll(entityQuery);
	}
	
}
