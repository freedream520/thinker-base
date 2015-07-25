package com.github.slowrookie.repository;

import org.springframework.stereotype.Repository;

import com.github.slowrookie.persistence.entity.User;

/**
 * 用户持久化接口
 * 
 * @author 刘佳兴
 */
@Repository
public interface UserRepository extends DefaultRepository<User> {
}
