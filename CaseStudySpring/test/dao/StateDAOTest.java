package dao;

import static org.junit.Assert.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import models.State;

public class StateDAOTest {
	static StateDAO sDAO;
	
	@BeforeClass
	public static void setup() {
		sDAO = new StateDAO();
	}

	@Test
	public void testGetStateList() throws IOException, SQLException {
		List<State> l = new ArrayList<State>();
		l = sDAO.getStateList();
			
		assertEquals("CA", l.get(0).getCode());
		assertEquals("CT", l.get(1).getCode());
		assertEquals("NJ", l.get(2).getCode());
	}
}
