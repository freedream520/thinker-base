package com.github.slowrookie.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;

@Configuration
@EnableWebSecurity
@EnableWebMvcSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Bean
	public AuthenticationProvider authenticationProvider(){
		return new BasicAuthenticationProvider();
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		//设置不拦截的资源
		web.ignoring().antMatchers("/*.ico");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authenticationProvider(authenticationProvider())
			.csrf().disable()
			.authorizeRequests()
				.anyRequest().authenticated()
				.and()
			.httpBasic();
	}
	
	
}
