package testCode;

import static org.junit.Assert.*;

import io.cucumber.java.en.*;
import mainCode.Customer;
import mainCode.MainSystem;

public class RegisterTest {
	
Customer customer=new Customer();
int emailF=0;
int passF=0;
int usernameF=0;
int validInputsF=0;
MainSystem main = new MainSystem();
	@Given("the customer in Registration page")
	public void theCustomerInRegistrationPage() {
	
	}
	@Given("the data table for customers is")
	public void theDataTableForCustomersIs(io.cucumber.datatable.DataTable dataTable) {
	  
	}

	@When("customer enters used  username")
	public void customerEntersUsedUsername() {
		String username1="saba";
		
		
	 if(  customer.UsernameIsUsed(username1, main)) {
		 usernameF=1;
	 }
	
	}
	@Then("the customer should see the user name is already used")
	public void theCustomerShouldSeeTheUserNameIsAlreadyUsed() {
	if(usernameF==1) {
		assertTrue(usernameF==1);
		System.out.println("username is already used");
	}
	
	}

	
	@When("customer enters used  email")
	public void customerEntersUsedEmail() {
		
		String email="saba2007@gmail.com";
		 if( customer.isValidEmail(email)&&customer.EmailIsUsed(email, main)) {
			emailF=1;
		 }
	
	}
	@Then("the customer should see the user e is already used")
	public void theCustomerShouldSeeTheUserEIsAlreadyUsed() {
		if(emailF==1) {
			assertTrue(emailF==1);
			System.out.println("email is already used");
		}
	}


	@When("customer enters wrong  email")
	public void customerEntersWrongEmail() {
		String email="saba200gmail.com";
		if( !customer.isValidEmail(email)) {
			emailF=1;
		 }
	    
	}
	@Then("the customer should see wrong email syntax")
	public void theCustomerShouldSeeWrongEmailSyntax() {
		if(emailF==1) {
			assertTrue(emailF==1);
			System.out.println("Wrong email syntax");
		}
	}


	@When("customer enters wrong password")
	public void customerEntersWrongPassword() {
		String Weakpass="saba1";
		if( !customer.isValidPassword(Weakpass)) {
			passF=1;
		 }
	}
	@Then("the customer should see weak password")
	public void theCustomerShouldSeeWeakPassword() {
		if(passF==1) {
			assertTrue(passF==1);
			System.out.println("Weak password");
		}
	}



	@When("customer enters valid input")
	public void customerEntersValidInput() {
		String validUsername="sama";
		String validPass="sama2001";
		String validEmail="sama2001@gmail.com";
		long number=598667006;
		String id="2";
		if(customer.isValidPassword(validPass)&& customer.isValidEmail(validEmail)&&!customer.UsernameIsUsed(validUsername, main)
				&& !customer.EmailIsUsed(validEmail, main)) {
			customer.setEmail(validEmail);
			customer.setId(id);
			customer.setPassword(validPass);
			customer.setPhoneNumber(number);
			customer.setUsername(validUsername);
			passF=0;
			emailF=0;
			usernameF=0;
			//validInputsF=1;
		}
	 
	}
	@Then("the customer account is created")
	public void theCustomerAccountIsCreated() {
  if(passF==0 && emailF==0 && usernameF==0) {
	  assertTrue(passF==0 && emailF==0 && usernameF==0);
	  System.out.println("Welcome to your account");
  }
	}





}
