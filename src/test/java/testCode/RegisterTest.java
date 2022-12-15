package testCode;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import io.cucumber.java.en.*;
import mainCode.Customer;
import mainCode.MainSystem;

public class RegisterTest {
	

static int emailF=0;
static int passF=0;
static int usernameF=0;
static int validInputsF=0;
Customer customer1 = new Customer ("1", "saba", "saba2007","saba2007@gmail.com",598667006);
Customer customer=new Customer();
MainSystem main = new MainSystem();
List <Customer> customers = new ArrayList <Customer>();

	@Given("the customer in Registration page")
	public void theCustomerInRegistrationPage() {
		
	}
	@Given("the data table for customers is")
	public void theDataTableForCustomersIs(io.cucumber.datatable.DataTable dataTable) {
	  
	}

	
	@When("customer enters used  username")
	public void customerEntersUsedUsername() {
		String username1="saba";
		
		main.addCustomer(customer1);
	 if(  customer.UsernameIsUsed(username1, main)) {
		 usernameF=1;
	 }
	
	}
	@Test
	@Then("the customer should see the username is already used")
	public void theCustomerShouldSeeTheUserNameIsAlreadyUsed() {
		
		if(usernameF==1) {
			
			System.out.println("username is already used");
		}
		assertEquals(1,usernameF);
	}

	
	@When("customer enters used  email")
	public void customerEntersUsedEmail() {
		main.addCustomer(customer1);
		String email="saba2007@gmail.com";
		 if( customer.isValidEmail(email)&&customer.EmailIsUsed(email, main)) {
			emailF=1;
		 }
	
	}
	
	@Test
	@Then("the customer should see the user e is already used")
	public void theCustomerShouldSeeTheUserEIsAlreadyUsed() {
		if(emailF==1) {
			assertEquals(1,emailF);
			System.out.println("email is already used");
		}
	}


	@When("customer enters wrong  email")
	public void customerEntersWrongEmail() {
		main.addCustomer(customer1);
		String email="saba200gmail.com";
		if( !customer.isValidEmail(email)) {
			emailF=1;
		 }
	    
	}
	
	@Test
	@Then("the customer should see wrong email syntax")
	public void theCustomerShouldSeeWrongEmailSyntax() {
		if(emailF==1) {
			assertEquals(1,emailF);
			System.out.println("Wrong email syntax");
		}
	}


	@When("customer enters wrong password")
	public void customerEntersWrongPassword() {
		main.addCustomer(customer1);
		String Weakpass="saba1";
		if( !customer.isValidPassword(Weakpass)) {
			passF=1;
		 }
	}
	
	@Test
	@Then("the customer should see weak password")
	public void theCustomerShouldSeeWeakPassword() {
		if(passF==1) {
			assertEquals(1,passF);
			System.out.println("Weak password");
		}
	}



	@When("customer enters valid input")
	public void customerEntersValidInput() {
		main.addCustomer(customer1);
		String validUsername="sama";
		String validPass="sama2001";
		String validEmail="sama2001@gmail.com";
		long number=598667006;
		String id="2";
		if(customer.isValidPassword(validPass)&& customer.isValidEmail(validEmail)&&!customer.UsernameIsUsed(validUsername, main)
				&& !customer.EmailIsUsed(validEmail, main))
		{
			customer.setEmail(validEmail);
			customer.setId(id);
			customer.setPassword(validPass);
			customer.setPhoneNumber(number);
			customer.setUsername(validUsername);
			customers.add(customer);
			main.setCustomers(customers);
			passF=0;
			emailF=0;
			usernameF=0;
			
			
		}
	 
	}
	@Test
	@Then("the customer account is created")
	public void theCustomerAccountIsCreated() {
  if(passF==0 && emailF==0 && usernameF==0) {
	  
	  boolean flag = (passF==0 && emailF==0 && usernameF==0);
	  assertTrue(flag);
	  System.out.println("Welcome to your account");
  }
	}





}
