<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<title>List | Employees</title>
</head>
<body>
	<div class="container">
		<div class="page-header">
			<h1>BCM Employees</h1>
		</div>

		<table class="table table-striped table-bordered" border="1"
			cellpadding="1">
			<col>
			<colgroup span="2"></colgroup>
			<colgroup span="2"></colgroup>
			<thead>
				<tr>
					<th>EmployeeID</th>
					<th>FirstName</th>
					<th>LastName</th>
					<th>DOB</th>
					<th>Hire_DT</th>
					<th>SSN</th>
					<th colspan="2" scope="colgroup" style="text-align: center;">Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${employees}" var="employee">
					<tr>
						<td>${employee.id}</td>
						<td>${employee.firstName}</td>
						<td>${employee.lastName}</td>
						<td>${employee.dob}</td>
						<td>${employee.hireDate}</td>
						<td>${employee.ssn}</td>
						<td><a href="update${employee.id}">Edit</a></td>
						<td><a href="deleteemp/${employee.id}">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<br /> <a href="add">Add New Employee</a>
	</div>

	<div class="container">
		<hr />
		<jsp:include page="footer.jsp" />
	</div>
	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<script src="js/custom.js"></script>
</body>
</html>