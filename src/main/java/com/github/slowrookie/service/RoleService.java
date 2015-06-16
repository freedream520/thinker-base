package com.github.slowrookie.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.github.slowrookie.persistence.entity.Role;
import com.github.slowrookie.persistence.entity.query.RoleQuery;
import com.github.slowrookie.repository.RoleRepository;

/**
 * 权限Service操作
 * 
 * @author 刘佳兴
 */
@Service
@Transactional
public class RoleService {
	
	@Autowired
	private RoleRepository roleRepository;

	/**
	 * 根据id查找
	 * 
	 * @param id
	 * @return
	 */
	public Role getOne(Long id){
		return roleRepository.getOne(id);
	}
	
	/**
	 * 查询所有
	 * 
	 * @param roleQuery
	 * 		查询类，根据属性拼接查询语句
	 * @param pageable
	 * 		分页参数
	 * @return Page<User>
	 * 		返回分页数据
	 */
	public Page<Role> findAll(RoleQuery roleQuery, Pageable pageable) {
		return roleRepository.findAll(roleQuery, pageable); 
	}
	
	/**
	 * 持久化方法，包含更新和新增操作
	 * 
	 * @param user
	 * 		保存信息
	 * @return User
	 * 		返回保存后的信息
	 */
	public Role save(Role user) {
		return roleRepository.save(user);
	}
	
	/**
	 * 删除数据
	 * 
	 * @param id
	 * 		主键id
	 */
	public void delete(Long id){
		roleRepository.delete(id);
	}
}
