package com.dealerengine.www.exception;

public class ApplicationError extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String errorId;
	public enum ErrorType {bad_request,  server_error, functional_error};
	
	public ApplicationError(ErrorType errorType, String errorId, String errorMessage) {
		super(errorMessage);
		this.errorId = generateErrorId(errorType, errorId);
	}
	
	public ApplicationError(ErrorType errorType, String errorId, String errorMessage, Throwable e) {
		super(errorMessage, e);
		this.errorId = generateErrorId(errorType, errorId);
	}
	
	public String getErrorId() {
		return this.errorId;
	}
	
	public String getErrorMessage() {
		return super.getMessage();
	}
	
	private String generateErrorId(ErrorType errorType, String errorId) {
		if(errorType.toString() != null && errorId != null)
			return errorType.toString() + "|" + errorId;
		else if(errorType.toString() == null && errorId != null)
			return errorId;
		else if(errorType.toString() != null && errorId == null)
			return errorType.toString();
		else
			return null;
	}

}
