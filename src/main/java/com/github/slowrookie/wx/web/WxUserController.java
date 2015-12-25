package com.github.slowrookie.wx.web;

import com.github.slowrookie.helper.PersistableHelper;
import com.github.slowrookie.helper.TreeHelper;
import com.github.slowrookie.service.DefaultCrudService;
import com.github.slowrookie.web.PageParamater;
import com.github.slowrookie.wx.persistence.entity.WxUser;
import com.github.slowrookie.wx.persistence.entity.query.WxUserQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 微信用户管理
 * 
 * @author 刘佳兴
 */
@RestController
public class WxUserController {

	@Autowired
	private DefaultCrudService<WxUser> wxUserService;
	
	/**
	 * 根据主键id查询
	 * 
	 * @param id 唯一ID
	 * @return {@link WxUser}
	 */
	@RequestMapping(value = "/WxUser/{id}", method = RequestMethod.GET)
	@ResponseBody WxUser findOne(@PathVariable("id") Long id) {
		return wxUserService.findOne(id);
	}

    /**
	 * 根据条件查询
     * @param wxUserQuery WxUserQuery
     * @return WxUser
     */
	@RequestMapping(value = "/WxUser", method = RequestMethod.GET)
	@ResponseBody WxUser findOneByQuery(WxUserQuery wxUserQuery) {
		return wxUserService.findOne(wxUserQuery);
	}
	
	/**
	 * 根据id删除菜单信息
	 * 
	 * @param id 唯一ID
	 */
	@RequestMapping(value = "/WxUser/{id}", method = RequestMethod.DELETE)
	void delete(@PathVariable("id") Long id){
		wxUserService.delete(id);
	}

	/**
	 * 保存或者更新
	 *
	 * @param WxUser 菜单
	 * @return     返回保存对象
     */
	@RequestMapping(value = "/WxUsers", method = RequestMethod.PUT, produces = "application/json")
	@ResponseBody WxUser save(HttpServletRequest request, @RequestBody WxUser WxUser){
        PersistableHelper.setDefaultFields(request, WxUser);
		return wxUserService.save(WxUser);
	}
	
	/**
	 * 批量插入
	 * 
	 * @param WxUsers 菜单数组
	 * @return List<WxUser>
	 */
	@RequestMapping(value = "/WxUsers", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody List<WxUser> saveAll(HttpServletRequest request, @RequestBody List<WxUser> WxUsers){
        PersistableHelper.setDefaultFields(request, WxUsers);
		return wxUserService.save(WxUsers);
	}
	
	/**
	 * 查询获取WxUsers支持全属性条件查询
	 * 
	 * @param wxUserQuery
	 * 		菜单查询对象，通过JSON传递
	 * @param pageParamater
	 * 		分页查询条件对象
	 * @return Page<WxUser>
	 * 		返回分页数据
	 */
	@RequestMapping(value = "/WxUsers", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody Page<WxUser> findAll(WxUserQuery wxUserQuery, PageParamater pageParamater) {
		return wxUserService.findAll(wxUserQuery, pageParamater.getPageRequest());
	}
	
	/**
	 * 根据属性查找所有
	 * 
	 * @param wxUserQuery 查询对象
	 * @return          数组
	 */
	@RequestMapping(value = "/WxUsers/all", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody List<WxUser> findAll(WxUserQuery wxUserQuery) {
		return wxUserService.findAll(wxUserQuery);
	}
	
}
