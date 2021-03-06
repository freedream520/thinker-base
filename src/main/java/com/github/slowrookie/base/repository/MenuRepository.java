package com.github.slowrookie.base.repository;

import com.github.slowrookie.repository.DefaultRepository;
import org.springframework.stereotype.Repository;

import com.github.slowrookie.base.persistence.entity.Menu;

/**
 * 菜单持久化接口
 * 
 * @author 刘佳兴
 */
@Repository
public interface MenuRepository extends DefaultRepository<Menu> {

}
