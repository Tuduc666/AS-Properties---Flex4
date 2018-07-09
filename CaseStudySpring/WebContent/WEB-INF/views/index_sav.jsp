<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>       
<!DOCTYPE html>
<%@ page import="models.*" %>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">	
 		<link rel="stylesheet" href="<spring:url value="/CSS/index.css" />">
 		<title>AS Properties</title>
	</head>
<%
	User u = (User) request.getAttribute("user");
	session.setAttribute("user", u);
%>
<body>
	<!-- 	<div id="bkg"></div>  -->                                        <!-- fading out background image -->
		<div style="display:flex;justify-content: space-between;">    <!-- needed this line to fit the 3 items in the header of the page -->

		<svg version="1.1" baseProfile="full" width="220" height="130" xmlns="http://www.w3.org/2000/svg"; style="float: left;">
		  <rect width="100%" height="100%" fill="red" />
		  <circle cx="110" cy="67" r="60" fill="green" />
		  <text x="110" y="72" font-size="50" text-anchor="middle" fill="white">ASP</text>
		</svg>

		<h1>AS Properties</h1>

		<svg version="1.1" baseProfile="full" width="220" height="130" xmlns="http://www.w3.org/2000/svg"; style="float: left;">
		  <rect width="100%" height="100%" fill="red" />
		  <circle cx="110" cy="67" r="60" fill="green" />
		  <text x="110" y="72" font-size="50" text-anchor="middle" fill="white">ASP</text>
		</svg>

	</div>

	<%=request.getAttribute("iframe") %>

</body>
</html>