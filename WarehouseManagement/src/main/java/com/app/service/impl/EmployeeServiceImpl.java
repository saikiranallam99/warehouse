package com.app.service.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IEmployeeDao;
import com.app.model.Employee;
import com.app.service.IEmployeeService;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
	@Autowired
	private IEmployeeDao dao;

	@Transactional
	public Integer saveEmployee(Employee emp) {
		return dao.saveEmployee(emp);
	}

	@Transactional
	public void updateEmployee(Employee emp) {
		dao.updateEmployee(emp);
	}

	@Transactional
	public void deleteEmployee(Integer empId) {
		dao.deleteEmployee(empId);
	}

	@Transactional(readOnly=true)
	public Employee getOneEmployee(Integer empId) {
		return dao.getOneEmployee(empId);
	}

	@Transactional(readOnly=true)
	public List<Employee> getAllEmployees() {
		 List<Employee> emps=dao.getAllEmployees();
		 Collections.sort(emps,(o1,o2)->o2.getEmpId()-o1.getEmpId());
		 return emps;
	}
}





