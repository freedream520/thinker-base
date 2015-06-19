package com.github.slowrookie.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.github.slowrookie.persistence.entity.Menu;
import com.github.slowrookie.repository.MenuRepository;
import com.github.slowrookie.service.PageableService;

/**
 * 菜单资源Service操作
 * 
 * @author 刘佳兴
 */
@Service("menuService")
@Transactional
public class MenuServiceImpl implements PageableService<Menu> {
	
	@Autowired
	private MenuRepository menuRepository;

	@Override
	public Menu findOne(Long id){
		return menuRepository.findOne(id);
	}
	
	@Override
	public List<Menu> findAll(Specification<Menu> entityQuery) {
		return menuRepository.findAll(entityQuery);
	}
	
	@Override
	public Page<Menu> findAll(Specification<Menu> entityQuery, Pageable pageable) {
		return menuRepository.findAll(entityQuery, pageable); 
	}

	@Override
	public Menu save(Menu entity) {
		if(null != entity.getParent()){
			entity.setParent(this.findOne(entity.getParent().getId()));
		}
		return menuRepository.save(entity);
	}
	
	@Override
	public List<Menu> save(Iterable<Menu> entities){
		for (Menu menu : entities) {
			if(null != menu.getParent()){
				menu.setParent(this.findOne(menu.getParent().getId()));
			}
		}
		return menuRepository.save(entities);
	}
	
	@Override
	public void delete(Long id){
		menuRepository.delete(id);
	}

	@Override
	public void detete(Iterable<Menu> entities) {
		menuRepository.delete(entities);
	}
	
}
