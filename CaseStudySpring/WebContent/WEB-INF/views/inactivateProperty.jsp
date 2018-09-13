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
		<link rel="stylesheet" href="<spring:url value="/CSS/showProperty.css" />">
		<title>Inactivate Property</title>
	</head>
<%
User u = null; UserDAO uDAO = null;  
Property p = null; 
try {
	p = (Property) request.getAttribute("property");   
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
	<h1>ASP Inactivate Property</h1>
	<div class="container">
		<form action="inactivatePropertySQL" method="post">	
		
			<div class="sub_field">
				<label>Id (non-input)</label>
				<input type="number" id="property_id" name="property_id" value=${property.getProperty_id() } readonly />
			</div>
			<div class="sub_field">
				<label>Address</label>
				<input type="text" id="address1" name="address1" value="<%=p.getAddress1()%>" required />
			</div>
			<div class="sub_field">
				<label>Owner Asking Price</label>
				<input type="number" id="asking_price" name="asking_price" value="<%=p.getAsking_price()%>" required />
			</div>
		
			<div class="btn">
				<input type="submit" name="submit"  value="Inactivate" />
			</div>
		</form>
	</div>
</body>
</html>
