package com.github.slowrookie.shiro;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.Filter;

import org.apache.shiro.authc.credential.DefaultPasswordService;
import org.apache.shiro.authc.credential.PasswordMatcher;
import org.apache.shiro.authc.credential.PasswordService;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.filter.authc.BasicHttpAuthenticationFilter;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

/**
 *Apache Shiro Java Configuration 配置
 * 
 * @author 刘佳兴
 */
@Configuration
public class ShiroConfig {
	
//	@Bean
//	public ShiroFilterFactoryBean getShiorFilter(){
//		ShiroFilterFactoryBean shiroFilter = new ShiroFilterFactoryBean();
//
//		//设置请求的拦截
//		Map<String, String> filterChainDefinitionMapping = new HashMap<String, String>();
//		filterChainDefinitionMapping.put("/**", "authcBasic");
//		shiroFilter.setFilterChainDefinitionMap(filterChainDefinitionMapping);
//
//		//设置SecurityManager
//		shiroFilter.setSecurityManager(getSecurityManager());
//
//		//设置拦截器
//		Map<String, Filter> filters = new LinkedHashMap<String, Filter>();
//		BasicHttpAuthenticationFilter authenticationFilter = new BasicHttpAuthenticationFilter();
//		authenticationFilter.setApplicationName("Base");
//		filters.put("authcBasic", authenticationFilter);
//		shiroFilter.setFilters(filters);
//
//		return shiroFilter;
//	}
	
	@Bean(name = "securityManager")
	public DefaultWebSecurityManager getSecurityManager(){
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
	    securityManager.setRealm(realm());
	    return securityManager;
	}
	
	@Bean(name = "realm")
	@DependsOn("lifecycleBeanPostProcessor")
	public UserRealm realm(){
		UserRealm userRealm = new UserRealm();
		userRealm.setCredentialsMatcher(passwordMatch());
		userRealm.init();
		return userRealm;
	}
	
	@Bean(name = "defaultPasswordService")
	public PasswordService passwordService(){
		return new DefaultPasswordService();
	}
	
	@Bean
	public PasswordMatcher passwordMatch(){
		return new PasswordMatcher();
	}
	
	@Bean
	public LifecycleBeanPostProcessor lifecycleBeanPostProcessor(){
		return new LifecycleBeanPostProcessor();
	}
	
}
