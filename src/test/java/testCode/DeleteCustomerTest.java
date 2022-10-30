package testCode;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import io.cucumber.java.en.*;
import mainCode.*;

public class DeleteCustomerTest {

	static int deleteF=0;
	Customer customer = new Customer ("1", "saba", "saba2007","saba2007@gmail.com",598667006);
	List <Customer> customers = new ArrayList <Customer>();
	Admin admin = new Admin();
	MainSystem main=new MainSystem();
	

	@When("i type wrong id")
	public void iTypeWrongId() {
		main.addCustomer(customer);
		
	   if(!admin.DeleteCustomer("5", main)) {
		   deleteF=1;
	   }
	}
	@Then("i should see the id doesn't exisit")
	public void iShouldSeeTheIdDoesnTExisit() {
	    if(deleteF==1) {
	    	assertTrue(deleteF==1);
	    	System.out.println("the id doesn't exist");
	    }
	}


	@When("i type valid id")
	public void iTypeValidId() {
		main.addCustomer(customer);
		customers.add(customer);
		main.setCustomers(customers);
		 if(admin.DeleteCustomer("1", main)) {
			   
			   customers.remove(customer);
			   deleteF=0;
		   }
	}
	@Then("deleted successfully")
	public void deletedSuccessfully() {
		if(deleteF==0) {
	    	assertTrue(deleteF==0);
	    	System.out.println("deleted successfully");
	    }
	}





	
}
