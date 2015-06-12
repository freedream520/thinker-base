package com.github.slowrookie.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 用户实体类
 * 
 * @author 刘佳兴
 */
@Entity
@Table(name = "base_user")
public class User extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	protected String loginName;
	
	protected String lastname;
	
	protected String firstname;
	
	protected String password;
	
	protected Integer gender;
	
	protected String email;
	
	protected String mobile;
	
	protected String telephone;

	public User() {
		super();
	}

	public User(String loginName, String lastname, String firstname, String password,
			Integer gender, String email, String mobile, String telephone) {
		super();
		this.loginName = loginName;
		this.lastname = lastname;
		this.firstname = firstname;
		this.password = password;
		this.gender = gender;
		this.email = email;
		this.mobile = mobile;
		this.telephone = telephone;
	}

	@Column(length = 20)
	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}


	@Column(length = 10)
	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	@Column(length = 20)
	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	@Column(length = 40)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	@Column(length = 50)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(length = 20)
	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Column(length = 20)
	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		}
		return true;
	}

	
	
	
}
