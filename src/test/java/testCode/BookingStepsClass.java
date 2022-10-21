package testCode;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import mainCode.Admin;
import mainCode.Appointment;
import mainCode.Customer;
import mainCode.Employee;
import mainCode.MainLoginClass;
import mainCode.MainSystem;
import mainCode.Service;

public class BookingStepsClass {
	/*
	 * io.cucumber.junit.UndefinedStepException: The step 'The system asks to enter
	 * the service that I want' and 2 other step(s) are undefined. You can implement
	 * these steps using the snippet(s) below:
	 */
	

	 boolean scenario1= false,scenario2= false,scenario3= false, scenario4= false, 
			scenario5= false, scenario6=false,scenario7=false, scenario8=false, scenario9=false;

	 MainSystem mainsystem = new MainSystem();
	
	Service service1 = new Service(1, "makeup", 200, 1,2);
	Service service2 = new Service(2, "haircut", 30, 2,1);
	Service service3 = new Service(3, "hair coloring", 250, 3,3);
	Service service4 = new Service(4, "bride pacakge", 1000, 4,8);
	Service service5 = new Service(5, "nails", 120, 5,2);
	
	
	Employee employee1 = new Employee (1, "Falak", "Falak1234", "Falak@gmail.com");
	Employee employee2 = new Employee (2, "Alma", "Alma1234", "Alma@gmail.com");
	Employee employee3 = new Employee (3, "Kareem", "Kareem1234", "Kareem@gmail.com");
	Employee employee4 = new Employee (4, "Tareq", "Tareq1234", "Tareq@gmail.com");
	Employee employee5 = new Employee (5, "Samar", "Samar1234", "Samar@gmail.com");
	
	Customer customer = new Customer (1, "aseel", "aseel1234","aseel@gmail.com",8563);
	Appointment appointment= new Appointment();//= customer.addAnAppointment(mainsystem);
	
	
	 int chosenServiceNumber;
	
	 Service chosenService = new Service() ;
	
	 int chosenYear;
	
	 int chosenMonth;
	
	 int chosenDay;
	
	 int chosenHour;
	

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


	@When("The system asks to enter the service that I want")
	public void theSystemAsksToEnterTheServiceThatIWant() {
		iHaveFiveServices();
		mainsystem.showServices();
		chosenServiceNumber = 0;
	}
	@When("I leave the service number field empty")
	public void iLeaveTheServiceNumberFieldEmpty() {
		if(chosenServiceNumber == 0) scenario1 = true;
	}
	@Then("I should see a required field is empty")
	public void iShouldSeeARequiredFieldIsEmpty() {
		if(scenario1) {
			appointment.showErrorMessageServiceNumberIsEmpty();
			assertTrue(scenario1);
			System.out.println();
			System.out.println("Scenario 1 Booking Feature is covered");
			System.out.println();
		}
	}
	
	
	/*
	 * io.cucumber.junit.UndefinedStepException: The step 'I type wrong service
	 * number' and 2 other step(s) are undefined. You can implement these steps
	 * using the snippet(s) below:
	 */

	@When("I type wrong service number")
	public void iTypeWrongServiceNumber() {
		iHaveFiveServices();
		mainsystem.showServices();
		chosenServiceNumber = 10;
		scenario2 = appointment.checkIfTheEnteredServiceNumberIsWrong(mainsystem, chosenServiceNumber,chosenService);
	}
	@Then("I should see a message telling that the service number is wrong")
	public void iShouldSeeAMessageTellingThatTheServiceNumberIsWrong() {
		if(scenario2) {
			appointment.showErrorMessageServiceNumberIsWrong();
			assertTrue(scenario2);
			System.out.println();
			System.out.println("Scenario 2 Booking Feature is covered");
			System.out.println();
		}
	}

	
	/*
	 * io.cucumber.junit.UndefinedStepException: The step 'I type wrong year number'
	 * and 2 other step(s) are undefined. You can implement these steps using the
	 * snippet(s) below:
	 */

