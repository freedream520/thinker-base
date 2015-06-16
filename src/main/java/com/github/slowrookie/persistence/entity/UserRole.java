package com.github.slowrookie.persistence.entity;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.github.slowrookie.persistence.IdentityPersistable;

/**
 * 用户和角色关联表
 * 
 * @author 刘佳兴
 */
@Entity
@Table(name = "base_user_role")
public class UserRole extends IdentityPersistable {

	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name="id_"))
	protected User user;
	
	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name="id_"))
	protected Role role;

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	
}
