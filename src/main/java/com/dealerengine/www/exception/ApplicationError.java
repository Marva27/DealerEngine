package com.dealerengine.www.exception;

public class ApplicationError extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public enum ErrorType {badRequest, securityError, functionalError, serverError};
	
	private String errorId;
	
	public String getErrorId() {
		return errorId;
	}

	public void setErrorId(String errorId) {
		this.errorId = errorId;
	}
	
	public String getErrorMessage() {
		return super.getMessage();
	}

	public ApplicationError(ErrorType errorType, String errorId, String errorMessage) {
		super(errorMessage);
		this.errorId = generateErrorId(errorType, errorId);
	}
	
	public ApplicationError(ErrorType errorType, String errorId, String errorMessage, Throwable e) {
		super(errorMessage, e);
		this.errorId = generateErrorId(errorType, errorId);
	}

	private String generateErrorId(ErrorType errorType, String errorId) {
		if(errorType == null && errorId != null)
			return errorId;
		else if(errorType != null && errorId == null)
			return errorType.toString();
		else if(errorType != null && errorId != null)
			return errorType.toString() + "|" + errorId;
		else
			return null;
	}

}
