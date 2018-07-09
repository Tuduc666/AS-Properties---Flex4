package dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import models.User;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserDAOTest {
	static UserDAO uDAO;
	static 	int id;
	
	@BeforeClass
	public static void setup() {
		uDAO = new UserDAO();
		
	}

	@Test
	public void t1_testGetUserById() throws IOException, SQLException {
		String expectedEmail = "TamD@yahoo.com";
		User u = uDAO.getUserById(1);
		assertEquals(expectedEmail, u.getEmail());
	}

	@Test
	public void t2_testGetUserList() throws IOException, SQLException {
		List<User> l = new ArrayList<User>();
		l = uDAO.getUserList();
		
//		System.out.println(l.get(0).getEmail());
//		System.out.println(l.get(1).getEmail());
//		System.out.println(l.get(2).getEmail());
//		System.out.println(l.get(3).getEmail());
//		System.out.println(l.get(4).getEmail());
		
		assertEquals("TamD@yahoo.com", l.get(0).getEmail());
		assertEquals("AnnD@yahoo.com", l.get(1).getEmail());
		assertEquals("lee@gmail.com", l.get(2).getEmail());	
	}

	@Test
	public void t3_testAddUser() throws IOException, SQLException {
		String expectedEmail = "test@yahoo.com";
		id = uDAO.addUser("tam", "111", "", "Bronx", "NY", "11111", "1111", expectedEmail, "Customer", "tt");
		User u = uDAO.getUserById(id);		
		assertEquals(expectedEmail, u.getEmail());
	}

	@Test
	public void t4_testUpdateUser() throws IOException, SQLException {
		String expectedEmail = "testupdate@yahoo.com";
		Boolean updt = uDAO.updateUser(id, "tam", "111", "", "Bronx", "NY", "11111", "1111", expectedEmail, "Customer", "tt");
		assertTrue(updt);
		User u = uDAO.getUserById(id);		
		assertEquals(expectedEmail, u.getEmail());
	}

	@Test
	public void t5_testDeleteUser() throws IOException, SQLException {
		Boolean delt = uDAO.deleteUser(id);
		assertTrue(delt);
		User u = uDAO.getUserById(id);		
		assertNull(u);
	}

	@Test
	public void t6_testIsValidUser() throws IOException, SQLException {
		String expectedEmail = "TamD@yahoo.com";
		User u = uDAO.isValidUser(expectedEmail, "adminp");
		assertEquals(expectedEmail, u.getEmail());
		u = uDAO.isValidUser(expectedEmail, "tttt");
		assertNull(u);
	}
}
