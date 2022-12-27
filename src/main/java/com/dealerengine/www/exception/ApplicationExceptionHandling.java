package com.dealerengine.www.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import com.dealerengine.www.model.Failure;

@ControllerAdvice
public class ApplicationExceptionHandling extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = {RuntimeException.class})
	public ResponseEntity<Failure> handleApplicationException(RuntimeException ex) {
		String errorId = null;
		String errorDescription = null;
		HttpStatus httpStatus = null;
		
		if(ex instanceof ApplicationError) {
			errorId = ((ApplicationError) ex).getErrorId();
			errorDescription = ((ApplicationError) ex).getMessage();
		}
		
		if(errorId.startsWith(ApplicationError.ErrorType.bad_request.toString()))
			httpStatus = HttpStatus.BAD_REQUEST;
		
		Failure error = new Failure();
		error.setErrorId(errorId);
		error.setErrorDescription(errorDescription);
		
		return new ResponseEntity<Failure>(error, httpStatus);
	}
}
