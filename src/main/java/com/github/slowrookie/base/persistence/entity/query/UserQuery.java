package com.github.slowrookie.base.persistence.entity.query;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import com.github.slowrookie.base.persistence.entity.User;

/**
 * 用户查询条件拼写
 * 
 * @author 刘佳兴
 */
public class UserQuery extends User implements Specification<User> {
	
	private static final long serialVersionUID = -7805576044463820714L;

	@Override
	public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query,
			CriteriaBuilder cb) {
		List<Predicate> predicates = new ArrayList<Predicate>();
		
		if(!StringUtils.isEmpty(this.loginName)) {
			predicates.add(cb.equal(root.get("loginName"), this.loginName));
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
		
		if(null != this.organization){
			predicates.add(cb.equal(root.get("organization"), this.organization));
		}
		
		Predicate[] pre = new Predicate[predicates.size()];
		
		return query.where(predicates.toArray(pre)).getRestriction();
	}
	
}
