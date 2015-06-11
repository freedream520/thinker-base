package com.github.slowrookie.common;

import java.util.Map;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;

import com.github.slowrookie.entity.AbstractEntity;

/**
 * 查询参数转换
 * 
 * @author liujiaxingemail@gmail.com
 */
public class QueryParameterUtils {

	/**
	 * 在GET请求的参数中提取分页、排序信息
	 * 
	 * @param params
	 * @return Pageable
	 */
	public static Pageable getPageable(Map<String, String> params) {
		Integer page = params.containsKey("page") ? Integer.valueOf(params.get("page")) : 0;
		Integer size = params.containsKey("size") ? Integer.valueOf(params.get("size")) : 1000;
		String  sort = params.containsKey("sort") ? params.get("sort") : "";
		Direction direction = params.containsKey("direction") ? Direction.DESC : Direction.ASC;
		return new PageRequest(page, size, direction, sort.split(","));
	}
	
	/**
	 * 根据参数填充实体类
	 * 
	 * @param params
	 * @param specification
	 */
	public static void getSpecification(Map<String, String> params, Specification<? extends AbstractEntity> specification) {
		
	}
	
}
