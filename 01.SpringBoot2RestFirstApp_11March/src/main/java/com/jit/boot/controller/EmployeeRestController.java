package com.jit.boot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeRestController {

	@GetMapping("/show")
	public ResponseEntity<String> showData() {
		ResponseEntity<String> resp = new ResponseEntity<String>("Hello GET", HttpStatus.OK);
		return resp;
	}

	@PostMapping("/save")
	public ResponseEntity<String> createData() {
		ResponseEntity<String> resp = new ResponseEntity<String>("Hello POST", HttpStatus.OK);
		return resp;
	}

	@PutMapping("/modify")
	public ResponseEntity<String> updateData() {
		ResponseEntity<String> resp = new ResponseEntity<String>("Hello PUT", HttpStatus.OK);
		return resp;
	}

	@DeleteMapping("/remove")
	public ResponseEntity<String> deleteData() {
		ResponseEntity<String> resp = new ResponseEntity<String>("Hello DELETE", HttpStatus.OK);
		return resp;
	}

	@PatchMapping("/modifymail")
	public ResponseEntity<String> updateMailData() {
		ResponseEntity<String> resp = new ResponseEntity<String>("Hello PATCH", HttpStatus.OK);
		return resp;
	}

}
