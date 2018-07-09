package dao;

import static org.junit.Assert.*;

import java.io.IOException; 
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import models.Salesperson;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SalespersonDAOTest {
	static SalespersonDAO sDAO;
	static 	int id;
	
	@BeforeClass
	public static void setup() {
		sDAO = new SalespersonDAO();		
	}
	
	@Test
	public void t1_testGetSalespersonById() throws IOException, SQLException {
		String expectedEmail = "Ann@gmail.com";
		Salesperson s = sDAO.getSalespersonById(1);
		assertEquals(expectedEmail, s.getEmail());
	}

	@Test
	public void t2_testGetSalespersonList() throws IOException, SQLException {
		List<Salesperson> l = new ArrayList<Salesperson>();
		l = sDAO.getSalespersonList();
		
		assertEquals("Ann@gmail.com", l.get(0).getEmail());
		assertEquals("tam@gmail.com", l.get(1).getEmail());
		assertEquals("max@gmail.com", l.get(2).getEmail());	
	}

	@Test
	public void t3_testAddSalesperson() throws IOException, SQLException {
		String expectedEmail = "testtam@yahoo.com";
		id = sDAO.addSalesperson("tam", "111", expectedEmail, 2.3);
//		System.out.println("add " + id);
		Salesperson s = sDAO.getSalespersonById(id);		
		assertEquals(expectedEmail, s.getEmail());
//		System.out.println("add " + id);
	}

	@Test
	public void t4_testUpdateSalesperson() throws IOException, SQLException {
		String expectedEmail = "testupdate@yahoo.com";
//		System.out.println("update" + id);
		Boolean updt = sDAO.updateSalesperson(id, "tam", "111", expectedEmail, 2.3);
//		System.out.println(updt);
		assertTrue(updt);
		Salesperson s = sDAO.getSalespersonById(id);		
		assertEquals(expectedEmail, s.getEmail());
	}

	@Test
	public void t5_testDeleteSalesperson() throws IOException, SQLException {
		Boolean delt = sDAO.deleteSalesperson(id);
		assertTrue(delt);
		Salesperson u = sDAO.getSalespersonById(id);		
		assertNull(u);
	}
}
