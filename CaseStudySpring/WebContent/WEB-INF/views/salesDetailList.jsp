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
		<link rel="stylesheet" href="<spring:url value="/CSS/ulist.css" />">
		<title>Salespersons Detail List</title>
	</head>
<%
	User u = null; UserDAO uDAO = null;      
	try {
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
	<body>
			<h1>AS Properties</h1>
			
			<div class="background"></div>   

	<nav>
	<ul>
<!-- HOME -->
	    <li><a href="showingDetailList">Home</a></li>

<!-- Add Salesperson -->
	    <li><a href="addSalesperson">Add Salesperson</a></li>
	    		    
<!-- logout -->
	    <li><a href="logout">Logout</a></li>
	</ul>
    </nav>


<!-- DETAIL LIST -->
<%
SalespersonDAO salespersonDAO= null;		
List<Salesperson> l = null;
try {
 	salespersonDAO= new SalespersonDAO();		
 	l = new ArrayList<Salesperson>();
 	l = salespersonDAO.getSalespersonList();
 	for (Salesperson s : l){ %>
 		<div class="flexbox">
		<div class="text">
			<p>ID-<%=s.getId()%></p>
			<p><%=s.getName()%></p>
			<p><%=s.getPhone()%></p>
			<p><%=s.getEmail()%></p>
		</div>
		<div class="flexbutton">
			<a href="updateSalesperson?id=<%=s.getId()%>" class="button">Update</a>			
			<a href="deleteSalesperson?id=<%=s.getId()%>" class="button">Delete</a>
		</div>  
	</div>
 <%	}  
}
catch(Exception e) {  
	throw new Exception("Ooops. Something went wrong when the system was trying to display the salesperson detail list page.");
}
 %>

	
	<!-- ************* this is how to go to the login page ************** -->
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