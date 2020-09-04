package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import entity.User;

//Jess
public class UserDao {

	public static void createUser(String username, String password, String email) throws SQLException {
		String sql = "INSERT INTO user (username, password, email) VALUES (?, ?, ?)";
		Connection connection = null;
		PreparedStatement statement = null;

		try {
			DBConnection.getInstance();
			connection = DBConnection.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, username);
			statement.setString(2, password);
			statement.setString(3, email);

			statement.executeUpdate();

		} finally {
			if (statement != null) {
				statement.close();
			}
			if (connection != null) {
				connection.close();
			}
		}
	}

	public static void modifyUser(int user_id, String username, String password, String email) throws SQLException {
		String sql = "UPDATE user SET username = ?, password = ?, email = ? WHERE user_id = ?";
		Connection connection = null;
		PreparedStatement statement = null;

		try {
			DBConnection.getInstance();
			connection = DBConnection.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, username);
			statement.setString(2, password);
			statement.setString(3, email);
			statement.setInt(4, user_id);

			statement.executeUpdate();

		} finally {
			if (statement != null) {
				statement.close();
			}
			if (connection != null) {
				connection.close();
			}
		}
	}

	public static void deleteUser(int user_id) throws SQLException {
		String sql = "DELETE FROM user WHERE user_id = ?";
		Connection connection = null;
		PreparedStatement statement = null;

		try {
			DBConnection.getInstance();
			connection = DBConnection.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setInt(1, user_id);

			statement.executeUpdate();

		} finally {
			if (statement != null) {
				statement.close();
			}
			if (connection != null) {
				connection.close();
			}
		}
	}

	
	public static List<User> displayUsers() throws SQLException {
		String sql = "SELECT * FROM user";
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		List<User> users = new ArrayList<>();

		try {
			DBConnection.getInstance();
			connection = DBConnection.getConnection();
			statement = connection.prepareStatement(sql);

			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				int user_id = resultSet.getInt("user_id");
				String username = resultSet.getString("username");
				String password = resultSet.getString("password");
				String email = resultSet.getString("email");
				User user = new User(user_id, username, password, email);
				users.add(user);

			}
			
		} finally {
			if (resultSet != null) {
				resultSet.close();
			}
			if (statement != null) {
				statement.close();
			}
			if (connection != null) {
				connection.close();
			}

		}
		return users;
	}

}
