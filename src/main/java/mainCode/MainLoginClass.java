package mainCode;

import java.util.ArrayList;
import java.util.List;

public class MainLoginClass {
	List<user> listOfUsers = new ArrayList<user>();

	user user1 = new user("Sondos", "sondos1234", "admin");
	user user2 = new user("Sama", "sama1234", "user");
	user user3 = new user("Raghad", "raghad1234", "employee");

	public MainLoginClass () {
		listOfUsers.add(user1);
		listOfUsers.add(user2);
		listOfUsers.add(user3);
	}
	
	String loginUsername;
	String loginPassword;
	String loginType;

	public List<user> getListOfUsers() {
		return listOfUsers;
	}
	public void setListOfUsers(List<user> listOfUsers) {
		this.listOfUsers = listOfUsers;
	}
	public String getLoginUsername() {
		return loginUsername;
	}
	public void setLoginUsername(String loginUsername) {
		this.loginUsername = loginUsername;
	}
	public String getLoginPassword() {
		return loginPassword;
	}
	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}
	public String getLoginType() {
		return loginType;
	}
	public void setLoginType(String loginType) {
		this.loginType = loginType;
	}
	
}
