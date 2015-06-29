package com.github.slowrookie.persistence.entity.query;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import com.github.slowrookie.persistence.entity.Menu;

/**
 * 菜单查询条件拼写
 * 
 * @author 刘佳兴
 */
public class MenuQuery extends Menu implements Specification<Menu> {
	
	private static final long serialVersionUID = -7805576044463820714L;

	@Override
	public Predicate toPredicate(Root<Menu> root, CriteriaQuery<?> query,
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
		
		if(!StringUtils.isEmpty(this.hiberarchy)){
			predicates.add(cb.like(root.get("hiberarchy").as(String.class), this.code + "%"));
		}
		
		Predicate[] pre = new Predicate[predicates.size()];
		return query.where(predicates.toArray(pre)).getRestriction();
	}
	
}
