<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
.err{
	color: red;
}
</style>
</head>
<body>
<%@include file="Menu.jsp"%>
<h2>welcome to Order Method Register</h2>
<form:form action="save" method="post" modelAttribute="orderMethod">
<pre>
Order Mode : <form:radiobutton path="mode" value="Sale"/>Sale <form:radiobutton path="mode" value="Purchase"/>Purchase
<form:errors path="mode" cssClass="err"/>
Order Code : <form:input path="code"/>
<form:errors path="code" cssClass="err"/>
Order Method : <form:select path="methd">
			<form:option value="">-Select-</form:option>
			<form:option value="FIFO">FIFO</form:option>
			<form:option value="LIFO">LIFO</form:option>
			<form:option value="FCFO">FCFO</form:option>
			<form:option value="FEFO">FEFO</form:option>
		</form:select>
<form:errors path="methd" cssClass="err"/>		
Order Accept : <form:checkbox path="accept" value="Multi-Model"/>Multi-Model
	       <form:checkbox path="accept" value="Accept-Return"/>Accept-Return
<form:errors path="accept" cssClass="err"/>	   
Description : <form:textarea path="dsc"/>
<form:errors path="dsc" cssClass="err"/>
<input type="submit" value="Register"/> 			   		
</pre>
</form:form>
${message}
</body>
</html>





