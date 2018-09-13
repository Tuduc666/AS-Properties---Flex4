<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>   
<!DOCTYPE html>
<%@ page errorPage="errorPage.jsp" %>
<%@ page import="models.*,dao.*" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link rel="stylesheet" href="<spring:url value="/CSS/updateUser.css" />">
		<title>Delete Salesperson</title>
	</head>
<%
User u = null; UserDAO uDAO = null; 
Salesperson s = null;   
try {
	s = (Salesperson) request.getAttribute("salesperson");  
	u = (User) session.getAttribute("userkey");	
	uDAO = new UserDAO();
	u = uDAO.isValidAdmin(u.getEmail(), u.getUser_password());        // only admin is allowed to access this page
	
	if(u==null) 
		throw new Exception("You need admin credentials to access this page.");
}
catch(Exception e) {  
	throw new Exception("You need admin credentials to access this page.");
}	
%>                                                   
<body>   <!-- NOTE: names below must match names in model class, not names in SQL table -->
	<h1>ASP Delete Salesperson</h1>
	<div class="container">
		<form action="deleteSalesSQL" method="post">	
		
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
				<input type="submit" name="submit"  value="Delete" />
			</div>
		</form>
	</div>
</body>
</html>