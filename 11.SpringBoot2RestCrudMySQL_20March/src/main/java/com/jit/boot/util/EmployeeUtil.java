package com.jit.boot.util;

import org.springframework.stereotype.Component;

import com.jit.boot.model.Employee;

@Component
public class EmployeeUtil {

	public void calculateDetails(Employee e) {
		Double sal = e.getEmpSal();
		e.setEmpHra(sal * 12/100.0);
		e.setEmpTa(sal * 3/100.0);
	}
}
