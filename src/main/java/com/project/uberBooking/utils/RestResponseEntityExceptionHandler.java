package com.project.uberBooking.utils;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpStatusCodeException;

import lombok.Data;

@RestControllerAdvice
public class RestResponseEntityExceptionHandler {
	
	/**
	 * All the exceptions thrown in the application will be handled here
	 * @param exception
	 * @param request
	 * @param response
	 * @return responseEntity
	 * @throws IOException
	 */
	@ExceptionHandler({ 
		HttpStatusCodeException.class,
		Exception.class})
	protected ResponseEntity<RestResponseExceptionEntity> handleRestExceptions(Exception exception, HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		
		RestResponseExceptionEntity responseEntity = new RestResponseExceptionEntity();
		responseEntity.setTimestamp(new Date());
		responseEntity.setMessage(exception.getMessage());
		if (exception instanceof HttpStatusCodeException) {
			// HTTP Status Code: XXX
			setResponseEntityHTTPStatusCodeDetails(responseEntity, ((HttpStatusCodeException) exception).getStatusCode());
			return new ResponseEntity<RestResponseExceptionEntity>(responseEntity, ((HttpStatusCodeException) exception).getStatusCode());
		} else {
			// HTTP Status Code: 500
			if(responseEntity.getMessage() == null || responseEntity.getMessage().isEmpty()) {
				responseEntity.setMessage("The application has encountered an unknown error.");
			}
			setResponseEntityHTTPStatusCodeDetails(responseEntity, HttpStatus.INTERNAL_SERVER_ERROR);
			return new ResponseEntity<RestResponseExceptionEntity>(responseEntity, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
		
	/**
	 * Sets up the HTTP Status details in the responseEntity based on the status
	 * @param responseEntity
	 * @param status
	 */
	protected void setResponseEntityHTTPStatusCodeDetails(RestResponseExceptionEntity responseEntity,
			HttpStatus status) {
		switch (status) {
		case UNAUTHORIZED:
			responseEntity.setError(HttpStatus.UNAUTHORIZED.getReasonPhrase());
			responseEntity.setStatus(HttpStatus.UNAUTHORIZED.value());
			break;
		case FORBIDDEN:
			responseEntity.setError(HttpStatus.FORBIDDEN.getReasonPhrase());
			responseEntity.setStatus(HttpStatus.FORBIDDEN.value());
			break;
		case NOT_FOUND:
			responseEntity.setError(HttpStatus.NOT_FOUND.getReasonPhrase());
			responseEntity.setStatus(HttpStatus.NOT_FOUND.value());
			break;
		default:
			responseEntity.setError(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
			responseEntity.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			break;
		}
	}
	
	@Data
	private class RestResponseExceptionEntity {
		Date timestamp;
		int status;
		String error;
		String message;
	}

}