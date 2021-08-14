package com.jit.boot.exception;

public class EmployeeNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1l;

	public EmployeeNotFoundException() {
		super();
	}

	public EmployeeNotFoundException(String message) {
		super(message);
	}
}
