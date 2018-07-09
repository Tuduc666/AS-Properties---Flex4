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
		<title>User Detail List</title>
	</head>
<%
	User u = (User) request.getAttribute("user");        // only pass in user from the login page
	if(u != null) session.setAttribute("userkey", u);    // if user is not passes in, then use userkey
	u = (User) session.getAttribute("userkey");
	
	String city = (String) request.getAttribute("city");
	String state = (String) request.getAttribute("state");
	String order = (String) request.getAttribute("order");
%>
	<body>
			<h1>AS Properties</h1>
			
			<div class="background"></div>   

	<nav>
	<ul>
<!-- HOME -->
	    <li><a href="userDetailList?city=all&state=all&order=date">Home</a></li>
		
<!-- CITY -->
<!-- Method 1 - one way of doing it, using out.print -->
	    <li class="dropdown">
		<a class="dropbtn" style="color:yellow;" id="selectCity">City:<%=city%></a>
		<div class="dropdown-content">
			<a href="userDetailList?city=all&state=<%=state%>&order=<%=order%>">City:All</a>
			<%
				CityDAO cityDAO= new CityDAO();		
				List<City> lc = new ArrayList<City>();
				lc = cityDAO.getCityList();
				for (City c : lc){
					out.print("<a href=\"userDetailList?city=" + c.getName() + "&state="); %><%=state%>		
				<% 	out.print("&order="); %><%=order%>		
				<% 	out.print("\">" + c.getName() + "</a>"); %>
				<% 	}  %> 
			<!-- ***************  This is the string we're building above    **************************     -->		
			<!-- ***************  <a href="userDetailList?city=Bronx&state=<%=state%>&order=<%=order%>">Bronx</a>   -->
		</div>
	    </li>

<!-- STATE -->
<!-- Method 2 - another way of doing it, using expression function -->
	    <li class="dropdown">
		<a class="dropbtn" style="color:yellow;" id="selectState">State:<%=state%></a>
		<div class="dropdown-content">
			<a href="userDetailList?city=<%=city%>&state=all&order=<%=order%>">State:All</a>
			<%
				StateDAO stateDAO= new StateDAO();		
				List<State> l = new ArrayList<State>();
				l = stateDAO.getStateList();
				for (State s : l){ %>
					<a href="userDetailList?city=<%=city%>&state=<%=s.getCode()%>
					&order=<%=order%>"><%=s.getCode()%></a>
			<% 	}  %> 
			<!-- ***************  This is the string we're building above    **************************     -->				
			<!-- ***************  <a href="userDetailList?city=<%=city%>&state=CA&order=<%=order%>">CA</a>   -->				
		</div>
	    </li>

<!-- ORDER BY -->
	  	<li class="dropdown">
		<a class="dropbtn" style="color:powderblue;" id="orderBy">Order by:<%=order%></a>
		<div class="dropdown-content">
			<a href="userDetailList?city=<%=city%>&state=<%=state%>&order=date">Order by Posted Date</a>
			<a href="userDetailList?city=<%=city%>&state=<%=state%>&order=price">Order by Price</a>
		</div>
	    </li>
	    
<!-- UPDATE PROFILE -->
	    <li><a href="userUpdateProfile">Update Profile</a></li>
	    
<!-- logout -->
	    <li><a href="logout">Logout</a></li>
	</ul>
    </nav>


<!-- DETAIL LIST -->
<%
 	PropertyDAO propertyDAO= new PropertyDAO();		
 	List<Property> pl = new ArrayList<Property>();
 	Boolean admin = u.getUser_type().equals("Admin");
 	pl = propertyDAO.getPropertyList(city, state, order, admin);
 	for (Property s : pl){ %>
 		<div class="flexbox">
		<img src="IMAGES/<%=s.getPhoto_filename()%>" alt="Property Photo">
		<div class="text">
			<h2>Asking Price: $<%=s.getAsking_price()%></h2>
			<p>(<%=s.getSales_type()%>)</p>
			<p><%=s.getAddress1()%></p>
			<p><%=s.getCity()%>,&nbsp<%=s.getState()%>&nbsp<%=s.getZip()%></p>
		</div>
		<div class="flexbutton">
			<a href="displayProperty?id=<%=s.getProperty_id()%>" class="button">Detail</a>
			<a href="showProperty?id=<%=s.getProperty_id()%>" class="button">Request</a>	
		</div>  
	</div>
 <%	}  %>

	
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