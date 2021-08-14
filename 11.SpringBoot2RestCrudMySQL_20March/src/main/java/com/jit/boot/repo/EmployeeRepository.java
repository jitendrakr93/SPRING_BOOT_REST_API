package com.jit.boot.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.jit.boot.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	@Modifying
	@Query("Update Employee SET empMail=:email WHERE empId=:eid")
	public Integer updateEmployeeMail(Integer eid,String email);
}
