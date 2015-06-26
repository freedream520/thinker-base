package com.github.slowrookie.web.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.http.HttpMethod;

import com.github.slowrookie.test.AbstractTest;

/**
 * 测试DepartmentController
 * 
 * @author 刘佳兴
 */
public class DepartmentControllerTest extends AbstractTest{

	@Test
	public void get() throws Exception {
		String url = HOST + "department?page=0&size=10&sort=createdBy";
		doRequest(url, HttpMethod.GET, null);
	}
	
	@Test
	public void save(){
		String url = HOST + "departments";
		
		Map<String, Object> department = new HashMap<>();
		department.put("name", "测试部门");
		department.put("code", "001");
		department.put("parent", null);
		doRequest(url, HttpMethod.PUT, department);
	}
	
	@Test
	public void delete(){
		String url = HOST + "department/1";
		doRequest(url, HttpMethod.DELETE, null);
	}
	
	@Test
	public void findOne(){
		String url = HOST + "department/1";
		doRequest(url, HttpMethod.GET, null);
	}
	
	@Test
	public void saveAll(){
		String url = HOST + "departments";
		List<Object> departments = new ArrayList<>();
		
		Map<String, Object> departments1 = new HashMap<>();
		departments1.put("name", "二级部门");
		departments1.put("code", "00101");
		departments1.put("parent", 1);
		
		Map<String, Object> departments2 = new HashMap<>();
		departments2.put("name", "二级部门01");
		departments2.put("code", "00101");
		departments2.put("parent", 1); 
		
		departments.add(departments1);
		departments.add(departments2);
		
		doRequest(url, HttpMethod.POST, departments);
	}
	
	
}
