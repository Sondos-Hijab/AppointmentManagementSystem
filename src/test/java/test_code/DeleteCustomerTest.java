package test_code;

import static org.junit.Assert.assertEquals;


import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import io.cucumber.java.en.*;
import main_code.*;

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
	    	assertEquals(1,deleteF);
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
			assertEquals(0,deleteF);
	    	System.out.println("deleted successfully");
	    }
	}





	
}
