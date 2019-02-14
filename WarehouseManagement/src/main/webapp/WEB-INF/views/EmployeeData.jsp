<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@include file="Menu.jsp"%>
<h2>Welcome to Employee Data Page</h2>
<a href="excel">Excel Export</a> | <a href="pdf">PDF Export</a>
<table border="1">
<tr>
	<th>ID</th>
	<th>NAME</th>
	<th>GENDER</th>
	<th>ADDRESS</th>
	<th>COUNTRY</th>
	<th>LANGUAGES</th>
	<th colspan="2">OPERATION</th>
</tr>
<c:forEach items="${list}" var="emp">
<tr>
	<td><c:out value="${emp.empId}"/></td>
	<td><c:out value="${emp.empName}"/></td>
	<td><c:out value="${emp.empGender}"/></td>
	<td><c:out value="${emp.empAddr}"/></td>
	<td><c:out value="${emp.empCntry}"/></td>
	<td><c:out value="${emp.empLangs}"/></td>
	<td>
	<a href="delete?id=${emp.empId}">DELETE</a>
	</td>
	<td>
		<a href="edit?id=${emp.empId}">EDIT</a>
	</td>
	
</tr>
</c:forEach>
</table>
${message}
</body>
</html>