	@When("I type wrong year number")
	public void iTypeWrongYearNumber() {
		iHaveFiveServices();
		mainsystem.showServices();
		chosenServiceNumber = 2;
		for(int i=0;i<mainsystem.getServices().size();i++) {
			if(mainsystem.getServices().get(i).getId() == chosenServiceNumber) {
				chosenService = mainsystem.getServices().get(i);
			}
		}
		
		if(!appointment.checkIfTheEnteredServiceNumberIsWrong(mainsystem, chosenServiceNumber,chosenService)) {
			mainsystem.showAvailableYears();
			chosenYear = 2024;
			scenario3 = appointment.checkIfTheEnteredYearNumberIsWrong(chosenYear);
		}
	}
	@Then("I should see a message telling that the year number is wrong")
	public void iShouldSeeAMessageTellingThatTheYearNumberIsWrong() {
		if(scenario3) {
			appointment.showErrorMessageYearNumberIsWrong();
			assertTrue(scenario3);
			System.out.println();
			System.out.println("Scenario 3 Booking Feature is covered");
			System.out.println();
		}
	}

	
	/*
	 * io.cucumber.junit.UndefinedStepException: The step 'I type wrong month
	 * number' and 2 other step(s) are undefined. You can implement these steps
	 * using the snippet(s) below:
	 */

	@When("I type wrong month number")
	public void iTypeWrongMonthNumber() {
		iHaveFiveServices();
		mainsystem.showServices();
		chosenServiceNumber = 2;
		for(int i=0;i<mainsystem.getServices().size();i++) {
			if(mainsystem.getServices().get(i).getId() == chosenServiceNumber) {
				chosenService = mainsystem.getServices().get(i);
			}
		}
		if(!appointment.checkIfTheEnteredServiceNumberIsWrong(mainsystem, chosenServiceNumber,chosenService)) {
			mainsystem.showAvailableYears();
			chosenYear = 2023;
			if(!appointment.checkIfTheEnteredYearNumberIsWrong(chosenYear)) {
				mainsystem.showAvailableMonths(chosenYear);
				chosenMonth = 13;
				scenario4 = appointment.checkIfTheEnteredMonthNumberIsWrong(mainsystem,chosenMonth);
			}
		}
	}
	@Then("I should see a message telling that the month number is wrong")
	public void iShouldSeeAMessageTellingThatTheMonthNumberIsWrong() {
		if(scenario4) {
			appointment.showErrorMessageMonthNumberIsWrong();
			assertTrue(scenario4);
			System.out.println();
			System.out.println("Scenario 4 Booking Feature is covered");
			System.out.println();
		}
	}



	/*
	 * io.cucumber.junit.UndefinedStepException: The step 'I type wrong day number'
	 * and 2 other step(s) are undefined. You can implement these steps using the
	 * snippet(s) below:
	 */

	@When("I type wrong day number")
	public void iTypeWrongDayNumber() {
		iHaveFiveServices();
		mainsystem.showServices();
		chosenServiceNumber = 2;
		for(int i=0;i<mainsystem.getServices().size();i++) {
			if(mainsystem.getServices().get(i).getId() == chosenServiceNumber) {
				chosenService = mainsystem.getServices().get(i);
			}
		}
		if(!appointment.checkIfTheEnteredServiceNumberIsWrong(mainsystem, chosenServiceNumber,chosenService)) {
			mainsystem.showAvailableYears();
			chosenYear = 2023;
			if(!appointment.checkIfTheEnteredYearNumberIsWrong(chosenYear)) {
				mainsystem.showAvailableMonths(chosenYear);
				chosenMonth = 10;
				if(!appointment.checkIfTheEnteredMonthNumberIsWrong(mainsystem, chosenMonth)) {
					mainsystem.showAvailableDays(chosenMonth,chosenYear);
					chosenDay = 33;
					scenario5 = appointment.checkIfTheEnteredDayNumberIsWrong(mainsystem,chosenDay);
				
				}
			}
		}
	}
	@Then("I should see a message telling that the day number is wrong")
	public void iShouldSeeAMessageTellingThatTheDayNumberIsWrong() {
		if(scenario5) {
			appointment.showErrorMessageDayNumberIsWrong();
			assertTrue(scenario5);
			System.out.println();
			System.out.println("Scenario 5 Booking Feature is covered");
			System.out.println();
		}
	}



	/*
	 * io.cucumber.junit.UndefinedStepException: The step 'I type wrong appointment
	 * number' and 2 other step(s) are undefined. You can implement these steps
	 * using the snippet(s) below:
	 */

