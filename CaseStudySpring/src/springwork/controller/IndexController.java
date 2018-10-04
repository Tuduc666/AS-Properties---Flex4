package springwork.controller;

//import java.io.IOException;
//import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dao.PropertyDAO;
import dao.SalespersonDAO;
import dao.ShowingDAO;
import dao.UserDAO;
import models.Property;
import models.Salesperson;
import models.Showing;
import models.User;

@Controller
public class IndexController {

	@RequestMapping("/")      // Home page - homePage
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView("homePage");
		mav.addObject("city", "all");           
		mav.addObject("state", "all");           
		mav.addObject("order", "date"); 
		return mav;
	}
	
	@GetMapping("/homePage")          // called from homePage menu bar selection, call homePage
	public ModelAndView homePage(
			@RequestParam("city") String city,
			@RequestParam("state") String state,
			@RequestParam("order") String order) {
		ModelAndView mav = new ModelAndView("homePage");
		mav.addObject("city", city);           
		mav.addObject("state", state);           
		mav.addObject("order", order);  
		return mav;
	}
	
	@RequestMapping("/login")      
	public ModelAndView login() {
		ModelAndView mav = new ModelAndView("login");
		return mav;
	}
	
	
//	@PostMapping("/customerLogin")      // called from login view, validate login, call detail list
//	public ModelAndView user_info(
//			@RequestParam("email") String email) throws IOException, SQLException {
//		
//		String returnPage = "login";
//		ModelAndView mav = null;
//		
//		User u = null; u = new User();
//		UserDAO uDAO = null; uDAO = new UserDAO();
//		u = uDAO.isValidUser(email); 
//		
//		if(u==null || !u.getUser_type().equals("Customer")) returnPage = "login";
//		else returnPage = "homePage";
//		
//		mav = new ModelAndView(returnPage);  
//		mav.addObject("user", u);           // the returnPage will make the user a session variable
//		mav.addObject("city", "all");           
//		mav.addObject("state", "all");           
//		mav.addObject("order", "date");    
//		mav.addObject("message", "Invalid login. Please click on 'Create new user account' to create a user account before logging in.");  
//		return mav;
//	}
	@PostMapping("/customerLogin")      // called from login view, validate login, call detail list
	public ModelAndView user_info(@RequestParam("email") String email) {
		
		String returnPage = "login";
		ModelAndView mav = null;
		User u = null; UserDAO uDAO = null;
		try {
			u = new User();
			uDAO = new UserDAO();
			u = uDAO.isValidUser(email); 
			
			if(u==null || !u.getUser_type().equals("Customer")) returnPage = "login";
			else returnPage = "homePage";
		}
		catch(Exception e) {  
			returnPage = "errorPageDisplay";
		}	
		
		mav = new ModelAndView(returnPage);  
		mav.addObject("user", u);           // the returnPage will make the user a session variable
		mav.addObject("city", "all");           
		mav.addObject("state", "all");           
		mav.addObject("order", "date");    
		// error message for the error page
		mav.addObject("message", "Ooops. Something went wrong during customer login.");  
		// error message for the login page
		mav.addObject("message2", "Invalid login. Please click on 'Create new user account' to create a user account before logging in.");  
		return mav;
	}
	
	@RequestMapping("/adminLogin")      
	public ModelAndView adminLogin() {
		ModelAndView mav = new ModelAndView("adminLogin");
		return mav;
	}
	
	@PostMapping("/validateAdminLogin")      // called from login view, validate login, call detail list
	public ModelAndView validateAdminLogin(
			@RequestParam("email") String email,
			@RequestParam("password") String password) {
		
		String returnPage = "errorPageDisplay";
		ModelAndView mav = null;
		User u = null; UserDAO uDAO = null; 
		try {		
			u = new User();
			uDAO = new UserDAO();
			u = uDAO.isValidAdmin(email, password); 
			
			if(u==null) returnPage = "errorPageDisplay";
			else returnPage = "showingDetailList";
		}
		catch(Exception e) {  
			returnPage = "errorPageDisplay";
		}			
		mav = new ModelAndView(returnPage);  
		mav.addObject("user", u);           // the returnPage will make the user a session variable
		mav.addObject("city", "all");           
		mav.addObject("state", "all");           
		mav.addObject("order", "date");           		
		mav.addObject("message", "Invalid login. You do not have admin credentials, please log in as a customer using your email address.");  
		return mav;
	}
	
	@GetMapping("/adminDetailList")          // called from adminDetailList menu bar selection, call adminDetailList
	public ModelAndView adminDetailList(
			@RequestParam("city") String city,
			@RequestParam("state") String state,
			@RequestParam("order") String order) {
		ModelAndView mav = new ModelAndView("adminDetailList");
		mav.addObject("city", city);           
		mav.addObject("state", state);           
		mav.addObject("order", order);  
		return mav;
	}
	
	@GetMapping("/showingDetailList")          // called from showingDetailList menu bar selection, call showingDetailList
	public ModelAndView showingDetailList() {
		ModelAndView mav = new ModelAndView("showingDetailList"); 
		return mav;
	}
	
	@GetMapping("/userUpdateProfile")   // called from homePage menu bar update profile button, call userUpdateProfile view
	public ModelAndView userUpdateProfile() {	
		ModelAndView mav = new ModelAndView("userUpdateProfile");
		return mav;
	}
	
