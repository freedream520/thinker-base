package com.github.slowrookie.persistence.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.github.slowrookie.persistence.AuditablePersistable;

/**
 * 部门实体类映射
 * 
 * @author 刘佳兴
 */
@Entity
@Table(name = "base_department")
public class Department extends AuditablePersistable {

	private static final long serialVersionUID = 1L;

	@NotNull
	@Column(length = 40, nullable = true, unique = true)
	protected String name;
	
	@NotNull
	protected String code = "";
	
	@NotNull
	protected Long organization;

	protected Long parent;
	
	@OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
	private Set<Department> children = new HashSet<Department>();
	
	public boolean isChild() {
		if(children.isEmpty() && parent != null ) return true;
		return false;
	}

	public String getName() { 
		return name;
	}

	public void setName(String name) {
		this.name = name; 
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Long getParent() {
		return parent;
	}

	public void setParent(Long parent) {
		this.parent = parent;
	}

	public Set<Department> getChildren() {
		return children;
	}

	public void setChildren(Set<Department> children) {
		this.children = children;
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
