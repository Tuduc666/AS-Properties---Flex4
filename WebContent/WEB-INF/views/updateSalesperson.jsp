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
		<title>Update Salesperson</title>
	</head>
<%
	Salesperson s = (Salesperson) request.getAttribute("salesperson");   
%>                                                   
<body>   <!-- NOTE: names below must match names in model class, not names in SQL table -->
	<h1>ASP Update Salesperson</h1>
	<div class="container">
		<form action="updateSalesSQL" method="post">	
		
			<div class="sub_field">
				<label>Id (non-input)</label>
				<input type="number" id="id" name="id" value=${salesperson.getId() } readonly />
			</div>
			<div class="sub_field">
				<label>Full Name</label>
				<input type="text" id="name" name="name" value="<%=s.getName()%>"  />
			</div>
			<div class="sub_field">
				<label>Phone</label>
				<input type="text" id="phone" name="phone" value="<%=s.getPhone()%>" />
			</div>
			<div class="sub_field">
				<label>Email</label>
				<input type="email" id="email" name="email" value="<%=s.getEmail()%>" />
			</div>
			<div class="sub_field">
				<label>Commission Percentage</label>
				<input type="number" step="0.01" id="comm" name="comm" value="<%=s.getComm()%>" />  
			</div>
			
			<div class="btn">
				<input type="submit" name="submit"  value="Update" />
			</div>
		</form>
	</div>
</body>
</html>