package com.te.ecommerce.springsecurity;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
@EnableWebSecurity
@Configuration
public class WebConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/").permitAll().anyRequest().authenticated().and().httpBasic();
		http.authorizeHttpRequests().anyRequest().authenticated().and().httpBasic();
		
		
	
	}
@Override
protected UserDetailsService userDetailsService() {
	UserDetails yaminiuser=User.builder().username("yamini.m").password("Ilove myfriend$").roles("ADMIN").build();
	 return new InMemoryUserDetailsManager(yaminiuser);
}
}
