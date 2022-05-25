package com.dealerengine.www.exception;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

@Component
public class Validation {

	public void ensureFieldNotNull(Object value, String fieldId) {
		if(value == null || value.toString().trim().equals(""))
			throw new ApplicationError(ApplicationError.ErrorType.badRequest, fieldId, fieldId + " cannot be empty");
	}
	
	public void ensureFieldNotZero(Object value, String fieldId) {
		if((int) value == 0)
			throw new ApplicationError(ApplicationError.ErrorType.badRequest, fieldId, fieldId + " cannot be zero");
	}
	
	public void ensureEmailAddressIsValid(Object value, String fieldId) {
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
		Pattern pattern = Pattern.compile(emailRegex);
		if(!pattern.matcher(value.toString()).matches())
			throw new ApplicationError(ApplicationError.ErrorType.badRequest, fieldId, value + " is invalid");
	}
}
