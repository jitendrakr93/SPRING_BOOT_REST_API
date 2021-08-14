package com.jit.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jit.boot.exception.EmployeeNotFoundException;
import com.jit.boot.model.Employee;
import com.jit.boot.service.IEmployeeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/rest/employee")
@Api(value = "SAMPLE",description = "EMPLOYEE OPERATIONS")
public class EmployeeRestController {

	@Autowired
	private IEmployeeService service;

	// 1.save employee
	@ApiOperation("SAVE EMPLOYEE TO DB")
	@PostMapping("/save")
	public ResponseEntity<String> saveEmployee(@RequestBody Employee employee) {
		ResponseEntity<String> resp = null;
		try {
			Integer id = service.saveEmployee(employee);
			resp = new ResponseEntity<String>("Employee saved " + id, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			resp = new ResponseEntity<String>("Unable to process save", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return resp;
	}

	// 2.display all
	@ApiOperation("FETCH ALL EMPLOYEE")
	@GetMapping("/all")
	public ResponseEntity<?> getAllEmployee() {
		ResponseEntity<?> resp = null;
		try {
			List<Employee> empList = service.getAllEmployees();
			// resp = new ResponseEntity<List<Employee>>(empList,HttpStatus.OK);
			resp = ResponseEntity.ok(empList);
		} catch (Exception e) {
			e.printStackTrace();
			resp = new ResponseEntity<String>("Unable to fetch data", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return resp;
	}

	// 3.get one by id
	@ApiOperation("FETCH THE EMPLOYEE BY ID")
	@GetMapping("/find/{id}")
	public ResponseEntity<?> getOneEmployee(@PathVariable Integer id) {
		ResponseEntity<?> resp = null;
		try {
			Employee emp = service.getOneEmployee(id);
			resp = ResponseEntity.ok(emp);
		} catch (EmployeeNotFoundException enfe) {
			// re throw back to handle
			throw enfe;
		} catch (Exception e) {
			e.printStackTrace();
			resp = new ResponseEntity<String>("Unable to fetch data", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return resp;
	}

	// 4.remove one
	@ApiOperation("DELETE THE EMPLOYEE BY ID")
	@DeleteMapping("/remove/{id}")
	public ResponseEntity<String> removeOneEmployee(@PathVariable Integer id) {
		ResponseEntity<String> resp = null;
		try {
			service.deleteEmployee(id);
			resp = new ResponseEntity<String>("Employee deleted " + id, HttpStatus.OK);
		} catch (EmployeeNotFoundException enfe) {
			// re throw back to handle
			throw enfe;
		} catch (Exception e) {
			e.printStackTrace();
			resp = new ResponseEntity<String>("Unable to fetch data for delete", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return resp;
	}

	// 5.update one
	@ApiOperation("UPDATE THE EMPLOYEE")
	@PutMapping("/update")
	public ResponseEntity<String> updateEmployee(@RequestBody Employee employee) {
		ResponseEntity<String> resp = null;
		try {
			service.updateEmployee(employee);
			resp = new ResponseEntity<String>("Employee updated", HttpStatus.OK);
		} catch (EmployeeNotFoundException enfe) {
			// re throw back to handle
			throw enfe;
		} catch (Exception e) {
			e.printStackTrace();
			resp = new ResponseEntity<String>("Unable to update data", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return resp;
	}

	// 6.partial update
	@ApiOperation("UPDATE THE EMPLOYEE MAIL USING EMPLOYEE ID")
	@PatchMapping("/modify/{id}/{mail}")
	public ResponseEntity<String> updateEmail(@PathVariable Integer id, @PathVariable String mail) {
		ResponseEntity<String> resp = null;
		try {
			String msg = null;
			Integer count = service.updateEmployeeMail(id, mail);
			if (count > 0) {
				msg = "Email Updated";
			} else {
				msg = "Email not updated";
			}
			resp = new ResponseEntity<String>(msg, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			resp = new ResponseEntity<String>("Unable to update mail", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return resp;
	}
}
