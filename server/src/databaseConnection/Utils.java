package databaseConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Utils {
	
	private static Connection connection = null;
	
	public static Connection getConnection() throws SQLException
	{
		if (connection == null) {
			return DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres?currentSchema=clinic", "postgres", "qwerty123");
		}
		return connection;
	}
	
	public static String getResponse(int... count) {
		if (count.length == 2) {
			if (count[0] == count[1]) return "OK";
			return "FAIL";
		} 
		else {
			if(count[0] == 1) return "OK";
			return "FAIL";
		}
	}
	
}
