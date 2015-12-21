package com.github.slowrookie.web;

import java.util.List;

import com.github.slowrookie.helper.PersistableHelper;
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

import javax.servlet.http.HttpServletRequest;

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
	 * @param id 唯一ID
	 * @return	 组织
	 */
	@RequestMapping(value = "/organization/{id}", method = RequestMethod.GET)
	@ResponseBody Organization findOne(@PathVariable("id") Long id) {
		return organizationService.findOne(id);
	}
	
	/**
	 * 根据id删除菜单信息
	 * 
	 * @param id 唯一ID
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
	@ResponseBody Organization save(HttpServletRequest request, @RequestBody Organization organization){
		PersistableHelper.setDefaultFields(request, organization);
		return organizationService.save(organization);
	}
	
	/**
	 * 批量插入
	 * 
	 * @param organizations 菜单
	 * @return List<Organization>
	 */
	@RequestMapping(value = "/organizations", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody List<Organization> saveAll(HttpServletRequest request,@RequestBody List<Organization> organizations){
		PersistableHelper.setDefaultFields(request, organizations);
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
	 * 根据属性查找所有
	 * 
	 * @param organizationQuery 菜单查询对象
	 * @return 菜单列表
	 */
	@RequestMapping(value = "/organizations/all", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody List<Organization> findAll(OrganizationQuery organizationQuery) {
		return organizationService.findAll(organizationQuery);
	}
	
	/**
	 * 查询组织树
	 * 
	 * @param organizationQuery 菜单查询对象
	 * @return Organization
	 */
	@RequestMapping(value = "/organizations/tree", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody Organization findOrganizationTree(OrganizationQuery organizationQuery){
		List<Organization> organizations = organizationService.findAll(organizationQuery);
		TreeHelper<Organization> helper = new TreeHelper<Organization>(organizations);
		return helper.generateTee();
	}
	
}
