<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>   
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link rel="stylesheet" href="<spring:url value="/CSS/updateUser.css" />">
		<title>Login</title>
	</head>

	<body>
		<h1>AS Properties Login Page</h1>
		<div class="container">
			<form action="customerLogin" method="post">	
				<div class="sub_field">
					<label>Email</label>
					<input type="text" id="email" name="email"  />
				</div>
				
				<div class="btn">
					<input type="submit" name="submit"  value="Submit Info" />
				</div>

				<p style="color:red;">${message2 }</p>   <!-- Invalid login message -->
			</form>
		</div>
		<p><a href="addUserProfile">Create new user account</a></p>
		<p><a href="https://www.aspropertiesnyc.com/">Return to Home Page</a></p>
	</body>
</html>