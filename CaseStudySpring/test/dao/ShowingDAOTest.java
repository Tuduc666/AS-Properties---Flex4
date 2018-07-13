package dao;

import static org.junit.Assert.*;

import java.io.IOException;
import java.sql.SQLException;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import models.Showing;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ShowingDAOTest {
	static ShowingDAO sDAO;
	static Integer show_id = 0;
	
	@BeforeClass
	public static void setup() {
		sDAO = new ShowingDAO();	
	}
	
	@Test
	public void t1_testAddShowing() throws IOException, SQLException {
		String email = "test@t.com";
		Integer property_id = 61;
		String user_message = "test showing";
		sDAO.addShowing(email, property_id, user_message, "111");
		Showing s = sDAO.getShowing(email, property_id);	
		assertEquals(user_message, s.getUser_message());
	}
	
	@Test
	public void t2_testGetShowing() throws IOException, SQLException {
		String email = "test@t.com";
		Integer property_id = 61;
		String user_message = "test showing";
		Showing s = sDAO.getShowing(email, property_id);	
		assertEquals(user_message, s.getUser_message());
		show_id = s.getShow_id();
	}

	@Test
	public void t3_testUpdateShowing() throws IOException, SQLException {
		String email = "test@t.com";
		Integer property_id = 61;
		String user_message = "new test showing";
		String status = "Inactive";
		Boolean updt = sDAO.updateShowing(email, property_id, user_message, status, "111");
		assertTrue(updt);
		Showing s = sDAO.getShowing(email, property_id);	
		assertEquals(user_message, s.getUser_message());
	}

	@Test
	public void t4_testDeleteShowing() throws IOException, SQLException {
		String email = "test@t.com";
		Integer property_id = 61;
		Boolean delt = sDAO.deleteShowing(show_id);
		assertTrue(delt);
		Showing s = sDAO.getShowing(email, property_id);			
		assertNull(s);
	}

}
