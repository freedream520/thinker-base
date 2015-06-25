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

import com.github.slowrookie.persistence.entity.Department;
import com.github.slowrookie.persistence.entity.query.DepartmentQuery;
import com.github.slowrookie.service.DefaultCrudService;

/**
 * 部门管理
 * 
 * @author 刘佳兴
 */
@RestController
public class DepartmentController {

	@Autowired
	private DefaultCrudService<Department> departmentService;
	
	/**
	 * 根据主键id查询
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/department/{id}", method = RequestMethod.GET)
	@ResponseBody Department findOne(@PathVariable("id") Long id) {
		Department department = departmentService.findOne(id);
		return department;
	}
	
	/**
	 * 根据id删除菜单信息
	 * 
	 * @param id
	 */
	@RequestMapping(value = "/department/{id}", method = RequestMethod.DELETE)
	void delete(@PathVariable("id") Long id){
		departmentService.delete(id);
	}
	
	/**
	 * 保存或者更新
	 * 
	 * @param menu
	 * 		序列化的Menu对象
	 * @return menu
	 * 		返回更新完成后的Menu
	 */
	@RequestMapping(value = "/departments", method = RequestMethod.PUT, produces = "application/json")
	@ResponseBody Department save(@RequestBody Department menu){
		return departmentService.save(menu);
	}
	
	/**
	 * 批量插入
	 * 
	 * @param menus
	 * @return
	 */
	@RequestMapping(value = "/departments", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody List<Department> saveAll(@RequestBody List<Department> menus){
		return departmentService.save(menus);
	}
	
	/**
	 * 查询获取departments支持全属性条件查询
	 * 
	 * @param departmentQuery
	 * 		菜单查询对象，通过JSON传递
	 * @param pageParamater
	 * 		分页查询条件对象
	 * @return Page<Department>
	 * 		返回分页数据
	 */
	@RequestMapping(value = "/departments", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody Page<Department> findAll(DepartmentQuery departmentQuery, PageParamater pageParamater) {
		return departmentService.findAll(departmentQuery, pageParamater.getPageRequest());
	}
	
	
}
