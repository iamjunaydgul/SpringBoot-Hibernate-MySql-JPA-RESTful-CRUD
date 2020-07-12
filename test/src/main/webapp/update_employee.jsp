<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="main.css" rel="stylesheet" />
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css"
	rel="stylesheet">
<title>Edit | Employee</title>

</head>
<body>
	<div style="text-align: center">
		<h1>Edit Employee Details</h1>
		<hr />
		<form:form method="post" action="editsave"
			modelAttribute="editEmployee" enctype="multipart/form-data"
			class="form">
			<table>
				<tr>
					<td></td>
					<td><form:hidden path="id" /></td>
				</tr>
				<tr>
					<td>First Name :</td>
					<td><form:input path="firstName" /></td>
				</tr>
				<tr>
					<td>Last Name :</td>
					<td><form:input path="lastName" /></td>
				</tr>
				<tr>
					<td>Date of Birth :</td>
					<td><form:input path="dob" /></td>
				</tr>
				<tr>
					<td>Hire Date :</td>
					<td><form:input path="hireDate" /></td>
				</tr>
				<tr>
					<td>SSN :</td>
					<td><form:input path="ssn" /></td>
				</tr>

				<tr>
					<td></td>
					<td><input type="submit" value="Edit Save" /></td>
				</tr>
			</table>
		</form:form>
		<div class="container">
			<hr />
			<jsp:include page="footer.jsp" />
		</div>
		<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
		<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
		<script src="js/custom.js"></script>
	</div>
</body>
</html>