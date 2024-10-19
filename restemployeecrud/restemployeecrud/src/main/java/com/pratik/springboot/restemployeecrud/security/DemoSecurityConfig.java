package com.pratik.springboot.restemployeecrud.security;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DemoSecurityConfig {
	
	
	@Bean
	public UserDetailsManager userDetails(DataSource dataSource) {
		
		JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
		
		jdbcUserDetailsManager.setUsersByUsernameQuery("select user_id,pw, active from members where user_id=?");
		
		jdbcUserDetailsManager.setAuthoritiesByUsernameQuery("select user_id,role from roles where user_id=?");
		
		return jdbcUserDetailsManager; 
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		
		http.authorizeHttpRequests(configurer->configurer.requestMatchers(HttpMethod.GET,"/api/employee").hasRole("EMPLOYEE")
		.requestMatchers(HttpMethod.GET,"/api/employee/**").hasRole("EMPLOYEE")
		.requestMatchers(HttpMethod.POST,"/api/employee").hasRole("MANAGER")
		.requestMatchers(HttpMethod.PUT,"/api/employee").hasRole("MANAGER")
		.requestMatchers(HttpMethod.DELETE,"/api/employee/**").hasRole("ADMIN"));
		
		http.httpBasic(Customizer.withDefaults());
		http.csrf(csrf->csrf.disable());
		
		return http.build();
	} 


//	@Bean
//	public InMemoryUserDetailsManager userDetailsManager() {
//		UserDetails pratik = User.builder().username("pratik").password("{noop}pratik123").roles("EMPLOYEE").build();
//		
//		UserDetails shushil = User.builder().username("shushil").password("{noop}shushil123").roles("EMPLOYEE","MANAGER").build();
//		
//		UserDetails shivam = User.builder().username("shivam").password("{noop}shivam123").roles("EMPLOYEE","MANAGER","ADMIN").build();
//		
//		return new InMemoryUserDetailsManager(pratik,shushil,shivam);
//	}

}
