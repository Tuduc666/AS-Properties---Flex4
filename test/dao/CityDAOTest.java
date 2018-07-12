package dao;

import static org.junit.Assert.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import models.City;

public class CityDAOTest {
	static CityDAO cDAO;
	
	@BeforeClass
	public static void setup() {
		cDAO = new CityDAO();
	}
	
	@Test
	public void testGetCityList() throws IOException, SQLException {
		List<City> l = new ArrayList<City>();
		l = cDAO.getCityList();
			
		assertEquals("Briarwood", l.get(0).getName());
		assertEquals("Bronx", l.get(1).getName());
		assertEquals("Brooklyn", l.get(2).getName());
	}
}
