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
                              
<body>       <!-- NOTE: names below must match names in model class, not names in SQL table -->
	<h1>ASP Create User Profile</h1>
	<div class="container">
		<form action="addUserSQL" method="post">	
		
			<div class="sub_field">
				<label>Full Name</label>
				<input type="text" id="user_name" name="user_name"  />
			</div>
			<div class="sub_field">
				<label>Address</label>
				<input type="text" id="address1" name="address1"  />
			</div>
			<div class="sub_field">
				<label>Address (line2)</label>
				<input type="text" id="address2" name="address2"  />
			</div>
			<div class="sub_field">
				<label>city</label>
				<input type="text" id="city" name="city"   />
			</div>
			<div class="sub_field">
				<label>state</label>
				<input type="text" id="state" name="state"  />
			</div>
			<div class="sub_field">
				<label>zip</label>
				<input type="text" id="zip" name="zip"  />
			</div>
			<div class="sub_field">
				<label>phone</label>
				<input type="text" id="phone" name="phone"   />
			</div>
			<div class="sub_field">
				<label>Email</label>
				<input type="text" id="email" name="email"  />
			</div>
			<div class="sub_field">
				<label>Password</label>
				<input type="password" id="user_password" name="user_password"  />
			</div>
			
			<div class="btn">
				<input type="submit" name="submit"  value="Submit" />
			</div>
		</form>
	</div>
</body>
</html>