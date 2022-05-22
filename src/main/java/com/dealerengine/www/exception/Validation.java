package com.dealerengine.www.exception;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

@Component
public class Validation {

	public void ensureFieldNotNull(Object value, String fieldId) {
		if(value == null || value.toString().trim().equals(""))
			throw new ApplicationError(ApplicationError.ErrorType.badRequest, fieldId, fieldId + " cannot be empty");
	}
	
	public void ensureEmailAddressIsValid(Object value, String fieldId) {
		if(!Pattern.compile("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\\\.[A-Za-z0-9-]+)*(\\\\.[A-Za-z]{2,})$").matcher(value.toString()).matches())
			throw new ApplicationError(ApplicationError.ErrorType.badRequest, fieldId, value + " is invalid");
	}
}
