package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import entity.Comment;

public class CommentDao {

	public static void createComment(int user_id, int recipes_id, String comment) throws SQLException {
		String sql = "INSERT INTO comment (user_id, recipes_id, comment) VALUES (?, ?, ?)";
		Connection connection = null;
		PreparedStatement statement = null;

		try {
			DBConnection.getInstance();
			connection = DBConnection.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setInt(1, user_id);
			statement.setInt(2, recipes_id);
			statement.setString(3, comment);

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

	public static void modifyComment(int comment_id, String comment) throws SQLException {
		String sql = "UPDATE comment SET comment = ? WHERE comment_id = ?";
		Connection connection = null;
		PreparedStatement statement = null;

		try {
			DBConnection.getInstance();
			connection = DBConnection.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, comment);
			statement.setInt(2, comment_id);

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

	public static void deleteComment(int comment_id) throws SQLException {
		String sql = "DELETE FROM comment WHERE comment_id = ?";
		Connection connection = null;
		PreparedStatement statement = null;

		try {
			DBConnection.getInstance();
			connection = DBConnection.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setInt(1, comment_id);

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

	public static List<Comment> displayComments() throws SQLException {
		String sql = "SELECT * FROM comment";
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		List<Comment> comments = new ArrayList<>();

		try {
			DBConnection.getInstance();
			connection = DBConnection.getConnection();
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				int commentId = resultSet.getInt("comment_id");
				String name = resultSet.getString("comment");
				Comment comment = new Comment(commentId, name);
				comments.add(comment);

			}

		} finally {
			if (statement != null) {
				statement.close();
			}
			if (connection != null) {
				connection.close();
			}

		}
		return comments;
	}
}
