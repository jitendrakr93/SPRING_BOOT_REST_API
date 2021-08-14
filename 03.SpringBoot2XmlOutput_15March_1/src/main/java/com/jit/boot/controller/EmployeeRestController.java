package com.jit.boot.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jit.boot.model.Employee;

@RestController
public class EmployeeRestController {

	@GetMapping("/obj")
	public ResponseEntity<Employee> showDataB() {
		Employee body = new Employee(106, "SYED", 600.0);
		return new ResponseEntity<Employee>(body, HttpStatus.OK);
	}

	@GetMapping("/list")
	public ResponseEntity<List<Employee>> showDataD() {
		List<Employee> body = Arrays.asList(new Employee(101, "A", 30.0), new Employee(102, "B", 31.0),
				new Employee(103, "C", 32.0), new Employee(104, "D", 33.0));
		return new ResponseEntity<List<Employee>>(body, HttpStatus.OK);
	}

	@GetMapping("/listb")
	public ResponseEntity<List<String>> showDataE() {
		List<String> body = Arrays.asList("ONE", "TWO", "ABC");
		return new ResponseEntity<List<String>>(body, HttpStatus.OK);
	}
}
