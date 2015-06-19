package com.github.slowrookie.persistence.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.github.slowrookie.persistence.AuditablePersistable;

@Entity
@Table(name = "base_menu")
public class Menu extends AuditablePersistable {

	private static final long serialVersionUID = 1L;

	protected String name;
	
	protected String url;
	
	protected Menu menu;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}
	
}
