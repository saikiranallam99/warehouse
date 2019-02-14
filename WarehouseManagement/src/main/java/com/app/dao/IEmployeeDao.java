package com.app.dao;

import java.util.List;

import com.app.model.Employee;

public interface IEmployeeDao {

	public Integer saveEmployee(Employee emp);
	public void updateEmployee(Employee emp);
	public void deleteEmployee(Integer empId);
	
	public Employee getOneEmployee(Integer empId);
	public List<Employee> getAllEmployees();
	
	
	
	
}
