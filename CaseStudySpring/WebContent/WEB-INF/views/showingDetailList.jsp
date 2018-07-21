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
		<link rel="stylesheet" href="<spring:url value="/CSS/ulist.css" />">
		<title>Showing Detail List</title>
	</head>
<%
	User u = (User) request.getAttribute("user");        // only pass in user from the login page
	if(u != null) session.setAttribute("userkey", u);    // if user is not passes in, then use userkey
	u = (User) session.getAttribute("userkey");
	
// 	String city = (String) request.getAttribute("city");
// 	String state = (String) request.getAttribute("state");
// 	String order = (String) request.getAttribute("order");
%>
	<body>
			<h1>ASP Showing Requests</h1>
			
			<div class="background"></div>   

	<nav>
	<ul>
<!-- HOME -->
	    <li><a href="showingDetailList">Home</a></li>
	    
<!-- PROPERTY MAINTENANCE  -->
	    <li><a href="adminDetailList?city=all&state=all&order=date">Properties</a></li>   
	    
<!-- SALESPERSON MAINTENANCE  -->
	    <li><a href="salesDetailList">Salespersons</a></li>   
	    
<!-- UPDATE PROFILE -->
	  <!-- <li><a href="adminUpdateProfile">Update Profile</a></li> -->  
	    
<!-- logout -->
	    <li><a href="logout">Logout</a></li>
	</ul>
    </nav>


<!-- DETAIL LIST -->
<!-- HERE!!!! Need to change to show showing requests list instead!!!!!!!!! -->
<%
 	PropertyDAO propertyDAO= new PropertyDAO();		
 	List<Property> pl = new ArrayList<Property>();
 	Boolean admin = u.getUser_type().equals("Admin");
 	pl = propertyDAO.getPropertyList("all", "all", "date", admin);
 	for (Property s : pl){ %>
 		<div class="flexbox">
		<img src="IMAGES/<%=s.getPhoto_filename()%>" alt="Photo coming soon">
		<div class="text">
			<h2>Asking Price: $<%=s.getAsking_price()%></h2>
			<p>(<%=s.getSales_type()%>)</p>
			<p><%=s.getAddress1()%></p>
			<p><%=s.getCity()%>,&nbsp<%=s.getState()%>&nbsp<%=s.getZip()%></p>
		</div>
		<div class="flexbutton">
			<a href="updateProperty?id=<%=s.getProperty_id()%>" class="button">Update</a>
			<a href="inactivateProperty?id=<%=s.getProperty_id()%>" class="button">Inactivate</a>		
		</div>  
	</div>
 <%	}  %>

	
	<!-- ************* this is how to go to the home page ************** -->
	<!-- *************  <a href="/CaseStudySpring/" >TESTING</a>  ******* -->
	
<%
// 	StateDAO stateDAO= new StateDAO();		
// 	List<State> l = new ArrayList<State>();
// 	l = stateDAO.getStateList();
// 	for (State s : l){
// 		out.print(s.getCode());
// 	}
%>

<%
//get property list
//  	PropertyDAO propertyDAO= new PropertyDAO();		
//  	List<Property> pl = new ArrayList<Property>();
//  	Boolean admin = u.getUser_type().equals("Admin");
//  	pl = propertyDAO.getPropertyList("all", "all", "date", admin);
//  	for (Property s : pl){
//  		out.print(s.getPhoto_filename());
//  	}  
 %>
				
	<footer>Copyright &copy; 2018 AS Properties.  All rights reserved.</footer>
		
	</body>
</html>