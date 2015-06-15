package com.github.slowrookie.persistence;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.springframework.data.domain.Persistable;

/**
 * 持久化唯一主键的父类映射
 * 
 * @author 刘佳兴
 */
@MappedSuperclass
public abstract class IdentityPersistable implements Persistable<Long> {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Long id;

	@Override
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public boolean isNew() {
		if(id == null) return true;
		return false;
	}
	
	
}
