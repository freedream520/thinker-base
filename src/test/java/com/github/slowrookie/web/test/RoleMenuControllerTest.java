package com.github.slowrookie.web.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.http.HttpMethod;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.slowrookie.test.AbstractTest;

/**
 * 测试UserController
 * 
 * @author 刘佳兴
 */
public class RoleMenuControllerTest extends AbstractTest{

	@Test
	public void getRoleMenus(){
		String url = HOST + "roleMenus";
		doRequest(url, HttpMethod.GET, null);
	}
	
	@Test
	public void getRolesByMenu() {
		String url = HOST + "roleMenus/menu/1";
		doRequest(url, HttpMethod.GET, null);;
	}
	
	@Test
	public void getMenusByRoleId() {
		String url = HOST + "roleMenus/role/1";
		doRequest(url, HttpMethod.GET, null);;
	}
	
	@Test
	public void saveRoleMenu(){
		String url = HOST + "roleMenus";
		Map<String, Object> map = new HashMap<>();
		
		Map<String, String> menu = new HashMap<>();
		menu.put("id", "1");
		
		Map<String, String> role = new HashMap<>();
		role.put("id", "1");
		
		map.put("menu", menu);
		map.put("role", role);
		
		doRequest(url, HttpMethod.PUT, map);
	}
	
	@Test
	public void deleteRoelMenu(){
		String url = HOST + "roleMenu/1";
		doRequest(url, HttpMethod.DELETE, null);
	}
	
	@Test
	public void findOne(){
		String url = HOST + "roleMenu/1";
		doRequest(url, HttpMethod.GET, null);
	}
	
	@Test
	public void save() throws JsonProcessingException{
		String url = HOST + "roleMenus";
		
		List<Object> roles = new ArrayList<>();
		
		Map<String, Object> map = new HashMap<>();
		
		Map<String, String> menu = new HashMap<>();
		menu.put("id", "1");
		
		Map<String, String> role = new HashMap<>();
		role.put("id", "1");
		
		map.put("menu", menu);
		map.put("role", role);
		
		roles.add(map);
		doRequest(url, HttpMethod.POST, roles);
	}

	
	@Test
	public void findMenuByUserId() {
		String url = HOST + "/roleMenus/user/1";
		doRequest(url, HttpMethod.GET, null);
	}
	
	
}
