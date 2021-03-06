<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>  
<!DOCTYPE html>
<%@ page errorPage="errorPage.jsp" %>
<%@ page import="models.*,dao.*" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.text.DecimalFormat" %>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link rel="stylesheet" href="<spring:url value="/CSS/ulist.css" />">
		<title>Admin AS Properties NYC</title>
	</head>
<%
	User u = null; UserDAO uDAO = null;       
	String city = null;
	String state = null;
	String order = null;
	DecimalFormat fmt = new DecimalFormat("###,###,###");   // format output of asking price   
try {
	u = (User) session.getAttribute("userkey");
	
	city = (String) request.getAttribute("city");
	state = (String) request.getAttribute("state");
	order = (String) request.getAttribute("order");
	
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
			<h1>AS Properties NYC</h1>
			
			<div class="background"></div>   

	<nav>
	<ul>
<!-- HOME -->
	    <li><a href="showingDetailList">Home</a></li>
		
<!-- CITY -->  <!-- added JavaScript onclick to solve the IOS hover issue on mobile devices -->
<!-- Method 1 - one way of doing it, using out.print -->
	    <li class="dropdown">
		<a class="dropbtn" style="color:yellow;" id="selectCity" 
		   onclick="showDropdown('selectCitydrop')">City:<%=city%></a>
		<div class="dropdown-content" id="selectCitydrop" >
			<a href="adminDetailList?city=all&state=<%=state%>&order=<%=order%>">City:All</a>
			<%
			CityDAO cityDAO= null;		
			List<City> lc = null;
			try {
				cityDAO= new CityDAO();		
				lc = new ArrayList<City>();
				lc = cityDAO.getCityList();
				
				for (City c : lc){
					out.print("<a href=\"adminDetailList?city=" + c.getName() + "&state="); %><%=state%>		
				<% 	out.print("&order="); %><%=order%>		
				<% 	out.print("\">" + c.getName() + "</a>"); %>
			<% 	
				}  
			}
			catch(Exception e) {  
				throw new Exception("Ooops. Something went wrong when the system was trying to do city selection in the admin detail list page.");
			}					
			%> 
			<!-- ***************  This is the string we're building above    **************************     -->		
			<!-- ***************  <a href="adminDetailList?city=Bronx&state=<%=state%>&order=<%=order%>">Bronx</a>   -->
		</div>
	    </li>

<!-- STATE -->  <!-- added JavaScript onclick to solve the IOS hover issue on mobile devices -->
<!-- Method 2 - another way of doing it, using expression function -->
	    <li class="dropdown">
		<a class="dropbtn" style="color:yellow;" id="selectState" 
		   onclick="showDropdown('selectStatedrop')">State:<%=state%></a>
		<div class="dropdown-content" id="selectStatedrop">
			<a href="adminDetailList?city=<%=city%>&state=all&order=<%=order%>">State:All</a>
			<%
			StateDAO stateDAO= null;		
			List<State> l = null;
			try {
				stateDAO= new StateDAO();		
				l = new ArrayList<State>();
				l = stateDAO.getStateList();
				for (State s : l){ %>
					<a href="adminDetailList?city=<%=city%>&state=<%=s.getCode()%>
					&order=<%=order%>"><%=s.getCode()%></a>
			<% 	
				}  
			}
			catch(Exception e) {  
				throw new Exception("Ooops. Something went wrong when the system was trying to do state selection in the admin detail list page.");
			}
			%> 
			<!-- ***************  This is the string we're building above    **************************     -->				
			<!-- ***************  <a href="adminDetailList?city=<%=city%>&state=CA&order=<%=order%>">CA</a>   -->				
		</div>
	    </li>

<!-- ORDER BY -->  <!-- added JavaScript onclick to solve the IOS hover issue on mobile devices -->
	  	<li class="dropdown">
		<a class="dropbtn" style="color:powderblue;" id="orderBy" 
		   onclick="showDropdown('orderBydrop')">Order by:<%=order%></a>
		<div class="dropdown-content" id="orderBydrop">
			<a href="adminDetailList?city=<%=city%>&state=<%=state%>&order=date">Order by Posted Date</a>
			<a href="adminDetailList?city=<%=city%>&state=<%=state%>&order=price">Order by Price</a>
		</div>
	    </li>
	    
<!-- ADD NEW PROPERTY  -->
	    <li><a href="addProperty">Add Property</a></li>
	    
	    
<!-- SALESPERSON MAINTENANCE  -->
	    <li><a href="salesDetailList">Salespersons</a></li>   
	    <!------- li><a href="usersMaintenance.html">Users List Maintenance</a></li>                -->
	    
<!-- UPDATE PROFILE -->
	    <!-- <li><a href="adminUpdateProfile">Update Profile</a></li> -->
	    
<!-- logout -->
	    <li><a href="logout">Logout</a></li>
	</ul>
    </nav>


<!-- DETAIL LIST -->
<%
PropertyDAO propertyDAO= null;		
List<Property> pl = null;
try {
 	propertyDAO= new PropertyDAO();		
 	pl = new ArrayList<Property>();
 	Boolean admin = u.getUser_type().equals("Admintandha");   // determine whether to display inactive properties or not
	if(!admin) 
		throw new Exception("You need admin credentials to access this page.");
 	pl = propertyDAO.getPropertyList(city, state, order, admin);
 	for (Property s : pl){ 
        String special_text = "";   
        if(s.getSpeciald() != null && s.getSpeciald() != "" && !s.getSpeciald().equals("none")){
	        if(s.getSpecial() != null) {
		        if(!s.getSpecial().equals("Other")) special_text = s.getSpecial();   
		        else if(s.getSpecialo() != null) special_text = s.getSpecialo();   
	        }
        }
 %>
		<% 
		String bk = " ";
		if(s.getStatus().equals("Inactive")) bk = "style=\"opacity:.1\" "; 
		%>
 		<div class="flexbox" onclick="showDropdown('cleardrop')" <%=bk%> >
		<a href="updateProperty?id=<%=s.getProperty_id()%>"><img src="IMAGES/<%=s.getPhoto_filename()%>" alt="Photo coming soon"></a>
		<div class="text" >			
			<h2><%=s.getSales_type()%>: $<%=fmt.format(s.getAsking_price())%> <span class="<%=s.getSpeciald()%>"><%=special_text%></span></h2> 
			<p><%=s.getAddress1()%></p>
			<p><%=s.getCity()%>,&nbsp<%=s.getState()%>&nbsp<%=s.getZip()%></p>
		</div>
		<div class="flexbutton">
			<a href="updateProperty?id=<%=s.getProperty_id()%>" class="button">Update</a>
			<a href="inactivateProperty?id=<%=s.getProperty_id()%>" class="button">Inactivate</a>		
		</div>  
	</div>
 <%	}  
}
catch(Exception e) {  
	throw new Exception("Ooops. Something went wrong when the system was trying to display the property list in the admin detail list page.");
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
	
    <script src="<spring:url value="/SCRIPT/homePage.js" />"></script>     
	<noscript>Sorry, your browser does not support JavaScript!</noscript>
		
	</body>
</html>