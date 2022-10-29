package mainClass;

import java.util.ArrayList;
import java.util.List;

public class Customer extends user {
	List <Reservations> Services = new ArrayList <Reservations>();

	public Customer (String userId, String username, String password, String email){
		super(userId, username, password, email);
		
	}
	public Customer(String username, String password) {
		super( username, password);

	}
	public Customer (){
		super();
		
	}

}
