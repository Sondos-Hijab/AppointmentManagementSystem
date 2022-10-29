package mainCode;

public class User {
	public String userId;
	public String username;
	public String password;
	public String email;
	public String type;
	

	
	//constructors
	public User() {
			
		}

	
	public User (String username,  String password, String type) {
		this.username = username;
		this.password = password;
		this.type = type;
	}
	
	
	
	//getter and setters
	
	public String getType() {
		return type;
	}

	
	
	public String getId() {
		return userId;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	
	
}