//	@GetMapping("/adminUpdateProfile")   // called from homePage menu bar update profile button, call userUpdateProfile view
//	public ModelAndView adminUpdateProfile() {	
//		ModelAndView mav = new ModelAndView("adminUpdateProfile");
//		return mav;
//	}
	
	@PostMapping("/userUpdateSQL")      // called from userUpdateProfile view, update SQL, call homePage
	public ModelAndView userUpdateSQL(@ModelAttribute User u) {	
		UserDAO userDAO = new UserDAO();
//		Integer userid = u.getUser_id();
//		String name = u.getUser_name();
//		String type = u.getUser_type();
//		String pass = u.getUser_password();
//		userDAO.updateUser(3, "Bruce Lee", "404 Lex", "", "Rego Park", "NY", 
//				"11374", "666-666-6666", "lee@gmail.com", "Customer", "leep");
		String returnPage = "homePage";
		try {	
			userDAO.updateUser(u.getUser_id(), u.getUser_name(), u.getPhone(), u.getEmail(), u.getUser_type(), "Customer",
					0, "N");
		}
		catch(Exception e) {  
			returnPage = "errorPageDisplay";
		}	
		ModelAndView mav = new ModelAndView(returnPage);
		mav.addObject("user", u);          
		mav.addObject("city", "all");           
		mav.addObject("state", "all");           
		mav.addObject("order", "date");  
		mav.addObject("message", "Ooops. Something went wrong during user profile update.");  
		return mav;
	}
	
