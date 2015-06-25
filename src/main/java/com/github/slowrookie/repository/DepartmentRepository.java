package com.github.slowrookie.repository;

import org.springframework.stereotype.Repository;

import com.github.slowrookie.persistence.entity.Department;

/**
 * 部门持久化接口
 * 
 * @author 刘佳兴
 */
@Repository
public interface DepartmentRepository extends DefaultRepository<Department>  {

}
