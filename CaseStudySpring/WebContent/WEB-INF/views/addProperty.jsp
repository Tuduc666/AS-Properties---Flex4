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
		<title>Add Property</title>
	</head>
<%

%>                                                   
<body>   <!-- NOTE: names below must match names in model class, not names in SQL table -->
	<h1>ASP Add Property</h1>
	<div class="container">
		<form action="addPropertySQL" method="post">	
			
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
				<input type="text" id="city" name="city"  />
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
				<label>Owner Name</label>
				<input type="text" id="owner_name" name="owner_name" />
			</div>
			<div class="sub_field">
				<label>Owner Phone</label>
				<input type="text" id="owner_phone" name="owner_phone"  />
			</div>
			<div class="sub_field">
				<label>For Sale / Rental</label>
				<input type="text" id="sales_type" name="sales_type"  />
			</div>
			<div class="sub_field">
				<label>Single Family,Multi-Family,Condo,Coop</label>
				<input type="text" id="property_type" name="property_type"  />
			</div>
			<div class="sub_field">
				<label>Number of Bedrooms</label>
				<input type="number" id="bedrooms" name="bedrooms"  />
			</div>
			<div class="sub_field">
				<label>Salesperon Id (select one from p_salesperson table)</label>
				<input type="number" id="salesperon_id" name="salesperon_id"  />
			</div>
			<div class="sub_field">
				<label>Posted Date</label>
				<input type="date" id="posted_date" name="posted_date"  />
			</div>
			<div class="sub_field">
				<label>MLS Number</label>
				<input type="text" id="mls_number" name="mls_number"  />
			</div>			
			<div class="sub_field">
				<label>Owner Asking Price</label>
				<input type="number" step="0.01" id="asking_price" name="asking_price"  />
			</div>
			<div class="sub_field">
				<label>Owner Acceptance Price</label>
				<input type="number" step="0.01" id="acceptance_price" name="acceptance_price"  />
			</div>
			<div class="sub_field">
				<label>Active / Inactive</label>
				<input type="text" id="status" name="status"  />
			</div>			
			<div class="sub_field">
				<label>PhotoFilename.jpg (from WebContent/IMAGES)</label>
				<input type="text" id="photo_filename" name="photo_filename"  />
			</div>			
		
			<div class="btn">
				<input type="submit" name="submit"  value="Add" />
			</div>
		</form>
	</div>
</body>
</html>