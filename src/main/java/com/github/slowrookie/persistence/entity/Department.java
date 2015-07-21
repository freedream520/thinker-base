package com.github.slowrookie.persistence.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.github.slowrookie.persistence.TreePersistable;

/**
 * 部门实体类映射（暂时弃用，组织与部门之间的关系并不非常明确，所在在Organization中添加type以做区分）
 * 
 * @author 刘佳兴
 */
@Entity
@Table(name = "base_department")
public class Department extends TreePersistable {

	private static final long serialVersionUID = 1L;

	@NotNull
	protected Long organization;

	public Long getOrganization() {
		return organization;
	}

	public void setOrganization(Long organization) {
		this.organization = organization;
	}

	public Long getParent() {
		return parent;
	}

	public void setParent(Long parent) {
		this.parent = parent;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Department other = (Department) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
}
