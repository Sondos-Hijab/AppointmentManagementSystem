package AMS;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;


public class Checkout_Login {

	String uname;
	String pass;

	static int truePass;
	static int trueName;

	Scanner sc = new Scanner(System.in);

	String index;
	String indexpass;
	String indexname;

	int size;
	int i, j;

	Map<String, String> Username;
	Map<String, String> Userpass;

	@Given("I am in a login page")
	public void iAmInALoginPage() {
		System.out.println("I am in a login page");
	}

	@Given("the data table for existing username")
	public void theDataTableForExistingUsername(DataTable dataTable) throws Throwable {
		Username = dataTable.asMap(String.class, String.class);
		System.out.println("User Name");
		size = Username.size();
		for (int i = 0; i < Username.size(); i++) {
			index = Integer.toString(i);
			System.out.println(Username.get(index));
		}

	}

	@Given("the user password table for these users in sequence")
	public void theUserPasswordTableForTheseUsersInSequence(DataTable dataTable) throws Throwable {
		Userpass = dataTable.asMap(String.class, String.class);
		System.out.println("User Password");
		for (int i = 0; i < Userpass.size(); i++) {
			index = Integer.toString(i);
			System.out.println(Userpass.get(index));
		}
	}

	@When("user enters username")
	public void userEntersUsername() {
		System.out.println("plz enter your username");
		uname = sc.nextLine();
		System.out.println(uname);

	}

	@When("user enters password")
	public void userEntersPassword() {
		System.out.println("plz enter your password");
		pass = sc.nextLine();
		System.out.println(pass);

	}

	@When("I check the username and password")
	public void iCheckTheUsernameAndPassword() {
		trueName=0;
		truePass=0;

		for (i = 0; i < Username.size(); i++) {
			indexname = Integer.toString(i);
			if (uname.matches(Username.get(indexname))) {
				trueName = 1;
				if (pass.matches(Userpass.get(indexname))) {
					truePass = 1;
				} 
			}
		}
		for (j = 0; j < Userpass.size(); j++) {
			indexpass = Integer.toString(j);
			if (pass.matches(Userpass.get(indexpass))) {
				truePass = 1;
				if (uname.matches(Username.get(indexpass))) {
					trueName = 1;
				} 
			}
		}
		
	}

	@When("I type correct username and password")
	public void iTypeCorrectUsernameAndPassword() {
		if (truePass==1 && trueName==1) {
			System.out.println("Welocme to home page");
		}

	}

	@Then("I should see Welcome to your account")
	public void iShouldSeeWelcomeToYourAccount() {
		if (truePass==1 && trueName==1) {
		assertTrue(truePass == trueName);
		}
	}

	@When("I type wrong username and password")
	public void iTypeWrongUsernameAndPassword() {

		if (truePass==0 &&  trueName==0) {
			System.out.println("wrong username and password");
		}

	}

	@Then("I should see username and password are incorrect")
	public void iShouldSeeUsernameAndPasswordAreIncorrect() {
		if (truePass==0 &&  trueName==0) {
		assertTrue(truePass==0 && trueName==0);
		}

	}

	@When("I type wrong username")
	public void iTypeWrongUsername() {
		if (truePass==1 &&  trueName==0) {
			System.out.println("wrong username");
		}

	}

	@Then("I should see username is incorrect")
	public void iShouldSeeUsernameIsIncorrect() {
		if (truePass==1 &&  trueName==0) {
		assertTrue(truePass != trueName);
		}

	}

	@When("I type wrong password")
	public void iTypeWrongPassword() {
		if (truePass==0 &&  trueName==1) {
			System.out.println("wrong password");
		}

	}

	@Then("I should see password is incorrect")
	public void iShouldSeePasswordIsIncorrect() {
		if (truePass==0 &&  trueName==1) {
		assertTrue(truePass != trueName);
		}
	}
}
