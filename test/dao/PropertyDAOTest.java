package dao;

import static org.junit.Assert.*;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import models.Property;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PropertyDAOTest {
	static PropertyDAO pDAO;
	static 	int id;
	
	@BeforeClass
	public static void setup() {
		pDAO = new PropertyDAO();
		
	}
	
	@Test
	public void t1_testGetPropertyById() throws IOException, SQLException {
		String expectedAddr1 = "6886 Broadway";
		Property p = pDAO.getPropertyById(1);
		assertEquals(expectedAddr1, p.getAddress1());
	}

	@Test
	public void t2_testGetPropertyList() throws IOException, SQLException {
		List<Property> l = new ArrayList<Property>();
		
		l = pDAO.getPropertyList("all", "all", "date", true);		
		assertEquals("888 125th St", l.get(0).getAddress1());
		assertEquals("866 28th Street", l.get(1).getAddress1());
		
		l = pDAO.getPropertyList("Sunnyside", "all", "date", true);		
		assertEquals("1080 Grand Ave", l.get(0).getAddress1());
		
		l = pDAO.getPropertyList("all", "TX", "date", true);		
		assertEquals("1080 Grand Ave", l.get(0).getAddress1());
		
		l = pDAO.getPropertyList("all", "all", "date", false);		
		assertEquals("888 125th St", l.get(0).getAddress1());
		assertEquals("866 28th Street", l.get(1).getAddress1());
		
		l = pDAO.getPropertyList("Sunnyside", "all", "date", false);		
		assertEquals("1080 Grand Ave", l.get(0).getAddress1());
		
		l = pDAO.getPropertyList("all", "TX", "date", false);		
		assertEquals("1080 Grand Ave", l.get(0).getAddress1());
		
		
		l = pDAO.getPropertyList("all", "all", "price", true);		
		assertEquals("38 18th Street", l.get(0).getAddress1());
		assertEquals("6886 Broadway", l.get(1).getAddress1());
		
		l = pDAO.getPropertyList("Sunnyside", "all", "price", true);		
		assertEquals("1080 Grand Ave", l.get(0).getAddress1());
		
		l = pDAO.getPropertyList("all", "TX", "price", true);		
		assertEquals("1080 Grand Ave", l.get(0).getAddress1());
		
		l = pDAO.getPropertyList("all", "all", "price", false);		
		assertEquals("38 18th Street", l.get(0).getAddress1());
		assertEquals("6886 Broadway", l.get(1).getAddress1());
		
		l = pDAO.getPropertyList("Sunnyside", "all", "price", false);		
		assertEquals("1080 Grand Ave", l.get(0).getAddress1());
		
		l = pDAO.getPropertyList("all", "TX", "price", false);		
		assertEquals("1080 Grand Ave", l.get(0).getAddress1());
	}
	
	@Test
	public void t3_testAddProperty() throws IOException, SQLException, ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  // MM and HH must be uppercase, otherwise date would come out wrong
		Date javaDate = sdf.parse("06/10/2013 18:29:09");
		java.sql.Date sqlDate = new java.sql.Date(javaDate.getTime());   

		String expectedAddr1 = "666 TestBroadway";
		id = pDAO.addProperty(expectedAddr1, "", "Bronx", "NY", "11111", "aaa", "111", "Rental", "Condo", 1, 
				1, sqlDate, "8778788", 5000D, 4900D, "Active", "P000001.jpg");
		Property p = pDAO.getPropertyById(id);		
		assertEquals(expectedAddr1, p.getAddress1());
	}

	@Test
	public void t4_testUpdateProperty() throws IOException, SQLException, ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");   // MM must be uppercase, otherwise date would come out wrong
		Date javaDate = sdf.parse("2018-06-10");
		java.sql.Date sqlDate = new java.sql.Date(javaDate.getTime());   
		
		String expectedAddr1 = "666 UpdatedBroadway";
		Boolean updt = pDAO.updateProperty(id, expectedAddr1, "", "Bronx", "NY", "11111", "aaa", "111", "Rental", "Condo", 1, 
				1, sqlDate, "8778788", 5000D, 4900D, "Active", "P000001.jpg");
		assertTrue(updt);
		Property p = pDAO.getPropertyById(id);		
		assertEquals(expectedAddr1, p.getAddress1());
	}

	@Test
	public void t5_testInactivateProperty() throws ParseException, IOException, SQLException {	
		String expectedStatus = "Inactive";
		Boolean updt = pDAO.inactivateProperty(id);
		assertTrue(updt);
		Property p = pDAO.getPropertyById(id);		
		assertEquals(expectedStatus, p.getStatus());
		pDAO.deleteProperty(id);            // cleaning up the record created for this test
		Property po = pDAO.getPropertyById(id);
		assertNull(po);
	}
}
