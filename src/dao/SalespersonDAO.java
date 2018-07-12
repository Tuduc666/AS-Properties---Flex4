package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.Salesperson;
import utils.OracleQueries;

public class SalespersonDAO {
	
	public Salesperson getSalespersonById(Integer id) throws IOException, SQLException 	{
		Salesperson salesperson = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet result = null;
		
		try {
			conn = OracleConnection.getConnection();
			stmt = conn.prepareStatement(OracleQueries.GETSALESPERSONBYID);
			stmt.setInt(1, id);
			result = stmt.executeQuery();
			if(result.next()) {
				salesperson = new Salesperson();
				salesperson.setId(result.getInt(1));
				salesperson.setName(result.getString(2));
				salesperson.setPhone(result.getString(3));
				salesperson.setEmail(result.getString(4));
				salesperson.setComm(result.getDouble(5));			
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
		
		return salesperson;
	}
	
	public List<Salesperson> getSalespersonList() throws IOException, SQLException 	{
		Salesperson salesperson = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet result = null;
		List<Salesperson> l = new ArrayList<Salesperson>();
		
		try {
			conn = OracleConnection.getConnection();
			stmt = conn.prepareStatement(OracleQueries.GETALLSALESPERSON);			
			result = stmt.executeQuery();
			while(result.next()) {
				salesperson = new Salesperson();
				salesperson.setId(result.getInt(1));
				salesperson.setName(result.getString(2));
				salesperson.setPhone(result.getString(3));
				salesperson.setEmail(result.getString(4));
				salesperson.setComm(result.getDouble(5));		
				l.add(salesperson);
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
	
	public int addSalesperson(String name, String phone, String email, Double comm) throws IOException, SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		String[] COL = {"salesperson_id"};    // use to get automatic sequence number for field "attending_id"   
		ResultSet result = null;              // this is needed to get the value above for the automatic sequence number
		Integer new_id = null;                // use to store the automatic sequence number
		
		try {
			conn = OracleConnection.getConnection();
			stmt = conn.prepareStatement(OracleQueries.ADDSALESPERSON, COL);    // use COL to get value of generated key
			stmt.setString(1, name);
			stmt.setString(2, phone);
			stmt.setString(3, email);
			stmt.setDouble(4, comm);
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

	public boolean updateSalesperson(Integer salesperson_id, String name, String phone, String email, 
															Double comm) throws IOException, SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		Integer result = null;           
		
		try {
			conn = OracleConnection.getConnection();
			stmt = conn.prepareStatement(OracleQueries.UPDATESALESPERSON);    
			stmt.setString(1, name);
			stmt.setString(2, phone);
			stmt.setString(3, email);
			stmt.setDouble(4, comm);
			stmt.setInt(5, salesperson_id);          
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

	public boolean deleteSalesperson(Integer salesperson_id) throws IOException, SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		Integer result = null;           
		
		try {
			conn = OracleConnection.getConnection();
			stmt = conn.prepareStatement(OracleQueries.DELETESALESPERSON);    
			stmt.setInt(1, salesperson_id);          
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
