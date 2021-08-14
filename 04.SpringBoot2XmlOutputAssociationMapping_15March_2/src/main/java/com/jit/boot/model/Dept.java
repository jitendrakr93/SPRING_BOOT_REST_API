package com.jit.boot.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dept {
	private Integer did;
	private String dname;
	private String dcode;
	private List<Employee> emps;
	private CompanyInfo cob;
}
