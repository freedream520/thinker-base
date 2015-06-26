package com.github.slowrookie.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.slowrookie.persistence.entity.Menu;
import com.github.slowrookie.repository.DefaultRepository;

/**
 * 菜单资源服务
 * 
 * @author 刘佳兴
 */
@Service("menuService")
@Transactional
public class MenuServiceImpl extends DefaultCrudServiceImpl<Menu> {
	
	@Autowired
	public MenuServiceImpl(DefaultRepository<Menu> menuRepository) {
		super(menuRepository);
	}

	
}
