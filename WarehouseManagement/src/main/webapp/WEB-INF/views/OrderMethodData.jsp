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
<h2>welcome to Order Method Data Page!!</h2>
<table border="1">
	<tr>
		<th>ID</th>
		<th>MODE</th>
		<th>CODE</th>
		<th>METHOD</th>
		<th>ACCEPT</th>
		<th>NOTE</th>
		<th>OPERATIONS</th>
	</tr>
	<c:forEach items="${orderMethods}" var="om">
		<tr>
			<td><c:out value="${om.id}"/> </td>
			<td><c:out value="${om.mode}"/> </td>
			<td><c:out value="${om.code}"/> </td>
			<td><c:out value="${om.methd}"/> </td>
			<td><c:out value="${om.accept}"/> </td>
			<td><c:out value="${om.dsc}"/> </td>
			<td>
				<a href="delete?id=${om.id}">DELETE</a>
			</td>
		</tr>
	</c:forEach>
</table>
${message}
</body>
</html>



