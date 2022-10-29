package mainClass;

public class employee extends user {
	
	public employee (String userId, String username, String password, String email){
		super(userId, username, password, email);
		
	}
	public employee(String username, String password) {
		super( username, password);

	}
	public employee (){
		super();
		
	}

}
