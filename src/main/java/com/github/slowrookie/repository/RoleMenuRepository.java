package com.github.slowrookie.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.github.slowrookie.persistence.entity.Menu;
import com.github.slowrookie.persistence.entity.Role;
import com.github.slowrookie.persistence.entity.RoleMenu;


public interface RoleMenuRepository extends DefaultRepository<RoleMenu> {

	@Query("select rm.role from RoleMenu rm where rm.menu.id = ?1")
	public List<Role> findRoleByMenuId(Long menuId);
	
	@Query("select rm.menu from RoleMenu rm where rm.role.id = ?1")
	public List<Menu> findMenuByRoleId(Long roleId);
	
}
