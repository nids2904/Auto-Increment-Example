package com.sample.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 
 * Represents Exception Handler for the application
 */
@ControllerAdvice
public class ExceptionHandlerAdvice {

	/**
	 * method to handle NoValueException
	 * @param NoValueException
	 * @return ResponseEntity
	 */
	@ExceptionHandler(NoValueException.class)
    public ResponseEntity<String> handleException1(NoValueException e) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body("No value found in the data-table.");
    } 
	
	/**
	 * method to handle InvalidNumberOfValuesException
	 * @param InvalidNumberOfValuesException
	 * @return ResponseEntity
	 */
	@ExceptionHandler(InvalidNumberOfValuesException.class)
    public ResponseEntity<String> handleException2(InvalidNumberOfValuesException e) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body("More than one value found in the data-table.");
    }
	
}
