package com.cg.capcafe.exception;

/**
 * Exception class for No Food Item found. This exception is thrown whenever the result returns empty
 * list of food items when searched based on some criteria.
 * @author Akash Verma
 *
 */
public class FoodItemNotFoundException extends Exception{

	public FoodItemNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FoodItemNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public FoodItemNotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public FoodItemNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public FoodItemNotFoundException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}
