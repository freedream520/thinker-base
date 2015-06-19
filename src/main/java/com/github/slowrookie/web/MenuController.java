package com.github.slowrookie.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.slowrookie.persistence.entity.Menu;
import com.github.slowrookie.persistence.entity.query.MenuQuery;
import com.github.slowrookie.service.PageableService;

/**
 * 组织管理
 * 
 * @author 刘佳兴
 */
@RestController
public class MenuController {

	@Autowired
	private PageableService<Menu> menuService;
	
	/**
	 * 根据主键id查询
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/menu/{id}", method = RequestMethod.GET)
	@ResponseBody Menu findOne(@PathVariable("id") Long id) {
		Menu menu = menuService.findOne(id);
		return menu;
	}
	
	/**
	 * 更具id删除菜单信息
	 * 
	 * @param id
	 */
	@RequestMapping(value = "/menu/{id}", method = RequestMethod.DELETE)
	void delete(@PathVariable("id") Long id){
		menuService.delete(id);
	}
	
	/**
	 * 保存或者更新
	 * 
	 * @param menu
	 * 		序列化的Menu对象
	 * @return menu
	 * 		返回更新完成后的Menu
	 */
	@RequestMapping(value = "/menus", method = RequestMethod.PUT, produces = "application/json")
	@ResponseBody Menu save(@RequestBody Menu menu){
		return menuService.save(menu);
	}
	
	/**
	 * 批量插入
	 * 
	 * @param menus
	 * @return
	 */
	@RequestMapping(value = "/menus", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody List<Menu> saveAll(@RequestBody List<Menu> menus){
		return menuService.save(menus);
	}
	
	/**
	 * 查询获取users支持全属性条件查询
	 * 
	 * @param menuQuery
	 * 		菜单查询对象，通过JSON传递
	 * @param pageParamater
	 * 		分页查询条件对象
	 * @return Page<Menu>
	 * 		返回分页数据
	 */
	@RequestMapping(value = "/menus", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody Page<Menu> findAll(PageParamater pageParamater, MenuQuery menuQuery) {
		return menuService.findAll(menuQuery, pageParamater.getPageRequest());
	}
	
	
}
