package com.jit.boot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jit.boot.model.ErrorData;

@RestControllerAdvice // afterThrowingAdvice
public class MyCustomExceptionHandler {

	/*@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<String> handleEmployeeNotFoundException(EmployeeNotFoundException enfe) {
		return new ResponseEntity<String>(enfe.getMessage(), HttpStatus.NOT_FOUND);

	}*/

	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<ErrorData> handleEmployeeNotFoundException(EmployeeNotFoundException enfe) {
		return new ResponseEntity<ErrorData>(new ErrorData(System.currentTimeMillis(), "Employee", enfe.getMessage()),
				HttpStatus.NOT_FOUND);
	}

}
