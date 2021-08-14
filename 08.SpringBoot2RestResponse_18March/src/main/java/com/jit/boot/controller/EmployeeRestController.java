package com.jit.boot.controller;

import java.util.Random;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jit.boot.model.Employee;

@RestController
@RequestMapping("/employee")
public class EmployeeRestController {

	@GetMapping("/backup")
	public ResponseEntity<Void> exportDataAsBack() {
		System.out.println("EXECUTING BACKUP PROCESS");
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

	@PostMapping("/save")
	public ResponseEntity<String> createEmployee() {
		return new ResponseEntity<String>("Employee created !!", HttpStatus.CREATED);
	}

	@PostMapping("/read")
	public ResponseEntity<Employee> readEmp(@RequestBody Employee employee) {
		Double sal = employee.getEsal();
		Double hra = sal * 10 / 100.0;
		Double ta = sal * 6 / 100.0;
		employee.setHra(hra);
		employee.setTa(ta);
		return new ResponseEntity<Employee>(employee, HttpStatus.ACCEPTED);
	}

	@GetMapping("/data")
	public ResponseEntity<String> processData() {
		if (new Random().nextInt(100) <= 100) {
			throw new RuntimeException("DUMMY");
		}
		return null;
	}
}
