package com.github.slowrookie.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.slowrookie.persistence.entity.Organization;
import com.github.slowrookie.repository.DefaultRepository;

/**
 * 组织服务
 * 
 * @author 刘佳兴
 */
@Service("organizationService")
@Transactional
public class OrganizationServiceImpl extends DefaultCrudServiceImpl<Organization> {
	
	@Autowired
	public OrganizationServiceImpl(DefaultRepository<Organization> organizationRepository) {
		super(organizationRepository);
	}

	
}
