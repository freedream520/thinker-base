package com.github.slowrookie.entity;

import javax.persistence.Entity;

import org.springframework.data.jpa.domain.AbstractAuditable;

@Entity
public class Employee extends AbstractAuditable<User, Long> {

	private static final long serialVersionUID = 1L;
	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
