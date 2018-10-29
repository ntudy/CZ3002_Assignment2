package connection;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class DatabaseConnection {


	public static void closeConnection(Connection conn) {
		try {
			if (conn != null && !conn.isClosed()) {
				conn.close();
			}
		} catch (SQLException sqle) {
			System.out.println("Error while closing connection.");
		}
	}

	public static Connection getConnection() throws Exception {
		Connection conn = null;
		InputStream input = null;
		Properties prop = new Properties();
		try {
			input =  DatabaseConnection.class.getClassLoader().getResourceAsStream("db.properties");
			prop.load(input);
			String url = "jdbc:mysql://localhost:3306/" + prop.getProperty("database");
			String user = prop.getProperty("user");
			String pwd = prop.getProperty("password");
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url,user,pwd);
		} catch (SQLException sqle) {
			System.out.println("SQLException: Unable to open connection to db: " + sqle.getMessage());
			throw sqle;
		} catch (Exception e) {
			System.out.println("Exception: Unable to open connection to db: " + e.getMessage());
			throw e;
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return conn;
	}
}
