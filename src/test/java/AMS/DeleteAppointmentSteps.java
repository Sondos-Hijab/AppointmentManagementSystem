package AMS;

import static org.junit.Assert.*;

import org.junit.Test;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import mainClass.Appointment;
import mainClass.Customer;
import mainClass.Employee;
import mainClass.MainSystem;
import mainClass.Service;

public class DeleteAppointmentSteps {
	 
	boolean scenario1 = false, scenario2 = false;
	MainSystem mainsystem = new MainSystem();
		
	Service service1 = new Service("1", "makeup","1", 200,2);
		
	Employee employee1 = new Employee ("1", "Falak", "Falak1234", "Falak@gmail.com");

	Customer customer = new Customer ("1", "aseel", "aseel1234","aseel@gmail.com",8563);
	
	Appointment appointment1 = new Appointment ("1","1",service1,12, 2022, 11, 5);

	String enteredAppointmentId;
	
	public void pre() {
		mainsystem.addEmployee(employee1);
		mainsystem.addCustomer(customer);
		mainsystem.addService(service1);
		mainsystem.addAppointment(appointment1);
		customer.getAppointments().add(appointment1);
	}
	
	
	@When("Customer asks to delete an appointment and enters wrong id")
	public void customerAsksToDeleteAnAppointmentAndEntersWrongId() {
		pre();
		enteredAppointmentId = "2";
		scenario1 = customer.deleteAppointment(enteredAppointmentId);
	}
	@Then("The system will give a message telling that the id is wrong")
	public void theSystemWillGiveAMessageTellingThatTheIdIsWrong() {
		assertTrue(!scenario1);
	}

	@When("Customer asks to delete an appointment and enters right id")
	public void customerAsksToDeleteAnAppointmentAndEntersRightId() {
		pre();
		enteredAppointmentId = "1";
		scenario2 = customer.deleteAppointment(enteredAppointmentId);
	}
	@Then("The system will give a message telling that the appointment is deleted successfully")
	public void theSystemWillGiveAMessageTellingThatTheAppointmentIsDeletedSuccessfully() {
		assertTrue(scenario2);
	}
}
