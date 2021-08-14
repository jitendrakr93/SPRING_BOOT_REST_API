package com.jit.boot.service;

import java.util.List;

import com.jit.boot.model.Employee;

public interface IEmployeeService {
	
	public Integer saveEmployee(Employee e);

	public void updateEmployee(Employee e);

	public void deleteEmployee(Integer id);

	public Employee getOneEmployee(Integer id);

	public List<Employee> getAllEmployees();
	
	public Integer updateEmployeeMail(Integer eid,String email);
}
