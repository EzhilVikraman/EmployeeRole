package com.compass;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.compass.customexception.ConstraintViolated;

@ControllerAdvice
public class AbstractController {
	 @ExceptionHandler(com.compass.customexception.DuplicateEntry.class)
	  @ResponseBody
	  //public ResponseEntity<ErrorResource> duplicateEntry(
	  public String duplicateEntry( 
	  HttpServletRequest req, Exception e) {
	   ErrorResource error = new ErrorResource();
	   error.setStatus(HttpStatus.BAD_REQUEST);
	   error.setErrorCode(HttpStatus.BAD_REQUEST.value());
	   error.setErrorMsg("User already exist");

/*
	   return new ResponseEntity<ErrorResource>(error,
	     HttpStatus.BAD_REQUEST);*/
	   return "USER NAME EXIST";
	  }

	 
	 @ExceptionHandler(com.compass.customexception.ConstraintViolated.class)
	  @ResponseBody
	  public ResponseEntity<ErrorResource> constraint(
	    HttpServletRequest req, Exception e) {
	   ErrorResource error = new ErrorResource();
	   error.setStatus(HttpStatus.BAD_REQUEST);
	   error.setErrorCode(HttpStatus.BAD_REQUEST.value());
	   error.setErrorMsg("length violation");


	   return new ResponseEntity<ErrorResource>(error,
	     HttpStatus.BAD_REQUEST);
	  }
}
