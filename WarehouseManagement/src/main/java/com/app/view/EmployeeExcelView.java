package com.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.app.model.Employee;

public class EmployeeExcelView extends AbstractXlsxView{

	@Override
	protected void buildExcelDocument(
			Map<String, Object> model, 
			Workbook workbook, 
			HttpServletRequest request,
			HttpServletResponse response) 
					throws Exception {

		//file name chnage
		response.addHeader("Content-Disposition", "attachment;filename=EMPLOYEES.xlsx");

		//create sheet with name 'Employees'
		Sheet sheet=workbook.createSheet("EMPLOYEES");
		//create Head
		setHead(sheet);

		//read data 
		@SuppressWarnings("unchecked")
		List<Employee> emps=(List<Employee>)model.get("emps");
		//set body
		setBody(sheet, emps);
	}


	private void setHead(Sheet sheet) {
		//create row 
		Row row=sheet.createRow(0);

		//create cell
		row.createCell(0).setCellValue("ID");
		row.createCell(1).setCellValue("NAME");
		row.createCell(2).setCellValue("GENDER");
		row.createCell(3).setCellValue("ADDRESS");
		row.createCell(4).setCellValue("COUNTRY");
		row.createCell(5).setCellValue("LANGUAGES");

	}

	private void setBody(Sheet sheet,List<Employee> emps) {
		int rowNum=1;
		for(Employee e:emps) {
			Row row=sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(e.getEmpId());
			row.createCell(1).setCellValue(e.getEmpName());
			row.createCell(2).setCellValue(e.getEmpGender());
			row.createCell(3).setCellValue(e.getEmpAddr());
			row.createCell(4).setCellValue(e.getEmpCntry());
			row.createCell(5).setCellValue(e.getEmpLangs().toString());
			
		}
	}






}
