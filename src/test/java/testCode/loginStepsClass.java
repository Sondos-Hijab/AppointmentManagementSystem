package testCode;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import mainCode.MainLoginClass;
import mainCode.user;

public class loginStepsClass {

	MainLoginClass loginClass1 = new MainLoginClass();
	MainLoginClass loginClass2 = new MainLoginClass();
	MainLoginClass loginClass3 = new MainLoginClass();
	MainLoginClass loginClass4 = new MainLoginClass();
	MainLoginClass loginClass5 = new MainLoginClass();
	MainLoginClass loginClass6 = new MainLoginClass();
	
	static List<user> listOfUsers = new ArrayList<user>();
	List<List<String>> usersList;
	
	static Boolean case1 = false;
	static Boolean case2 = false;
	static Boolean case3 = false;
	static Boolean case4 = false;
	static Boolean case5 = false;
	static Boolean case6 = false;
	
	String case1Username ="Sondos";
	String case1Password = "1234";
	String case1Type = "admin";
	

	String case2Username ="SondosH";
	String case2Password = "sondos";
	String case2Type = "admin";
	
	String case3Username ="SondosH";
	String case3Password = "sondos1234";
	String case3Type = "admin";
	
	
	String case4Username ="Sondos";
	String case4Password = "sondos1234";
	String case4Type = "admin";
	
	String case5Username ="Sama";
	String case5Password = "sama1234";
	String case5Type = "user";
	
	String case6Username ="Raghad";
	String case6Password = "raghad1234";
	String case6Type = "employee";
	
	
	
	@Given("the data table for existing users")
	public void theDataTableForExistingUsers(io.cucumber.datatable.DataTable dataTable) {
		usersList = dataTable.asLists();	
		for(int i=1;i<usersList.size();i++) {
			 user temp = new user(usersList.get(i).get(0).toString(), usersList.get(i).get(1).toString(),usersList.get(i).get(2).toString()); 
			 listOfUsers.add(temp);
		}
		

	}
	
	//wrong password
	@When("I type right username, wrong password and select the right user type")
	public void iTypeRightUsernameWrongPasswordAndSelectTheRightUserType() {
		loginClass1.setLoginUsername(case1Username);
		loginClass1.setLoginPassword(case1Password);
		loginClass1.setLoginType(case1Type);
		 
		
		for(int i=0;i<listOfUsers.size();i++) {
			if(loginClass1.getLoginUsername().equals(listOfUsers.get(i).getUsername()) && 
					!loginClass1.getLoginPassword().equals(listOfUsers.get(i).getPassword()) &&
					loginClass1.getLoginType().equals(listOfUsers.get(i).getType())) {
				
				case1 = true;
				break;
			}
		}
	    // Write code here that turns the phrase above into concrete actions

	}
	@Then("I should see password is incorrect")
	public void iShouldSeePasswordIsIncorrect() {

	    // Write code here that turns the phrase above into concrete actions
		if(case1 == true) {
			System.out.println("Case1: Password is incorrect");
			assertTrue(case1);
		}
	}
	
	
	//wrong password and username
	@When("I type wrong username, wrong password")
	public void iTypeWrongUsernameWrongPassword() {
		loginClass2.setLoginUsername(case2Username);
		loginClass2.setLoginPassword(case2Password);
		loginClass2.setLoginType(case2Type);
	    // Write code here that turns the phrase above into concrete actions
		for(int i=0;i<listOfUsers.size();i++) {
			if(!loginClass2.getLoginUsername().equals(listOfUsers.get(i).getUsername()) && 
					!loginClass2.getLoginPassword().equals(listOfUsers.get(i).getPassword()) &&
					loginClass2.getLoginType().equals(listOfUsers.get(i).getType())) {
				case2 = true;
			}
		}
	}

	@Then("I should see password and username are incorrect")
	public void iShouldSeePasswordAndUsernameAreIncorrect() {
	    // Write code here that turns the phrase above into concrete actions
		if(case2 == true) {
			System.out.println("Case2: Password and Username are incorrect");
			assertTrue(case2);
		}

	}

