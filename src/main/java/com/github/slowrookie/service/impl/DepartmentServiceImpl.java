package com.github.slowrookie.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.slowrookie.persistence.entity.Department;
import com.github.slowrookie.repository.DefaultRepository;

/**
 * 部门服务
 * 
 * @author 刘佳兴
 */
@Service("departmentService")
@Transactional
public class DepartmentServiceImpl extends DefaultCrudServiceImpl<Department> {
	
	@Autowired
	public DepartmentServiceImpl(DefaultRepository<Department> departmentRepository) {
		super(departmentRepository);
	}

	
}
