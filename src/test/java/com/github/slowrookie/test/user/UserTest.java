package com.github.slowrookie.test.user;

import static org.junit.Assert.assertEquals;

import org.joda.time.DateTime;
import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;

import com.github.slowrookie.persistence.entity.User;
import com.github.slowrookie.test.AbstractTest;

public class UserTest extends AbstractTest{

	@Test
	public void getUsers() throws Exception {
		
		String url = HOST + "users?page=0&size=10&sort=createdBy";
		url += "&loginName=liujx";
		try{
			ResponseEntity<String> response = rest.exchange(url, HttpMethod.GET, 
					new HttpEntity<>( httpHeaders), String.class);
			
			assertEquals(HttpStatus.OK, response.getStatusCode());
			
			System.out.println(response.getBody());
		}catch (HttpClientErrorException e){
			//接受异常信息，并告知调用者
			System.out.println(e.getResponseBodyAsString());
		}
		
	}
	
	@Test
	public void saveUser(){
		String url = HOST + "users";
		
		User user = new User("liujx", "刘","佳兴", "3", 1, "liujiaxingemail@gmail.com", "17092080066", "00000000");
		user.setActivity(1);
		user.setCreatedBy(1L);
		user.setCreatedDate(new DateTime().toDate());
		user.setLastModifiedBy(1L);
		user.setLastModifiedDate(new DateTime().toDate());
		
		
		try {
			ResponseEntity<String> response = rest.exchange(url, HttpMethod.PUT, 
					new HttpEntity<>(user, httpHeaders), String.class);
			
			assertEquals(HttpStatus.OK, response.getStatusCode());
			
			System.out.println(response.getBody());
		} catch (HttpClientErrorException e) {
			System.out.println(e.getResponseBodyAsString());
		}
		
	}
	
}
