<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isErrorPage="true"%>

<!DOCTYPE html>
<html>

<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
	<title>New Contact</title>
</head>

<body>
	<div class="container">
		<div class="row p-4 justify-content-center">
			<div class="col-sm-6">
				<h1 class="text-center">Contact Info</h1>
			</div>
		</div>
		<div class="row justify-content-center">
			<div class="col-4 p-2">
				<form:form action="/contact/new" method="post" modelAttribute="contact">
					<div class="row justify-content-start">
						<div class="col-6">
							<form:label path="student">Student</form:label>
						</div>
						<div class="col-6" style="width: 170px;">
							<form:select path="student">
								<c:forEach items="${ students }" var="student">
						        	<form:option value="${ student.id }">${ student.firstName } ${ student.lastName }</form:option>
						        </c:forEach>
							</form:select>
						</div>
					</div>
					<div class="row justify-content-start">
						<div class="col-6">
							<form:label path="address">Address</form:label>
							<p class="text-danger"><form:errors path="address"/></p>
						</div>
						<div class="col-6">
							<form:input path="address"/>
						</div>
					</div>
					<div class="row justify-content-start">
						<div class="col-6">
							<form:label path="city">City</form:label>
							<p class="text-danger"><form:errors path="city"/></p>
						</div>
						<div class="col-6">  
							<form:input path="city"/>
						</div>
					</div>
					<div class="row justify-content-start">
						<div class="col-6">
							<form:label path="state">State</form:label>
							<p class="text-danger"><form:errors path="state"/></p>
						</div>
						<div class="col-6">  
							<form:input path="state"/>
						</div>
					</div>
					<div class="row justify-content-end">
						<div class="col-2-offset-5 p-4">
							<input type="submit" value="Create" class="btn btn-success"/>
						</div>
					</div>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>