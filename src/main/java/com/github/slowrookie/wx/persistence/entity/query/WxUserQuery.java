package com.github.slowrookie.wx.persistence.entity.query;

import com.github.slowrookie.base.persistence.entity.Menu;
import com.github.slowrookie.wx.persistence.entity.WxUser;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * 菜单查询条件拼写
 * 
 * @author 刘佳兴
 */
public class WxUserQuery extends WxUser implements Specification<WxUser> {
	
	private static final long serialVersionUID = -7805576044463820714L;

	@Override
	public Predicate toPredicate(Root<WxUser> root, CriteriaQuery<?> query,
			CriteriaBuilder cb) {
		List<Predicate> predicates = new ArrayList<Predicate>();
		
		Predicate[] pre = new Predicate[predicates.size()];
		return query.where(predicates.toArray(pre)).getRestriction();
	}
	
}
