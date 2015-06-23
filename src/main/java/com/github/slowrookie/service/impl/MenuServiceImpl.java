package com.github.slowrookie.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.github.slowrookie.persistence.entity.Menu;
import com.github.slowrookie.repository.DefaultRepository;

/**
 * 菜单资源Service操作
 * 
 * @author 刘佳兴
 */
@Service("menuService")
@Transactional
public class MenuServiceImpl extends DefaultCrudServiceImpl<Menu> {
	
	@Override
	@Autowired
	@Qualifier(value = "menuRepository")
	public void setDefaultRepository(DefaultRepository<Menu> menuRepository) {
		this.defaultRepository = menuRepository;
	}

	
}
