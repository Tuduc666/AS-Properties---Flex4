package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.City;
import utils.OracleQueries;

public class CityDAO {
	
	public List<City> getCityList() throws IOException, SQLException 	{
		City city = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet result = null;
		List<City> l = new ArrayList<City>();
		
		try {
			conn = OracleConnection.getConnection();
			stmt = conn.prepareStatement(OracleQueries.GETALLCITIES);		
			result = stmt.executeQuery();
			while(result.next()) {
				city = new City();
				city.setName(result.getString(1));
				l.add(city);
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