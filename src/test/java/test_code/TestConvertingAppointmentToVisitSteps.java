package test_code;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.logging.Logger;

import org.junit.Test;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import main_code.Appointment;
import main_code.Customer;
import main_code.Employee;
import main_code.MainSystem;
import main_code.Service;
import main_code.Visit;

public class TestConvertingAppointmentToVisitSteps {

	private static final Logger logger = Logger.getLogger(TestConvertingAppointmentToVisitSteps.class.getName());
	Employee employee = new Employee ("1", "Falak", "Falak1234", "Falak@gmail.com");
	Customer customer = new Customer ("1", "aseel", "aseel1234","aseel@gmail.com",8563);
	Service service = new Service("1", "makeup","1", 200, 2);
    static Appointment appointment = new Appointment (); //today, we'll convert it to today every time
	
	
	Visit visit = new Visit();
	
	MainSystem mainsystem = new MainSystem();
	
	String cuctomerUserName;
	String appointmentId;
	String feedback;
	
	LocalDate time = java.time.LocalDate.now();
	int currentMonth = time.getMonthValue();
	int currentDay = time.getDayOfMonth();
	int currentYear = time.getYear();
	
	@Given("the customer has an appointment and the employee wants to convert it to a visit")
	public void theCustomerHasAnAppointmentAndTheEmployeeWantsToConvertItToAVisit() {
		appointment.setId("1");
		appointment.setCustomerId("1");
		appointment.setService(service);
		appointment.setStartingHour(12);
		
		appointment.setMonth(currentMonth);
		appointment.setDay(currentDay);
		customer.getAppointments().add(appointment);
		mainsystem.addEmployee(employee);
		mainsystem.addCustomer(customer);
	}
	@When("The employee types the username of the customer and the appointment id and the feedback and the username isn't in our record")
	public void theEmployeeTypesTheUsernameOfTheCustomerAndTheAppointmentIdAndTheFeedbackAndTheUsernameIsnTInOurRecord() {
		appointment.setYear(currentYear);
		cuctomerUserName = "sama";
		appointmentId = "1";
		feedback = "The services you provide are good!";
		
	}
	
	@Test
	@Then("The employee should see username is not found")
	public void theEmployeeShouldSeeUsernameIsNotFound() {
		logger.info("\n \n \n");
		logger.info("\n \nCustomer Username: " + cuctomerUserName + " Appointment Id: " +appointmentId +" Feedback: " +feedback);
		assertTrue(!employee.convertAppointmentToVisit(cuctomerUserName,appointmentId,feedback, mainsystem));
		logger.info("Test Case 1 : wrong customer username worked");
	}


	

	
	@When("The employee types wrong appointment id")
	public void theEmployeeTypesWrongAppointmentId() {
		appointment.setYear(currentYear);
		cuctomerUserName = "aseel";
		appointmentId = "2";
		feedback = "The services you provide are good!";
	}
	
	@Test
	@Then("the employee should see appointment id is wrong")
	public void theEmployeeShouldSeeAppointmentIdIsWrong() {
		logger.info("Customer Username: " + cuctomerUserName + " Appointment Id: " +appointmentId +" Feedback: " +feedback);
		assertTrue(!employee.convertAppointmentToVisit(cuctomerUserName,appointmentId,feedback, mainsystem));
		logger.info("Test Case 2 : wrong appointment id worked");
	}
	
	
	
	@Given("the customer has an appointment and the employee wants to convert it to a visit but at a different day")
	public void theCustomerHasAnAppointmentAndTheEmployeeWantsToConvertItToAVisitButAtADifferentDay() {
		cuctomerUserName = "aseel";
		appointmentId = "1";
		feedback = "The services you provide are good!";
		appointment.setYear(currentYear+1);
		customer.getAppointments().add(appointment);
		mainsystem.addEmployee(employee);
		mainsystem.addCustomer(customer);
	}
	@When("The appointment date isn't today")
	public void theAppointmentDateIsnTToday() {
		
	}
	
	@Test
	@Then("the employee should see can't convert it to a visit because it should be today")
	public void theEmployeeShouldSeeCanTConvertItToAVisitBecauseItShouldBeToday() {
		assertTrue(!employee.convertAppointmentToVisit(cuctomerUserName,appointmentId,feedback, mainsystem));
		logger.info("Test Case 3 : wrong day worked");
	}
	


	@When("Employee types right customeer username, right appointment id")
	public void employeeTypesRightCustomeerUsernameRightAppointmentId() {
		appointment.setYear(currentYear);
		cuctomerUserName = "aseel";
		appointmentId = "1";
		feedback = "The services you provide are good!";
	}
	
	
	@Then("A visit for the appointment will be added to the customer visits record and to the system visits record")
	public void aVisitForTheAppointmentWillBeAddedToTheCustomerVisitsRecordAndToTheSystemVisitsRecord() {
		logger.info("Customer Username: " + cuctomerUserName + " Appointment Id: " +appointmentId +" Feedback: " +feedback);
		assertTrue(employee.convertAppointmentToVisit(cuctomerUserName,appointmentId,feedback, mainsystem));
		logger.info("Test Case 4 : A visit for the appointment will be added to the customer visits record and to the system visits record");
	}
	
	@Then("The employee should see Converting appointment to a visit went successfully")
	public void theEmployeeShouldSeeConvertingAppointmentToAVisitWentSuccessfully() {
		logger.info("Converting appointment to a visit went successfully");
		logger.info("Priniting customer's visit");
		customer.getVisits().get(0).printVisit();
		
		logger.info("\n \n \n");
	}
	
}
