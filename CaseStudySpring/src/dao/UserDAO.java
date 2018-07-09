package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.User;
import utils.OracleQueries;

public class UserDAO {
	
	public User getUserById(int id) throws IOException, SQLException 	{
		User user = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet result = null;
		
		try {
			conn = OracleConnection.getConnection();
			stmt = conn.prepareStatement(OracleQueries.GETUSERBYID);
			stmt.setInt(1, id);
			result = stmt.executeQuery();
			if(result.next()) {
				user = new User();
				user.setUser_id(result.getInt(1));
				user.setUser_name(result.getString(2));
				user.setAddress1(result.getString(3));
				user.setAddress2(result.getString(4));
				user.setCity(result.getString(5));
				user.setState(result.getString(6));
				user.setZip(result.getString(7));
				user.setPhone(result.getString(8));
				user.setEmail(result.getString(9));		
				user.setUser_type(result.getString(10));		
				user.setUser_password(result.getString(11));		
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
		
		return user;
	}
	
	public List<User> getUserList() throws IOException, SQLException 	{
		User user = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet result = null;
		List<User> l = new ArrayList<User>();
		
		try {
			conn = OracleConnection.getConnection();
			stmt = conn.prepareStatement(OracleQueries.GETALLUSERS);		
			result = stmt.executeQuery();
			while(result.next()) {
				user = new User();
				user.setUser_id(result.getInt(1));
				user.setUser_name(result.getString(2));
				user.setAddress1(result.getString(3));
				user.setAddress2(result.getString(4));
				user.setCity(result.getString(5));
				user.setState(result.getString(6));
				user.setZip(result.getString(7));
				user.setPhone(result.getString(8));
				user.setEmail(result.getString(9));		
				user.setUser_type(result.getString(10));
				l.add(user);
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
	
	public int addUser(String user_name, String address1, String address2, String city, String state, String zip,
			String phone, String email, String user_type, String password) throws IOException, SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		String[] COL = {"user_id"};        // use to get automatic sequence number for field "attending_id"   
		ResultSet result = null;           // this is needed to get the value above for the automatic sequence number
		Integer new_id = null;             // use to store the automatic sequence number
		
		try {
			conn = OracleConnection.getConnection();
			stmt = conn.prepareStatement(OracleQueries.ADDUSER, COL);    // use COL to get value of generated key
			stmt.setString(1, user_name);
			stmt.setString(2, address1);
			stmt.setString(3, address2);
			stmt.setString(4, city);
			stmt.setString(5, state);
			stmt.setString(6, zip);
			stmt.setString(7, phone);
			stmt.setString(8, email);
			stmt.setString(9, user_type);
			stmt.setString(10, password);
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

	public boolean updateUser(Integer user_id, String user_name, String address1, String address2, String city, String state, String zip,
			String phone, String email, String user_type, String password) throws IOException, SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		Integer result = null;           
		
		try {
			conn = OracleConnection.getConnection();
			stmt = conn.prepareStatement(OracleQueries.UPDATEUSER);    
			stmt.setString(1, user_name);
			stmt.setString(2, address1);
			stmt.setString(3, address2);
			stmt.setString(4, city);
			stmt.setString(5, state);
			stmt.setString(6, zip);
			stmt.setString(7, phone);
			stmt.setString(8, email);
			stmt.setString(9, user_type);
			stmt.setString(10, password);
			stmt.setInt(11, user_id);          
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


	public boolean deleteUser(Integer user_id) throws IOException, SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		Integer result = null;           
		
		try {
			conn = OracleConnection.getConnection();
			stmt = conn.prepareStatement(OracleQueries.DELETEUSER);    
			stmt.setInt(1, user_id);          
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

	public User isValidUser(String email, String password) throws IOException, SQLException 	{
		User user = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet result = null;
		
		try {
			conn = OracleConnection.getConnection();
			stmt = conn.prepareStatement(OracleQueries.ISVALIDUSER);
			stmt.setString(1, email);          
			stmt.setString(2, password); 
			result = stmt.executeQuery();
			if(result.next()) {
				user = new User();
				user.setUser_id(result.getInt(1));
				user.setUser_name(result.getString(2));
				user.setAddress1(result.getString(3));
				user.setAddress2(result.getString(4));
				user.setCity(result.getString(5));
				user.setState(result.getString(6));
				user.setZip(result.getString(7));
				user.setPhone(result.getString(8));
				user.setEmail(result.getString(9));		
				user.setUser_type(result.getString(10));	
				user.setUser_password(result.getString(11));	
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
		
		return user;
	}
}
