package AMS;

import static org.junit.Assert.*;

import org.junit.Test;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import mainClass.Appointment;
import mainClass.Customer;
import mainClass.Service;

public class GeneratingInvoiceSteps {


	Customer customer = new Customer ("1", "aseel", "aseel1234","aseel@gmail.com",8563);
	Service service1 = new Service("1", "makeup","1", 200,2);
	Service service2 = new Service("2", "haircut","2", 30, 1);
	Service service3 = new Service("3", "hair coloring","3", 250, 3);
	
	Appointment appointment1 = new Appointment ("1","1",service1,12, 2022, 11, 5);
	Appointment appointment2 = new Appointment ("2","1",service2,10, 2022, 10, 30);
	Appointment appointment3 = new Appointment ("3","1",service3,9, 2023, 10, 26);
	
	
	@When("Customer asks for generating an invoice, and he\\/she doesn't have any appointments yet")
	public void customerAsksForGeneratingAnInvoiceAndHeSheDoesnTHaveAnyAppointmentsYet() {
	    
	}
	@Then("The system will tell him\\/her that he\\/she should add an appointment first")
	public void theSystemWillTellHimHerThatHeSheShouldAddAnAppointmentFirst() {
	    assertTrue(!customer.generateAnInvoice());
	}


	@Given("the customer has an appointment")
	public void theCustomerHasAnAppointment() {
		appointment1.setService(service1);
	    customer.getAppointments().add(appointment1);
	}
	@When("the customer asks to generate an invoice for it")
	public void theCustomerAsksToGenerateAnInvoiceForIt() {
	   
	}
	@Then("the customer should see the generated invoice for the appointment")
	public void theCustomerShouldSeeTheGeneratedInvoiceForTheAppointment() {
		 assertTrue(customer.generateAnInvoice());
	}
	@Given("the customer has multiple appointments")
	public void theCustomerHasMultipleAppointments() {
		appointment1.setService(service1);
		appointment2.setService(service2);
		appointment3.setService(service3);
		customer.getAppointments().add(appointment1);
		customer.getAppointments().add(appointment2);
		customer.getAppointments().add(appointment3);
	}
	@When("the customer asks to generate an invoice for them")
	public void theCustomerAsksToGenerateAnInvoiceForThem() {
	    
	}
	@Then("the customer should see the generated invoice for the multiple appointment")
	public void theCustomerShouldSeeTheGeneratedInvoiceForTheMultipleAppointment() {
		 assertTrue(customer.generateAnInvoice());
		 System.out.println("\n\n\n");
	}


}
