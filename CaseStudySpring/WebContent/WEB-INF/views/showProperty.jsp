<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>   
<!DOCTYPE html>
<%@ page errorPage="errorPage.jsp" %>
<%@ page import="models.*,dao.*" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<meta name="description" content="NYC Real Estate by Ann Uduc, a NYS Licensed Real Estate Agent.  Homes for sale and rental in Forest Hills Queens and New York City area.">
  		<meta name="keywords" content="NYC,Real Estate,Ann Uduc,Licensed Real Estate Agent,Homes,Houses,Apartments,Sell,Buy,Rent,Bed,Bedroom,Bath,Forest Hills,Queens,New York City,request,showing,realty,realtor ">
  		<meta name="author" content="Ann Uduc">		
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link rel="stylesheet" href="<spring:url value="/CSS/showProperty.css" />">
		<title>AS Properties NYC - Homes for sale and rental in New York City - Request a Showing</title>
	</head>
<%
Integer p_id = null;   
User u = null;
String user_email = ""; String user_name = "";
try {
	p_id = (Integer) request.getAttribute("propertyid");   
	u = (User) session.getAttribute("userkey");
	if (u != null) {
		user_email = u.getEmail();
		user_name = u.getUser_name();
	}
}
catch(Exception e) {  
	throw new Exception("Ooops. Something went wrong when the system was trying to display Showing Request page.");
}
%>                                                   
<body>   <!-- NOTE: names below must match names in model class, not names in SQL table -->
	<h1>ASP Showing Request</h1>
	<div class="container">
		<form action="showingSQL" method="post">	
		<p style="margin-top:1vw;">To request a showing, please contact Ann Uduc at 347-564-2460, email: Ann@showcaserealtynyc.com</p>
		<p>Or simply fill in and submit your information below and we will contact you.</p>
			<div class="sub_field">
				<label>Full Name</label>
				<input type="text" id="user_name" name="user_name" value="<%=user_name%>" required />
			</div>
			<div class="sub_field">
				<label>Email</label>
				<input type="email" id="email" name="email" value="<%=user_email%>" required />
			</div>
			<div class="sub_field">
				<label>Phone</label>
				<input type="text" id="phone" name="phone" />
			</div>
			<div class="sub_field">
				<label>PropertyId (non-input)</label>
				<input style="background-color:#ccc;" type="number" id="property_id" name="property_id" value="<%=p_id%>"  readonly />
			</div>
			<div class="sub_field">
				<label>Message</label>
				<textarea name="user_message" rows="6" cols="30" placeholder="Message to the agent..." wrap="soft" ></textarea>
			<!-- the textarea above worked!!!!!!!!!!!!!!!!!!   -->		
			<!-- <input style="width:80%;" type="text" id="user_message" name="user_message" placeholder="Enter your message here" /> --> 
			</div>
			<div class="btn">
				<input type="submit" name="submit"  value="Submit" />
			</div>
		</form>
	</div>
</body>
</html>
