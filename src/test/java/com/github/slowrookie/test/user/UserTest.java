package com.github.slowrookie.test.user;

import static org.junit.Assert.assertEquals;

import java.sql.Timestamp;

import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.github.slowrookie.entity.User;
import com.github.slowrookie.test.AbstractTest;

public class UserTest extends AbstractTest{

	@Test
	public void getUsers() throws Exception {
		
		String url = HOST + "users?page=0&size=10&sort=createdBy";
		url += "&loginName=liujx";
		
		ResponseEntity<String> response = rest.exchange(url, HttpMethod.GET, 
				new HttpEntity<>( httpHeaders), String.class);
		
		assertEquals(HttpStatus.OK, response.getStatusCode());
		
		System.out.println(response.getBody());
		
	}
	
	@Test
	public void saveUser(){
		String url = HOST + "users";
		
		User user = new User("liujx", "刘","佳兴", "3", 1, "liujiaxingemail@gmail.com", "17092080066", "00000000");
		user.setId(1L);
		Timestamp d = new Timestamp(System.currentTimeMillis()); 
		user.setActivity(1);
		user.setCreatedBy(1L);
		user.setCreationDate(d);
		user.setLastUpdateBy(1L);
		user.setLastUpdateDate(d);
		
		ResponseEntity<String> response = rest.exchange(url, HttpMethod.PUT, 
				new HttpEntity<>(user, httpHeaders), String.class);
		
		assertEquals(HttpStatus.OK, response.getStatusCode());
		
		System.out.println(response.getBody());
		
	}
	
}
