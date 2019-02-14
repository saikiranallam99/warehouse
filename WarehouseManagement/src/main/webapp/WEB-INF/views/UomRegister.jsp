<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>

</head>
<body>
<%@include file="Menu.jsp"%>
	<!-- container start -->
	<div class="container">
		<!-- card start -->
		<div class="card">


			<!-- card Header -->
			<div class="card-header bg-primary text-white">
				<h2>WELCOME TO UOM REGISTER PAGE</h2>
			</div>


			<!-- card body -->
			<div class="card-body">
				<form:form action="save" method="post" modelAttribute="uom" cssClass="form">

					
					
					<div class="form-group">
						<label for="uomType" class="control-label col-sm-4">UOM
							TYPE</label>
						<form:select path="uomType" cssClass="form-control col-sm-4">
							<form:option value="">--SELECT--</form:option>
							<form:option value="PACKING">PACKING</form:option>
							<form:option value="NO PACKING">NO PACKING</form:option>
							<form:option value="-NA-">-NA-</form:option>
						</form:select>
						<form:errors path="uomType" cssClass="text-danger" />
					</div>

					
					<div class="form-group">
						<label for="uomModel" class="control-label col-sm-4">UOM MODEL</label>
						<form:input path="uomModel" cssClass="form-control col-sm-4"/>
						<form:errors path="uomModel" cssClass="text-danger" />
					</div>

					
					<div class="form-group">
						<label for="uomModel" class="control-label col-sm-4">UOM NOTE</label>
						<form:textarea path="uomDsc" cssClass="form-control col-sm-4"/>
						<form:errors path="uomDsc" cssClass="text-danger" />
					</div>


					
					<div class="form-group">
						<input type="submit" value="Register" class="btn btn-success" />
					</div>
					
					
				</form:form>

			</div>

			<!-- card footer -->
			<c:if test="${message ne null }">
				<div class="card-footer bg-info text-white">${message}</div>
			</c:if>
			
		<!-- card end -->			
		</div>

	<!-- container end -->
	</div>
</body>
</html>




