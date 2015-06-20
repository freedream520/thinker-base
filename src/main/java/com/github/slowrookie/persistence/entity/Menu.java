package com.github.slowrookie.persistence.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.github.slowrookie.persistence.AuditablePersistable;

/**
 * 组织实体类映射
 * 
 * @author 刘佳兴
 */
@Entity
@Table(name = "base_menu")
public class Menu extends AuditablePersistable {

	private static final long serialVersionUID = 1L;

	@NotNull
	@Column(length = 40, nullable = true, unique = true)
	protected String name;
	
	@NotNull
	protected String resouce = "";

	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	protected Menu parent;
	
	@OneToMany(mappedBy = "parent")
	private Set<Menu> children = new HashSet<Menu>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name; 
	}

	public String getResouce() {
		return resouce;
	}

	public void setResouce(String resouce) {
		this.resouce = resouce;
	}

	public Menu getParent() {
		return parent;
	}

	public void setParent(Menu parent) {
		this.parent = parent;
	}

	public Set<Menu> getChildren() {
		return children;
	}

	public void setChildren(Set<Menu> children) {
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
		Menu other = (Menu) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
}
