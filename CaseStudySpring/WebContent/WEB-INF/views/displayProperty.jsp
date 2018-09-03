<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>   
<!DOCTYPE html>
<%@ page import="models.*,dao.*" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.text.DecimalFormat" %>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<meta name="description" content="NYC Real Estate Website by Ann Uduc, a NYS Licensed Real Estate Agent.  Homes for sale, buy, and rent.">
  		<meta name="keywords" content="NYC,Real Estate,Ann Uduc,Licensed Real Estate Agent,Homes,Houses,Apartments,Sale,Buy,Rent">
  		<meta name="author" content="Ann Uduc">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link rel="stylesheet" href="<spring:url value="/CSS/displayProperty.css" />">
		<title>Property Detail</title>
	</head>
<%
	Property p = (Property) request.getAttribute("property"); 
    DecimalFormat fmt = new DecimalFormat("###,###,###");   // format output of asking price
    
    String special_text = "";   
    if(p.getSpeciald() != null && p.getSpeciald() != "" && !p.getSpeciald().equals("none")){
        if(p.getSpecial() != null) {
	        if(!p.getSpecial().equals("Other")) special_text = p.getSpecial();   
	        else if(p.getSpecialo() != null) special_text = p.getSpecialo();   
        }
    }
%>                                                   
<body>   <!-- NOTE: names below must match names in model class, not names in SQL table -->
	<h1>ASP Property Detail</h1>
	
	<span class="<%=p.getSpeciald()%>"><%=special_text%></span>		
	<img alt="Photo coming soon" src="IMAGES/<%=p.getPhoto_filename()%>" style="float:left; margin-right:5vw">

	<p>Id: ${property.getProperty_id() } </p>
	<p>Address: <%=p.getAddress1()%> <%=p.getAddress2()%></p>
	<p>City: <%=p.getCity()%></p>
	<p>State: <%=p.getState()%></p>
	<p>Zip: <%=p.getZip()%></p>
	<p>Sale Type: <%=p.getSales_type()%></p>
	<p>Property Type: <%=p.getProperty_type()%></p>
	<p>Number of Bedrooms: <%=p.getBedrooms()%></p>
	<p>Number of Bathrooms: <%=p.getBathrooms()%></p>
	<p>Owner Asking Price: $<%=fmt.format(p.getAsking_price())%></p>
	<p>Salesperson Name: <%=p.getSalesperson_name()%></p>
	<p>Salesperson Phone: <%=p.getSalesperson_phone()%></p>
	<p>Salesperson Email: <%=p.getSalesperson_email()%></p>
	<p>Posted Date: <%=p.getPosted_date()%></p>
	<p>Description: <br> <%=p.getDescription()%></p>
					
	<p><a href="homePage?city=all&state=all&order=date" class="button">Back</a></p>

</body>
</html>
