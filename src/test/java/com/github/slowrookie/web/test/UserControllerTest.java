package com.github.slowrookie.web.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.http.HttpMethod;

import com.github.slowrookie.persistence.entity.User;
import com.github.slowrookie.test.AbstractTest;

/**
 * 测试UserController
 * 
 * @author 刘佳兴
 */
public class UserControllerTest extends AbstractTest{

	@Test
	public void getUsers() throws Exception {
		String url = HOST + "users?page=0&size=10&sort=createdBy";
		url += "&loginName=liujx";
		doRequest(url, HttpMethod.GET, null);
	}
	
	@Test
	public void saveUser(){
		String url = HOST + "users";
		User user = new User("liujx", "刘","佳兴", "3", 1, "liujiaxingemail@gmail.com", "17092080066", "00000000");
		doRequest(url, HttpMethod.PUT, user);
	}
	
	@Test
	public void deleteUser(){
		String url = HOST + "user/1";
		doRequest(url, HttpMethod.DELETE, null);
	}
	
	@Test
	public void findOne(){
		String url = HOST + "user/1";
		doRequest(url, HttpMethod.GET, null);
	}
	
	@Test
	public void saveUsers(){
		String url = HOST + "users";
		List<User> users = new ArrayList<>();
		User user = new User("liujx1", "刘","佳兴", "3", 1, "liujiaxingemail@gmail.com", "17092080066", "00000000");
		User user1 = new User("liujx2", "刘","佳兴", "3", 1, "liujiaxingemail@gmail.com", "17092080066", "00000000");
		users.add(user);
		users.add(user1);
		doRequest(url, HttpMethod.POST, users);
	}
	
	
}
