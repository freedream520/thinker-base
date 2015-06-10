package com.github.slowrookie.test;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 
 * @author liujiaxing
 *
 */
public class AbstractTest {
	
	protected static final String HOST = "http://localhost:8081/";
	
	protected ObjectMapper mapper = new ObjectMapper();
		
	protected final RestTemplate rest = new RestTemplate();
	
	protected HttpHeaders httpHeaders = getHttpHeaders();

	protected HttpHeaders getHttpHeaders() {
		HttpHeaders httpHeaders = new HttpHeaders();
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
	

}
