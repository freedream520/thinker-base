package com.github.slowrookie.entity.query;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.h2.util.StringUtils;
import org.springframework.data.jpa.domain.Specification;

import com.github.slowrookie.entity.User;

@SuppressWarnings("serial")
public class UserQuery extends User implements Specification<User> {

	@Override
	public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query,
			CriteriaBuilder cb) {
		List<Predicate> predicates = new ArrayList<Predicate>();
		
		if(!StringUtils.isNullOrEmpty(getRealName())){
			predicates.add(cb.like(root.get("realName").as(String.class), "%" + getRealName() + "%"));
		}
		
		if(null != getId()){
			predicates.add(cb.equal(root.get("id").as(Long.class), getId()));
		}
		
		
		
		Predicate[] pre = new Predicate[predicates.size()];
		return query.where(predicates.toArray(pre)).getRestriction();
	}

	
	
}
