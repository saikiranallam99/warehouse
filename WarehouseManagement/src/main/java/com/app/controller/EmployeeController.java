package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.model.Employee;
import com.app.service.IEmployeeService;
import com.app.view.EmployeeExcelView;
import com.app.view.EmployeePdfView;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	private IEmployeeService service;

	//1. To display Register Page
	@RequestMapping("/register")
	public String showRegPage(ModelMap map) {
		//create object <-linked with--> form
		map.addAttribute("employee", new Employee());
		return "EmployeeRegister";
	}

	//2. on click submit button
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public String saveData(
			@ModelAttribute Employee employee,
			ModelMap map) {
		Integer empId=service.saveEmployee(employee);
		String msg="Employee '"+empId+"' saved";
		map.addAttribute("message", msg);
		//clear form data
		map.addAttribute("employee", new Employee());
		return "EmployeeRegister";
	}


	//3. Get data from DB to UI
	@RequestMapping("/getAll")
	public String showData(ModelMap map) {
		List<Employee> emps=service.getAllEmployees();
		map.addAttribute("list", emps);
		return "EmployeeData";
	}

	//4. delete employee by id
	@RequestMapping("/delete")
	public String deleteEmp(
			@RequestParam("id")Integer empId,
			ModelMap map) {
		service.deleteEmployee(empId);
		String msg="Employee '"+empId+"' Deleted";
		List<Employee> emps=service.getAllEmployees();

		map.addAttribute("message", msg);
		map.addAttribute("list", emps);


		return "EmployeeData";
	}



	//5. show edit page
	@RequestMapping("/edit")
	public String showEdit(
			@RequestParam("id")Integer empId,
			ModelMap map
			) 
	{
		Employee emp=service.getOneEmployee(empId);
		map.addAttribute("employee", emp);
		return "EmployeeEdit";
	}


	
	//6. do update operation
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String doUpdateData(
			@ModelAttribute Employee employee,
			ModelMap map)
	{
		service.updateEmployee(employee);
		String msg="Employee  '"+employee.getEmpId()+"' Updated";
		List<Employee> emps=service.getAllEmployees();
		
		map.addAttribute("message", msg);
		map.addAttribute("list", emps);
		return "EmployeeData";
	}
	//7. Export data to excel file
	@RequestMapping("/excel")
	public ModelAndView showExcel() {
		List<Employee> emps=service.getAllEmployees();
		ModelAndView m=new ModelAndView();
		//view details
		m.setView(new EmployeeExcelView());
		//model details
		m.addObject("emps", emps);
		return m;
	}
	
	//8. Export data to PDF file
	@RequestMapping("/pdf")
	public ModelAndView showPdf() {
		//fetch data from DB
		List<Employee> emps=service.getAllEmployees();
		//create Model and view
		ModelAndView m=new ModelAndView();
		//provide view class name
		m.setView(new EmployeePdfView());
		//provide data to it
		m.addObject("emps", emps);
		return m;
	}
	
}