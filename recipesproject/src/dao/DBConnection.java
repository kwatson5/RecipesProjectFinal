package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//Jess
public class DBConnection {

	private static final String URL = "jdbc:mysql://localhost:3306/recipes";
	private static final String USERNAME = "root";
	private static final String PASSWORD = null;
	private static DBConnection INSTANCE = new DBConnection();

	private static Connection connection;

	private DBConnection() {
	}

	public static DBConnection getInstance() {
		return INSTANCE;
	}

	public static Connection getConnection() throws SQLException {
		//INSTANCE.connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		DBConnection.connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		System.out.println("Connection Successful");

		return connection;
	}

}
