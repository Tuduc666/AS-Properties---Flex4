<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>   
<!DOCTYPE html>
<%@page isErrorPage="true" %>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<meta name="description" content="NYC Real Estate Website by Ann Uduc, a NYS Licensed Real Estate Agent.  Homes for sale, buy, and rent.">
  		<meta name="keywords" content="NYC,Real Estate,Ann Uduc,Licensed Real Estate Agent,Homes,Houses,Apartments,Sale,Buy,Rent">
  		<meta name="author" content="Ann Uduc">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link rel="stylesheet" href="<spring:url value="/CSS/ulist.css" />">
		<title>ASP Error Page</title>
	</head>
                                                  
<body>   
	<h1>ASP Error Page</h1>
			
	<div>

		<p style="text-font:3vw;"><%=exception.getMessage() %></p><br>
		
		<p>Please click on the link below to go to our home page to retry your request.</p>
		<p><a href="https://www.aspropertiesnyc.com/">https://www.aspropertiesnyc.com/</a></p>

	</div>

</body>
</html>
