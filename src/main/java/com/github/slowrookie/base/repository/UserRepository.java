package com.github.slowrookie.base.repository;

import com.github.slowrookie.repository.DefaultRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.github.slowrookie.base.persistence.entity.User;

/**
 * 用户持久化接口
 * 
 * @author 刘佳兴
 */
@Repository
public interface UserRepository extends DefaultRepository<User> {
	
	@Query("from User u where u.loginName = ?1")
	public User findByLoginName(String loginName);
	
}
