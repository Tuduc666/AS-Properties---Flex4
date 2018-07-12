package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleConnection {
	public static Connection getConnection() throws ClassNotFoundException, IOException, SQLException {
		Connection conn = null;
		Class.forName("oracle.jdbc.driver.OracleDriver");  
		conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", 
				"ANONYMOUS", "Tamduc1166");
		return conn;
	}
}