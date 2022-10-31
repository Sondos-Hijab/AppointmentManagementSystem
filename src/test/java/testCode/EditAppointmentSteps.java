package testCode;

import static org.junit.Assert.*;

import org.junit.Test;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import mainCode.Appointment;
import mainCode.Customer;
import mainCode.Employee;
import mainCode.MainSystem;
import mainCode.Service;

public class EditAppointmentSteps {
	
	 static boolean scenario1= false,scenario2= false,scenario3= false, scenario4= false, 
				scenario5= false, scenario6=false,scenario7=false, scenario8=false;

	
	String appointmentId;
	int year, month, day, startHour;
	
	MainSystem mainsystem = new MainSystem();
	Service service1 = new Service("1", "makeup", 200, 1,2);
	
	Employee employee1 = new Employee ("1", "Falak", "Falak1234", "Falak@gmail.com");

	Customer customer = new Customer ("1", "aseel", "aseel1234","aseel@gmail.com",8563);
	
	Appointment appointment1 = new Appointment ("1","1",service1,12, 2023, 11, 5);
	
	public void pre () {
		mainsystem.getEmployees().add(employee1);
		mainsystem.getServices().add(service1);
		mainsystem.getCustomers().add(customer);
		customer.getAppointments().add(appointment1);
		mainsystem.getSystemAppointments().add(appointment1);
	}
	
	@When("customer wants to edit the appointment")
	public void customerWantsToEditTheAppointment() {
	    pre();
	    
	}
	@When("customer enters wrong appointment id")
	public void customerEntersWrongAppointmentId() {
		appointmentId = "2";	
	}
	@Then("the appointment will not be edited and it will give a message telling the appointment number enetred is wrong")
	public void theAppointmentWillNotBeEditedAndItWillGiveAMessageTellingTheAppointmentNumberEnetredIsWrong() {

		scenario1 = !customer.editAppointment("22",12, 2023, 11, 4, mainsystem);
		assertTrue(scenario1);
	}
	
	@When("customer enters wrong year")
	public void customerEntersWrongYear() {
		pre();
		year = 2026;
		appointmentId = "1";
	}
	@Then("the appointment will not be edited and it will give a message telling the year number enetred is wrong")
	public void theAppointmentWillNotBeEditedAndItWillGiveAMessageTellingTheYearNumberEnetredIsWrong() {
		scenario2 = !customer.editAppointment(appointmentId,12, year, 11, 4, mainsystem);
		assertTrue(scenario2);
	}

	@When("customer enters wrong month")
	public void customerEntersWrongMonth() {
		pre();
		month = 13;
		appointmentId = "1";
	}
	@Then("the appointment will not be edited and it will give a message telling the month number enetred is wrong")
	public void theAppointmentWillNotBeEditedAndItWillGiveAMessageTellingTheMonthNumberEnetredIsWrong() {
		scenario3 = !customer.editAppointment(appointmentId,12, 2023, month, 4, mainsystem);
		assertTrue(scenario3);
	}
	
	@When("customer enters wrong day")
	public void customerEntersWrongDay() {
		pre();
		day = 13;
		appointmentId = "1";
	}
	@Then("the appointment will not be edited and it will give a message telling the day number enetred is wrong")
	public void theAppointmentWillNotBeEditedAndItWillGiveAMessageTellingTheDayNumberEnetredIsWrong() {
		scenario4 = !customer.editAppointment(appointmentId,12, 2022, 10, day, mainsystem);
		assertTrue(scenario4);
	}
	
	@When("customer enters wrong starting hour")
	public void customerEntersWrongStartingHour() {
		pre();
		startHour = 20;
		appointmentId = "1";
	}
	@Then("the appointment will not be edited and it will give a message telling the staring hour number enetred is wrong")
	public void theAppointmentWillNotBeEditedAndItWillGiveAMessageTellingTheStaringHourNumberEnetredIsWrong() {
		scenario5 = !customer.editAppointment(appointmentId,startHour, 2023, 10, 4, mainsystem);
		assertTrue(scenario5);
	}
	
	@When("customer enters right starting hour")
	public void customerEntersRightStartingHour() {
		pre();
		appointmentId = "1";
	}
	@Then("the appointment will be edited and it will give a message telling the appointment is edited successfully")
	public void theAppointmentWillBeEditedAndItWillGiveAMessageTellingTheAppointmentIsEditedSuccessfully() {
		scenario6 = customer.editAppointment(appointmentId,14, 2023, 12, 4, mainsystem);
		assertTrue(scenario6);
	}
}