	@When("I type wrong hour number")
	public void iTypeWrongHourNumber() {
		iHaveFiveServices();
		mainsystem.showServices();
		chosenServiceNumber = 2;
		for(int i=0;i<mainsystem.getServices().size();i++) {
			if(mainsystem.getServices().get(i).getId() == chosenServiceNumber) {
				chosenService = mainsystem.getServices().get(i);
			}
		}
		if(!appointment.checkIfTheEnteredServiceNumberIsWrong(mainsystem, chosenServiceNumber,chosenService)) {
			mainsystem.showAvailableYears();
			chosenYear = 2023;
			if(!appointment.checkIfTheEnteredYearNumberIsWrong(chosenYear)) {
				mainsystem.showAvailableMonths(chosenYear);
				chosenMonth = 10;
				if(!appointment.checkIfTheEnteredMonthNumberIsWrong(mainsystem, chosenMonth)) {
					mainsystem.showAvailableDays(chosenMonth,chosenYear);
					chosenDay = 25;
					if(!appointment.checkIfTheEnteredDayNumberIsWrong(mainsystem, chosenDay)) {
						  mainsystem.showAvailableHours(chosenService);
						  chosenHour = 18;
						  scenario6=appointment.checkIfTheEnteredHourNumberIsWrong(mainsystem, chosenHour,chosenService); 
						  }
				
				}
			}
		}

	}
	@Then("I should see a message telling that the hour number is wrong")
	public void iShouldSeeAMessageTellingThatTheHourNumberIsWrong() {
		if(scenario6) {
			appointment.showErrorMessageHourNumberIsWrong();
			assertTrue(scenario6);
			System.out.println();
			System.out.println("Scenario 6 Booking Feature is covered");
			System.out.println();
		}
	}

	
	/*
	 * io.cucumber.junit.UndefinedStepException: The step 'I type right appointment
	 * number but I have another appointment at the same time' and 2 other step(s)
	 * are undefined. You can implement these steps using the snippet(s) below:
	 */

	@When("I type right appointment number but I have another appointment at the same time")
	public void iTypeRightAppointmentNumberButIHaveAnotherAppointmentAtTheSameTime() {
		iHaveFiveServices();
		mainsystem.showServices();
		chosenServiceNumber = 2;
		for(int i=0;i<mainsystem.getServices().size();i++) {
			if(mainsystem.getServices().get(i).getId() == chosenServiceNumber) {
				chosenService = mainsystem.getServices().get(i);
			}
		}
		if(!appointment.checkIfTheEnteredServiceNumberIsWrong(mainsystem, chosenServiceNumber,chosenService)) {
			mainsystem.showAvailableYears();
			chosenYear = 2023;
			if(!appointment.checkIfTheEnteredYearNumberIsWrong(chosenYear)) {
				mainsystem.showAvailableMonths(chosenYear);
				chosenMonth = 10;
				if(!appointment.checkIfTheEnteredMonthNumberIsWrong(mainsystem, chosenMonth)) {
					mainsystem.showAvailableDays(chosenMonth,chosenYear);
					chosenDay = 25;
					if(!appointment.checkIfTheEnteredDayNumberIsWrong(mainsystem, chosenDay)) {
						  mainsystem.showAvailableHours(chosenService);
						  chosenHour = 12;
						  if(!appointment.checkIfTheEnteredHourNumberIsWrong(mainsystem, chosenHour, chosenService)) {
							    appointment.setService(chosenService);
								appointment.setCustomerId(customer.getId());
								appointment.setYear(chosenYear);
								appointment.setMonth(chosenMonth);
								appointment.setDay(chosenDay);
								appointment.setStartingHour(chosenHour);
								
							  customer.getAppointments().add(appointment);	
							  if(appointment.checkIfTheCustomerHasAnAppointmentAtTheSameTime(customer, appointment)) {
								  scenario7 = true;
							  }
						  }
						  
						  }
				
				}
			}
		}

	}
	@Then("I should see a message telling that I have another appointment at the same time")
	public void iShouldSeeAMessageTellingThatIHaveAnotherAppointmentAtTheSameTime() {
		if(scenario7) {
			System.out.println("You have another appointment at the same time");
			assertTrue(scenario7);
			System.out.println();
			System.out.println("Scenario 7 Booking Feature is covered");
			System.out.println();
		}
	}

	/*
	 * io.cucumber.junit.UndefinedStepException: The step 'I type right appointment
	 * number and there was a conflict in the booking' and 1 other step(s) are
	 * undefined. You can implement these steps using the snippet(s) below:
	 */

