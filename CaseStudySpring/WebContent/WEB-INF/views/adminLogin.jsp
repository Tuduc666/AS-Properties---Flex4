<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>   
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link rel="stylesheet" href="<spring:url value="/CSS/login.css" />">
		<title>Admin Login</title>
	</head>
<body>
	<h1>AS Properties Admin Login</h1>
	<div class="container">
		<form action="validateAdminLogin" method="post">	
			<div class="sub_field">
				<label>Email</label>
				<input type="text" id="email" name="email"  />
			</div>
			<div class="sub_field">
				<label>Password</label>
				<input type="password" id="pass" name="password" />
			</div>
			
			<div class="btn">
				<input type="submit" name="submit"  value="Submit Info" />
			</div>
		</form>
	</div>

</body>
</html>