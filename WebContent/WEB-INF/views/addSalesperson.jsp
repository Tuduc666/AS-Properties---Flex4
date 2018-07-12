<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>   
<!DOCTYPE html>
<%@ page import="models.*,dao.*" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link rel="stylesheet" href="<spring:url value="/CSS/updateUser.css" />">
		<title>Add Salesperson</title>
	</head>
<%

%>                                                   
<body>   <!-- NOTE: names below must match names in model class, not names in SQL table -->
	<h1>ASP Add Salesperson</h1>
	<div class="container">
		<form action="addSalesSQL" method="post">	
		
			<div class="sub_field">
				<label>Full Name</label>
				<input type="text" id="name" name="name"  />
			</div>
			<div class="sub_field">
				<label>Phone</label>
				<input type="text" id="phone" name="phone"  />
			</div>
			<div class="sub_field">
				<label>Email</label>
				<input type="email" id="email" name="email"  />
			</div>
			<div class="sub_field">
				<label>Commission Percentage</label>
				<input type="number" step="0.01" id="comm" name="comm"  />  
			</div>
			
			<div class="btn">
				<input type="submit" name="submit"  value="Add" />
			</div>
		</form>
	</div>
</body>
</html>