package springwork.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	
	@RequestMapping("login")      
	public ModelAndView login() {
		ModelAndView mav = new ModelAndView("login");
		return mav;
	}
	
	// testdata - TamD@yahoo.com  adminp, lee@gmail.com  leep
	@PostMapping("/validateLogin")      // called from login view, validate login, call detail list
	public ModelAndView user_info(
			@RequestParam("email") String email,
			@RequestParam("password") String password) throws IOException, SQLException {
		
		String returnPage = "login";
		ModelAndView mav = null;
		
		User u = null; u = new User();
		UserDAO uDAO = null; uDAO = new UserDAO();
		u = uDAO.isValidUser(email, password); 
		
		if(u==null) returnPage = "login";
		else {
			if(u.getUser_type().equals("Admin")) returnPage = "showingDetailList";
			else returnPage = "homePage";
		}
		
		mav = new ModelAndView(returnPage);  
		mav.addObject("user", u);           // the returnPage will make the user a session variable
		mav.addObject("city", "all");           
		mav.addObject("state", "all");           
		mav.addObject("order", "date");           
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
	
	@GetMapping("/userUpdateProfile")   // called from homePage menu bar update profile button, call userUpdateProfile view
	public ModelAndView userUpdateProfile() {	
		ModelAndView mav = new ModelAndView("userUpdateProfile");
		return mav;
	}
	
	@GetMapping("/adminUpdateProfile")   // called from homePage menu bar update profile button, call userUpdateProfile view
	public ModelAndView adminUpdateProfile() {	
		ModelAndView mav = new ModelAndView("adminUpdateProfile");
		return mav;
	}
	
	@PostMapping("/userUpdateSQL")      // called from userUpdateProfile view, update SQL, call homePage
	public ModelAndView userUpdateSQL(@ModelAttribute User u) throws IOException, SQLException {	
		UserDAO userDAO = new UserDAO();
//		Integer userid = u.getUser_id();
//		String name = u.getUser_name();
//		String type = u.getUser_type();
//		String pass = u.getUser_password();
//		userDAO.updateUser(3, "Bruce Lee", "404 Lex", "", "Rego Park", "NY", 
//				"11374", "666-666-6666", "lee@gmail.com", "Customer", "leep");
		userDAO.updateUser(u.getUser_id(), u.getUser_name(), u.getPhone(), u.getEmail(), u.getUser_type(), u.getUser_password());
		
		ModelAndView mav = new ModelAndView("homePage");
		mav.addObject("user", u);          
		mav.addObject("city", "all");           
		mav.addObject("state", "all");           
		mav.addObject("order", "date");    
		return mav;
	}
	
	@PostMapping("/adminUpdateSQL")      // called from userUpdateProfile view, update SQL, call homePage
	public ModelAndView adminUpdateSQL(@ModelAttribute User u) throws IOException, SQLException {	
		UserDAO userDAO = new UserDAO();
		userDAO.updateUser(u.getUser_id(), u.getUser_name(), u.getPhone(), u.getEmail(), u.getUser_type(), u.getUser_password());
		
		ModelAndView mav = new ModelAndView("adminDetailList");
		mav.addObject("user", u);          
		mav.addObject("city", "all");           
		mav.addObject("state", "all");           
		mav.addObject("order", "date");    
		return mav;
	}
	
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
	public ModelAndView addSalesSQL(@ModelAttribute Salesperson s) throws IOException, SQLException {	
		SalespersonDAO sDAO = new SalespersonDAO();
		
//		String name = s.getName();
//		String phone = s.getPhone();
//		String email = s.getEmail();
//		Double comm = s.getComm();

		
		sDAO.addSalesperson(s.getName(), s.getPhone(), s.getEmail(), s.getComm());
		// sDAO.addSalesperson("aaa", "222", "aaa@gmail.com", (double) 2.25);
		
		ModelAndView mav = new ModelAndView("salesDetailList");   
		return mav;
	}
	
	@GetMapping("/updateSalesperson")   // called from salesDetailList detail line button, call updateSalesperson view
	public ModelAndView updateSalesperson(@RequestParam("id") Integer id) throws IOException, SQLException {
		SalespersonDAO sDAO = new SalespersonDAO();
		Salesperson s = new Salesperson();
		s = sDAO.getSalespersonById(id);
		
		ModelAndView mav = new ModelAndView("updateSalesperson");
		mav.addObject("salesperson", s); 
		return mav;
	}
	
	@PostMapping("/updateSalesSQL")      // called from updateSalesperson view, update SQL, call salesDetailList
	public ModelAndView updateSalesSQL(@ModelAttribute Salesperson s) throws IOException, SQLException {	
		SalespersonDAO sDAO = new SalespersonDAO();
		
//		Integer id = s.getId();
//		String name = s.getName();
//		String phone = s.getPhone();
//		String email = s.getEmail();
//		Double comm = s.getComm();

		sDAO.updateSalesperson(s.getId(), s.getName(), s.getPhone(), s.getEmail(), s.getComm());
		
		ModelAndView mav = new ModelAndView("salesDetailList");   
		return mav;
	}
	
	@GetMapping("/deleteSalesperson")   // called from salesDetailList detail line button, delete record, return to salesDetailList view
	public String deleteSalesperson(@RequestParam("id") Integer id) throws IOException, SQLException {
		SalespersonDAO sDAO = new SalespersonDAO();
		sDAO.deleteSalesperson(id);
		
		return "salesDetailList";
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
	public ModelAndView addPropertySQL(@ModelAttribute Property p) throws IOException, SQLException {	
		PropertyDAO pDAO = new PropertyDAO();
		
//		String name = s.getName();
//		String phone = s.getPhone();
//		String email = s.getEmail();
//		Double comm = s.getComm();

		pDAO.addProperty(p.getAddress1(), p.getAddress2(), p.getCity(), p.getState(), p.getZip(), p.getOwner_name(), 
				          p.getOwner_phone(), p.getSales_type(), p.getProperty_type(), p.getBedrooms(), p.getSalesperon_id(), 
				          p.getPosted_date(), p.getMls_number(), p.getAsking_price(), p.getAcceptance_price(), 
				          p.getStatus(), p.getPhoto_filename());
		// pDAO.addSalesperson(s.getName(), s.getPhone(), s.getEmail(), s.getComm());
		// sDAO.addSalesperson("aaa", "222", "aaa@gmail.com", (double) 2.25);
		
		ModelAndView mav = new ModelAndView("adminDetailList");  
		mav.addObject("city", "all");           
		mav.addObject("state", "all");           
		mav.addObject("order", "date");   
		return mav;
	}
	
	@GetMapping("/updateProperty")   // called from adminDetailList detail line button, call updateProperty view
	public ModelAndView updateProperty(@RequestParam("id") Integer id) throws IOException, SQLException {
		PropertyDAO pDAO = new PropertyDAO();
		Property p = new Property();
		p = pDAO.getPropertyById(id);
		
		ModelAndView mav = new ModelAndView("updateProperty");
		mav.addObject("property", p); 
		return mav;
	}
	
	@PostMapping("/updatePropertySQL")      // called from updateProperty view, update p_property table, call adminDetailList
	public ModelAndView updatePropertySQL(@ModelAttribute Property p) throws IOException, SQLException {	
		PropertyDAO pDAO = new PropertyDAO();
		
//		Integer id = s.getId();
//		String name = s.getName();
//		String phone = s.getPhone();
//		String email = s.getEmail();
//		Double comm = s.getComm();

		pDAO.updateProperty(p.getProperty_id(), p.getAddress1(), p.getAddress2(), p.getCity(), p.getState(), p.getZip(), p.getOwner_name(), 
				          p.getOwner_phone(), p.getSales_type(), p.getProperty_type(), p.getBedrooms(), p.getSalesperon_id(), 
				          p.getPosted_date(), p.getMls_number(), p.getAsking_price(), p.getAcceptance_price(), 
				          p.getStatus(), p.getPhoto_filename());
		// sDAO.updateSalesperson(s.getId(), s.getName(), s.getPhone(), s.getEmail(), s.getComm());
		
		ModelAndView mav = new ModelAndView("adminDetailList");  
		mav.addObject("city", "all");           
		mav.addObject("state", "all");           
		mav.addObject("order", "date");   
		return mav;
	}
	
	@GetMapping("/inactivateProperty")      // called from adminDetailList detail line, inactivate property record, return to adminDetailList
	public ModelAndView inactivateProperty(@RequestParam("id") Integer id) throws IOException, SQLException {	
		PropertyDAO pDAO = new PropertyDAO();
		
		pDAO.inactivateProperty(id);
		
		ModelAndView mav = new ModelAndView("adminDetailList");  
		mav.addObject("city", "all");           
		mav.addObject("state", "all");           
		mav.addObject("order", "date");   
		return mav;
	}
	
	@GetMapping("/displayProperty")   // called from homePage detail line button, call displayProperty view
	public ModelAndView displayProperty(@RequestParam("id") Integer id) throws IOException, SQLException {
		PropertyDAO pDAO = new PropertyDAO();
		Property p = new Property();
		p = pDAO.getPropertyById(id);
		
		ModelAndView mav = new ModelAndView("displayProperty");
		mav.addObject("property", p); 
		return mav;
	}
	
//---------- ADD USER -------------------------------
	@RequestMapping("addUserProfile")      // call login view to create new user
	public ModelAndView addUserProfile() {
		ModelAndView mav = new ModelAndView("addUserProfile");
		return mav;
	}
	
	@PostMapping("/addUserSQL")      // called from addUserProfile view, add to p_user table, call homePage
	public ModelAndView addUserSQL(@ModelAttribute User u) throws IOException, SQLException {	
		UserDAO uDAO = new UserDAO();
		User uNew = new User();
		
		Integer i  = uDAO.addUser(u.getUser_name(), u.getPhone(), u.getEmail(), "Customer", u.getUser_password());
		uNew = uDAO.getUserById(i);
		// sDAO.updateSalesperson(s.getId(), s.getName(), s.getPhone(), s.getEmail(), s.getComm());
		
		ModelAndView mav = new ModelAndView("homePage");  
		mav.addObject("user", uNew); 
		mav.addObject("city", "all");           
		mav.addObject("state", "all");           
		mav.addObject("order", "date");   
		return mav;
	}
	
	//---------- SHOWING -------------------------------
	@GetMapping("/showProperty")   // called from homePage detail line button, call showProperty view
	public ModelAndView showProperty(@RequestParam("id") Integer id) throws IOException, SQLException {
		
		ModelAndView mav = new ModelAndView("showProperty");
		mav.addObject("propertyid", id); 
		return mav;
	}
	
	@PostMapping("/showingSQL")      // called from showProperty view, add to p_requestshowing table, call homePage
	public ModelAndView showingSQL(@ModelAttribute Showing s) throws IOException, SQLException {	
		ShowingDAO sDAO = new ShowingDAO();
		
		Showing old = sDAO.getShowing(s.getEmail(), s.getProperty_id());
		if(old==null) sDAO.addShowing(s.getEmail(), s.getProperty_id(), s.getUser_message());
		else sDAO.updateShowing(s.getEmail(), s.getProperty_id(), s.getUser_message(), "Active");
		
		ModelAndView mav = new ModelAndView("homePage");  
		mav.addObject("city", "all");           
		mav.addObject("state", "all");           
		mav.addObject("order", "date");   
		return mav;
	}
}