//	@PostMapping("/adminUpdateSQL")      // called from userUpdateProfile view, update SQL, call homePage
//	public ModelAndView adminUpdateSQL(@ModelAttribute User u) throws IOException, SQLException {	
//		UserDAO userDAO = new UserDAO();
//		userDAO.updateUser(u.getUser_id(), u.getUser_name(), u.getPhone(), u.getEmail(), u.getUser_type(), u.getUser_password());
//		
//		ModelAndView mav = new ModelAndView("adminDetailList");
//		mav.addObject("user", u);          
//		mav.addObject("city", "all");           
//		mav.addObject("state", "all");           
//		mav.addObject("order", "date");    
//		return mav;
//	}
	
	@GetMapping("/logout")   // called from homePage menu bar logout button, call logout view
	public String logout() {	
		return "logout";
	}
	
	//---------- SALESPERSONS MAINTENANCE -------------------------------
	@GetMapping("/salesDetailList")   // called from adminDetailList menu bar, call salesDetailList view
	public ModelAndView salesDetailList() {	
		ModelAndView mav = new ModelAndView("salesDetailList");
		return mav;
	}
	
	@GetMapping("/addSalesperson")   // called from salesDetailList menu bar, call salesDetailList view
	public ModelAndView addSalesperson() {	
		ModelAndView mav = new ModelAndView("addSalesperson");
		return mav;
	}
	
	@PostMapping("/addSalesSQL")      // called from addSalesperson view, insert into SQL, call salesDetailList
	public ModelAndView addSalesSQL(@ModelAttribute Salesperson s) {	
		SalespersonDAO sDAO = new SalespersonDAO();
		
//		String name = s.getName();
//		String phone = s.getPhone();
//		String email = s.getEmail();
//		Double comm = s.getComm();

		String returnPage = "salesDetailList";
		try {			
			sDAO.addSalesperson(s.getName(), s.getPhone(), s.getEmail(), s.getComm());
			// sDAO.addSalesperson("aaa", "222", "aaa@gmail.com", (double) 2.25);
		}
		catch(Exception e) {  
			returnPage = "errorPageDisplay";
		}	
		ModelAndView mav = new ModelAndView(returnPage);   
		mav.addObject("message", "Ooops. Something went wrong during add salesperson process.");  
		return mav;
	}
	
	@GetMapping("/updateSalesperson")   // called from salesDetailList detail line button, call updateSalesperson view
	public ModelAndView updateSalesperson(@RequestParam("id") Integer id) {
		String returnPage = "updateSalesperson";
		SalespersonDAO sDAO = null;
		Salesperson s = null;
		try {			
			sDAO = new SalespersonDAO();
			s = new Salesperson();
			s = sDAO.getSalespersonById(id);
		}
		catch(Exception e) {  
			returnPage = "errorPageDisplay";
		}		
		ModelAndView mav = new ModelAndView(returnPage);
		mav.addObject("salesperson", s); 
		mav.addObject("message", "Ooops. Something went wrong during update salesperson process.");  
		return mav;
	}
	
	@PostMapping("/updateSalesSQL")      // called from updateSalesperson view, update SQL, call salesDetailList
	public ModelAndView updateSalesSQL(@ModelAttribute Salesperson s) {	
		SalespersonDAO sDAO = new SalespersonDAO();
		
//		Integer id = s.getId();
//		String name = s.getName();
//		String phone = s.getPhone();
//		String email = s.getEmail();
//		Double comm = s.getComm();
		String returnPage = "salesDetailList";
		try {	
			sDAO.updateSalesperson(s.getId(), s.getName(), s.getPhone(), s.getEmail(), s.getComm());
		}
		catch(Exception e) {  
			returnPage = "errorPageDisplay";
		}	
		ModelAndView mav = new ModelAndView(returnPage);   
		mav.addObject("message", "Ooops. Something went wrong during update salesperson sql process.");  
		return mav;
	}
	

	@GetMapping("/deleteSalesperson")   // called from salesDetailList detail line button, call deleteSalesperson view
	public ModelAndView deleteSalesperson(@RequestParam("id") Integer id) {
		String returnPage = "deleteSalesperson";
		SalespersonDAO sDAO = null;
		Salesperson s = null;
		try {			
			sDAO = new SalespersonDAO();
			s = new Salesperson();
			s = sDAO.getSalespersonById(id);
		}
		catch(Exception e) {  
			returnPage = "errorPageDisplay";
		}		
		ModelAndView mav = new ModelAndView(returnPage);
		mav.addObject("salesperson", s); 
		mav.addObject("message", "Ooops. Something went wrong during delete salesperson process.");  
		return mav;
	}
	
	@PostMapping("/deleteSalesSQL")      // called from deleteSalesperson view, update SQL, call salesDetailList
	public ModelAndView deleteSalesSQL(@ModelAttribute Salesperson s) {	
		SalespersonDAO sDAO = new SalespersonDAO();
		String returnPage = "salesDetailList";
		try {	
			sDAO.deleteSalesperson(s.getId());  
		}
		catch(Exception e) {  
			returnPage = "errorPageDisplay";
		}	
		ModelAndView mav = new ModelAndView(returnPage);   
		mav.addObject("message", "Ooops. Something went wrong during delete salesperson sql process.");  
		return mav;
	}
	
