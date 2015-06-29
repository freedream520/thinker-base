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

import com.github.slowrookie.helper.TreeHelper;
import com.github.slowrookie.persistence.entity.Organization;
import com.github.slowrookie.persistence.entity.query.OrganizationQuery;
import com.github.slowrookie.service.DefaultCrudService;

/**
 * 组织管理
 * 
 * @author 刘佳兴
 */
@RestController
public class OrganizationController {

	@Autowired
	private DefaultCrudService<Organization> organizationService;
	
	/**
	 * 根据主键id查询
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/organization/{id}", method = RequestMethod.GET)
	@ResponseBody Organization findOne(@PathVariable("id") Long id) {
		Organization menu = organizationService.findOne(id);
		return menu;
	}
	
	/**
	 * 根据id删除菜单信息
	 * 
	 * @param id
	 */
	@RequestMapping(value = "/organization/{id}", method = RequestMethod.DELETE)
	void delete(@PathVariable("id") Long id){
		organizationService.delete(id);
	}
	
	/**
	 * 保存或者更新
	 * 
	 * @param organization
	 * 		序列化的Menu对象
	 * @return {@link Organization}
	 * 		返回更新完成后的organization
	 */
	@RequestMapping(value = "/organizations", method = RequestMethod.PUT, produces = "application/json")
	@ResponseBody Organization save(@RequestBody Organization organization){
		return organizationService.save(organization);
	}
	
	/**
	 * 批量插入
	 * 
	 * @param organizations
	 * @return List<Organization>
	 */
	@RequestMapping(value = "/organizations", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody List<Organization> saveAll(@RequestBody List<Organization> organizations){
		return organizationService.save(organizations);
	}
	
	/**
	 * 查询获取menus支持全属性条件查询
	 * 
	 * @param organizationQuery
	 * 		菜单查询对象，通过JSON传递
	 * @param pageParamater
	 * 		分页查询条件对象
	 * @return Page<Menu>
	 * 		返回分页数据
	 */
	@RequestMapping(value = "/organizations", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody Page<Organization> findAll(OrganizationQuery organizationQuery, PageParamater pageParamater) {
		return organizationService.findAll(organizationQuery, pageParamater.getPageRequest());
	}
	
	/**
	 * 查询组织树
	 * 
	 * @param organizationQuery
	 * @return Organization
	 */
	@RequestMapping(value = "/organizations/tree", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody Organization findOrganizationTree(OrganizationQuery organizationQuery){
		List<Organization> organizations = organizationService.findAll(organizationQuery);
		TreeHelper<Organization> helper = new TreeHelper<Organization>(organizations);
		return helper.generateTee();
	}
	
}
