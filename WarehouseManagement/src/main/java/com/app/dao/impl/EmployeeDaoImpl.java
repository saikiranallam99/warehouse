package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IEmployeeDao;
import com.app.model.Employee;

@Repository
public class EmployeeDaoImpl  implements IEmployeeDao{
	@Autowired
	private HibernateTemplate ht;

	
	public Integer saveEmployee(Employee emp) {
		return (Integer) ht.save(emp);
	}

	
	public void updateEmployee(Employee emp) {
		ht.update(emp);
	}

	
	public void deleteEmployee(Integer empId) {
		ht.delete(new Employee(empId));
	}


	public Employee getOneEmployee(Integer empId) {
		return ht.get(Employee.class, empId);
	}


	public List<Employee> getAllEmployees() {
		return ht.loadAll(Employee.class);
	}

}



