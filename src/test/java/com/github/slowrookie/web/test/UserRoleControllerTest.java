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
public class UserRoleControllerTest extends AbstractTest{

	@Test
	public void getUserRoles(){
		String url = HOST + "userRoles";
		doRequest(url, HttpMethod.GET, null);
	}
	
	@Test
	public void getUsersByRoleId() {
		String url = HOST + "userRoles/users/1";
		doRequest(url, HttpMethod.GET, null);;
	}
	
	@Test
	public void getRolesByUserId() {
		String url = HOST + "userRoles/roles/1";
		doRequest(url, HttpMethod.GET, null);;
	}
	
	@Test
	public void saveUserRole(){
		String url = HOST + "userRoles";
		Map<String, Object> map = new HashMap<>();
		Map<String, String> user = new HashMap<>();
		user.put("id", "1");
		Map<String, String> role = new HashMap<>();
		role.put("id", "1");
		map.put("user", user);
		map.put("role", role);
		doRequest(url, HttpMethod.PUT, map);
	}
	
	@Test
	public void deleteUserRoel(){
		String url = HOST + "userRole/1";
		doRequest(url, HttpMethod.DELETE, null);
	}
	
	@Test
	public void findOne(){
		String url = HOST + "userRole/1";
		doRequest(url, HttpMethod.GET, null);
	}
	
	@Test
	public void saveUserRoles() throws JsonProcessingException{
		String url = HOST + "userRoles";
		List<Object> roles = new ArrayList<>();
		Map<String, Object> map = new HashMap<>();
		Map<String, String> user = new HashMap<>();
		user.put("id", "1");
		Map<String, String> role = new HashMap<>();
		role.put("id", "1");
		map.put("user", user);
		map.put("role", role);
		roles.add(map);
		doRequest(url, HttpMethod.POST, roles);
	}
	
	
}
