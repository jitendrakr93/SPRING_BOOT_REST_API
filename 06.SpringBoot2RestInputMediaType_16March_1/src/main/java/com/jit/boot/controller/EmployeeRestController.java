package com.jit.boot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jit.boot.model.Employee;

@RestController
@RequestMapping("/employee")
public class EmployeeRestController {

	@PostMapping("/read")
	public ResponseEntity<String> readEmp(@RequestBody Employee employee) {
		return new ResponseEntity<String>(employee.toString(), HttpStatus.OK);

	}
}
