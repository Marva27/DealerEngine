package com.dealerengine.www.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.dealerengine.www.model.AdminUser;

public interface AdminUserRepository extends MongoRepository<AdminUser, String> {
	
	public AdminUser findByUserName(String userName);
	public AdminUser findByEmailAddress(String emailAddress);

}
