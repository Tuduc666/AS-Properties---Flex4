<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>   
<!DOCTYPE html>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<meta name="description" content="NYC Real Estate Website by Ann Uduc, a NYS Licensed Real Estate Agent.  Homes for sale, buy, and rent.">
  		<meta name="keywords" content="NYC,Real Estate,Ann Uduc,Licensed Real Estate Agent,Homes,Houses,Apartments,Sale,Buy,Rent">
  		<meta name="author" content="Ann Uduc">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link rel="stylesheet" href="<spring:url value="/CSS/ulist.css" />">
		<title>ASP Contact Page</title>
	</head>
                                                  
<body>   <!-- NOTE: names below must match names in model class, not names in SQL table -->
	<h1>ASP Contact Page</h1>
			
	<img alt="salesperson" src="IMAGES/HA.jpg" width="40%" height="60%" style="float:left; margin-right:5vw;" >

	<p>Please contact me to schedule an appointment to view the property.</p><br>
	
	Ann Uduc of Showcase Realty Inc<br>
	(a licensed real estate sales agent)<br>
	Phone:  347-564-2460<br>
	Email: Ann@showcaserealtynyc.com<br><br><br>

				
	<p><a href="homePage?city=all&state=all&order=date" class="button">Back</a></p>

	

</body>
</html>
