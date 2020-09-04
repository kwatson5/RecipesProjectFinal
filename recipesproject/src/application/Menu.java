package application;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import dao.CommentDao;
import dao.RecipesDao;
import dao.UserDao;
import entity.Comment;
import entity.Recipes;
import entity.User;

public class Menu {
	// Kim
	private Scanner scanner = new Scanner(System.in);
	private List<String> options = Arrays.asList("Display Recipes", "Create Recipe", "Modify Recipe", "Delete Recipe",
			"Display Comments", "Create Comment", "Modify Comment", "Delete Comment", "Create User", "Delete User", "Display Users", "Modify User");

	public void start() throws SQLException {
		String selection = "";

		do {
			printMenu();
			selection = scanner.nextLine();

			if (selection.equals("1")) {
				displayRecipes();
			} else if (selection.equals("2")) {
				createRecipe();
			} else if (selection.equals("3")) {
				modifyRecipe();
			} else if (selection.equals("4")) {
				deleteRecipe();
			} else if (selection.equals("5")) {
				displayComments();
			} else if (selection.equals("6")) {
				createComment();
			} else if (selection.equals("7")) {
				modifyComment();
			} else if (selection.equals("8")) {
				deleteComment();
			} else if (selection.equals("9")) {
				createUser();
			} else if (selection.equals("10")) {
				deleteUser();
			} else if (selection.equals("11")) {
				displayUsers();
			} else if (selection.equals("12")) {
				modifyUser();
			}

			System.out.println("Press enter to continue...");
			scanner.hasNextLine();
		} while (selection.equals("-1"));

	}

	private void printMenu() {
		System.out.println("Select an Option: \n -------------------");
		for (int i = 0; i < options.size(); i++) {
			System.out.println(i + 1 + "-" + options.get(i));
		}
	}

	private void modifyUser() throws SQLException {
		UserDao.displayUsers();
		System.out.println("Enter User Id to Modify: ");
		int user_id = Integer.parseInt(scanner.nextLine());
		System.out.println("Enter New Username: ");
		String username = scanner.nextLine();
		System.out.println("Enter New Password: ");
		String password = scanner.nextLine();
		System.out.println("Enter New Email: ");
		String email = scanner.nextLine();

		
		UserDao.modifyUser(user_id, username, password, email);
		UserDao.displayUsers();

	}

	private void displayUsers() throws SQLException {
		List<User> user = UserDao.displayUsers();

		user.stream().forEach(System.out::println);
	}

//Jess
	private void deleteUser() throws SQLException {
		UserDao.displayUsers();
		System.out.println("Enter User ID to Delete: ");
		int user_id = Integer.parseInt(scanner.nextLine());
		System.out.println("User " + user_id + " Has Been Deleted");

		UserDao.deleteUser(user_id);
		displayUsers();
	}

	private void createUser() throws SQLException {
		System.out.println("Enter Username: ");
		String username = scanner.nextLine();
		System.out.println("Enter Password (Must Be 5 Characters): ");
		String password = scanner.nextLine();
		System.out.println("Enter Email: ");
		String email = scanner.nextLine();
		System.out.println("Your User ID Has Been Created!");

		UserDao.createUser(username, password, email);
		displayUsers();
	}

	private void deleteComment() throws SQLException {
		CommentDao.displayComments();
		System.out.println("Enter Comment ID to Delete: ");
		int comment_id = Integer.parseInt(scanner.nextLine());
		System.out.println("Comment " + comment_id + "Has Been Deleted");

		CommentDao.deleteComment(comment_id);
		displayComments();
	}

	private void modifyComment() throws SQLException {
		CommentDao.displayComments();
		System.out.println("Enter Comment ID to Modify: ");
		int comment_id = Integer.parseInt(scanner.nextLine());
		System.out.println("Enter New Comment: ");
		String comment = scanner.nextLine();

		CommentDao.modifyComment(comment_id, comment);
		displayComments();

	}

	private void createComment() throws SQLException {
		System.out.println("Enter User Id");
		int user_id = Integer.parseInt(scanner.nextLine());
		System.out.println("Enter Recipe Id");
		int recipes_id = Integer.parseInt(scanner.nextLine());
		System.out.println("Enter Comment: ");
		String comment = scanner.nextLine();

		CommentDao.createComment(user_id, recipes_id, comment);
		displayComments();

	}

	private void displayComments() throws SQLException {
		List<Comment> comment = CommentDao.displayComments();

		comment.stream().forEach(System.out::println);

	}

	private void deleteRecipe() throws SQLException {
		System.out.println("Enter Recipe ID to Delete: ");
		int recipes_id = Integer.parseInt(scanner.nextLine());
		System.out.println("Your Recipe Has Been Deleted");

		RecipesDao.deleteRecipe(recipes_id);
		displayRecipes();

	}

	private void modifyRecipe() throws SQLException {
		displayRecipes();
		System.out.println("Enter Recipe ID to Modify: ");
		int recipes_id = Integer.parseInt(scanner.nextLine());
		System.out.println("Enter New Recipe Name: ");
		String name = scanner.nextLine();
		System.out.println("Enter New Ingredient Information: ");
		String ingredients = scanner.nextLine();
		System.out.println("Enter New Instructions: ");
		String instructions = scanner.nextLine();
		System.out.println("Your Recipe Has Been Updated");

		RecipesDao.modifyRecipe(recipes_id, name, ingredients, instructions);
		displayRecipes();
	}

	private void createRecipe() throws SQLException {
		System.out.println("Enter User Id: ");
		int user_id = Integer.parseInt(scanner.nextLine());
		System.out.println("Enter Recipe Name: ");
		String name = scanner.nextLine();
		System.out.println("Enter Ingredient Information: ");
		String ingredients = scanner.nextLine();
		System.out.println("Enter Instructions: ");
		String instructions = scanner.nextLine();
		System.out.println("Your Recipe Has Been Created!");

		RecipesDao.createRecipe(user_id, name, ingredients, instructions);
		displayRecipes();
	}

	private void displayRecipes() throws SQLException {
		List<Recipes> recipes = RecipesDao.displayRecipes();

		recipes.stream().forEach(recipe -> System.out.println(recipe));

	}

}
