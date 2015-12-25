package com.github.slowrookie.base.web;

import java.util.List;

import com.github.slowrookie.helper.PersistableHelper;
import com.github.slowrookie.web.PageParamater;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.slowrookie.helper.TreeHelper;
import com.github.slowrookie.base.persistence.entity.Menu;
import com.github.slowrookie.base.persistence.entity.query.MenuQuery;
import com.github.slowrookie.service.DefaultCrudService;

import javax.servlet.http.HttpServletRequest;

/**
 * 菜单管理
 * 
 * @author 刘佳兴
 */
@RestController
public class MenuController {

	@Autowired
	private DefaultCrudService<Menu> menuService;
	
	/**
	 * 根据主键id查询
	 * 
	 * @param id 唯一ID
	 * @return {@link Menu}
	 */
	@RequestMapping(value = "/menu/{id}", method = RequestMethod.GET)
	@ResponseBody Menu findOne(@PathVariable("id") Long id) {
		return menuService.findOne(id);
	}
	
	/**
	 * 根据id删除菜单信息
	 * 
	 * @param id 唯一ID
	 */
	@RequestMapping(value = "/menu/{id}", method = RequestMethod.DELETE)
	void delete(@PathVariable("id") Long id){
		menuService.delete(id);
	}

	/**
	 * 保存或者更新
	 *
	 * @param menu 菜单
	 * @return     返回保存对象
     */
	@RequestMapping(value = "/menus", method = RequestMethod.PUT, produces = "application/json")
	@ResponseBody Menu save(HttpServletRequest request, @RequestBody Menu menu){
        PersistableHelper.setDefaultFields(request, menu);
		return menuService.save(menu);
	}
	
	/**
	 * 批量插入
	 * 
	 * @param menus 菜单数组
	 * @return List<Menu>
	 */
	@RequestMapping(value = "/menus", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody List<Menu> saveAll(HttpServletRequest request, @RequestBody List<Menu> menus){
        PersistableHelper.setDefaultFields(request, menus);
		return menuService.save(menus);
	}
	
	/**
	 * 查询获取menus支持全属性条件查询
	 * 
	 * @param menuQuery
	 * 		菜单查询对象，通过JSON传递
	 * @param pageParamater
	 * 		分页查询条件对象
	 * @return Page<Menu>
	 * 		返回分页数据
	 */
	@RequestMapping(value = "/menus", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody Page<Menu> findAll(MenuQuery menuQuery, PageParamater pageParamater) {
		return menuService.findAll(menuQuery, pageParamater.getPageRequest());
	}
	
	/**
	 * 根据属性查找所有
	 * 
	 * @param menuQuery 查询对象
	 * @return          菜单数组
	 */
	@RequestMapping(value = "/menus/all", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody List<Menu> findAll(MenuQuery menuQuery) {
		return menuService.findAll(menuQuery);
	}
	
	/**
	 * 查询菜单树
	 * 
	 * @param menuQuery 查询对象
	 * @return Menu
	 */
	@RequestMapping(value = "/menus/tree", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody Menu findMenuTree(MenuQuery menuQuery){
		List<Menu> menus = menuService.findAll(menuQuery);
		TreeHelper<Menu> helper = new TreeHelper<Menu>(menus);
		return helper.generateTee();
	}
	
}
