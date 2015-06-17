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
public class RoleControllerTest extends AbstractTest{

	@Test
	public void getRoles() throws Exception {
		String url = HOST + "roles";
		doRequest(url, HttpMethod.GET, null);
	}
	
	@Test
	public void saveRole(){
		String url = HOST + "roles";
		Map<String, String> map = new HashMap<>();
		map.put("name", "主管权限");
		doRequest(url, HttpMethod.PUT, map);
	}
	
	@Test
	public void deleteRoel(){
		String url = HOST + "role/1";
		doRequest(url, HttpMethod.DELETE, null);
	}
	
	@Test
	public void findOne(){
		String url = HOST + "role/1";
		doRequest(url, HttpMethod.GET, null);
	}
	
	@Test
	public void saveRoles() throws JsonProcessingException{
		String url = HOST + "roles";
		List<Object> roles = new ArrayList<>();
		Map<String, String> map = new HashMap<>();
		map.put("name", "主管权限1");
		Map<String, String> map2 = new HashMap<>();
		map2.put("name", "主管权限2");
		roles.add(map);
		roles.add(map2);
		doRequest(url, HttpMethod.POST, roles);
	}
	
	
}
