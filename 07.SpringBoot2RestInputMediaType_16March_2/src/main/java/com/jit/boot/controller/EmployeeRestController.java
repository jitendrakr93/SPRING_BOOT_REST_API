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
	public ResponseEntity<Employee> readEmp(@RequestBody Employee employee) {
		Double sal = employee.getEsal();
		Double hra = sal * 10 / 100.0;
		Double ta = sal * 6 / 100.0;
		employee.setHra(hra);
		employee.setTa(ta);

		return new ResponseEntity<Employee>(employee, HttpStatus.OK);

	}
}
