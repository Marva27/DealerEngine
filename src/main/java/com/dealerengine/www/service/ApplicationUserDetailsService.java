package com.dealerengine.www.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.dealerengine.www.model.AdminUser;
import com.dealerengine.www.repository.AdminUserRepository;

@Service
public class ApplicationUserDetailsService implements UserDetailsService{

	@Autowired
	private AdminUserRepository adminUserRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		AdminUser adminUser = adminUserRepository.findByUserName(username);
		return new User(adminUser.getUserName(), adminUser.getPassword(), new ArrayList<>());
	}

}
