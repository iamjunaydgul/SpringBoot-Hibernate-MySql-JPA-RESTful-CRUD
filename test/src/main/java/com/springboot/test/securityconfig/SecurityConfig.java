package com.springboot.test.securityconfig;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// Note:
		// Use this to enable the tomcat basic authentication (tomcat popup rather than
		// spring login page)
		// Note that the CSRf token is disabled for all requests (change it as you
		// wish...)
		// csrf must be disabled otherwise no post request or send token instead :)
		http.csrf().disable();
	}
}
