<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
	<title>Students</title>
</head>

<body>
	<div class="container">
		<div class="row p-4 justify-content-center">
			<div class="col-sm-6">
				<h3 class="text-center"><a href="/students/new">New Student</a> | <a href="/contact/new">New Contact</a></h3>
			</div>
		</div>
		
		<div class="row">
			 <table class="table table-bordered table-striped">
				<thead class="thead-dark">
					<tr>
						<th scope="col"><h5>Name</h5></th>
						<th scope="col"><h5>Age</h5></th>
						<th scope="col"><h5>Address</h5></th>
						<th scope="col"><h5>City</h5></th>
						<th scope="col"><h5>State</h5></th>
					</tr>					        		
				</thead>
				<tbody>
					<c:forEach items="${ students }" var="student">								    
						<tr>
							<td><h6>${ student.firstName } ${ student.lastName }</h6></td>
							<td><h6>${ student.age }</h6></td>
							<td><h6>${ student.contact.address }</h6></td>
							<td><h6>${ student.contact.city }</h6></td>
							<td><h6>${ student.contact.state }</h6></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		
	</div>
</body>
</html>