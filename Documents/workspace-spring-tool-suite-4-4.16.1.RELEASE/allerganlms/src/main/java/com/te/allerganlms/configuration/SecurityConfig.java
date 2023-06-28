//package com.te.allerganlms.configuration;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//public class SecurityConfig {
//
////	@Bean
////	AuthenticationProvider provider() {
////		UserDetailsService detailsService = null;
////		BCryptPasswordEncoder encoder = null;
////		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
////		daoAuthenticationProvider.setUserDetailsService(detailsService);
////		daoAuthenticationProvider.setPasswordEncoder(encoder);
////		return daoAuthenticationProvider;
////	}
//
//	// for websecurityconfigureradapter
//
////	@Override
////	protected void configure(HttpSecurity http) throws Exception {
////		http.csrf().disable();
////		http.authorizeRequests().antMatchers("/CUSTOMER/register").permitAll().anyRequest().authenticated();
////
////	}
//
////
////	@Override
////	public void configure(WebSecurity web) throws Exception {
////		web.ignoring().antMatchers("/v2/api-docs", "/configuration/ui", "/swagger-resources/**",
////				"/configuration/security", "/swagger-ui.html", "/webjars/**");
////	}
//
//	// oauth2client
//
//	@Bean
//	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//		http.authorizeRequests().anyRequest().authenticated().and().oauth2Login();
////		http.csrf().disable().authorizeRequests().antMatchers("/CUSTOMER/register").authenticated().and().oauth2Login();
//		return http.build();
//	}
//
//}
