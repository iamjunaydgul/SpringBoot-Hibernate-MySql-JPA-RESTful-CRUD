package com.springboot.test.securityconfig;

import javax.servlet.Filter;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.support.ErrorPageFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/* security configuration */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	/* encoded_password string of secret123 :) */
	private static final String ENCODED_PASSWORD = "$2a$10$AIUufK8g6EFhBcumRRV2L.AQNz3Bjp7oDQVFiO5JJMBFZQ6x2/R/2";

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// csrf must be disabled otherwise no post request or send token instead :)
		http.csrf().disable();
		/* using default spring security login page */
		http.authorizeRequests().anyRequest().authenticated().and().formLogin().and().httpBasic();
	}
	/* Encoding password for security reason */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().passwordEncoder(passwordEncoder()).withUser("bcm").password(ENCODED_PASSWORD)
				.roles("USER");
	}
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	/* getting  Cannot forward to error page for request [/edit/1] as the response has already been committed
	 * ErrorPageFilter error*/
	@Bean
	public FilterRegistrationBean<Filter> disableSpringBootErrorFilter(ErrorPageFilter filter) {
	    FilterRegistrationBean<Filter> filterRegistrationBean = new FilterRegistrationBean<>();
	    filterRegistrationBean.setFilter(filter);
	    filterRegistrationBean.setEnabled(false);

	    return filterRegistrationBean;
	}
}
