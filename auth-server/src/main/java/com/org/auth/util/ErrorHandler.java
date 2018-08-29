package com.org.auth.util;

import javax.security.sasl.AuthenticationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.org.auth.model.ErrorDetails;

@ControllerAdvice
public class ErrorHandler {

	private final Logger log = LoggerFactory.getLogger(ErrorHandler.class);

	@ExceptionHandler(Exception.class)
	public @ResponseBody ErrorDetails processValidationError(Exception e) {
		log.info("Error Occured", e.getMessage());
		ErrorDetails error = new ErrorDetails();
		if(e instanceof AuthenticationException){
			error.setErrorCode("401");
			error.setErrorDesc(e.getMessage());
		}
		else if (e.getMessage()!=null) {
			error.setErrorCode("500");
			error.setErrorDesc(e.getMessage());
		} else {
			error.setErrorCode("500");
			error.setErrorDesc("System is currently unavailable, please try after sometime.");
		}
		return error;
	}
}
