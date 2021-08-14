package com.jit.boot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "emp_tab")
public class Employee {
	@Id
	@GeneratedValue
	@Column(name = "eid")
	private Integer empId;

	@Column(name = "ename")
	private String empName;
	
	@Column(name = "email")
	private String empMail;

	@Column(name = "esal")
	private Double empSal;

	@Column(name = "ehra")
	private Double empHra;

	@Column(name = "eta")
	private Double empTa;
}