	//wrong username
	@When("I type wrong username, right password and right user type")
	public void iTypeWrongUsernameRightPasswordAndRightUserType() {
	    // Write code here that turns the phrase above into concrete actions
		loginClass3.setLoginUsername(case3Username);
		loginClass3.setLoginPassword(case3Password);
		loginClass3.setLoginType(case3Type);
	    // Write code here that turns the phrase above into concrete actions
		for(int i=0;i<listOfUsers.size();i++) {
			if(!loginClass3.getLoginUsername().equals(listOfUsers.get(i).getUsername()) && 
					loginClass3.getLoginPassword().equals(listOfUsers.get(i).getPassword()) &&
					loginClass3.getLoginType().equals(listOfUsers.get(i).getType())) {
				case3 = true;
				break;
			}
		}
	}
	@Then("I should see username is incorrect")
	public void iShouldSeeUsernameIsIncorrect() {
	    // Write code here that turns the phrase above into concrete actions
		if(case3 == true) {
			System.out.println("Case3: Username is incorrect");
			assertTrue(case3);
		}
	}
	
	//login successfully for admin
	@When("I type right username, right password and the usertype is an admin")
	public void iTypeRightUsernameRightPasswordAndTheUsertypeIsAnAdmin() {
	    // Write code here that turns the phrase above into concrete actions
		loginClass4.setLoginUsername(case4Username);
		loginClass4.setLoginPassword(case4Password);
		loginClass4.setLoginType(case4Type);
	    // Write code here that turns the phrase above into concrete actions
		for(int i=0;i<listOfUsers.size();i++) {
			if(loginClass4.getLoginUsername().equals(listOfUsers.get(i).getUsername()) && 
					loginClass4.getLoginPassword().equals(listOfUsers.get(i).getPassword()) &&
					loginClass4.getLoginType().equals(listOfUsers.get(i).getType())) {
				case4 = true;
				break;
			}
		}
	}
	@Then("I should be on the admins home page")
	public void iShouldBeOnTheAdminsHomePage() {
	    // Write code here that turns the phrase above into concrete actions
		if(case4 == true) {
			System.out.println("Case4: Admins Home Page");
		}	
	}
	@Then("I should see Login successful for admin")
	public void iShouldSeeLoginSuccessfulForAdmin() {
	    // Write code here that turns the phrase above into concrete actions
		if(case4 == true) {
			System.out.println("Case4: Login Successful for admin");
			assertTrue(case4);
		}	
	}
	
	//login successfully for user
	@When("I type right username, right password and the usertype is a user")
	public void iTypeRightUsernameRightPasswordAndTheUsertypeIsAUser() {
	    // Write code here that turns the phrase above into concrete actions
		loginClass5.setLoginUsername(case5Username);
		loginClass5.setLoginPassword(case5Password);
		loginClass5.setLoginType(case5Type);
	    // Write code here that turns the phrase above into concrete actions
		for(int i=0;i<listOfUsers.size();i++) {
			if(loginClass5.getLoginUsername().equals(listOfUsers.get(i).getUsername()) && 
					loginClass5.getLoginPassword().equals(listOfUsers.get(i).getPassword()) &&
					loginClass5.getLoginType().equals(listOfUsers.get(i).getType())) {
				case5 = true;
				break;
			}
		}
	}
	@Then("I should be on the users home page")
	public void iShouldBeOnTheUsersHomePage() {
	    // Write code here that turns the phrase above into concrete actions
		if(case5 == true) {
			System.out.println("Case5: Users Home Page");
			assertTrue(case5);
		}
	}
	@Then("I should see Login successful for user")
	public void iShouldSeeLoginSuccessfulForUser() {
	    // Write code here that turns the phrase above into concrete actions
		if(case5 == true) {
			System.out.println("Case5: Login Successful for user");
		}
	}


	//login successfully for employee
	@When("I type right username, right password and the usertype is a employee")
	public void iTypeRightUsernameRightPasswordAndTheUsertypeIsAEmployee() {
		loginClass6.setLoginUsername(case6Username);
		loginClass6.setLoginPassword(case6Password);
		loginClass6.setLoginType(case6Type);
	    // Write code here that turns the phrase above into concrete actions
		for(int i=0;i<listOfUsers.size();i++) {
			if(loginClass6.getLoginUsername().equals(listOfUsers.get(i).getUsername()) && 
					loginClass6.getLoginPassword().equals(listOfUsers.get(i).getPassword()) &&
					loginClass6.getLoginType().equals(listOfUsers.get(i).getType())) {
				case6 = true;
				break;
			}
		}
	}
	@Then("I should be on the employees home page")
	public void iShouldBeOnTheEmployeesHomePage() {
	    // Write code here that turns the phrase above into concrete actions
		if(case6 == true) {
			System.out.println("Case6: Employees Home Page");
			assertTrue(case6);
		}
	}
	@Then("I should see Login successful for employee")
	public void iShouldSeeLoginSuccessfulForEmployee() {
		if(case6 == true) {
			System.out.println("Case6: Login Successful for employee");
		}
	}

	
	@Test
	public void test() {
	}

}
