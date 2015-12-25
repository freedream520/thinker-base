package com.github.slowrookie.base.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.github.slowrookie.constant.RoleType;
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
	
	@NotEmpty
	@Size(max = 20)
	@Column(name = "name_", length = 20, unique = true)
	protected String name;

	@Column(name = "describe_")
	protected String describe;
	
	//默认均为菜单权限
    @Column(name = "type_")
	protected Integer type = RoleType.MENU.value();

	public Role() {
		super();
	}

	public Role(String name, Integer type) {
		super();
		this.name = name;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}
	
	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
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
		Role other = (Role) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
}
