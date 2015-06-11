package com.github.slowrookie.common;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;

/**
 * 对于分页和排序查询条件的封装
 * 
 * @author 刘佳兴
 */
public class PageParamater {
	
	private Integer page = 0;
	
	private Integer size = 1000;
	
	private String sort = null;
	
	private String direction = null;
	
	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}
	
	public Pageable getPageRequest(){
		return new PageRequest(page, size, direction == null ? Direction.ASC : Direction.DESC, sort == null ? null : sort.split(","));
	}
	
}
