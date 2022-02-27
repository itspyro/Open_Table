package com.example.opentable.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.opentable.transport.ErrorResponse;

@RestControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {
	
	@Override
	public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
	    List<String> details = new ArrayList<>();
	    for(ObjectError error : ex.getBindingResult().getAllErrors()) {
	      details.add(error.getDefaultMessage());
	    }
	    ErrorResponse error = new ErrorResponse();
	    error.setHttpStatusCode(HttpStatus.BAD_REQUEST.value());
	    error.setResponseMessage("Validation Failed");
	    error.setDetails(details);
	    return new ResponseEntity<Object>(error, HttpStatus.OK);
	    }
}
