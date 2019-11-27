package com.sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sample.exception.InvalidNumberOfValuesException;
import com.sample.exception.NoValueException;
import com.sample.service.IncrementService;

/**
 * Represents controller for REST requests. 
 * 
 */
@RestController
public class IncrementController {

	/**
	 * Represents service which is used for processing controller's requests 
	 *
	 */
	@Autowired
	private IncrementService iService;
	
	/**
	  * method to respond to REST request for updating the only record-value of number table
	  * @throws InvalidNumberOfValuesException, NoValueException
	  * @return ResponseEntity of String type 
	  */
	@RequestMapping(value="/updateValue",method = RequestMethod.GET)
	private ResponseEntity<String> updateValue() throws InvalidNumberOfValuesException, NoValueException{
		 return ResponseEntity.status(HttpStatus.CREATED).body(iService.updateValue());
	}
	
	/**
	  * method to respond to REST request for getting the only record-value of number table
	  * @throws InvalidNumberOfValuesException, NoValueException
	  * @return ResponseEntity of String type 
	  */
	@RequestMapping(value="/getValue",method = RequestMethod.GET)
	private ResponseEntity<String> getValue() throws InvalidNumberOfValuesException, NoValueException{
		return ResponseEntity.status(HttpStatus.FOUND).body(iService.getValue());
	}
	
	/**
	  * method to respond to REST request for initializing the only record-value of number table
	  * @return ResponseEntity of String type 
	  */	
	@RequestMapping(value="/resetValue",method = RequestMethod.GET)
	private ResponseEntity<String> initialize(){
		return ResponseEntity.status(HttpStatus.CREATED).body(iService.resetDAO());
	}
}
