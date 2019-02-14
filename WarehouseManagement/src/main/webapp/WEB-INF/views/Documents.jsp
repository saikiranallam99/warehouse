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
<h2>Welcome to Documents Page!!</h2>
<form action="upload" method="post" enctype="multipart/form-data">
<pre>
File : <input type="file" name="file"/>
<input type="submit" value="Upload">
</pre>
</form>
<table border="1">
<tr>
	<th>ID</th>
	<th>NAME</th>
	<th>LINK</th>
</tr>
<c:forEach items="${docs}" var="doc">
<tr>
	<td><c:out value="${doc[0]}"/></td>
	<td><c:out value="${doc[1]}"/></td>
	<td>
		<a href="download?docId=${doc[0]}">DOWNLOAD</a>
	</td>
</tr>
</c:forEach>
</table>

${message}
</body>
</html>





