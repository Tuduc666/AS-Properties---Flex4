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
	Property p = (Property) request.getAttribute("property");   
%>                                                   
<body>   <!-- NOTE: names below must match names in model class, not names in SQL table -->
	<h1>ASP Property Detail</h1>
	<div class="container">
		<form action="userDetailList" method="post">	
		
			<div class="sub_field">
				<label>Id</label>
				<input type="number" id="property_id" name="property_id" value=${property.getProperty_id() } readonly />
			</div>
			<div class="sub_field">
				<label>Address</label>
				<input type="text" id="address1" name="address1" value="<%=p.getAddress1()%>" readonly />
			</div>
			<div class="sub_field">
				<label>Address (line2)</label>
				<input type="text" id="address2" name="address2" value="<%=p.getAddress2()%>" readonly />
			</div>
			<div class="sub_field">
				<label>city</label>
				<input type="text" id="city" name="city" value="<%=p.getCity()%>" readonly />
			</div>
			<div class="sub_field">
				<label>state</label>
				<input type="text" id="state" name="state" value="<%=p.getState()%>" readonly />
			</div>
			<div class="sub_field">
				<label>zip</label>
				<input type="text" id="zip" name="zip" value="<%=p.getZip()%>" readonly />
			</div>
			<div class="sub_field">
				<label>Owner Name</label>
				<input type="text" id="owner_name" name="owner_name" value="<%=p.getOwner_name()%>" readonly />
			</div>
			<div class="sub_field">
				<label>Owner Phone</label>
				<input type="text" id="owner_phone" name="owner_phone" value="<%=p.getOwner_phone()%>" readonly />
			</div>
			<div class="sub_field">
				<label>For Sale / Rental</label>
				<input type="text" id="sales_type" name="sales_type" value="<%=p.getSales_type()%>" readonly />
			</div>
			<div class="sub_field">
				<label>Single Family,Multi-Family,Condo,Coop</label>
				<input type="text" id="property_type" name="property_type" value="<%=p.getProperty_type()%>" readonly />
			</div>
			<div class="sub_field">
				<label>Number of Bedrooms</label>
				<input type="number" id="bedrooms" name="bedrooms" value="<%=p.getBedrooms()%>" readonly />
			</div>
			<div class="sub_field">
				<label>Salesperson Name (non-input)</label>
				<input type="text" id="salesperson_name" name="salesperson_name" value="<%=p.getSalesperson_name()%>" readonly />
			</div>
			<div class="sub_field">
				<label>Salesperson Phone (non-input)</label>
				<input type="text" id="salesperson_phone" name="salesperson_phone" value="<%=p.getSalesperson_phone()%>" readonly />
			</div>
			<div class="sub_field">
				<label>Salesperson Email (non-input)</label>
				<input type="text" id="salesperson_email" name="salesperson_email" value="<%=p.getSalesperson_email()%>" readonly />
			</div>
			<div class="sub_field">
				<label>Posted Date</label>
				<input type="date" id="posted_date" name="posted_date" value="<%=p.getPosted_date()%>" readonly />
			</div>
			<div class="sub_field">
				<label>MLS Number</label>
				<input type="text" id="mls_number" name="mls_number" value="<%=p.getMls_number()%>" readonly />
			</div>			
			<div class="sub_field">
				<label>Owner Asking Price</label>
				<input type="number" step="0.01" id="asking_price" name="asking_price" value="<%=p.getAsking_price()%>" readonly />
			</div>		
		
			<div class="btn">
				<input type="submit" name="submit"  value="Back" />
			</div>
			<button onclick="goBack()"; style="float: right;">Go Back</button>
		</form>
	</div>
	
	<img alt="<%=p.getPhoto_filename()%>" src="<%=p.getPhoto_filename()%>">
	
</body>
</html>
