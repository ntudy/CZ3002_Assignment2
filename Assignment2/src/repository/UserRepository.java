package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import connection.DatabaseConnection;;

public class UserRepository {

	private Connection dbConnection;
	
	public UserRepository() {
		try {
			dbConnection = DatabaseConnection.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean containsResult(String[] params) throws Exception {
		String query = "SELECT * FROM Users WHERE username=? AND password=?";
		boolean contains = false;
		Connection conn = null;
		try {
			conn = dbConnection;
			PreparedStatement prepStmt = conn.prepareStatement(query);
			int count = 1;
			for (String param : params) {
				prepStmt.setString(count, param);
				count++;
			}

			ResultSet rs = prepStmt.executeQuery();
			if (rs.next()) {
				System.out.println("User found in database.");
				contains = true;
			}
		} catch (Exception e) {
			throw e;
		} finally {
			DatabaseConnection.closeConnection(conn);
		}
		return contains;
	}
}
