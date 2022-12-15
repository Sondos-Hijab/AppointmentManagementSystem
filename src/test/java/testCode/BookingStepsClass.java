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

public class BookingStepsClass {
	

	 boolean scenario1= false,scenario2= false,scenario3= false, scenario4= false, 
			scenario5= false, scenario6=false,scenario7=false, scenario8=false;

	 MainSystem mainsystem = new MainSystem();
	
	Service service1 = new Service("1", "makeup","1", 200,2);
	Service service2 = new Service("2", "haircut","2",30,1);
	Service service3 = new Service("3", "hair coloring","3", 250,3);
	Service service4 = new Service("4", "bride pacakge","4", 1000,8);
	Service service5 = new Service("5", "nails","5", 120,2);
	
	
	Employee employee1 = new Employee ("1", "Falak", "Falak1234", "Falak@gmail.com");
	Employee employee2 = new Employee ("2", "Alma", "Alma1234", "Alma@gmail.com");
	Employee employee3 = new Employee ("3", "Kareem", "Kareem1234", "Kareem@gmail.com");
	Employee employee4 = new Employee ("4", "Tareq", "Tareq1234", "Tareq@gmail.com");
	Employee employee5 = new Employee ("5", "Samar", "Samar1234", "Samar@gmail.com");
	
	Customer customer = new Customer ("1", "aseel", "aseel1234","aseel@gmail.com",8563);	
	
	 int chosenServiceNumber = 0;
	
	 Service chosenService = new Service() ;
	
	 int chosenYear = 0;
	
	 int chosenMonth = 0;
	
	 int chosenDay = 0;
	
	 int chosenHour = 0;
	

	public void iHaveFiveServices() {
		mainsystem.getServices().add(service1);
		mainsystem.getServices().add(service2);
		mainsystem.getServices().add(service3);
		mainsystem.getServices().add(service4);
		mainsystem.getServices().add(service5);
		
	
		mainsystem.getEmployees().add(employee1);
		mainsystem.getEmployees().add(employee2);
		mainsystem.getEmployees().add(employee3);
		mainsystem.getEmployees().add(employee4);
		mainsystem.getEmployees().add(employee5);
	}




	@When("I type wrong service number")
	public void iTypeWrongServiceNumber() {
		iHaveFiveServices();
		chosenServiceNumber = 6;
		scenario1 = !customer.bookAppointment(mainsystem,chosenServiceNumber,chosenYear,chosenMonth,chosenDay,chosenHour);
	}
	
	@Test
	@Then("I should see a message telling that the service number is wrong")
	public void iShouldSeeAMessageTellingThatTheServiceNumberIsWrong() {
		if(scenario1) {
			assertTrue(scenario1);
			System.out.println("Scenario1 --> Wrong Service Number --> tested successfully");
		}
	}

	


	@When("I type wrong year number")
	public void iTypeWrongYearNumber() {
		iHaveFiveServices();
		chosenServiceNumber = 1;
		chosenYear = 2021;
		scenario2 = !customer.bookAppointment(mainsystem,chosenServiceNumber,chosenYear,chosenMonth,chosenDay,chosenHour);
	}
	
	@Test
	@Then("I should see a message telling that the year number is wrong")
	public void iShouldSeeAMessageTellingThatTheYearNumberIsWrong() {
		if(scenario2) {
		assertTrue(scenario2);
		System.out.println("Scenario2 --> Wrong Year Number --> tested successfully");
		}
	}

	


	@When("I type wrong month number")
	public void iTypeWrongMonthNumber() {
		iHaveFiveServices();
		chosenServiceNumber = 1;
		chosenYear = 2022;
		chosenMonth = 8;
		scenario3 = !customer.bookAppointment(mainsystem,chosenServiceNumber,chosenYear,chosenMonth,chosenDay,chosenHour);
	}
	
	@Test
	@Then("I should see a message telling that the month number is wrong")
	public void iShouldSeeAMessageTellingThatTheMonthNumberIsWrong() {
		if(scenario3) {
		assertTrue(scenario3);
		System.out.println("Scenario3 --> Wrong month Number --> tested successfully");
		}
	}





	@When("I type wrong day number")
	public void iTypeWrongDayNumber() {
		iHaveFiveServices();
		chosenServiceNumber = 1;
		chosenYear = 2022;
		chosenMonth = 10;
		chosenDay = 12;
		scenario4 = !customer.bookAppointment(mainsystem,chosenServiceNumber,chosenYear,chosenMonth,chosenDay,chosenHour);

	}
	
