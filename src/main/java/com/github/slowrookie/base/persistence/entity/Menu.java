package com.github.slowrookie.base.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

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
	@Column(name = "resource_")
	protected String resource = "";
	
	@Column(name = "image_", length = 50)
	protected String image = "";
	
	@NotNull
	@Column(name = "type_")
	protected Integer type = null;

	public Menu() {
	}

	public Menu(Long id) {
		super(id);
	}

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
	public String toString() {
		return "Menu{" +
				"resource='" + resource + '\'' +
				", image='" + image + '\'' +
				", type=" + type +
				'}';
	}
}
