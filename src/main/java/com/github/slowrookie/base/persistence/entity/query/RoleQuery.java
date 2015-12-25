package com.github.slowrookie.base.persistence.entity.query;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import com.github.slowrookie.base.persistence.entity.Role;

/**
 * 用户查询条件拼写
 * 
 * @author 刘佳兴
 */
public class RoleQuery extends Role implements Specification<Role> {

	private static final long serialVersionUID = -8137525775222659866L;

	@Override
	public Predicate toPredicate(Root<Role> root, CriteriaQuery<?> query,
			CriteriaBuilder cb) {
		
		List<Predicate> predicates = new ArrayList<Predicate>();
		
		if(!StringUtils.isEmpty(this.name)) {
			predicates.add(cb.like(root.get("name").as(String.class), "%" + this.name + "%"));
		}
		
		if(null != this.id) {
			predicates.add(cb.equal(root.get("id"), this.id));
		}
		
		if(null != this.activity) {
			predicates.add(cb.equal(root.get("activity"), this.activity));
		}
		
		Predicate[] pre = new Predicate[predicates.size()];
		return query.where(predicates.toArray(pre)).getRestriction();
	}
	
	
}
