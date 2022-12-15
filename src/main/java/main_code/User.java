package main_code;

public class User {
	private String userId;
	private String username;
	private String password;
	private String email;
	public User() {
		this.userId = "";
		this.username = "";
		this.password = "";
		this.email = "";
	}
	public User(String userId, String username, String password, String email) {
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.email = email;	
	}
	public User(String username, String password) {
		this.userId = "";
		this.username = username;
		this.password = password;
		this.email = "";	
	}
	public String getId() {
		return userId;
	}


	public void setId(String userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}