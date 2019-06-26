/**
 * 
 */
package org.com.data.controller;

import org.com.data.exception.AdminErrorResponce;
import org.com.data.exception.AdminNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author sanjsingh
 *
 */

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(AdminNotFoundException.class)
	public ResponseEntity<AdminErrorResponce> handleException(AdminNotFoundException adminNotFound) {

		AdminErrorResponce error = new AdminErrorResponce();
		error.setErrorMessage(error.getErrorMessage());
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setTimeSt(System.currentTimeMillis());

		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<AdminErrorResponce> handleAllException(Exception adminNotFound) {

		AdminErrorResponce error = new AdminErrorResponce();
		error.setErrorMessage(error.getErrorMessage());
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setTimeSt(System.currentTimeMillis());

		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);

	}

}
