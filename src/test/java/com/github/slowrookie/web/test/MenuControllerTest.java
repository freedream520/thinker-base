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
	public void getMenuTree() {
		String url = HOST + "menus/tree";
		doRequest(url, HttpMethod.GET, null);
	}
	
	@Test
	public void save(){
		String url = HOST + "menus";
		
		Map<String, Object> menu = new HashMap<>();
		menu.put("name", "一级菜单");
		menu.put("code", "001");
		menu.put("hiberarchy", "001");
		menu.put("resource", "/menus0");
		menu.put("parent", "0");
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
	public void saveAll(){
		String url = HOST + "menus";
		List<Object> menus = new ArrayList<>();
		
		
		Map<String, Object> menu1 = new HashMap<>();
		menu1.put("name", "二级菜单");
		menu1.put("code", "002");
		menu1.put("hiberarchy", "001.002");
		menu1.put("resource", "/menus0/1");
		menu1.put("parent", 1);
		
		Map<String, Object> menu2 = new HashMap<>();
		menu2.put("name", "三级菜单01");
		menu2.put("code", "003");
		menu2.put("hiberarchy", "001.002.003");
		menu2.put("resource", "/menus/1/2");
		menu2.put("parent", 1); 
		
		menus.add(menu1);
		menus.add(menu2);
		
		doRequest(url, HttpMethod.POST, menus);
	}
	
	
}
