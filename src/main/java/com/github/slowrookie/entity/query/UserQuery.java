package com.github.slowrookie.entity.query;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import com.github.slowrookie.entity.User;

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
		
		if(!StringUtils.isEmpty(this.getRealName())) {
			predicates.add(cb.like(root.get("realName").as(String.class), "%" + this.getRealName() + "%"));
		}
		
		if(null != this.getId()) {
			predicates.add(cb.equal(root.get("id"), this.getId()));
		}
		
		if(null != this.getActivity()) {
			predicates.add(cb.equal(root.get("activity"), this.getActivity()));
		}
		
		if(null != this.getGender()) {
			predicates.add(cb.equal(root.get("gender"), this.getGender()));
		}
		
		if(null != this.getLoginName()){
			predicates.add(cb.equal(root.get("loginName"), this.getLoginName()));
		}
		
		Predicate[] pre = new Predicate[predicates.size()];
		return query.where(predicates.toArray(pre)).getRestriction();
	}

	
	
}
