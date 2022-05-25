package com.dealerengine.www.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import com.dealerengine.www.service.ApplicationUserDetailsService;
import com.dealerengine.www.util.JwtTokenManager;

public class ApplicationSecurityFilter extends OncePerRequestFilter {

	@Autowired
	private JwtTokenManager jwtTokenManager;
	
	@Autowired
	private ApplicationUserDetailsService applicationUserDetailsService;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		final String authorizationHeader = request.getHeader("Authorization");
		
		String userName = null;
		String jwt = null;
		
		if(authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
			jwt = authorizationHeader.substring(7);
			userName = jwtTokenManager.getUserNameFromToken(jwt);
		}
		
		if(userName != null && SecurityContextHolder.getContext().getAuthentication() == null) {
			UserDetails userDetails = applicationUserDetailsService.loadUserByUsername(userName);
			if(jwtTokenManager.isTokenExpired(jwt, userDetails)) {
				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
				usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
			}
		}
	}

}