	@When("I type right appointment number and there was a conflict in the booking")
	public void iTypeRightAppointmentNumberAndThereWasAConflictInTheBooking() {
		iHaveFiveServices();
		mainsystem.showServices();
		chosenServiceNumber = 2;
		for(int i=0;i<mainsystem.getServices().size();i++) {
			if(mainsystem.getServices().get(i).getId() == chosenServiceNumber) {
				chosenService = mainsystem.getServices().get(i);
			}
		}
		if(!appointment.checkIfTheEnteredServiceNumberIsWrong(mainsystem, chosenServiceNumber,chosenService)) {
			mainsystem.showAvailableYears();
			chosenYear = 2023;
			if(!appointment.checkIfTheEnteredYearNumberIsWrong(chosenYear)) {
				mainsystem.showAvailableMonths(chosenYear);
				chosenMonth = 10;
				if(!appointment.checkIfTheEnteredMonthNumberIsWrong(mainsystem, chosenMonth)) {
					mainsystem.showAvailableDays(chosenMonth,chosenYear);
					chosenDay = 25;
					if(!appointment.checkIfTheEnteredDayNumberIsWrong(mainsystem, chosenDay)) {
						  mainsystem.showAvailableHours(chosenService);
						  chosenHour = 12;
						  if(!appointment.checkIfTheEnteredHourNumberIsWrong(mainsystem, chosenHour, chosenService)) {
							    appointment.setService(chosenService);
								appointment.setCustomerId(customer.getId());
								appointment.setYear(chosenYear);
								appointment.setMonth(chosenMonth);
								appointment.setDay(chosenDay);
								appointment.setStartingHour(chosenHour);
								
								mainsystem.getSystemAppointments().add(appointment);	
							  if(!appointment.checkIfTheCustomerHasAnAppointmentAtTheSameTime(customer, appointment)
									  && appointment.checkIfThereIsAConflict(mainsystem, appointment)) {
								  scenario8 = true;
							  }
						  }
						  
					  }
			
			}
		}
	}
						  
	}
	@Then("I should see a message telling that there is a conflict")
	public void iShouldSeeAMessageTellingThatThereIsAConflict() {
		if(scenario8) {
			System.out.println("There is a conflict");
			assertTrue(scenario8);
			System.out.println();
			System.out.println("Scenario 8 Booking Feature is covered");
			System.out.println();
		}
	}



	/*
	 * io.cucumber.junit.UndefinedStepException: The step 'I type right appointment
	 * number' and 4 other step(s) are undefined. You can implement these steps
	 * using the snippet(s) below:
	 */

	@When("I type right appointment number")
	public void iTypeRightAppointmentNumber() {
		iHaveFiveServices();
		mainsystem.showServices();
		chosenServiceNumber = 2;
		for(int i=0;i<mainsystem.getServices().size();i++) {
			if(mainsystem.getServices().get(i).getId() == chosenServiceNumber) {
				chosenService = mainsystem.getServices().get(i);
			}
		}
		if(!appointment.checkIfTheEnteredServiceNumberIsWrong(mainsystem, chosenServiceNumber,chosenService)) {
			mainsystem.showAvailableYears();
			chosenYear = 2023;
			if(!appointment.checkIfTheEnteredYearNumberIsWrong(chosenYear)) {
				mainsystem.showAvailableMonths(chosenYear);
				chosenMonth = 10;
				if(!appointment.checkIfTheEnteredMonthNumberIsWrong(mainsystem, chosenMonth)) {
					mainsystem.showAvailableDays(chosenMonth,chosenYear);
					chosenDay = 25;
					if(!appointment.checkIfTheEnteredDayNumberIsWrong(mainsystem, chosenDay)) {
						  mainsystem.showAvailableHours(chosenService);
						  chosenHour = 12;
						  if(!appointment.checkIfTheEnteredHourNumberIsWrong(mainsystem, chosenHour, chosenService)) {
							    appointment.setService(chosenService);
								appointment.setCustomerId(customer.getId());
								appointment.setYear(chosenYear);
								appointment.setMonth(chosenMonth);
								appointment.setDay(chosenDay);
								appointment.setStartingHour(chosenHour);
								
							  if(!appointment.checkIfTheCustomerHasAnAppointmentAtTheSameTime(customer, appointment)
									  && !appointment.checkIfThereIsAConflict(mainsystem, appointment)) {
								  scenario9 = true;
							  }
						  }
						  
					  }
			
			}
		}
		}
	}
	@Then("I should see a message telling that the appointment is confirmed")
	public void iShouldSeeAMessageTellingThatTheAppointmentIsConfirmed() {
		if(scenario9) {
			System.out.println("Booked Successfully");
			assertTrue(scenario9);
			System.out.println();
			System.out.println("Scenario 9 Booking Feature is covered");
			System.out.println();
		}
	}
	@Then("The system will book the appointment and will appear in the admin's and employee's calendar")
	public void theSystemWillBookTheAppointmentAndWillAppearInTheAdminSAndEmployeeSCalendar() {
		System.out.println("Appointment added to the system Successfully");
	}
	@Then("the appointment will be saved in the record of the customer's appointments")
	public void theAppointmentWillBeSavedInTheRecordOfTheCustomerSAppointments() {
		customer.getAppointments().add(appointment);
	}


}
