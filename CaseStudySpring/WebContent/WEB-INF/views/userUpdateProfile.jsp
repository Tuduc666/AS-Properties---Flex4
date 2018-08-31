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
		<title>Update User Profile</title>
	</head>
<%
	User u = (User) session.getAttribute("userkey"); // two different ways to retrieve the information
	                 // method #1 - value=${userkey.getUser_id() only returns 1st word in a string and "/" if blank
	                 // method #2 -  u.getUser_name() returns the full string
	                 // should always go with method #2 to be sure
%>                                                   
<body>
	<h1>ASP Update User Info</h1>
	<div class="container">
		<form action="userUpdateSQL" method="post">	
		
			<div class="sub_field">
				<label>(non-input)</label>
				<input style="background-color:#ccc;" type="text" id="user_type" name="user_type" value="<%=u.getUser_type()%>" readonly />
			</div>
			<div class="sub_field">
				<label>UserId (non-input)</label>
				<input style="background-color:#ccc;" type="number" id="user_id" name="user_id" value=${userkey.getUser_id() } readonly />
			</div>
			<div class="sub_field">
				<label>Full Name</label>
				<input type="text" id="user_name" name="user_name" required />
			</div>
			<div class="sub_field">
				<label>Email</label>
				<input type="email" id="email" name="email" value="<%=u.getEmail()%>" required />
			</div>
			<div class="sub_field">
				<label>Phone</label>
				<input type="phone" id="phone" name="phone" required />
			</div>
			
			<div class="btn">
				<input type="submit" name="submit"  value="Update Info" />
			</div>
		</form>
		<!-- <p>Important:  You must use only unique password that you don't use anywhere else.</p> -->
	</div>
</body>
</html>