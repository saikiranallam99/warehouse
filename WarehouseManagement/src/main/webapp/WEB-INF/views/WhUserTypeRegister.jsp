<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		//default background color is grey
		if('OTHER' == $("#userIdType").val()){
			$('#ifOther').attr('readonly', false);
			$('#ifOther').css('background-color', '#FFFFFF');
		}else{
			$('#ifOther').attr('readonly', true);
			$('#ifOther').css('background-color', '#DCDCDC');
		}
		
		
		//on click radio button user type-execute this
		$("input[type=radio][name=userType]").click(function() {
			if (this.value == 'Vendor') {
				$("#userFor").val("Purchase");
			} else if (this.value == 'Customer') {
				$("#userFor").val("Sale");
			}
		});
		
		//on change dropdown value of user id type
		$("#userIdType").change(function() {
			var opt = $("#userIdType").val();
			if (opt != 'OTHER') {
				$('#ifOther').attr('readonly', true);
				$('#ifOther').css('background-color', '#DCDCDC');
				$('#ifOther').val("");
			} else {
				$('#ifOther').attr('readonly', false);
				$('#ifOther').css('background-color', '#FFFFFF');
			}
		});
	});
</script>
<style type="text/css">
.err {
	color: red;
}
</style>
</head>
<body>
<%@include file="Menu.jsp"%>
	<h2>welcome to UserRegister Page!!</h2>
	<form:form action="save" method="post" modelAttribute="whUserType">
		<pre>
User Type : <form:radiobutton path="userType" value="Vendor" /> Vendor  <form:radiobutton
				path="userType" value="Customer" /> Customer
<form:errors path="userType" cssClass="err" />
User Code : <form:input path="userCode" />
<form:errors path="userCode" cssClass="err" />
User For  : <form:input path="userFor" readonly="true" />

User Email: <form:input path="userEmail" />	
<form:errors path="userEmail" cssClass="err" />
User Contact: <form:input path="userContact" />
<form:errors path="userContact" cssClass="err" />
User Id Type: <form:select path="userIdType">
			   <form:option value="">-SELECT-</form:option>
			   <form:option value="PAN CARD">PAN CARD</form:option>
			   <form:option value="AADHAR">AADHAR</form:option>
			   <form:option value="VOTER ID">VOTER ID</form:option>
			   <form:option value="OTHER">OTHER</form:option>
			</form:select>
<form:errors path="userIdType" cssClass="err" />
*IF other  : <form:input path="ifOther" />
<form:errors path="ifOther" cssClass="err" />
ID NUMBER  : <form:input path="userIdNum" />
<form:errors path="userIdNum" cssClass="err" />
<input type="submit" value="Register" />				
</pre>
	</form:form>
	${message}
</body>
</html>