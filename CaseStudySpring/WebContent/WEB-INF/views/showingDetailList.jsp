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
		<link rel="stylesheet" href="<spring:url value="/CSS/slist.css" />">
		<title>Showing Detail List</title>
	</head>
<%
User u = null; UserDAO uDAO = null;        
try {
	u = (User) request.getAttribute("user");             // only pass in user from the login page
	if(u != null) session.setAttribute("userkey", u);    // if user is not passes in, then use userkey
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
			<h1>Showing Requests</h1>
			
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
ShowingDetailDAO ShowingDetailDAO= null;		
List<ShowingDetail> dl = null;
try {
 	ShowingDetailDAO= new ShowingDetailDAO();		
 	dl = new ArrayList<ShowingDetail>();
 	dl = ShowingDetailDAO.getShowingDetailList();
 	for (ShowingDetail s : dl){ %>
 		<div class="flexbox">
		<img src="IMAGES/<%=s.getPhoto_filename()%>" alt="Photo coming soon">
		<div class="text">
			<h4>(id=<%=s.getProperty_id()%>)&nbsp<%=s.getAddress1()%>&nbsp<%=s.getCity()%>,&nbsp<%=s.getState()%>&nbsp<%=s.getZip()%></h4>
			<p style="margin-top:-1vw;">User: <%=s.getUser_name()%></p>
			<p style="margin-top:-1vw;">Email: <%=s.getEmail()%></p>
			<p style="margin-top:-1vw;">Phone: <%=s.getPhone()%></p>
			<p style="margin-top:-1vw;"><%=s.getUser_message()%></p>
		</div>
		<div class="flexbutton">
			<a href="dismissShowing?id=<%=s.getProperty_id()%>&email=<%=s.getEmail()%>" class="button">Dismiss</a>		
		</div>  
	</div>
 <%	}  
}
catch(Exception e) {  
	throw new Exception("Ooops. Something went wrong when the system was trying to display the showing detail list page.");
}
 %>

	
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