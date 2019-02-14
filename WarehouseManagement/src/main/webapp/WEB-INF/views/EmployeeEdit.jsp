<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form"  uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@include file="Menu.jsp"%>
<h2>Welcome to Employee Edit Page </h2>
<form:form action="update"  method="POST" modelAttribute="employee">
<pre>
ID      : <form:input path="empId" readonly="true"/>
NAME    : <form:input path="empName"/>
GENDER  : <form:radiobutton path="empGender" value="Male"/> Male <form:radiobutton path="empGender" value="Female"/> Female
ADDRESS : <form:textarea path="empAddr"/>
COUNTRY : <form:select path="empCntry">
			<form:option value="">-SELECT-</form:option>
			<form:option value="IND">India</form:option>
			<form:option value="ENG">England</form:option>
		  </form:select>
Languages: 
     <form:checkbox path="empLangs" value="ENG"/>English		  
     <form:checkbox path="empLangs" value="HIN"/>Hindi		  
     <form:checkbox path="empLangs" value="TEL"/>Telugu
<input type="submit" value="Update"/>     		  
</pre>	
</form:form>
</body>
</html>


