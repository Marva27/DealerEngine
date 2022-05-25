package com.dealerengine.www.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.dealerengine.www.service.ApplicationUserDetailsService;

@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private ApplicationUserDetailsService applicationUserDetailsService;
	
	private String[] URLS_ALLOWED = {"/resources/**",
			"/users/**",
    		"/static/**", 
    		"/css/**",
    		"/js/**",
    		"/images/**",
    		"/v3/api-docs/**",
            "/configuration/ui",
            "/swagger-resources/**",
            "/configuration/security",
            "/swagger-ui/**",
            "/webjars/**",
            "/localhost/**"};

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(applicationUserDetailsService);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		 http.csrf().disable()
	        .authorizeRequests()
	        .antMatchers(URLS_ALLOWED).permitAll()
	        .anyRequest().authenticated();
	}
	
	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		// TODO Auto-generated method stub
		return super.authenticationManagerBean();
	}
}