	@Test
	@Then("I should see a message telling that the day number is wrong")
	public void iShouldSeeAMessageTellingThatTheDayNumberIsWrong() {
		if(scenario4) {
		assertTrue(scenario4);
		System.out.println("Scenario4 --> Wrong day Number --> tested successfully");
		}
	}





	@When("I type wrong hour number")
	public void iTypeWrongHourNumber() {
		iHaveFiveServices();
		chosenServiceNumber = 1;
		chosenYear = 2023;
		chosenMonth = 10;
		chosenDay = 25;
		chosenHour = 20;
		scenario5 = !customer.bookAppointment(mainsystem,chosenServiceNumber,chosenYear,chosenMonth,chosenDay,chosenHour);

	}
	
	@Test
	@Then("I should see a message telling that the hour number is wrong")
	public void iShouldSeeAMessageTellingThatTheHourNumberIsWrong() {
		if(scenario5) {
		assertTrue(scenario5);
		System.out.println("Scenario5 --> Wrong hour Number --> tested successfully");
		}
	}

	


	@When("I type right appointment number but I have another appointment at the same time")
	public void iTypeRightAppointmentNumberButIHaveAnotherAppointmentAtTheSameTime() {
		iHaveFiveServices();
		chosenServiceNumber = 1;
		chosenYear = 2023;
		chosenMonth = 10;
		chosenDay = 25;
		chosenHour = 14;
		
		for(int i=0;i<mainsystem.getServices().size();i++) {
			if(Integer.parseInt(mainsystem.getServices().get(i).getServiceId()) == chosenServiceNumber) {
				chosenService = mainsystem.getServices().get(i);
			}
		}
		Appointment fakeAppointment = new Appointment("1", "1", chosenService,14, 2023, 10, 25);
		customer.getAppointments().add(fakeAppointment);
		scenario6 = !customer.bookAppointment(mainsystem,chosenServiceNumber,chosenYear,chosenMonth,chosenDay,chosenHour);
	
	}
	
	@Test
	@Then("I should see a message telling that I have another appointment at the same time")
	public void iShouldSeeAMessageTellingThatIHaveAnotherAppointmentAtTheSameTime() {
		if(scenario6) {
		assertTrue(scenario6);
		System.out.println("Scenario6 --> The customer has appointment at the same time --> tested successfully");
		}
	}



	@When("I type right appointment number and there was a conflict in the booking")
	public void iTypeRightAppointmentNumberAndThereWasAConflictInTheBooking() {
		iHaveFiveServices();
		chosenServiceNumber = 1;
		chosenYear = 2023;
		chosenMonth = 10;
		chosenDay = 25;
		chosenHour = 14;
		
		for(int i=0;i<mainsystem.getServices().size();i++) {
			if(Integer.parseInt(mainsystem.getServices().get(i).getServiceId()) == chosenServiceNumber) {
				chosenService = mainsystem.getServices().get(i);
			}
		}
		
		Appointment fakeAppointment = new Appointment("1", "1", chosenService,14, 2023, 10, 25);
		mainsystem.getSystemAppointments().add(fakeAppointment);
		
		scenario7 = !customer.bookAppointment(mainsystem,chosenServiceNumber,chosenYear,chosenMonth,chosenDay,chosenHour);		  
	}
	
	@Test
	@Then("I should see a message telling that there is a conflict")
	public void iShouldSeeAMessageTellingThatThereIsAConflict() {
		if(scenario7) {
			assertTrue(scenario7);
			System.out.println("Scenario7 --> There is a conflict --> tested successfully");
			}
	}





	@When("I type right appointment number")
	public void iTypeRightAppointmentNumber() {
		iHaveFiveServices();
		chosenServiceNumber = 1;
		chosenYear = 2023;
		chosenMonth = 10;
		chosenDay = 25;
		chosenHour = 12;
		scenario8 = customer.bookAppointment(mainsystem,chosenServiceNumber,chosenYear,chosenMonth,chosenDay,chosenHour);		  
	}
	
	@Test
	@Then("I should see a message telling that the appointment is confirmed")
	public void iShouldSeeAMessageTellingThatTheAppointmentIsConfirmed() {
		if(scenario8) {
			assertTrue(scenario8);
			System.out.print("Scenario8 --> Appointment Booked Successfully --> tested successfully");
			}
	}
	@Then("The system will book the appointment and will appear in the admin's and employee's calendar")
	public void theSystemWillBookTheAppointmentAndWillAppearInTheAdminSAndEmployeeSCalendar() {

	}
	@Then("the appointment will be saved in the record of the customer's appointments")
	public void theAppointmentWillBeSavedInTheRecordOfTheCustomerSAppointments() {

	}


}

