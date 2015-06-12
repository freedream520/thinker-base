package com.github.slowrookie.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.github.slowrookie.entity.User;
import com.github.slowrookie.entity.query.UserQuery;
import com.github.slowrookie.repository.UserRepository;

/**
 * 用户Service操作
 * 
 * @author 刘佳兴
 */
@Service
@Transactional
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	/**
	 * 根据id查找
	 * 
	 * @param id
	 * @return
	 */
	public User findOne(Long id){
		return userRepository.getOne(id);
	}
	
	/**
	 * 查询所有
	 * 
	 * @param userQuery
	 * 		查询类，根据属性拼接查询语句
	 * @param pageable
	 * 		分页参数
	 * @return Page<User>
	 * 		返回分页数据
	 */
	public Page<User> findAll(UserQuery userQuery, Pageable pageable) {
		return userRepository.findAll(userQuery, pageable); 
	}
	
	/**
	 * 持久化方法，包含更新和新增操作
	 * 
	 * @param user
	 * 		保存信息
	 * @return User
	 * 		返回保存后的用户信息
	 */
	public User persist(User user) {
		return userRepository.save(user);
	}
	
	/**
	 * 删除用户数据
	 * 
	 * @param id
	 * 		用户的主键id
	 */
	public void remove(Long id){
		userRepository.delete(id);
	}
}
