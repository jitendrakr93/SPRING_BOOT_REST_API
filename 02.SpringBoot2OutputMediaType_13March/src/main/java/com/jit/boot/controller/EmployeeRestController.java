package com.jit.boot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jit.boot.model.Employee;

@RestController
public class EmployeeRestController {

	@GetMapping("/msg")
	public ResponseEntity<String> showDataA() {
		String body = "Welcome to Simple data";
		return new ResponseEntity<String>(body, HttpStatus.OK);
	}

	@GetMapping("/obj")
	public ResponseEntity<Employee> showDataB() {
		Employee body = new Employee(106, "SYED", 600.0);
		return new ResponseEntity<Employee>(body, HttpStatus.OK);
	}

	@GetMapping("/obja")
	public Employee showDataC() {
		Employee body = new Employee(190, "AHMED SYED", 800.0);
		return body;
	}
}
