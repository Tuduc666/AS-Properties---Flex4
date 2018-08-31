package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.ShowingDetail;
import utils.OracleQueries;

public class ShowingDetailDAO {

	public List<ShowingDetail> getShowingDetailList() throws IOException, SQLException 	{
		ShowingDetail sd = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet result = null;
		List<ShowingDetail> l = new ArrayList<ShowingDetail>();
		
		try {
			conn = OracleConnection.getConnection();
			stmt = conn.prepareStatement(OracleQueries.GETSHOWINGDETAILLIST);  // returns only active showing requests
			
			result = stmt.executeQuery();
			while(result.next()) {
				sd = new ShowingDetail();
				sd.setUser_name(result.getString(1));
				sd.setEmail(result.getString(2));
				sd.setPhone(result.getString(3));
				sd.setUser_message(result.getString(4));
				sd.setProperty_id(result.getInt(5));
				sd.setAddress1(result.getString(6));
				sd.setCity(result.getString(7));
				sd.setState(result.getString(8));
				sd.setZip(result.getString(9));
				sd.setPhoto_filename(result.getString(10));		
				
				l.add(sd);
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
