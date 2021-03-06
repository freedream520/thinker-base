package com.github.slowrookie.base.web;

import java.util.List;

import com.github.slowrookie.base.persistence.entity.Role;
import com.github.slowrookie.base.persistence.entity.query.RoleQuery;
import com.github.slowrookie.helper.PersistableHelper;
import com.github.slowrookie.web.PageParamater;
import org.apache.shiro.authc.credential.PasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.slowrookie.base.persistence.entity.User;
import com.github.slowrookie.base.persistence.entity.query.UserQuery;
import com.github.slowrookie.service.DefaultCrudService;

import javax.servlet.http.HttpServletRequest;

/**
 * 用户管理
 * 
 * @author 刘佳兴
 */
@RestController
public class UserController {

	@Autowired
	private DefaultCrudService<User> userService;
	
	@Autowired
	private PasswordService defaultPasswordService;

	/**
	 * 根据主键id查询
	 * 
	 * @param id 唯一ID
	 * @return User
	 */
	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
	@ResponseBody User findOne(@PathVariable("id") Long id) {
		return userService.findOne(id);
	}

	/**
	 * 根据条件查询
	 * @param userQuery UserQuery
	 * @return User
	 */
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	@ResponseBody
	User findOneByQuery(UserQuery userQuery) {
		return userService.findOne(userQuery);
	}
	
	/**
	 * 删除用户信息
	 * 
	 * @param id 唯一ID
	 */
	@RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
	void delete(@PathVariable("id") Long id){
		userService.delete(id);
	}
	
	/**
	 * 保存或者更新
	 * 
	 * @param user
	 * 		序列化的User对象
	 * @return User
	 * 		返回更新完成后的User
	 */
	@RequestMapping(value = "/users", method = RequestMethod.PUT, produces = "application/json")
	@ResponseBody User save(HttpServletRequest request, @RequestBody User user){
		if(StringUtils.isEmpty(user.getPassword())){
			user.setPassword(defaultPasswordService.encryptPassword("8888"));
		}else{
			user.setPassword(defaultPasswordService.encryptPassword(user.getPassword()));
		}
        PersistableHelper.setDefaultFields(request, user);
		return userService.save(user);
	}
	
	/**
	 * 批量插入
	 * 
	 * @param users 列表
	 * @return 列表
	 */
	@RequestMapping(value = "/users", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody List<User> saveAll(HttpServletRequest request, @RequestBody List<User> users){
        for (User user: users){
            if(StringUtils.isEmpty(user.getPassword())){
                user.setPassword(defaultPasswordService.encryptPassword("8888"));
            }else{
                user.setPassword(defaultPasswordService.encryptPassword(user.getPassword()));
            }
        }
        PersistableHelper.setDefaultFields(request, users);
		return userService.save(users);
	}
	
	/**
	 * 查询获取users支持全属性条件查询
	 * 
	 * @param userQuery
	 * 		用户查询对象，通过JSON传递
	 * @param pageParamater
	 * 		分页查询条件对象
	 * @return Page<User>
	 * 		返回分页数据
	 */
	@RequestMapping(value = "/users", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody Page<User> findAll(UserQuery userQuery, PageParamater pageParamater) {
		return userService.findAll(userQuery, pageParamater.getPageRequest());
	}
	
	/**
	 * 查询获取users支持全属性条件查询
	 * 
	 * @param userQuery
	 * 		用户查询对象，通过JSON传递
	 * @return Page<User>
	 * 		返回分页数据
	 */
	@RequestMapping(value = "/users/all", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody List<User> findAll(UserQuery userQuery) {
		return userService.findAll(userQuery);
	}
	
}
