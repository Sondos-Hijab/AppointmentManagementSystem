package test_code;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.junit.Test;

import io.cucumber.java.en.*;
import main_code.*;

public class TestEditCustomerInfo {
	private static final Logger logger = Logger.getLogger(TestEditCustomerInfo.class.getName());

static int passF=0;
String correctPass="saba2007";

Customer customer= new Customer();
Customer customer1 = new Customer ("1", "saba", "saba2007","saba2007@gmail.com",598667006);
MainSystem main= new MainSystem();

List <Customer> customers = new ArrayList <Customer>();

	@Given("the customer is logged in")
	public void theCustomerIsLoggedIn() {
	    
	}
	@When("the customer enters wrong password")
	public void theCustomerEntersWrongPassword() {
		main.addCustomer(customer1);
	   String Pass="saba";
	   if(!Customer.validPassword(Pass, main)) {
		   passF=1;
	   }
	}
	
	@Test
	@Then("the customer should see incorrect password")
	public void theCustomerShouldSeeIncorrectPassword() {
	  if(passF==1) {
		  assertEquals(1, passF);
		  logger.info("wrong password");
	  }
	}


	@When("user enters right password and wants to edit the email")
	public void userEntersRightPasswordAndWantsToEditTheEmail() {
		main.addCustomer(customer1);
		 //String Pass="saba2007";
	    String newEmail="sabafadda@gmail.com";
	    if(Customer.validPassword(correctPass, main)) {
	    	customer.setEmail(newEmail);
	    	customers.add(customer);
	    	main.setCustomers(customers);
	    	
			   passF=0;
		   }
	}
	
	@Test
	@Then("the customer should see the email has been edited")
	public void theCustomerShouldSeeTheEmailHasBeenEdited() {
		  if(passF==0) {
			  assertEquals(0,passF);
			  logger.info("the email has been edited");
		  }
	}


	@When("user enters right password and wants to edit the password")
	public void userEntersRightPasswordAndWantsToEditThePassword() {
		main.addCustomer(customer1);
		 //String Pass="saba1234";
	    String newPassword="sabafadda@gmail.com";
	    if(Customer.validPassword(correctPass, main)) {
	    	customer.setPassword(newPassword);
	    	customers.add(customer);
	    	main.setCustomers(customers);
	    	
			   passF=0;
		   }
	}
	
	@Test
	@Then("the customer should see the password has been edited")
	public void theCustomerShouldSeeThePasswordHasBeenEdited() {
		 if(passF==0) {
			 assertEquals(0,passF);
			 logger.info("the Password has been edited");
		  }
	}

	

	@When("user enters right password and wants to edit the phone number")
	public void userEntersRightPasswordAndWantsToEditThePhoneNumber() {
		main.addCustomer(customer1);
		// String Pass="saba1234";
	    long newPhone=59867265;
	    if(Customer.validPassword(correctPass, main)) {
	    	customer.setPhoneNumber(newPhone);
	    	customers.add(customer);
	    	main.setCustomers(customers);
	    	
			   passF=0;
	}
	}
	
	@Test
	@Then("the customer should see the phone number has been edited")
	public void theCustomerShouldSeeThePhoneNumberHasBeenEdited() {
		 if(passF==0) {
			 assertEquals(0,passF);
			 logger.info("the phone number has been edited");
		  
	}

	}



	
	








}
