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
		<title>Property Detail</title>
	</head>
<%
	Integer p_id = (Integer) request.getAttribute("propertyid");   
	User u = (User) session.getAttribute("userkey");
	// out.print("property_id = " + p_id);
%>                                                   
<body>   <!-- NOTE: names below must match names in model class, not names in SQL table -->
	<h1>ASP Showing Request</h1>
	<div class="container">
		<form action="showingSQL" method="post">	
			<div class="sub_field">
				<label>UserId (non-input)</label>
				<input type="number" id="user_id" name="user_id" value=${userkey.getUser_id() } readonly />
			</div>
			<div class="sub_field">
				<label>PropertyId (non-input)</label>
				<input type="number" id="property_id" name="property_id" value="<%=p_id%>"  readonly />
			</div>
				<div class="sub_field">
				<label>Message</label>
				<input style="width:80%;" type="text" id="user_message" name="user_message"  />
			</div>
			<div class="btn">
				<input type="submit" name="submit"  value="Submit" />
			</div>
		</form>
	</div>
</body>
</html>
