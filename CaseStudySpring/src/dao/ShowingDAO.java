package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import models.Showing;
import utils.OracleQueries;

public class ShowingDAO {

	public Showing getShowing(String email, Integer property_id) throws IOException, SQLException 	{
		Showing showing = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet result = null;
		
		try {
			conn = OracleConnection.getConnection();
			stmt = conn.prepareStatement(OracleQueries.GETSHOWING);
			stmt.setString(1, email);
			stmt.setInt(2, property_id);
			result = stmt.executeQuery();
			if(result.next()) {
				showing = new Showing();
				showing.setShow_id(result.getInt(1));
				showing.setEmail(result.getString(2));
				showing.setProperty_id(result.getInt(3));
				showing.setUser_message(result.getString(4));					
				showing.setStatus(result.getString(5));					
				showing.setPhone(result.getString(6));
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
		
		return showing;
	}
	
	public Boolean addShowing(String email, Integer property_id, String user_message, String phone) throws IOException, SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		Integer result = null;          
		
		try {
			conn = OracleConnection.getConnection();
			stmt = conn.prepareStatement(OracleQueries.ADDSHOWING);    
			stmt.setString(1, email);
			stmt.setInt(2, property_id);
			stmt.setString(3, user_message);
			stmt.setString(4, phone);
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
		return result>0;                    
	}

	// use for updating user message and status
	public Boolean updateShowing(String email, Integer property_id, String user_message, 
			                                      String status, String phone) throws IOException, SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		Integer result = null;           
		
		try {
			conn = OracleConnection.getConnection();
			stmt = conn.prepareStatement(OracleQueries.UPDATESHOWING);    
			stmt.setString(1, user_message);  
			stmt.setString(2, status);  
			stmt.setString(3, phone);  
			stmt.setString(4, email);                    
			stmt.setInt(5, property_id);                    
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


	// used for unit testing only
	public boolean deleteShowing(Integer show_id) throws IOException, SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		Integer result = null;           
		
		try {
			conn = OracleConnection.getConnection();
			stmt = conn.prepareStatement(OracleQueries.DELETESHOWING);    
			stmt.setInt(1, show_id);       
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
