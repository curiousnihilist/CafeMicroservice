package com.cg.capcafe.exception;

/**
 * Exception class for No Cafe found. This exception is thrown whenever the result returns empty
 * list of cafe's when searched based on some criteria.
 * @author Akash Verma
 *
 */
public class CafeNotFoundException extends Exception {

	public CafeNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CafeNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public CafeNotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public CafeNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public CafeNotFoundException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
	

}
