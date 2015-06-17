package com.github.slowrookie.test.user;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;

import com.github.slowrookie.persistence.entity.User;
import com.github.slowrookie.test.AbstractTest;

public class UserControllerTest extends AbstractTest{

	@Test
	public void getUsers() throws Exception {
		String url = HOST + "users?page=0&size=10&sort=createdBy0";
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
		User user = new User("liujx", "刘","佳兴", "3", 1, "liujiaxingemail@gmail.com", "17092080066", "00000000");
		User user1 = new User("liujx", "刘","佳兴", "3", 1, "liujiaxingemail@gmail.com", "17092080066", "00000000");
		users.add(user);
		users.add(user1);
		doRequest(url, HttpMethod.POST, users);
	}
	
	private void doRequest(String url, HttpMethod httpMethod, Object obj){
		try {
			ResponseEntity<String> response = rest.exchange(url, httpMethod, 
					new HttpEntity<>(obj, httpHeaders), String.class);
			
			assertEquals(HttpStatus.OK, response.getStatusCode());
			
			System.out.println(response.getBody());
		} catch (HttpClientErrorException e) {
			System.out.println(e.getResponseBodyAsString());
		}
	}
	
}
