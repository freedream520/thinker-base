package com.github.slowrookie.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.github.slowrookie.constant.MenuType;
import com.github.slowrookie.persistence.TreePersistable;

/**
 * 菜单实体类映射
 * 
 * @author 刘佳兴
 */
@Entity
@Table(name = "base_menu")
public class Menu extends TreePersistable {

	private static final long serialVersionUID = 1L;
	
	@NotNull
	protected String resource = "";
	
	@Column(length = 50)
	protected String image = "";
	
	@NotNull
	protected Integer type = MenuType.MENU.value();

	public String getResource() {
		return resource;
	}

	public void setResource(String resource) {
		this.resource = resource;
	}
	
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
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
		Menu other = (Menu) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
}
