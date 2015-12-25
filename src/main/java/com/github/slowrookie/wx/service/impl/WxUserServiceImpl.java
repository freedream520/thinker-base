package com.github.slowrookie.wx.service.impl;

import com.github.slowrookie.base.persistence.entity.Menu;
import com.github.slowrookie.repository.DefaultRepository;
import com.github.slowrookie.service.impl.DefaultCrudServiceImpl;
import com.github.slowrookie.wx.persistence.entity.WxUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * 微信
 * 
 * @author 刘佳兴
 */
@Service("wxUserService")
@Transactional
public class WxUserServiceImpl extends DefaultCrudServiceImpl<WxUser> {
	
	@Autowired
	public WxUserServiceImpl(DefaultRepository<WxUser> wxUserRepository) {
		super(wxUserRepository);
	}

	
}
