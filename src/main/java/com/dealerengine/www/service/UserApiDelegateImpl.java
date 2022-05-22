package com.dealerengine.www.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.dealerengine.www.api.UsersApiDelegate;
import com.dealerengine.www.exception.ApplicationError;
import com.dealerengine.www.exception.Validation;
import com.dealerengine.www.model.AdminUser;
import com.dealerengine.www.model.SignInRequest;
import com.dealerengine.www.model.Token;
import com.dealerengine.www.repository.AdminUserRepository;

@Service
public class UserApiDelegateImpl implements UsersApiDelegate {
	
	@Autowired
	private Validation validation;
	
	@Autowired
	private AdminUserRepository adminUserRepository;

	@Override
	public ResponseEntity<Token> adminUserSignIn(SignInRequest signInRequest) {
		// TODO Auto-generated method stub
		return UsersApiDelegate.super.adminUserSignIn(signInRequest);
	}

	@Override
	public ResponseEntity<AdminUser> adminUserSignUp(AdminUser adminUser) {
		validation.ensureFieldNotNull(adminUser.getFirstName(), "firstName");
		validation.ensureFieldNotNull(adminUser.getLastName(), "lastName");
		validation.ensureFieldNotNull(adminUser.getEmailAddress(), "emailAddress");
		validation.ensureEmailAddressIsValid(adminUser.getEmailAddress(), "emailAddress");
		validation.ensureFieldNotNull(adminUser.getUserName(), "userName");
		validation.ensureFieldNotNull(adminUser.getPassword(), "password");
		
		if(adminUserRepository.findByUserName(adminUser.getUserName()) != null)
			throw new ApplicationError(ApplicationError.ErrorType.badRequest, "userName", "userName [" + adminUser.getUserName() + "] already exists");
		
		if(adminUserRepository.findByEmailAddress(adminUser.getEmailAddress()) != null)
			throw new ApplicationError(ApplicationError.ErrorType.badRequest, "emailAddress", "emailAddress [" + adminUser.getEmailAddress() + "] already exists");
		
		adminUserRepository.save(adminUser);
		
		return new ResponseEntity<AdminUser>(adminUser, HttpStatus.OK);
	}

}
