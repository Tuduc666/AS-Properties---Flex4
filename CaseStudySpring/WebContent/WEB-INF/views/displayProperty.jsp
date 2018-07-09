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
		<link rel="stylesheet" href="<spring:url value="/CSS/ulist.css" />">
		<title>Property Detail</title>
	</head>
<%
	Property p = (Property) request.getAttribute("property");   
%>                                                   
<body>   <!-- NOTE: names below must match names in model class, not names in SQL table -->
	<h1>ASP Property Detail</h1>
			
	<img alt="<%=p.getPhoto_filename()%>" src="IMAGES/<%=p.getPhoto_filename()%>" style="float:left; margin-right:5vw">

	<p>Id: ${property.getProperty_id() } </p>
	<p>Address: <%=p.getAddress1()%> <%=p.getAddress2()%></p>
	<p>City: <%=p.getCity()%></p>
	<p>State: <%=p.getState()%></p>
	<p>Zip: <%=p.getZip()%></p>
	<p>Sale Type: <%=p.getSales_type()%></p>
	<p>Property Type: <%=p.getProperty_type()%></p>
	<p>Number of Bedrooms: <%=p.getBedrooms()%></p>
	<p>Salesperson Name: <%=p.getSalesperson_name()%></p>
	<p>Salesperson Phone: <%=p.getSalesperson_phone()%></p>
	<p>Salesperson Email: <%=p.getSalesperson_email()%></p>
	<p>Posted Date: <%=p.getPosted_date()%></p>
	<p>MLS Number: <%=p.getMls_number()%></p>
	<p>Owner Asking Price: <%=p.getAsking_price()%></p>
				
	<p><a href="userDetailList?city=all&state=all&order=date" class="button">Back</a></p>

	

</body>
</html>
