package com.sample.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Represents controller to handle error-redirects
 *
 */
@Controller
public class CustomErrorController implements ErrorController  {
 
	/**
	 * method to customize the output of WhiteLabel error page
	 *@return ResponseEntity
	 */
    @RequestMapping("/error")
    public ResponseEntity<String> handleError() {
    	return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Application-error or Invalid URL");
    }
 
    /**
	 * over-ridden method to change the output of WhiteLabel error page
	 *@return String
	 */
    @Override
    public String getErrorPath() {
        return "/error";
    }
}