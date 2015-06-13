package com.github.slowrookie.persistence.entity.query;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import com.github.slowrookie.persistence.entity.User;

/**
 * 用户查询条件拼写
 * 
 * @author 刘佳兴
 */
@SuppressWarnings("serial")
public class UserQuery extends User implements Specification<User> {

	@Override
	public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query,
			CriteriaBuilder cb) {
		List<Predicate> predicates = new ArrayList<Predicate>();
		
		if(!StringUtils.isEmpty(this.loginName)) {
			predicates.add(cb.like(root.get("loginName").as(String.class), "%" + this.loginName + "%"));
		}
		
		if(null != this.id) {
			predicates.add(cb.equal(root.get("id"), this.id));
		}
		
		if(null != this.activity) {
			predicates.add(cb.equal(root.get("activity"), this.activity));
		}
		
		if(null != this.gender) {
			predicates.add(cb.equal(root.get("gender"), this.gender));
		}
		
		Predicate[] pre = new Predicate[predicates.size()];
		return query.where(predicates.toArray(pre)).getRestriction();
	}
	
}
