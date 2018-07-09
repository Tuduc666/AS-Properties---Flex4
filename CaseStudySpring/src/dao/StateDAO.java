package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.State;
import utils.OracleQueries;

public class StateDAO {
	
	public List<State> getStateList() throws IOException, SQLException 	{
		State state = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet result = null;
		List<State> l = new ArrayList<State>();
		
		try {
			conn = OracleConnection.getConnection();
			stmt = conn.prepareStatement(OracleQueries.GETALLSTATES);		
			result = stmt.executeQuery();
			while(result.next()) {
				state = new State();
				state.setCode(result.getString(1));
				state.setName(result.getString(2));
				l.add(state);
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
	
}