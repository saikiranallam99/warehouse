<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>UOM Data Page</title>

</head>
<body>
<%@include file="Menu.jsp"%>
	<div class="container">

		<div class="card">

			<!-- card heading starts -->
			<div class="card-header bg-info text-white">
				<h2>WELCOME TO UOM DATA PAGE</h2>
			</div>
			
			<!-- card body start -->
			<div class="card-body">
				<c:choose>
					<c:when test="${!empty uoms}">
						<table class="table table-hover">
							<tr>
								<th>ID</th>
								<th>TYPE</th>
								<th>MODEL</th>
								<th>NOTE</th>
								<th>OPERATIONS</th>
							</tr>
							<c:forEach items="${uoms}" var="uom">
								<tr>
									<td><c:out value="${uom.id}" /></td>
									<td><c:out value="${uom.uomType}" /></td>
									<td><c:out value="${uom.uomModel}" /></td>
									<td><c:out value="${uom.uomDsc}" /></td>
									<td><a href="delete?id=${uom.id}" class="btn btn-danger">DELETE</a>
									<a href="edit?id=${uom.id}"><img src="../resources/imgs/edit.png" width="50" height="50"></a></td>
								</tr>
							</c:forEach>
						</table>
					</c:when>
					<c:otherwise>
						<div class="text-info">No Data Found in Database</div>
					</c:otherwise>
				</c:choose>
				<!-- card body end -->
			</div>


			<!-- card footer -->
			<c:if test="${message ne null }">
				<div class="card-footer bg-warning">${message}</div>
			</c:if>


			<!-- card end -->
		</div>
		<!-- container end -->
	</div>
</body>
</html>



