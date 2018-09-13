package utils;

public class OracleQueries {

	public final static String GETPROPERTYBYID = "select * from p_property p "
			+ "join p_salesperson s on p.salesperson_id = s.salesperson_id "  
			+ "where p.property_id = ?";
	
	public final static String GETPROPERTYBYSTATE = "select * from p_property p "
			+ "join p_salesperson s on p.salesperson_id = s.salesperson_id "  
			+ "where p.state_code = ? and p.status = 'Active' order by p.posted_date desc, p.property_id";
	public final static String GETPROPERTYBYCITY = "select * from p_property p "
			+ "join p_salesperson s on p.salesperson_id = s.salesperson_id "  
			+ "where p.city_name = ? and p.status = 'Active' order by p.posted_date desc, p.property_id";
	public final static String GETALLPROPERTIESACTIVE = "select * from p_property p "
			+ "join p_salesperson s on p.salesperson_id = s.salesperson_id "  
			+ "where p.status = 'Active' order by p.posted_date desc, p.property_id";
	public final static String GETALLPROPERTIES = "select * from p_property p "
			+ "join p_salesperson s on p.salesperson_id = s.salesperson_id "  
			+ "order by p.posted_date desc, p.property_id";
	
	public final static String GETPROPERTYBYSTATEP = "select * from p_property p "
			+ "join p_salesperson s on p.salesperson_id = s.salesperson_id "  
			+ "where p.state_code = ? and p.status = 'Active' order by p.asking_price, p.property_id";
	public final static String GETPROPERTYBYCITYP = "select * from p_property p "
			+ "join p_salesperson s on p.salesperson_id = s.salesperson_id "  
			+ "where p.city_name = ? and p.status = 'Active' order by p.asking_price, p.property_id";
	public final static String GETALLPROPERTIESACTIVEP = "select * from p_property p "
			+ "join p_salesperson s on p.salesperson_id = s.salesperson_id "  
			+ "where p.status = 'Active' order by p.asking_price, p.property_id";
	public final static String GETALLPROPERTIESP = "select * from p_property p "
			+ "join p_salesperson s on p.salesperson_id = s.salesperson_id "  
			+ "order by p.asking_price, p.property_id";
	
	public final static String ADDPROPERTY = "insert into p_property "
			+ "(address1,address2,city_name,state_code,zipcode,sales_type,property_type,"
			+ "bedrooms,salesperson_id,posted_date,status,photo_filename,mls_number,bathrooms,description,weblink,"
			+ "asking_price, special, specialo, speciald) "
			+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public final static String UPDATEPROPERTY = "update p_property "
			+ "set address1 = ?, address2 = ?, city_name = ?, state_code = ?, zipcode = ?, sales_type = ?, property_type = ?, "
			+ "bedrooms = ?, salesperson_id = ?, posted_date = ?, status = ?, photo_filename = ?, mls_number = ?, "
			+ "bathrooms = ?, description = ?, weblink = ?, asking_price = ?, special=?, specialo=?, speciald=? "
			+ "where property_id = ?";
	public final static String INACTIVATEPROPERTYBYID = "update p_property "
			+ "set status = 'Inactive' where property_id = ?";
	public final static String DELETEPROPERTYBYID = "delete from p_property "
			+ "where property_id = ?";
	
	public final static String GETSHOWING = "select * from p_requestshowing " 
			+ "where email = ? and property_id = ?";
	public final static String ADDSHOWING = "insert into p_requestshowing "
			+ "(email,property_id,user_message, status, phone, user_name) "
			+ "values(?,?,?,'Active',?,?)";
	public final static String UPDATESHOWING = "update p_requestshowing "
			+ "set user_message = ?, status = ?, phone = ? "
			+ "where email = ? and property_id = ?";
	public final static String DELETESHOWING = "delete from p_requestshowing "
			+ "where show_id = ?";
	public final static String DISMISSSHOWING = "update p_requestshowing "
			+ "set status = 'Inactive' where property_id=? and email=?";
	
	public final static String GETSHOWINGDETAILLIST = "select s.user_name, "
			+ "s.email, s.phone, s.user_message, s.property_id, p.address1, p.city_name, "
			+ "p.state_code, p.zipcode, p.photo_filename from p_requestshowing s "  
			+ "join p_property p on s.property_id = p.property_id "  
			+ "where s.status = 'Active' "
			+ "order by s.show_id desc";
	
	public final static String GETSALESPERSONBYID = "select * from p_salesperson " 
			+ "where salesperson_id = ?";
	public final static String GETALLSALESPERSON = "select * from p_salesperson order by salesperson_id ";
	public final static String ADDSALESPERSON = "insert into p_salesperson "
			+ "(salesperson_name,phone,email,commission) "
			+ "values(?,?,?,?)";
	public final static String UPDATESALESPERSON = "update p_salesperson "
			+ "set salesperson_name = ?, phone = ?, email = ?, commission = ? "
			+ "where salesperson_id = ?";
	public final static String DELETESALESPERSON = "delete from p_salesperson "
			+ "where salesperson_id = ?";
	
	public final static String GETUSERBYID = "select * from p_user " 
			+ "where user_id = ?";
	public final static String GETALLUSERS = "select * from p_user order by user_id";
	public final static String ADDUSER = "insert into p_user "
			+ "(user_name,phone,email,user_type,user_password) "
			+ "values(?,?,?,?,?)";
	public final static String UPDATEUSER = "update p_user "
			+ "set user_name=?, phone = ?, email = ?, user_type = ?, user_password = ? "
			+ "where user_id = ?";
	public final static String DELETEUSER = "delete from p_user "
			+ "where user_id = ?";
	public final static String ISVALIDUSER = "select * from p_user " 
			+ "where email = ? ";
	public final static String ISVALIDADMIN = "select * from p_user " 
			+ "where user_type='Admintandha' and email = ? and user_password = ? ";
	
	public final static String GETALLSTATES = "select * from p_state order by code";
	
	public final static String GETALLCITIES = "select * from p_city order by city_name";
	
	
	
	
//	public final static String GETALLINSTRUCTORS = "select * from instructor";
//	public final static String GETINSTRUCTORBYEMAIL = "select * from instructor "
//			+ "where email = ?";	
//	public final static String GETALLCOURSES = "select * from course";
//	public final static String GETCOURSESBYINSTRUCTOR = "select c.COURSE_ID,c.COURSE_NAME,c.MINIMUN_GPA from TEACHING t " 
//			+ "join COURSE c on t.COURSE_ID = c.COURSE_ID "  
//			+ "where t.INSTRUCTOR_ID = ?";
//
//	public final static String GETINSTRUCTORSCOURSES = "select c.COURSE_NAME,c.MINIMUN_GPA,"
//			+ "i.FULL_NAME,i.EMAIL from TEACHING t " 
//			+ "join COURSE c   on t.COURSE_ID = c.COURSE_ID "    
//			+ "join INSTRUCTOR i on t.INSTRUCTOR_ID = i.INSTRUCTOR_ID ";  
//	
//	public final static String GETSTUDENTCOURSES = "select c.COURSE_NAME,"
//			+ "i.FULL_NAME,i.EMAIL from ATTENDING a " 
//			+ "join COURSE c   on a.COURSE_ID = c.COURSE_ID "  
//			+ "join TEACHING t on a.COURSE_ID = t.COURSE_ID "  
//			+ "join INSTRUCTOR i on t.INSTRUCTOR_ID = i.INSTRUCTOR_ID "   
//			+ "where a.STUDENT_ID = ?";

	
}