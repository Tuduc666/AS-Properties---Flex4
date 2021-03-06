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
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link rel="stylesheet" href="<spring:url value="/CSS/showProperty.css" />">
		<title>Update Property</title>
	</head>
<%
User u = null; UserDAO uDAO = null;  
Property p = null; 
try {
	p = (Property) request.getAttribute("property");   
	u = (User) session.getAttribute("userkey");	
	uDAO = new UserDAO();
	u = uDAO.isValidAdmin(u.getEmail(), u.getUser_password());        // only admin is allowed to access this page
	
	if(u==null) 
		throw new Exception("You need admin credentials to access this page.");
}
catch(Exception e) {  
	throw new Exception("You need admin credentials to access this page.");
}	
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
				<input type="text" id="address1" name="address1" value="<%=p.getAddress1()%>" required />
			</div>
			<div class="sub_field">
				<label>Address (line2)</label>
				<input type="text" id="address2" name="address2" value="<%=p.getAddress2()%>" />
			</div>
			<div class="sub_field">
				<label>city</label>
				<input type="text" id="city" name="city" value="<%=p.getCity()%>" required />
			</div>
			<div class="sub_field">
				<label>state</label>
				<input type="text" id="state" name="state" value="<%=p.getState()%>" required />
			</div>
			<div class="sub_field">
				<label>zip</label>
				<input type="text" id="zip" name="zip" value="<%=p.getZip()%>" required />
			</div>
			<div class="sub_field">
				<label>For Sale / Rental</label>
				<input type="text" id="sales_type" name="sales_type" value="<%=p.getSales_type()%>" required />
			</div>
			<div class="sub_field">
				<label>Single Family/Multi-Family/Condo/Coop/Rental Building/Rent Stabilized</label>
				<input type="text" id="property_type" name="property_type" value="<%=p.getProperty_type()%>" required />
			</div>
			<div class="sub_field">
				<label>Number of Bedrooms</label>
				<input type="number" id="bedrooms" name="bedrooms" value="<%=p.getBedrooms()%>" required />
			</div>
			<div class="sub_field">
				<label>Number of Bathrooms</label>
				<input type="number" step="0.1" id="bathrooms" name="bathrooms" value="<%=p.getBathrooms()%>" required />
			</div>
			<div class="sub_field">
				<label>Salesperson Id (select one from p_salesperson table)</label>
				<input type="number" id="salesperon_id" name="salesperon_id" value="<%=p.getSalesperon_id()%>" required />
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
				<input type="date" id="posted_date" name="posted_date" value="<%=p.getPosted_date()%>" required />
			</div>
			<div class="sub_field">
				<label>MLS Number</label>
				<input type="text" id="mls_number" name="mls_number" value="<%=p.getMls_number()%>" />
			</div>			
			<div class="sub_field">
				<label>Owner Asking Price</label>
				<input type="number" id="asking_price" name="asking_price" value="<%=p.getAsking_price()%>" required />
			</div>
			<div class="sub_field">
				<label>Active / Inactive</label>
				<input type="text" id="status" name="status" value="<%=p.getStatus()%>" required />
			</div>			
			<div class="sub_field">
				<label>PhotoFilename.jpg (from WebContent/IMAGES)</label>
				<input type="text" id="photo_filename" name="photo_filename" value="<%=p.getPhoto_filename()%>" />
			</div>		
			<div class="sub_field">
				<label>Description</label>
				<textarea name="description" rows="8" cols="40" placeholder="Enter property description" wrap="soft" ><%=p.getDescription()%></textarea>
			</div>		
			<div class="sub_field">
				<label>Special text</label>
				<input type="text" id="special" name="special" value="<%=p.getSpecial()%>" />
			</div>		
			<div class="sub_field">
				<label>Other special text</label>
				<input type="text" id="specialo" name="specialo" value="<%=p.getSpecialo()%>" />
			</div>		
			<div class="sub_field">
				<label>Display special text - highlighted/blinking/none</label>
				<input type="text" id="speciald" name="speciald" value="<%=p.getSpeciald()%>" />
			</div>		
			<div class="sub_field">
				<label>Weblink/none</label>
				<input type="text" id="weblink" name="weblink" value="<%=p.getWeblink()%>" required />
			</div>		
		
			<div class="btn">
				<input type="submit" name="submit"  value="Update" />
			</div>
		</form>
	</div>
</body>
</html>
