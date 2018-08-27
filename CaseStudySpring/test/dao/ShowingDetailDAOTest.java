package dao;

import static org.junit.Assert.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import models.ShowingDetail;

public class ShowingDetailDAOTest {
	static ShowingDetailDAO sDAO;
	
	@BeforeClass
	public static void setup() {
		sDAO = new ShowingDetailDAO();
	}
	
	@Test
	public void testGetShowingDetailList() throws IOException, SQLException {
		List<ShowingDetail> l = new ArrayList<ShowingDetail>();
		l = sDAO.getShowingDetailList();
			
		assertEquals(3, l.get(0).getUser_id());
		assertEquals(3, l.get(1).getUser_id());

	}
}
