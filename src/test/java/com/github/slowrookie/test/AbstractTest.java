package com.github.slowrookie.test;

import static org.junit.Assert.assertEquals;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.codec.Base64;
import org.junit.Before;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 使用RestTemplate做单元测试
 * 
 * @author 刘佳兴
 */
public class AbstractTest {
	
	protected static final String HOST = "http://localhost:8081/";
	
	protected ObjectMapper mapper = new ObjectMapper();
		
	protected final RestTemplate rest = new RestTemplate();
	
	protected HttpHeaders httpHeaders = getHttpHeaders();

	protected HttpHeaders getHttpHeaders() {
		HttpHeaders httpHeaders = new HttpHeaders();
		
		//用户校验
		String auth = "liujx" + ":" + "8888";
		byte[] bytes = Base64.encode(auth.getBytes());
		String authHeader = "Basic " + new String(bytes);
		httpHeaders.set("Authorization", authHeader);
		
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		List<MediaType> mediaTypes = new ArrayList<>();
		mediaTypes.add(MediaType.APPLICATION_JSON);
		httpHeaders.setAccept(mediaTypes);
		return httpHeaders;
	}
	
	/**
	 * 关于请求/接受中文乱码的问题
	 * 模式是 StandardCharsets.ISO_8859_1
	 */
	@Before
	public void setup() {
		rest.getMessageConverters().add(0, new StringHttpMessageConverter(StandardCharsets.UTF_8));
	}
	
	protected void doRequest(String url, HttpMethod httpMethod, Object obj){
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
