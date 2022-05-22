package com.dealerengine.www.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import com.dealerengine.www.model.Error;

@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(value= {RuntimeException.class})
	public ResponseEntity<Error> handleApplicationExceptions(RuntimeException e) {
		
		String id = null;
		String message = null;
		HttpStatus httpStatus = null;
		
		if(e instanceof ApplicationError) {
			id = ((ApplicationError) e).getErrorId();
			message = ((ApplicationError) e).getErrorMessage();
		}
		
		if(id.startsWith(ApplicationError.ErrorType.badRequest.toString()))
			httpStatus = HttpStatus.BAD_REQUEST;
		
		Error error = new Error();
		error.setId(id);
		error.setMessage(message);
		
		return new ResponseEntity<Error>(error, httpStatus);
	}
}
