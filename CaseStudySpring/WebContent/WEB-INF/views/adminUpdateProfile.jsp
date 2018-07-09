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
		<title>adminUpdateProfile</title>
	</head>
<%
	User u = (User) session.getAttribute("userkey"); // two different ways to retrieve the information
	                 // method #1 - value=${userkey.getUser_id() only returns 1st word in a string and "/" if blank
	                 // method #2 -  u.getUser_name() returns the full string
	                 // should always go with method #2 to be sure
%>                                                   
<body>
	<h1>ASP Update Admin Info</h1>
	<div class="container">
		<form action="adminUpdateSQL" method="post">	
		
			<div class="sub_field">
				<label>User type (non-input)</label>
				<input type="text" id="user_type" name="user_type" value="<%=u.getUser_type()%>" readonly />
			</div>
			<div class="sub_field">
				<label>UserId (non-input)</label>
				<input type="number" id="user_id" name="user_id" value=${userkey.getUser_id() } readonly />
			</div>
			<div class="sub_field">
				<label>Full Name</label>
				<input type="text" id="user_name" name="user_name" value="<%=u.getUser_name()%>"  />
			</div>
			<div class="sub_field">
				<label>Address</label>
				<input type="text" id="address1" name="address1" value="<%=u.getAddress1()%>"  />
			</div>
			<div class="sub_field">
				<label>Address (line2)</label>
				<input type="text" id="address2" name="address2" value="<%=u.getAddress2()%>"  />
			</div>
			<div class="sub_field">
				<label>city</label>
				<input type="text" id="city" name="city" value="<%=u.getCity()%>"  />
			</div>
			<div class="sub_field">
				<label>state</label>
				<input type="text" id="state" name="state" value=${userkey.getState() }  />
			</div>
			<div class="sub_field">
				<label>zip</label>
				<input type="text" id="zip" name="zip" value="<%=u.getZip()%>" />
			</div>
			<div class="sub_field">
				<label>phone</label>
				<input type="text" id="phone" name="phone" value="<%=u.getPhone()%>"  />
			</div>
			<div class="sub_field">
				<label>Email</label>
				<input type="text" id="email" name="email" value="<%=u.getEmail()%>"  />
			</div>
			<div class="sub_field">
				<label>Password</label>
				<input type="password" id="user_password" name="user_password" value="<%=u.getUser_password()%>"  />
			</div>
			
			<div class="btn">
				<input type="submit" name="submit"  value="Update Info" />
			</div>
		</form>
	</div>
</body>
</html>