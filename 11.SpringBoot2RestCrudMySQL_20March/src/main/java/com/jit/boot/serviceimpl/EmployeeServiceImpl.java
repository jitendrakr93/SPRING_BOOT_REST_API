package com.jit.boot.serviceimpl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.emitter.EmitterException;

import com.jit.boot.exception.EmployeeNotFoundException;
import com.jit.boot.model.Employee;
import com.jit.boot.repo.EmployeeRepository;
import com.jit.boot.service.IEmployeeService;
import com.jit.boot.util.EmployeeUtil;

import net.bytebuddy.implementation.bytecode.Throw;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	private EmployeeRepository repo;

	@Autowired
	private EmployeeUtil util;

	public Integer saveEmployee(Employee e) {
		util.calculateDetails(e);
		Integer id = repo.save(e).getEmpId();
		return id;
	}

	public void updateEmployee(Employee e) {
		getOneEmployee(e.getEmpId());
		util.calculateDetails(e);
		repo.save(e);
	}

	public void deleteEmployee(Integer id) {
		// repo.deleteById(id);
		repo.delete(getOneEmployee(id));

	}

	public Employee getOneEmployee(Integer id) {
		Optional<Employee> opt = repo.findById(id);
		if (opt.isPresent()) {
			return opt.get();
		} else {
			throw new EmployeeNotFoundException("Employee " + id + " not exist");
		}
	}

	public List<Employee> getAllEmployees() {
		return repo.findAll();
	}

	@Transactional
	public Integer updateEmployeeMail(Integer eid, String email) {
		return repo.updateEmployeeMail(eid, email);
	}

}
