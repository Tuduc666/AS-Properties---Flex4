<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>   
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link rel="stylesheet" href="<spring:url value="/CSS/login.css" />">
		<title>Logout</title>
	</head>
<%
	session.invalidate();              // this invalidate the session, back button would no longer work
	response.sendRedirect("reLogin");  // this send it back to the login page, 
                                       // otherwise it would just display the message below in the logout page

%>	
	<body>
		<h2>You have successfully logged out.</h2>
	
	</body>
</html>