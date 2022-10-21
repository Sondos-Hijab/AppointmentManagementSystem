package AMS;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import mainClass.BookingClass;
import mainClass.Reservations;
import mainClass.service;

public class appointmentSteps {
	static List<Reservations> listOfAppointments = new ArrayList<Reservations>();
	static List<List<String>> appointmentsList;
	BookingClass ob;

	String serviceName = "colouring hair";
	String employeeId = "2";
	String userId = "3";
	String serviceId = "1";
	String price = "100";
	String time = "2";
	String start_time = "4";
	String end_time = "6";
	String day = "10";
	String month = "11";
	String year = "2023";

	String serviceNameCase1 = "";
	
	static String serviceIdCase2 = "100";
	static int sizeOfArrayService = 10;
	static int numberOfService = Integer.parseInt(serviceIdCase2);
	
	

	static String yearCase3 = "2025";
	static int yearC3 = Integer.parseInt(yearCase3);

	static String monthCase4 = "13";
	static int monthC4 = Integer.parseInt(yearCase3);
	
	static String dayCase5 = "13";
	static int dayC5 = Integer.parseInt(dayCase5);
	static String monthCase5 = "11";
	static int monthC5 = Integer.parseInt(monthCase5);

	static String start_timeCase6 = "9";
	static int start_timeC6 = Integer.parseInt(start_timeCase6);

	static String start_timeCase7 = "5";
	static int start_timeC7 = Integer.parseInt(start_timeCase7);
	static String timeCase7 = "2";
	static int timeC7 = Integer.parseInt(timeCase7);

	static String serviceIdCase8 = "1";
	static int serviceIdC8 = Integer.parseInt(serviceIdCase8);
	
	static String userIdCase9 = "3";
	static int userIdC9 = Integer.parseInt(userIdCase9);
	
	static String serviceIdCase10 = "8";
	static int serviceIdC10 = Integer.parseInt(serviceIdCase10);
	static String userIdCase10 = "13";
	static int userIdC10 = Integer.parseInt(userIdCase10);
	
	static String dayCase8_10 = "1";
	static String monthCase8_10 = "12";
	static String yearCase8_10 = "2022";
	static String start_timeCase8_10 = "10";
	static String end_timeCase8_10 = "12";
	static int start_timeC8_10 = Integer.parseInt(start_timeCase8_10);
	static int end_timeC8_10 = Integer.parseInt(end_timeCase8_10);
	static int dayC8_10 = Integer.parseInt(dayCase8_10);
	static int monthC8_10 = Integer.parseInt(monthCase8_10);
	static int yearC8_10 = Integer.parseInt(yearCase8_10);


	static boolean case1 = false;
	static boolean case2 = false;
	static boolean case3 = false;
	static boolean case4 = false;
	static boolean case5 = false;
	static boolean case6 = false;
	static boolean case7 = false;
	static boolean case8 = false;
	static boolean case9 = false;
	static boolean case10 = false;

	@Given("the data table for existing appointments")
	public void theDataTableForExistingAppointments(io.cucumber.datatable.DataTable dataTable) {
		System.out.println("Appointment test caseS");
		appointmentsList = dataTable.asLists();
		for (int i = 1; i < appointmentsList.size(); i++) {
			Reservations temp = new Reservations(appointmentsList.get(i).get(0).toString(),
					appointmentsList.get(i).get(1).toString(), appointmentsList.get(i).get(2).toString(),
					appointmentsList.get(i).get(3).toString(), appointmentsList.get(i).get(4).toString(),
					appointmentsList.get(i).get(5).toString(), appointmentsList.get(i).get(6).toString(),
					appointmentsList.get(i).get(7).toString(), appointmentsList.get(i).get(8).toString(),
					appointmentsList.get(i).get(9).toString(), appointmentsList.get(i).get(10).toString());
			listOfAppointments.add(temp);
		}
	}

	@When("I miss typing the value of one field or more")
	public void iMissTypingTheValueOfOneFieldOrMore() {

		if (serviceNameCase1.isEmpty() || employeeId.isEmpty() || userId.isEmpty() || serviceId.isEmpty()
				|| price.isEmpty() || time.isEmpty() || start_time.isEmpty() || end_time.isEmpty() || day.isEmpty()
				|| month.isEmpty() || year.isEmpty()) {
			case1 = true;
		}

	}

	@Then("I should see the value of one field or more is empty")
	public void iShouldSeeTheValueOfOneFieldOrMoreIsEmpty() {
		if (case1) {
			System.out.println("Case2: the value of one field or more is empty");
			assertTrue(case1);
		}

	}

	@When("I type wrong number for the service")
	public void iTypeWrongNumberForTheService() {
		if (!ob.checkNumberOfService(sizeOfArrayService, numberOfService)) {
			case2 = true;
		}

	}

	@Then("I should see the number for the service is incorrect")
	public void iShouldSeeTheNumberForTheServiceIsIncorrect() {
		if (case2) {
			System.out.println("Case2: the number for the service is incorrect");
			assertTrue(case2);
		}
	}

	@When("I type wrong number for the year")
	public void iTypeWrongNumberForTheYear() {
		if (!ob.checkYear(yearC3)) {
			case3 = true;
		}

	}

	@Then("I should see the number for the year is incorrect")
	public void iShouldSeeTheNumberForTheYearIsIncorrect() {
		if (case3) {
			System.out.println("Case3: the number for the year is incorrect");
			assertTrue(case3);
		}

	}

