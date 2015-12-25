package com.github.slowrookie.base.service.impl;

import javax.transaction.Transactional;

import com.github.slowrookie.service.impl.DefaultCrudServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.slowrookie.base.persistence.entity.Menu;
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
