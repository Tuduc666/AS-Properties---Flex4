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
		<link rel="stylesheet" href="<spring:url value="/CSS/showProperty.css" />">
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
				<input type="text" id="address1" name="address1" required />
			</div>
			<div class="sub_field">
				<label>Address (line2)</label>
				<input type="text" id="address2" name="address2"  />
			</div>
			<div class="sub_field">
				<label>City</label>
				<input type="text" id="city" name="city" required />
			</div>
			<div class="sub_field">
				<label>State</label>
				<input type="text" id="state" name="state" value="NY" required />
			</div>
			<div class="sub_field">
				<label>Zip</label>
				<input type="text" id="zip" name="zip" required />
			</div>
			<div class="sub_field">
				<label>Sales type</label>
				<select id="sales_type" name="sales_type" required />
				  <option value="For Sale">For Sale</option>
				  <option value="Rental" selected="selected">Rental</option>
				</select>
			</div>
			<div class="sub_field">
				<label>Property type</label>
				<select id="property_type" name="property_type" required />
				  <option value="Single Family">Single Family</option>
				  <option value="Multi-Family">Multi-Family</option>
				  <option value="Condo">Condo</option>
				  <option value="Coop" selected="selected">Coop</option>
				  <option value="Rental Building">Rental Building</option>
				  <option value="Rent Stabilized">Rent Stabilized</option>
				</select>
			</div>
			<div class="sub_field">
				<label>Number of bedrooms</label>
				<input type="number" id="bedrooms" name="bedrooms" required />
			</div>
			<div class="sub_field">
				<label>Number of bathrooms</label>
				<input type="number" step="0.1" id="bathrooms" name="bathrooms" required />
			</div>
			<div class="sub_field">
				<label>Salesperon id (select one from p_salesperson table)</label>
				<input type="number" id="salesperon_id" name="salesperon_id" value=1 />
			</div>
			<div class="sub_field">
				<label>Posted date</label>
				<input type="date" id="posted_date" name="posted_date" required />
			</div>
			<div class="sub_field">
				<label>MLS number</label>
				<input type="text" id="mls_number" name="mls_number"  />
			</div>			
			<div class="sub_field">
				<label>Owner asking price</label>
				<input type="number" id="asking_price" name="asking_price" required />
			</div>
			<div class="sub_field">
				<label>Status</label>
				<select id="status" name="status" required />
				  <option value="Active">Active</option>
				  <option value="Inactive">Inactive</option>
				</select>
			</div>			
			<div class="sub_field">
				<label>PhotoFilename.jpg (from WebContent/IMAGES)</label>
				<input type="text" id="photo_filename" name="photo_filename"  />
			</div>
			<div class="sub_field">
				<label>Description</label>
				<textarea name="description" rows="8" cols="40" placeholder="Enter property description" wrap="soft" ></textarea>
			</div>			
			<div class="sub_field">
				<label>Weblink</label>
				<input type="text" id="weblink" name="weblink"  />
			</div>			
		
			<div class="btn">
				<input type="submit" name="submit"  value="Add" />
			</div>
		</form>
	</div>
</body>
</html>