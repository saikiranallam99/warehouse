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
<h2>Welcome to User Data Page!!</h2>
<table border="1">
	<tr>
		<th>ID</th>
		<th>TYPE</th>
		<th>CODE</th>
		<th>FOR</th>
		<th>EMAIL</th>
		<th>CONTACT</th>
		<th>IDTYPE</th>
		<th>OTHER</th>
		<th>ID NUMBER</th>
		<th>OPERATIONS</th>
	</tr>
	<c:forEach items="${users}" var="usr">
		<tr>
			<td><c:out value="${usr.id}"/> </td>
			<td><c:out value="${usr.userType}"/> </td>
			<td><c:out value="${usr.userCode}"/> </td>
			<td><c:out value="${usr.userFor}"/> </td>
			<td><c:out value="${usr.userEmail}"/> </td>
			<td><c:out value="${usr.userContact}"/> </td>
			<td><c:out value="${usr.userIdType}"/> </td>
			<td><c:out value="${usr.ifOther}"/> </td>
			<td><c:out value="${usr.userIdNum}"/> </td>
			<td>
			<a href="delete?id=${usr.id}">DELETE</a> 
			</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>