	@When("I type  wrong number for the month")
	public void iTypeWrongNumberForTheMonth() {
		if (!ob.checkMonth(monthC4)) {
			case4 = true;
		}

	}

	@Then("I should see the number for the month is incorrect")
	public void iShouldSeeTheNumberForTheMonthIsIncorrect() {
		if (case4) {
			System.out.println("Case4: the number for the month is incorrect");
			assertTrue(case4);
		}

	}

	@When("I type  wrong number for the day")
	public void iTypeWrongNumberForTheDay() {
		if (!ob.checkDay(dayC5, monthC5)) {
			case5 = true;
		}

	}

	@Then("I should see the number for the day is incorrect")
	public void iShouldSeeTheNumberForTheDayIsIncorrect() {
		if (case5) {
			System.out.println("Case5: the number for the day is incorrect");
			assertTrue(case5);
		}

	}

	@When("I type  wrong number for the starting time")
	public void iTypeWrongNumberForTheStartingTime() {
		if (!ob.checkStartTime(start_timeC6)) {
			case6 = true;
		}

	}

	@Then("I should see the number for the starting time is incorrect")
	public void iShouldSeeTheNumberForTheStartingTimeIsIncorrect() {
		if (case6) {
			System.out.println("Case6: the number for the starting time is incorrect");
			assertTrue(case6);
		}

	}

	@When("I type  correct number for the starting time but the ending time exceeded the close time")
	public void iTypeCorrectNumberForTheStartingTimeButTheEndingTimeExceededTheCloseTime() {
		if (!ob.checkEndTime(start_timeC7, timeC7)) {
			case7 = true;
		}

	}

	@Then("I should see the number for the starting time and ending time are incorrect")
	public void iShouldSeeTheNumberForTheStartingTimeAndEndingTimeAreIncorrect() {
		if (case7) {
			System.out.println("Case7: the number for the ending time is incorrect");
			assertTrue(case7);
		}

	}

	@When("I typed the right booking date but there is already another booking on that date")
	public void iTypedTheRightBookingDateButThereIsAlreadyAnotherBookingOnThatDate() {
		if (ob.checkDate(yearC8_10, monthC8_10, dayC8_10)) {
			for (int i = 0; i < listOfAppointments.size(); i++) {
				if (serviceIdCase8.equals(listOfAppointments.get(i).getServiceId())
						&& start_timeCase8_10.equals(listOfAppointments.get(i).getStartTime())
						&& end_timeCase8_10.equals(listOfAppointments.get(i).getEndTime())
						&& dayCase8_10.equals(listOfAppointments.get(i).getDay())
						&& monthCase8_10.equals(listOfAppointments.get(i).getMonth())
						&& yearCase8_10.equals(listOfAppointments.get(i).getYear())) {
					case8 = true;
					break;
				}
			}
		}
	}

	@Then("I should see the appointment you are trying to book is already booked")
	public void iShouldSeeTheAppointmentYouAreTryingToBookIsAlreadyBooked() {
		if (case8) {
			System.out.println("Case8: the appointment you are trying to book is already booked");
			assertTrue(case8);
		}

	}

	@When("I typed the right booking date but I already have another booking on that date")
	public void iTypedTheRightBookingDateButIAlreadyHaveAnotherBookingOnThatDate() {
		if (ob.checkDate(yearC8_10, monthC8_10, dayC8_10)) {
			for (int i = 0; i < listOfAppointments.size(); i++) {
				if (userIdCase9.equals(listOfAppointments.get(i).getUserId())
						&& start_timeCase8_10.equals(listOfAppointments.get(i).getStartTime())
						&& end_timeCase8_10.equals(listOfAppointments.get(i).getEndTime())
						&& dayCase8_10.equals(listOfAppointments.get(i).getDay())
						&& monthCase8_10.equals(listOfAppointments.get(i).getMonth())
						&& yearCase8_10.equals(listOfAppointments.get(i).getYear())){
					case9 = true;
					break;
				}
			}
		}
		

	}

	@Then("I should see you already have another booking on that date")
	public void iShouldSeeYouAlreadyHaveAnotherBookingOnThatDate() {
		if (case9) {
			System.out.println("Case9: you already have another booking on that date");
			assertTrue(case9);
		}

	}

	@When("I typed the right booking date without any conflict in the booking and I don't  have another booking on that date")
	public void iTypedTheRightBookingDateWithoutAnyConflictInTheBookingAndIDonTHaveAnotherBookingOnThatDate() {
		if (ob.checkDate(yearC8_10, monthC8_10, dayC8_10)) {
			for (int i = 0; i < listOfAppointments.size(); i++) {
				if ((!userIdCase10.equals(listOfAppointments.get(i).getUserId())
						|| !serviceIdCase10.equals(listOfAppointments.get(i).getServiceId()))
						&& start_timeCase8_10.equals(listOfAppointments.get(i).getStartTime())
						&& end_timeCase8_10.equals(listOfAppointments.get(i).getEndTime())
						&& dayCase8_10.equals(listOfAppointments.get(i).getDay())
						&& monthCase8_10.equals(listOfAppointments.get(i).getMonth())
						&& yearCase8_10.equals(listOfAppointments.get(i).getYear())) {
					case10 = true;
					break;
				}
			}
		}

	}

	@Then("I should see successful booking")
	public void iShouldSeeSuccessfulBooking() {
		if (case10) {
			System.out.println("Case10: successful booking");
			assertTrue(case10);
		}

	}

}
