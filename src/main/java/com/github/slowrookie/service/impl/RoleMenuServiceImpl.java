package com.github.slowrookie.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.github.slowrookie.persistence.entity.Menu;
import com.github.slowrookie.persistence.entity.Role;
import com.github.slowrookie.persistence.entity.RoleMenu;
import com.github.slowrookie.repository.RoleMenuRepository;
import com.github.slowrookie.service.RoleMenuService;

@Service("RoleMenuService")
@Transactional
public class RoleMenuServiceImpl implements RoleMenuService {

	@Autowired
	private RoleMenuRepository roleMenuRepository;
	

	@Override
	public List<Role> findRoleByMenuId(Long menuId) {
		return roleMenuRepository.findRoleByMenuId(menuId);
	}

	@Override
	public List<Menu> findMenuByRoleId(Long roleId) {
		return roleMenuRepository.findMenuByRoleId(roleId);
	}

	@Override
	public RoleMenu save(RoleMenu entity){
		RoleMenu persistEntity = entity;
		if(!entity.isNew()){
			persistEntity = roleMenuRepository.findOne(entity.getId());
			BeanUtils.copyProperties(entity, persistEntity);
		}
		return roleMenuRepository.save(entity);
	}

	@Override
	public RoleMenu findOne(Long id) {
		return roleMenuRepository.findOne(id);
	}

	@Override
	public List<RoleMenu> save(Iterable<RoleMenu> entities) {
		
		List<RoleMenu> result = new ArrayList<RoleMenu>();
		
		for (RoleMenu RoleMenu : entities) {
			result.add(RoleMenu);
			this.save(RoleMenu);
		}
		
		return result;
		
	}

	@Override
	public void delete(Long id) {
		roleMenuRepository.delete(id);
	}

	@Override
	public void detete(Iterable<RoleMenu> entities) {
		roleMenuRepository.delete(entities);
	}

	@Override
	public List<RoleMenu> findAll(Specification<RoleMenu> entityQuery) {
		return roleMenuRepository.findAll(entityQuery);
	}
	
}
