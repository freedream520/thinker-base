package com.github.slowrookie.persistence.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.github.slowrookie.persistence.AuditablePersistable;

/**
 * 角色管理
 * 
 * @author 刘佳兴
 */
@Entity
@Table(name = "base_role")
public class Role extends AuditablePersistable {
	
	private static final long serialVersionUID = 1L;
	
	protected String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
