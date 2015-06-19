package com.github.slowrookie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.github.slowrookie.persistence.entity.Menu;

/**
 * 持久化接口
 * 
 * @author 刘佳兴
 */
@Repository
public interface MenuRepository extends JpaRepository<Menu, Long>, JpaSpecificationExecutor<Menu>  {

}
