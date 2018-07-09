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
			stmt = conn.prepareStatement(OracleQueries.GETSHOWINGDETAILLIST);
			
			result = stmt.executeQuery();
			while(result.next()) {
				sd = new ShowingDetail();
				sd.setUser_id(result.getInt(1));
				sd.setUser_name(result.getString(2));
				sd.setEmail(result.getString(3));
				sd.setPhone(result.getString(4));
				sd.setUser_message(result.getString(5));
				sd.setProperty_id(result.getInt(6));
				sd.setAddress1(result.getString(7));
				sd.setCity(result.getString(8));
				sd.setState(result.getString(9));
				sd.setZip(result.getString(10));
				sd.setPhoto_filename(result.getString(11));		
				
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
