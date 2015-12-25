package com.github.slowrookie.base.repository;

import java.util.List;

import com.github.slowrookie.repository.DefaultRepository;
import org.springframework.data.jpa.repository.Query;

import com.github.slowrookie.base.persistence.entity.Menu;
import com.github.slowrookie.base.persistence.entity.Role;
import com.github.slowrookie.base.persistence.entity.RoleMenu;

/**
 * 角色菜单持久化接口
 * 
 * @author 刘佳兴
 */
public interface RoleMenuRepository extends DefaultRepository<RoleMenu> {

	@Query("select rm.role from RoleMenu rm where rm.menu.id = ?1")
	public List<Role> findRoleByMenuId(Long menuId);
	
	@Query("select rm.menu from RoleMenu rm where rm.role.id = ?1")
	public List<Menu> findMenuByRoleId(Long roleId);
	
	@Query("select rm.menu from RoleMenu rm, UserRole ur where ur.role.id = rm.role.id and ur.user.id = ?1 and rm.menu.type = ?2")
	public List<Menu> findMenuByUserId(Long userId, Integer type);

	public void deleteByRoleId(Long roleId);
	
}
