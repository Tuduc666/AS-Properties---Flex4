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
		<title>Update Property</title>
	</head>
<%
	Property p = (Property) request.getAttribute("property");   
%>                                                   
<body>   <!-- NOTE: names below must match names in model class, not names in SQL table -->
	<h1>ASP Update Property</h1>
	<div class="container">
		<form action="updatePropertySQL" method="post">	
		
			<div class="sub_field">
				<label>Id (non-input)</label>
				<input type="number" id="property_id" name="property_id" value=${property.getProperty_id() } readonly />
			</div>
			<div class="sub_field">
				<label>Address</label>
				<input type="text" id="address1" name="address1" value="<%=p.getAddress1()%>" />
			</div>
			<div class="sub_field">
				<label>Address (line2)</label>
				<input type="text" id="address2" name="address2" value="<%=p.getAddress2()%>" />
			</div>
			<div class="sub_field">
				<label>city</label>
				<input type="text" id="city" name="city" value="<%=p.getCity()%>" />
			</div>
			<div class="sub_field">
				<label>state</label>
				<input type="text" id="state" name="state" value="<%=p.getState()%>" />
			</div>
			<div class="sub_field">
				<label>zip</label>
				<input type="text" id="zip" name="zip" value="<%=p.getZip()%>" />
			</div>
			<div class="sub_field">
				<label>Owner Name</label>
				<input type="text" id="owner_name" name="owner_name" value="<%=p.getOwner_name()%>" />
			</div>
			<div class="sub_field">
				<label>Owner Phone</label>
				<input type="text" id="owner_phone" name="owner_phone" value="<%=p.getOwner_phone()%>" />
			</div>
			<div class="sub_field">
				<label>For Sale / Rental</label>
				<input type="text" id="sales_type" name="sales_type" value="<%=p.getSales_type()%>" />
			</div>
			<div class="sub_field">
				<label>Single Family,Multi-Family,Condo,Coop</label>
				<input type="text" id="property_type" name="property_type" value="<%=p.getProperty_type()%>" />
			</div>
			<div class="sub_field">
				<label>Number of Bedrooms</label>
				<input type="number" id="bedrooms" name="bedrooms" value="<%=p.getBedrooms()%>" />
			</div>
			<div class="sub_field">
				<label>Salesperson Id (select one from p_salesperson table)</label>
				<input type="number" id="salesperon_id" name="salesperon_id" value="<%=p.getSalesperon_id()%>" />
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
				<label>Salesperson comm% (non-input)</label>
				<input type="number" id="salesperson_comm" name="salesperson_comm" value="<%=p.getSalesperson_comm()%>" readonly />
			</div>
			<div class="sub_field">
				<label>Posted Date</label>
				<input type="date" id="posted_date" name="posted_date" value="<%=p.getPosted_date()%>" />
			</div>
			<div class="sub_field">
				<label>MLS Number</label>
				<input type="text" id="mls_number" name="mls_number" value="<%=p.getMls_number()%>" />
			</div>			
			<div class="sub_field">
				<label>Owner Asking Price</label>
				<input type="number" step="0.01" id="asking_price" name="asking_price" value="<%=p.getAsking_price()%>" />
			</div>
			<div class="sub_field">
				<label>Owner Acceptance Price</label>
				<input type="number" step="0.01" id="acceptance_price" name="acceptance_price" value="<%=p.getAcceptance_price()%>" />
			</div>
			<div class="sub_field">
				<label>Active / Inactive</label>
				<input type="text" id="status" name="status" value="<%=p.getStatus()%>"  />
			</div>			
			<div class="sub_field">
				<label>PhotoFilename.jpg (from WebContent/IMAGES)</label>
				<input type="text" id="photo_filename" name="photo_filename" value="<%=p.getPhoto_filename()%>" />
			</div>			
		
			<div class="btn">
				<input type="submit" name="submit"  value="Update" />
			</div>
		</form>
	</div>
</body>
</html>
