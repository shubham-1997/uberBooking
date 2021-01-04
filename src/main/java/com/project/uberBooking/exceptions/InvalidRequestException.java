package com.project.uberBooking.exceptions;

/**
 * Exception thrown when the request is invalid
 *
 */
public class InvalidRequestException extends Exception{

	private static final long serialVersionUID = -6129175031163502327L;
	
	public InvalidRequestException(String msg){
		super(msg);
	}

}
