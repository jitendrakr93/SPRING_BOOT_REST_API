package com.jit.boot.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jit.boot.model.Student;

@RestController
@RequestMapping("/std")
public class StudentRestController {

	@GetMapping("/data")
	public ResponseEntity<String> showMsg(){
		return ResponseEntity.ok("Hello");
	}
	
	@PostMapping("/create")
	public ResponseEntity<String> createStudent(@RequestBody Student student){
		return ResponseEntity.ok("Student data is :: "+student);
	}
}
