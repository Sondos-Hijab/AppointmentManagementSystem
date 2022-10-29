package AMS;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import mainClass.Admin;
import mainClass.Customer;
import mainClass.employee;
import mainClass.user;

public class loginSteps {


	
	static List<user> listOfUsers = new ArrayList<user>();
	static List<List<String>> usersList1;
	static List<List<String>> usersList2;
	static List<List<String>> usersList3;
	

	static Boolean case1 = false;
	static Boolean case2 = false;
	static Boolean case3 = false;
	static Boolean case4 = false;
	static Boolean case5 = false;
	static Boolean case6 = false;
	
	static List<Admin> listOfAdmins = new ArrayList<Admin>();
	static List<Customer> listOfCustomers = new ArrayList<Customer>();
	static List<employee> listOfEmployees = new ArrayList<employee>();

	user userCase1 = new user("Lena", "12345678hz");
	user userCase2 = new user("Noor", "12345678hz");
	user userCase3 = new user("Noor", "123456789");
	user userCase4 = new user("Raghad", "1234ttttt");
	user userCase5 = new user("Ali", "111111111");
	user userCase6 = new user("Reema", "yyyyhpp12");

	

	@Given("the data table for existing Admins")
	public void theDataTableForExistingAdmins(io.cucumber.datatable.DataTable dataTable) {
		System.out.println("Login test cases");
		usersList1 = dataTable.asLists();	
		for(int i=1;i<usersList1.size();i++) {
			user temp = new user(usersList1.get(i).get(0).toString(), usersList1.get(i).get(1)); 
			Admin temp2 = new Admin(usersList1.get(i).get(0).toString(), usersList1.get(i).get(1)); 
			 listOfUsers.add(temp);
			 listOfAdmins.add((Admin) temp2);
		}

	    
	}
	@Given ("the data table for existing Employees")
	public void theDataTableForExistingEmployees(io.cucumber.datatable.DataTable dataTable) {
		usersList2 = dataTable.asLists();	
		for(int i=1;i<usersList2.size();i++) {
			user temp = new user(usersList2.get(i).get(0).toString(), usersList2.get(i).get(1)); 
			employee temp2 = new employee(usersList2.get(i).get(0).toString(), usersList2.get(i).get(1)); 
			 listOfUsers.add(temp);
			 listOfEmployees.add((employee) temp2);
		}

	}
	@Given ("the data table for existing Customers")
	public void theDataTableForExistingCustomers(io.cucumber.datatable.DataTable dataTable) {
		usersList3 = dataTable.asLists();	
		for(int i=1;i<usersList3.size();i++) {
			user temp = new user(usersList3.get(i).get(0).toString(), usersList3.get(i).get(1)); 
			Customer temp2 = new Customer(usersList3.get(i).get(0).toString(), usersList3.get(i).get(1)); 
			 listOfUsers.add(temp);
			 listOfCustomers.add((Customer) temp2);
		}

	}
	@When("I type right username, wrong password")
	public void iTypeRightUsernameWrongPassword() {

		for(int i=0;i<listOfUsers.size();i++) {
			if(userCase1.getUsername().equals(listOfUsers.get(i).getUsername()) && 
					!userCase1.getPassword().equals(listOfUsers.get(i).getPassword())) {
				case1 = true;
				break;
			}
		}
		
		
	}
	@Then("I should see password is incorrect")
	public void iShouldSeePasswordIsIncorrect() {
		if(case1) {
			System.out.println("Case1: Password is incorrect");
			assertTrue(case1);
		}
	}


	@When("I type wrong username, wrong password")
	public void iTypeWrongUsernameWrongPassword() {
		for(int i=0;i<listOfUsers.size();i++) {
			if(!userCase2.getUsername().equals(listOfUsers.get(i).getUsername()) && 
					!userCase2.getPassword().equals(listOfUsers.get(i).getPassword())) {
				case2 = true;
				break;
			}
		}
	}
	@Then("I should see password and username are incorrect")
	public void iShouldSeePasswordAndUsernameAreIncorrect() {
		if(case2) {
			System.out.println("Case2: Password and Username are incorrect");
			assertTrue(case2);
		}
		
	}



	@When("I type wrong username, right password")
	public void iTypeWrongUsernameRightPassword() {
		for(int i=0;i<listOfUsers.size();i++) {
			if(!userCase3.getUsername().equals(listOfUsers.get(i).getUsername()) && 
					userCase3.getPassword().equals(listOfUsers.get(i).getPassword())) {
				case3 = true;
				break;
			}
		}
	}
	@Then("I should see username is incorrect")
	public void iShouldSeeUsernameIsIncorrect() {
		if(case3) {
			System.out.println("Case3: Username is incorrect");
			assertTrue(case3);
		}
	}


	@When("I type right username, right password and the usertype is an admin")
	public void iTypeRightUsernameRightPasswordAndTheUsertypeIsAnAdmin() {
		for(int i=0;i<listOfAdmins.size();i++) {
			if(userCase4.getUsername().equals(listOfAdmins.get(i).getUsername()) && 
					userCase4.getPassword().equals(listOfAdmins.get(i).getPassword())) {
				case4 = true;
				break;
			}
		}
	}
	@Then("I should see Login successful for admin")
	public void iShouldSeeLoginSuccessfulForAdmin() {	
			if(case4) {
				System.out.println("Case4: Login Successful welcome to Admins Home Page");
				assertTrue(case4);
			}	
	}



	@When("I type right username, right password and the usertype is a customer")
	public void iTypeRightUsernameRightPasswordAndTheUsertypeIsACustomer() {
		for(int i=0;i<listOfCustomers.size();i++) {
			if(userCase5.getUsername().equals(listOfCustomers.get(i).getUsername()) && 
					userCase5.getPassword().equals(listOfCustomers.get(i).getPassword())) {
				case5 = true;
				break;
			}
		}
	}
	@Then("I should see Login successful for user")
	public void iShouldSeeLoginSuccessfulForUser() {
		if(case5) {
			System.out.println("Case4: Login Successful welcome to Customers Home Page");
			assertTrue(case5);
		}
	}

	@When("I type right username, right password and the usertype is a employee")
	public void iTypeRightUsernameRightPasswordAndTheUsertypeIsAEmployee() {
		for(int i=0;i<listOfEmployees.size();i++) {
			if(userCase6.getUsername().equals(listOfEmployees.get(i).getUsername()) && 
					userCase6.getPassword().equals(listOfEmployees.get(i).getPassword())) {
				case6 = true;
				break;
			}
		}
	}
	@Then("I should see Login successful for employee")
	public void iShouldSeeLoginSuccessfulForEmployee() {
		if(case6) {
			System.out.println("Case4: Login Successful welcome to Employees Home Page");
			assertTrue(case6);
		}
	}


}
