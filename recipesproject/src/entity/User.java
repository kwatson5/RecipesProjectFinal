package entity;

public class User {
//Jess
	private int user_id;
	private String username;
	private String password;
	private String email;

	public User(int user_id, String username, String password, String email) {
		this.user_id = user_id;
		this.username = username;
		this.password = password;
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [userId = " + user_id + ", username = " + username + ", password= " + password + ","
				+ " email = " + email + "]";
	}

	public int getUserId() {
		return user_id;

	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;

	}

	public String getEmail() {
		return email;

	}

}
