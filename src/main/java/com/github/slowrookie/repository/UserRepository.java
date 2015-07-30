package com.github.slowrookie.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.github.slowrookie.persistence.entity.User;

/**
 * 用户持久化接口
 * 
 * @author 刘佳兴
 */
@Repository
public interface UserRepository extends DefaultRepository<User> {
	
	@Query("from User u where u.loginName = ?1 and u.password = ?2")
	public User findByLoginNameAndPassword(String loginName, String password);
	
}
