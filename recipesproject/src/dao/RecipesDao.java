package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Recipes;

//Jess
public class RecipesDao {

	public static void createRecipe(int user_id, String name, String ingredients, String instructions)
			throws SQLException {
		String sql = "INSERT INTO recipes (user_id, name, ingredients, instructions) VALUES (?, ?, ?, ?)";
		Connection connection = null;
		PreparedStatement statement = null;

		try {
			DBConnection.getInstance();
			connection = DBConnection.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setInt(1, user_id);
			statement.setString(2, name);
			statement.setString(3, ingredients);
			statement.setString(4, instructions);

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

	public static void modifyRecipe(int recipes_id, String name, String ingredients, String instructions)
			throws SQLException {
		String sql = "UPDATE recipes SET name = ?, ingredients = ?, instructions = ? WHERE recipes_id = ?";
		Connection connection = null;
		PreparedStatement statement = null;

		try {
			DBConnection.getInstance();
			connection = DBConnection.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, name);
			statement.setString(2, ingredients);
			statement.setString(3, instructions);
			statement.setInt(4, recipes_id);

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

	public static void deleteRecipe(int recipes_id) throws SQLException {
		String sql = "DELETE FROM recipes WHERE recipes_id = ?";
		Connection connection = null;
		PreparedStatement statement = null;

		try {
			DBConnection.getInstance();
			connection = DBConnection.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setInt(1, recipes_id);

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

	public static List<Recipes> displayRecipes() throws SQLException {
		String sql = "SELECT * FROM recipes";
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		List<Recipes> recipes = new ArrayList<>();

		try {
			DBConnection.getInstance();
			connection = DBConnection.getConnection();
			statement = connection.prepareStatement(sql);

			resultSet = statement.executeQuery();
//Kim
			while (resultSet.next()) {
				int recipes_id = resultSet.getInt("recipes_id");
				String name = resultSet.getString("name");
				String ingredients = resultSet.getString("ingredients");
				String instructions = resultSet.getString("instructions");
				Recipes recipe = new Recipes(recipes_id, name, ingredients, instructions);
				recipes.add(recipe);
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

		return recipes;
	}

}
