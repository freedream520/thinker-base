package com.github.slowrookie.persistence.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.github.slowrookie.constant.OrganizationType;
import com.github.slowrookie.persistence.TreePersistable;

/**
 * 组织实体类映射
 * 
 * @author 刘佳兴
 */
@Entity
@Table(name = "base_organization")
public class Organization extends TreePersistable {

	private static final long serialVersionUID = 1L;
	
	//默认是组织
	private Integer type = OrganizationType.Organization.value();
	
	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
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
		Organization other = (Organization) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
}