//---------- PROPERTIES MAINTENANCE -------------------------------
//	@GetMapping("/propertyDetailList")   // called from adminDetailList menu bar, call propertyDetailList view
//	public ModelAndView propertyDetailList() {	
//		ModelAndView mav = new ModelAndView("propertyDetailList");
//		return mav;
//	}
	
	@GetMapping("/addProperty")   // called from propertyDetailList menu bar, call propertyDetailList view
	public ModelAndView addProperty() {	
		ModelAndView mav = new ModelAndView("addProperty");
		return mav;
	}
	
	@PostMapping("/addPropertySQL")      // called from addProperty view, insert into SQL, call propertyDetailList
	public ModelAndView addPropertySQL(@ModelAttribute Property p) {	
		PropertyDAO pDAO = new PropertyDAO();
		
//		String name = s.getName();
//		String phone = s.getPhone();
//		String email = s.getEmail();
//		Double comm = s.getComm();
		
		String returnPage = "adminDetailList";
		try {
		pDAO.addProperty(p.getAddress1(), p.getAddress2(), p.getCity(), p.getState(), p.getZip(), p.getSales_type(), p.getProperty_type(), p.getBedrooms(), p.getSalesperon_id(), 
				          p.getPosted_date(), p.getStatus(), p.getPhoto_filename(), p.getMls_number(), p.getBathrooms(), p.getDescription(), 
				          p.getWeblink(), p.getAsking_price(), p.getSpecial(), p.getSpecialo(), p.getSpeciald());
		// pDAO.addSalesperson(s.getName(), s.getPhone(), s.getEmail(), s.getComm());
		// sDAO.addSalesperson("aaa", "222", "aaa@gmail.com", (double) 2.25);
		}
		catch(Exception e) {  
			returnPage = "errorPageDisplay";
		}
		ModelAndView mav = new ModelAndView(returnPage);  
		mav.addObject("city", "all");           
		mav.addObject("state", "all");           
		mav.addObject("order", "date");   
		mav.addObject("message", "Ooops. Something went wrong during add property sql process."); 

		return mav;
	}
	
	@GetMapping("/updateProperty")   // called from adminDetailList detail line button, call updateProperty view
	public ModelAndView updateProperty(@RequestParam("id") Integer id) {
		PropertyDAO pDAO = new PropertyDAO();
		Property p = new Property();
		String returnPage = "updateProperty";
		try {
			p = pDAO.getPropertyById(id);
		}
		catch(Exception e) {  
			returnPage = "errorPageDisplay";
		}
		ModelAndView mav = new ModelAndView(returnPage);
		mav.addObject("property", p); 
		mav.addObject("message", "Ooops. Something went wrong during update property process."); 

		return mav;
	}
	
	@PostMapping("/updatePropertySQL")      // called from updateProperty view, update p_property table, call adminDetailList
	public ModelAndView updatePropertySQL(@ModelAttribute Property p) {	
		PropertyDAO pDAO = new PropertyDAO();
		
//		Integer id = s.getId();
//		String name = s.getName();
//		String phone = s.getPhone();
//		String email = s.getEmail();
//		Double comm = s.getComm();
		
		String returnPage = "adminDetailList";
		try {
		pDAO.updateProperty(p.getProperty_id(), p.getAddress1(), p.getAddress2(), p.getCity(), p.getState(), p.getZip(), p.getSales_type(), 
				p.getProperty_type(), p.getBedrooms(), p.getSalesperon_id(), 
		          p.getPosted_date(), p.getStatus(), p.getPhoto_filename(), p.getMls_number(), p.getBathrooms(), p.getDescription(), 
		          p.getWeblink(), p.getAsking_price(), p.getSpecial(), p.getSpecialo(), p.getSpeciald());
		}
		catch(Exception e) {  
			returnPage = "errorPageDisplay";
		}
		ModelAndView mav = new ModelAndView(returnPage);  
		mav.addObject("city", "all");           
		mav.addObject("state", "all");           
		mav.addObject("order", "date");   
		mav.addObject("message", "Ooops. Something went wrong during update property sql process."); 
		return mav;
	}
	
	@GetMapping("/inactivateProperty")   // called from adminDetailList detail line button, call inactivateProperty view
	public ModelAndView inactivateProperty(@RequestParam("id") Integer id) {
		PropertyDAO pDAO = new PropertyDAO();
		Property p = new Property();
		String returnPage = "inactivateProperty";
		try {
			p = pDAO.getPropertyById(id);
		}
		catch(Exception e) {  
			returnPage = "errorPageDisplay";
		}
		ModelAndView mav = new ModelAndView(returnPage);
		mav.addObject("property", p); 
		mav.addObject("message", "Ooops. Something went wrong during inactivate property process."); 

		return mav;
	}
	
	@PostMapping("/inactivatePropertySQL")      // called from inactivateProperty view, inactivate p_property table, call adminDetailList
	public ModelAndView inactivatePropertySQL(@ModelAttribute Property p)  {	
		PropertyDAO pDAO = new PropertyDAO();
		String returnPage = "adminDetailList";
		try {
			pDAO.inactivateProperty(p.getProperty_id());
		}
		catch(Exception e) {  
			returnPage = "errorPageDisplay";
		}
		ModelAndView mav = new ModelAndView(returnPage);  
		mav.addObject("city", "all");           
		mav.addObject("state", "all");           
		mav.addObject("order", "date");   
		mav.addObject("message", "Ooops. Something went wrong during inactivate property sql process."); 
		return mav;
	}
	
	@GetMapping("/displayProperty")   // called from homePage detail line button, call displayProperty view
	public ModelAndView displayProperty(@RequestParam("id") Integer id) {
		PropertyDAO pDAO = new PropertyDAO();
		Property p = new Property();
		String returnPage = "displayProperty";
		try {
			p = pDAO.getPropertyById(id);
		}
		catch(Exception e) {  
			returnPage = "errorPageDisplay";
		}
		ModelAndView mav = new ModelAndView(returnPage);
		mav.addObject("property", p); 
		mav.addObject("message", "Ooops. Something went wrong during display property process."); 
		return mav;
	}
	
