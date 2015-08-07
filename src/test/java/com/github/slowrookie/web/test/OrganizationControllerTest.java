package com.github.slowrookie.web.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.http.HttpMethod;

import com.github.slowrookie.test.AbstractTest;

/**
 * 测试OrganizationController
 * 
 * @author 刘佳兴
 */
public class OrganizationControllerTest extends AbstractTest{

	@Test
	public void get() throws Exception {
		String url = HOST + "organizations?page=0&size=10&sort=createdBy";
		doRequest(url, HttpMethod.GET, null);
	}
	
	@Test
	public void save(){
		String url = HOST + "organizations"; 
		
		Map<String, Object> menu = new HashMap<>();
		menu.put("name", "一级组织");
		menu.put("code", "001");
		menu.put("parent", null);
		doRequest(url, HttpMethod.PUT, menu);
	}
	
	@Test
	public void delete(){
		String url = HOST + "organization/2";
		doRequest(url, HttpMethod.DELETE, null);
	}
	
	@Test
	public void findOne(){
		String url = HOST + "organization/1";
		doRequest(url, HttpMethod.GET, null);
	}
	
	@Test
	public void saveAll(){
		String url = HOST + "organizations";
		List<Object> organizations = new ArrayList<>();
		
		Map<String, Object> organization1 = new HashMap<>();
		organization1.put("name", "二级组织");
		organization1.put("code", "00101");
		organization1.put("parent", 1);
		
		Map<String, Object> organization2 = new HashMap<>();
		organization2.put("name", "二级组织01");
		organization2.put("code", "00102");
		organization2.put("parent", 1); 
		
		organizations.add(organization1);
		organizations.add(organization2);
		
		doRequest(url, HttpMethod.POST, organizations);
	}
	
	
}
