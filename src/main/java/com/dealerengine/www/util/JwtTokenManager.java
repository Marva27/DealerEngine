package com.dealerengine.www.util;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.dealerengine.www.model.AdminUser;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtTokenManager implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static long TOKEN_VALIDITY = 10 * 60 * 60;
	
	private String secretKey = "BabyAvanthika@27";
	
	public String generateToken(UserDetails userDetails) {
		Map<String, Object> claims = new HashMap<String, Object>();
		return Jwts.builder()
				.setClaims(claims)
				.setSubject(userDetails.getUsername())
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + TOKEN_VALIDITY * 1000))
				.signWith(SignatureAlgorithm.HS256, secretKey).compact();	
	}
	
	public String getUserNameFromToken(String token) {
		Claims claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJwt(token).getBody();
		return claims.getSubject();
	}
	
	public Boolean isTokenExpired(String token, UserDetails userDetails) {
		String userName = getUserNameFromToken(token);
		Claims claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJwt(token).getBody();
		Boolean isTokenValid = claims.getExpiration().before(new Date(System.currentTimeMillis()));
		return (isTokenValid && userDetails.getUsername().equals(userName));
	}

}