//---------- ADD USER -------------------------------
	@RequestMapping("/addUserProfile")      // call login view to create new user
	public ModelAndView addUserProfile() {
		ModelAndView mav = new ModelAndView("addUserProfile");
		return mav;
	}
	
	@PostMapping("/addUserSQL")      // called from addUserProfile view, add to p_user table, call homePage
	public ModelAndView addUserSQL(@ModelAttribute User u) {	
		UserDAO uDAO = new UserDAO();
		User uNew = new User();
		String returnPage = "homePage";
		
		// check data entered.  Make sure the length does not exceed the max length in the database
//		if((u.getUser_name().length() >50) 
//				|| (u.getPhone().length() >20)
//				|| (u.getEmail().length() >100))
//			returnPage = "errorPageDisplay";
		
		// check data entered.  No need to check each field as done above.  try-catch will catch all exceptions.
		try {
			// check if user already exist.  Insert SQL record would crash because of duplicate record.
			// if uNew is not null, then just pass it back to homePage below
			uNew = uDAO.isValidUser(u.getEmail());  
			
			if(uNew==null) {
				Integer i  = uDAO.addUser(u.getUser_name(), u.getPhone(), u.getEmail(), "Customer", "Customer", 0, "N");
				uNew = uDAO.getUserById(i);
			}
		}
		catch(Exception e) {  
			returnPage = "errorPageDisplay";
		}
//		finally {
		
		ModelAndView mav = new ModelAndView(returnPage);  
		mav.addObject("user", uNew); 
		mav.addObject("city", "all");           
		mav.addObject("state", "all");           
		mav.addObject("order", "date");   
		mav.addObject("message", "Ooops. Something went wrong.  It's possible that the string entered is too long.");  
//		}
		return mav;
	}
	
	//---------- SHOWING -------------------------------
	@GetMapping("/showProperty")   // called from homePage detail line button, call showProperty view
	public ModelAndView showProperty(@RequestParam("id") Integer id) {
		
		ModelAndView mav = new ModelAndView("showProperty");
		mav.addObject("propertyid", id); 
		return mav;
	}
	
	@PostMapping("/showingSQL")      // called from showProperty view, add to p_requestshowing table, call homePage
	public ModelAndView showingSQL(@ModelAttribute Showing s) {	
		ShowingDAO sDAO = new ShowingDAO();
		Showing old = null;
		String returnPage = "homePage";
		try {
			old = sDAO.getShowing(s.getEmail(), s.getProperty_id());
			if(old==null) sDAO.addShowing(s.getEmail(), s.getProperty_id(), s.getUser_message(), 
					                                                  s.getPhone(), s.getUser_name());
			else sDAO.updateShowing(s.getEmail(), s.getProperty_id(), s.getUser_message(), "Active", s.getPhone());
			
			// check if user does already exist, then add user
			UserDAO uDAO = new UserDAO();
			User uNew = uDAO.isValidUser(s.getEmail());  
			if(uNew==null) uDAO.addUser(s.getUser_name(), s.getPhone(), s.getEmail(), "Customer", "Customer", 0, "N");
		}
		catch(Exception e) {  
			returnPage = "errorPageDisplay";
		}
		ModelAndView mav = new ModelAndView(returnPage);  
		mav.addObject("city", "all");           
		mav.addObject("state", "all");           
		mav.addObject("order", "date");   
		mav.addObject("message", "Ooops. Something went wrong during showing sql process."); 

		return mav;
	}
	
	@GetMapping("/dismissShowing")   // called from showingDetailList detail line button, call dismissShowing view
	public ModelAndView dismissShowing(@RequestParam("id") Integer id,@RequestParam("email") String email) {	
		ModelAndView mav = new ModelAndView("dismissShowing");
		mav.addObject("id", id); 
		mav.addObject("email", email); 
		return mav;
	}
	
	@PostMapping("/dismissShowingSQL")      // called from inactivateProperty view, inactivate p_property table, call adminDetailList
	public ModelAndView dismissShowingSQL(@ModelAttribute Showing s)  {	
		ShowingDAO sDAO = new ShowingDAO();
		String returnPage = "showingDetailList";
		try {
			sDAO.dismissShowing(s.getProperty_id(), s.getEmail());
		}
		catch(Exception e) {  
			returnPage = "errorPageDisplay";
		}
		ModelAndView mav = new ModelAndView(returnPage);   
		mav.addObject("message", "Ooops. Something went wrong during dismiss showing sql process."); 
		return mav;
	}
	
	@GetMapping("/contact")   // called from homePage detail line button, call displayProperty view
	public ModelAndView contact() {
		
		ModelAndView mav = new ModelAndView("contact");
		return mav;
	}
	
	//---------- ABOUT -------------------------------
	@GetMapping("/about")   // called from homePage detail line button, call displayProperty view
	public ModelAndView about() {
		
		ModelAndView mav = new ModelAndView("about");
		return mav;
	}
}