package com.github.slowrookie.web.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.http.HttpMethod;

import com.github.slowrookie.test.AbstractTest;

/**
 * 测试MenuController
 * 
 * @author 刘佳兴
 */
public class MenuControllerTest extends AbstractTest{

	@Test
	public void getMenus() throws Exception {
		String url = HOST + "menus?page=0&size=10&sort=createdBy";
		doRequest(url, HttpMethod.GET, null);
	}
	
	@Test
	public void saveMenu(){
		String url = HOST + "menus";
		
		Map<String, Object> menu = new HashMap<>();
		menu.put("name", "一级菜单");
		menu.put("resource", "");
		menu.put("parent", null);
		doRequest(url, HttpMethod.PUT, menu);
	}
	
	@Test
	public void deleteMenu(){
		String url = HOST + "menu/1";
		doRequest(url, HttpMethod.DELETE, null);
	}
	
	@Test
	public void findOne(){
		String url = HOST + "menu/1";
		doRequest(url, HttpMethod.GET, null);
	}
	
	@Test
	public void saveUsers(){
		String url = HOST + "menus";
		List<Object> menus = new ArrayList<>();
		
		Map<String, Object> parent = new HashMap<>();
		parent.put("id", 1);
		
		Map<String, Object> menu1 = new HashMap<>();
		menu1.put("name", "二级菜单");
		menu1.put("resource", "");
		menu1.put("parent", parent); 
		
		menus.add(menu1);
		
		doRequest(url, HttpMethod.POST, menus);
	}
	
	
}
