package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.Property;
import utils.OracleQueries;

public class PropertyDAO {
	
	public Property getPropertyById(Integer id) throws IOException, SQLException 	{
		Property property = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet result = null;
		
		try {
			conn = OracleConnection.getConnection();
			stmt = conn.prepareStatement(OracleQueries.GETPROPERTYBYID);
			stmt.setInt(1, id);
			result = stmt.executeQuery();
			if(result.next()) {
				property = new Property();
				property.setProperty_id(result.getInt(1));
				property.setAddress1(result.getString(2));
				property.setAddress2(result.getString(3));
				property.setCity(result.getString(4));
				property.setState(result.getString(5));
				property.setZip(result.getString(6));
				property.setOwner_name(result.getString(7));
				property.setOwner_phone(result.getString(8));
				property.setSales_type(result.getString(9));
				property.setProperty_type(result.getString(10));
				property.setBedrooms(result.getInt(11));
				property.setSalesperon_id(result.getInt(12));
				property.setPosted_date(result.getDate(13));         // what does get date return??????
				property.setMls_number(result.getString(14));
				property.setAsking_price(result.getDouble(15));
				property.setAcceptance_price(result.getDouble(16));
				property.setStatus(result.getString(17));
				property.setPhoto_filename(result.getString(18));
				// property.setSalesperon_id(result.getInt(19));    // skipping salesperson_id from p_salesperson file
				property.setSalesperson_name(result.getString(20));
				property.setSalesperson_phone(result.getString(21));
				property.setSalesperson_email(result.getString(22));
				property.setSalesperson_comm(result.getFloat(23));			
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			if(result != null) {
				result.close();
			}
			if(stmt != null) {
				stmt.close();
			}
			if(conn != null) {
				conn.close();
			}
		}
		
		return property;
	}
	
	public List<Property> getPropertyList(String city, String state, String order, Boolean admin) throws IOException, SQLException 	{
		Property property = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet result = null;
		List<Property> l = new ArrayList<Property>();
		
		try {
			conn = OracleConnection.getConnection();
			
			// order by posted date
			if(!order.equals("price")){
				if(!city.equals("all")) {
					stmt = conn.prepareStatement(OracleQueries.GETPROPERTYBYCITY);
					stmt.setString(1, city);
				}
				else if(!state.equals("all")) {
					stmt = conn.prepareStatement(OracleQueries.GETPROPERTYBYSTATE);
					stmt.setString(1, state);
				}
				else {
					if(admin) stmt = conn.prepareStatement(OracleQueries.GETALLPROPERTIES);
					else stmt = conn.prepareStatement(OracleQueries.GETALLPROPERTIESACTIVE);  // not admin, show active only
				}
			}
			// order by price
			else{
				if(!city.equals("all")) {
					stmt = conn.prepareStatement(OracleQueries.GETPROPERTYBYCITYP);
					stmt.setString(1, city);
				}
				else if(!state.equals("all")) {
					stmt = conn.prepareStatement(OracleQueries.GETPROPERTYBYSTATEP);
					stmt.setString(1, state);
				}
				else {
					if(admin) stmt = conn.prepareStatement(OracleQueries.GETALLPROPERTIESP);
					else stmt = conn.prepareStatement(OracleQueries.GETALLPROPERTIESACTIVEP);  // not admin, show active only
				}
			}
			
			result = stmt.executeQuery();
			while(result.next()) {
				property = new Property();
				property.setProperty_id(result.getInt(1));
				property.setAddress1(result.getString(2));
				property.setAddress2(result.getString(3));
				property.setCity(result.getString(4));
				property.setState(result.getString(5));
				property.setZip(result.getString(6));
				property.setOwner_name(result.getString(7));
				property.setOwner_phone(result.getString(8));
				property.setSales_type(result.getString(9));
				property.setProperty_type(result.getString(10));
				property.setBedrooms(result.getInt(11));
				property.setSalesperon_id(result.getInt(12));
				property.setPosted_date(result.getDate(13));         // what does get date return??????
				property.setMls_number(result.getString(14));
				property.setAsking_price(result.getDouble(15));
				property.setAcceptance_price(result.getDouble(16));
				property.setStatus(result.getString(17));
				property.setPhoto_filename(result.getString(18));
				// property.setSalesperon_id(result.getInt(19));    // skipping salesperson_id from p_salesperson file
				property.setSalesperson_name(result.getString(20));
				property.setSalesperson_phone(result.getString(21));
				property.setSalesperson_email(result.getString(22));
				property.setSalesperson_comm(result.getFloat(23));		
				
				if(!city.equals("all") && !state.equals("all")) {    // selecting both city and state
					if(state.equals(property.getState())) l.add(property);
				}
				else l.add(property);
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			if(result != null) {
				result.close();
			}
			if(stmt != null) {
				stmt.close();
			}
			if(conn != null) {
				conn.close();
			}
		}
		
		return l;
	}
	
	public int addProperty(String address1, String address2, String city_name, String state_code, String zipcode,
			String owner_name, String owner_phone, String sales_type, String property_type,
			Integer bedrooms, Integer salesperson_id, Date posted_date, String mls_number,
			Double asking_price, Double acceptance_price, String status, String filename) throws IOException, SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		String[] COL = {"property_id"};    // use to get automatic sequence number for field "attending_id"   
		ResultSet result = null;           // this is needed to get the value above for the automatic sequence number
		Integer new_id = null;             // use to store the automatic sequence number
		
		try {
			conn = OracleConnection.getConnection();
			stmt = conn.prepareStatement(OracleQueries.ADDPROPERTY, COL);    // use COL to get value of generated key
			stmt.setString(1, address1);
			stmt.setString(2, address2);
			stmt.setString(3, city_name);
			stmt.setString(4, state_code);
			stmt.setString(5, zipcode);
			stmt.setString(6, owner_name);
			stmt.setString(7, owner_phone);
			stmt.setString(8, sales_type);
			stmt.setString(9, property_type);
			stmt.setInt(10, bedrooms);
			stmt.setInt(11, salesperson_id);
			stmt.setDate(12, posted_date);
			stmt.setString(13, mls_number);
			stmt.setDouble(14, asking_price);
			stmt.setDouble(15, acceptance_price);
			stmt.setString(16, status);
			stmt.setString(17, filename);
			stmt.executeUpdate();
			// get the value of generated key
			result = stmt.getGeneratedKeys();
			if(result.next()) {
				new_id = result.getInt(1);
			}
						
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(stmt != null) {
				stmt.close();
			}
			if(conn != null) {
				conn.close();
			}
		}
		return new_id;                    // new_id is needed for j-unit testing
	}

	public boolean updateProperty(Integer property_id, String address1, String address2, String city_name, String state_code, String zipcode,
			String owner_name, String owner_phone, String sales_type, String property_type,
			Integer bedrooms, Integer salesperson_id, Date posted_date, String mls_number,
			Double asking_price, Double acceptance_price, String status, String filename) throws IOException, SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		Integer result = null;           
		
		try {
			conn = OracleConnection.getConnection();
			stmt = conn.prepareStatement(OracleQueries.UPDATEPROPERTY);    
			stmt.setString(1, address1);
			stmt.setString(2, address2);
			stmt.setString(3, city_name);
			stmt.setString(4, state_code);
			stmt.setString(5, zipcode);
			stmt.setString(6, owner_name);
			stmt.setString(7, owner_phone);
			stmt.setString(8, sales_type);
			stmt.setString(9, property_type);
			stmt.setInt(10, bedrooms);
			stmt.setInt(11, salesperson_id);
			stmt.setDate(12, posted_date);               // date updated correctly?????
			stmt.setString(13, mls_number);
			stmt.setDouble(14, asking_price);
			stmt.setDouble(15, acceptance_price);
			stmt.setString(16, status);
			stmt.setString(17, filename);
			stmt.setInt(18, property_id);          
			result = stmt.executeUpdate();
						
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(stmt != null) {
				stmt.close();
			}
			if(conn != null) {
				conn.close();
			}
		}
		return result > 0;                    
	}


	public boolean inactivateProperty(Integer property_id) throws IOException, SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		Integer result = null;           
		
		try {
			conn = OracleConnection.getConnection();
			stmt = conn.prepareStatement(OracleQueries.INACTIVATEPROPERTYBYID);    
			stmt.setInt(1, property_id);          
			result = stmt.executeUpdate();
						
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(stmt != null) {
				stmt.close();
			}
			if(conn != null) {
				conn.close();
			}
		}
		return result > 0;                    
	}
	
	// note: this is only use for cleaning up in J-unit testing
	public boolean deleteProperty(Integer property_id) throws IOException, SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		Integer result = null;           
		
		try {
			conn = OracleConnection.getConnection();
			stmt = conn.prepareStatement(OracleQueries.DELETEPROPERTYBYID);    
			stmt.setInt(1, property_id);          
			result = stmt.executeUpdate();
						
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(stmt != null) {
				stmt.close();
			}
			if(conn != null) {
				conn.close();
			}
		}
		return result > 0;                    
	}

}