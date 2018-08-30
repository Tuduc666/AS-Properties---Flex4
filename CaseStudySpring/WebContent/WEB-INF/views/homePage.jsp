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
		<link rel="stylesheet" href="<spring:url value="/CSS/ulist.css" />">
		<title>AS Properties NYC - Homes for sale, buy, and rent in NYC - by Ann Uduc</title>
	</head>
<%
	User u = (User) request.getAttribute("user");        // only pass in user from the login page
	if(u != null) session.setAttribute("userkey", u);    // if user is not passes in, then use userkey
	u = (User) session.getAttribute("userkey");
	
	String city = (String) request.getAttribute("city");
	String state = (String) request.getAttribute("state");
	String order = (String) request.getAttribute("order");
	
    DecimalFormat fmt = new DecimalFormat("###,###,###");   // format output of asking price
%>
	<body>
		<h1  onclick="showDropdown('cleardrop')">AS Properties NYC</h1>
		<h6>(Ann's Selected Properties NYC)</h6>
		
		<div class="background"></div>   

	<nav>
	<ul>
<!-- HOME -->
	    <li><a href="homePage?city=all&state=all&order=date">Home</a></li>
		
<!-- CITY -->  <!-- added JavaScript onclick to solve the IOS hover issue on mobile devices -->
<!-- Method 1 - one way of doing it, using out.print -->
	    <li class="dropdown">
		<a class="dropbtn" style="color:yellow;" id="selectCity" 
		   onclick="showDropdown('selectCitydrop')">City:<%=city%></a>
		<div class="dropdown-content" id="selectCitydrop" >
			<a href="homePage?city=all&state=<%=state%>&order=<%=order%>">City:All</a>
			<%
				CityDAO cityDAO= new CityDAO();		
				List<City> lc = new ArrayList<City>();
				lc = cityDAO.getCityList();
				for (City c : lc){
					out.print("<a href=\"homePage?city=" + c.getName() + "&state="); %><%=state%>		
				<% 	out.print("&order="); %><%=order%>		
				<% 	out.print("\">" + c.getName() + "</a>"); %>
				<% 	}  %> 
			<!-- ***************  This is the string we're building above    **************************     -->		
			<!-- ***************  <a href="homePage?city=Bronx&state=<%=state%>&order=<%=order%>">Bronx</a>   -->
		</div>
	    </li>

<!-- STATE -->  <!-- added JavaScript onclick to solve the IOS hover issue on mobile devices -->
<!-- Method 2 - another way of doing it, using expression function -->
	    <li class="dropdown">
		<a class="dropbtn" style="color:yellow;" id="selectState" 
		   onclick="showDropdown('selectStatedrop')">State:<%=state%></a>
		<div class="dropdown-content" id="selectStatedrop">
			<a href="homePage?city=<%=city%>&state=all&order=<%=order%>">State:All</a>
			<%
				StateDAO stateDAO= new StateDAO();		
				List<State> l = new ArrayList<State>();
				l = stateDAO.getStateList();
				for (State s : l){ %>
					<a href="homePage?city=<%=city%>&state=<%=s.getCode()%>
					&order=<%=order%>"><%=s.getCode()%></a>
			<% 	}  %> 
			<!-- ***************  This is the string we're building above    **************************     -->				
			<!-- ***************  <a href="homePage?city=<%=city%>&state=CA&order=<%=order%>">CA</a>   -->				
		</div>
	    </li>

<!-- ORDER BY -->  <!-- added JavaScript onclick to solve the IOS hover issue on mobile devices -->
	  	<li class="dropdown">
		<a class="dropbtn" style="color:powderblue;" id="orderBy" 
		   onclick="showDropdown('orderBydrop')">Order by:<%=order%></a>
		<div class="dropdown-content" id="orderBydrop">
			<a href="homePage?city=<%=city%>&state=<%=state%>&order=date">Order by Posted Date</a>
			<a href="homePage?city=<%=city%>&state=<%=state%>&order=price">Order by Price</a>
		</div>
	    </li>
	    
<!-- about -->
	    <li><a href="about">About</a></li>

<%
	if(u != null) {
%>		
<!-- UPDATE PROFILE -->
	    <li><a href="userUpdateProfile">Update Profile</a></li>
	    
<!-- logout -->
	    <li><a href="logout">Logout</a></li>
<%
	}
	else {
%>	
<!-- login -->  <!-- added JavaScript onclick to solve the IOS hover issue on mobile devices -->
	  	<li class="dropdown">
		<a class="dropbtn" id="login" onclick="showDropdown('logindrop')">Login</a>
		<div class="dropdown-content" id="logindrop">
			<a href="login">Customer Login</a>
			<a href="adminLogin">Admin Login</a>
		</div>
	    </li>
<%
	}
%>	
	</ul>
    </nav>


<!-- DETAIL LIST -->
<%
 	PropertyDAO propertyDAO= new PropertyDAO();		
 	List<Property> pl = new ArrayList<Property>();
 	pl = propertyDAO.getPropertyList(city, state, order, false);
 	for (Property s : pl){ %>
 		<div class="flexbox" onclick="showDropdown('cleardrop')">
		<a href="displayProperty?id=<%=s.getProperty_id()%>"><img src="IMAGES/<%=s.getPhoto_filename()%>" alt="Photo coming soon"></a>
		<div class="text">
			<h2><%=s.getSales_type()%>: $<%=fmt.format(s.getAsking_price())%></h2> 
			<p><%=s.getAddress1()%></p>
			<p><%=s.getCity()%>,&nbsp<%=s.getState()%>&nbsp<%=s.getZip()%></p>
		</div>
		<div class="flexbutton">
			<a href="displayProperty?id=<%=s.getProperty_id()%>" class="button">Detail</a>
			<a href="showProperty?id=<%=s.getProperty_id()%>" class="button">Request</a>
				
		
		<!-- ***** <a href="contact" class="button">Contact</a> -->			
		 	        	
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
				
	<footer><a href="contact">Ann Uduc, NYS Licensed Real Estate Agent. All listings deemed reliable but not guaranteed. Copyright &copy; 2018 AS Properties NYC.  All rights reserved.</a></footer>
	
    <script src="<spring:url value="/SCRIPT/homePage.js" />"></script>     
	<noscript>Sorry, your browser does not support JavaScript!</noscript>

	</body>
</html>