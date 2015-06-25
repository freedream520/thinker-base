package com.github.slowrookie.repository;

import org.springframework.stereotype.Repository;

import com.github.slowrookie.persistence.entity.Organization;

/**
 * 组织持久化接口
 * 
 * @author 刘佳兴
 */
@Repository
public interface OrganizationRepository extends DefaultRepository<Organization>  {

}
