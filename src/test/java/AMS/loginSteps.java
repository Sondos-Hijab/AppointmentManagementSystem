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
import mainClass.Employee;
import mainClass.User;

public class loginSteps {


	
	static List<User> listOfUsers = new ArrayList<User>();
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
	static List<Employee> listOfEmployees = new ArrayList<Employee>();

	User userCase1 = new User("Lena", "12345678hz");
	User userCase2 = new User("Noor", "12345678hz");
	User userCase3 = new User("Noor", "123456789");
	User userCase4 = new User("Raghad", "1234ttttt");
	User userCase5 = new User("Ali", "111111111");
	User userCase6 = new User("Reema", "yyyyhpp12");

	

	@Given("the data table for existing Admins")
	public void theDataTableForExistingAdmins(io.cucumber.datatable.DataTable dataTable) {
		System.out.println("Login test cases");
		usersList1 = dataTable.asLists();	
		for(int i=1;i<usersList1.size();i++) {
			User temp = new User(usersList1.get(i).get(0).toString(), usersList1.get(i).get(1)); 
			Admin temp2 = new Admin(usersList1.get(i).get(0).toString(), usersList1.get(i).get(1)); 
			 listOfUsers.add(temp);
			 listOfAdmins.add((Admin) temp2);
		}

	    
	}
	@Given ("the data table for existing Employees")
	public void theDataTableForExistingEmployees(io.cucumber.datatable.DataTable dataTable) {
		usersList2 = dataTable.asLists();	
		for(int i=1;i<usersList2.size();i++) {
			User temp = new User(usersList2.get(i).get(0).toString(), usersList2.get(i).get(1)); 
			Employee temp2 = new Employee(usersList2.get(i).get(0).toString(), usersList2.get(i).get(1)); 
			 listOfUsers.add(temp);
			 listOfEmployees.add((Employee) temp2);
		}

	}
	@Given ("the data table for existing Customers")
	public void theDataTableForExistingCustomers(io.cucumber.datatable.DataTable dataTable) {
		usersList3 = dataTable.asLists();	
		for(int i=1;i<usersList3.size();i++) {
			User temp = new User(usersList3.get(i).get(0).toString(), usersList3.get(i).get(1)); 
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

	@When("I type right username, right password and the user type is an admin")
	public void iTypeRightUsernameRightPasswordAndTheUserTypeIsAnAdmin() {
		for(int i=0;i<listOfAdmins.size();i++) {
			if(userCase4.getUsername().equals(listOfAdmins.get(i).getUsername()) && 
					userCase4.getPassword().equals(listOfAdmins.get(i).getPassword())) {
				case4 = true;
				break;
			}
		}
	}


	@Then("I should see this message Login successful for admin")
	public void iShouldSeeThisMessageLoginSuccessfulForAdmin() {
		if(case4) {
			System.out.println("Case4: Login Successful welcome to Admins Home Page");
			assertTrue(case4);
		}	
	}


	@When("I type right username, right password and the user type is a customer")
	public void iTypeRightUsernameRightPasswordAndTheUserTypeIsACustomer() {
		for(int i=0;i<listOfCustomers.size();i++) {
			if(userCase5.getUsername().equals(listOfCustomers.get(i).getUsername()) && 
					userCase5.getPassword().equals(listOfCustomers.get(i).getPassword())) {
				case5 = true;
				break;
			}
		}
	}
	@Then("I should see this message Login successful for customer")
	public void iShouldSeeThisMessageLoginSuccessfulForCustomer() {
		if(case5) {
			System.out.println("Case4: Login Successful welcome to Customers Home Page");
			assertTrue(case5);
		}
	}

	

	@When("I type right username, right password and the user type is an employee")
	public void iTypeRightUsernameRightPasswordAndTheUserTypeIsAnEmployee() {
		for(int i=0;i<listOfEmployees.size();i++) {
			if(userCase6.getUsername().equals(listOfEmployees.get(i).getUsername()) && 
					userCase6.getPassword().equals(listOfEmployees.get(i).getPassword())) {
				case6 = true;
				break;
			}
		}
	}
	@Then("I should see this message Login successful for employee")
	public void iShouldSeeThisMessageLoginSuccessfulForEmployee() {
		if(case6) {
			System.out.println("Case4: Login Successful welcome to Employees Home Page");
			assertTrue(case6);
		}
	}

}
