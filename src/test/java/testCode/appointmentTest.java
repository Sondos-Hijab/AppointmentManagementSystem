package testCode;


import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import io.cucumber.java.en.*;
import mainCode.Service;
import mainCode.reservation;
public class appointmentTest {
	static List<Service> reservationsList = new ArrayList<Service>();
	List<List<String>> services;
	List<List<String>> reservations;
	static int numF=0;
	static int dayF=0;
	static int monthF=0;
	static int hourF=0;
	static int yearF=0;
	
	reservation reservation1 = new reservation();
	reservation reservation2 = new reservation();
	reservation reservation3 = new reservation();
	reservation reservation4 = new reservation();
	reservation reservation5 = new reservation();
	reservation reservation6 = new reservation();
	reservation reservation7 = new reservation();
	 
	String wrongNum ="6";
	String year = "2023";
	String month = "6";
	String  day="3";
	String hour = "4";
	

	String Num ="1";
	String wrongyear = "2012";
	String month2 = "12";
	String  day2="12";
	String hour2 = "2";
	
	String Num3 ="3";
	String year3 = "2023";
	String Wrongmonth = "13";
	String  day3="1";
	String hour3 = "1";
	
	
	String Num4 ="4";
	String year4 = "2022";
	String month4 = "12";
	String  Wrongday="33";
	String hour4 = "3";
	
	String Num5 ="5";
	String year5 = "2023";
	String month5 = "6";
	String  day5="3";
	String Wronghour = "50";
	
	String Num6 ="2";
	String year6 = "2022";
	String month6 = "11";
	String  day6="1";
	String hour6 = "2";
	
	String Num7 ="2";
	String year7 = "2023";
	String month7 = "8";
	String  day7="15";
	String hour7 = "10";
	
	@Given("the user is logged in")
	public void theUserIsLoggedIn() {
	    
	}
	@Given("the data table for services")
	public void theDataTableForServices(io.cucumber.datatable.DataTable dataTable) {
		services = dataTable.asLists();		
		/*for(int i=0 ; i<services.size();i++) {
			System.out.println(services);
		}*/
	}
	@Given("the data table for reservations")
	public void theDataTableForReservations(io.cucumber.datatable.DataTable dataTable) {
		reservations = dataTable.asLists();		
		System.out.println(reservations);
		for(int i=0 ; i<reservations.size();i++) {
			Service temp = new Service(reservations.get(i).get(0).toString(), reservations.get(i).get(1).toString(),reservations.get(i).get(2).toString(), reservations.get(i).get(3).toString(),reservations.get(i).get(4).toString(), reservations.get(i).get(5).toString()); 
			 reservationsList.add(temp);
		}
	}
	/*@When("user enters number of service")
	public void userEntersNumberOfService() {
		reservation1.setNumber(wrongNum);
	 
	}
	@When("I check if the number exists")
	public void iCheckIfTheNumberExists() {
		for(int i=0;i<reservationsList.size();i++) {
			if(!reservation1.getNumber().equals(reservationsList.get(i).getNumber()))
				
				numF = 1;
			}
	}
	@When("user enters year")
	public void userEntersYear() {
	   
	}
	@When("I check if the year is correct")
	public void iCheckIfTheYearIsCorrect() {
	    
	}
	@When("user enters month")
	public void userEntersMonth() {
	  
	}
	@When("I check if the month is correct")
	public void iCheckIfTheMonthIsCorrect() {
	    
	}
	@When("user enters day")
	public void userEntersDay() {
	   
	}
	@When("I check if the day is correct")
	public void iCheckIfTheDayIsCorrect() {
	  
	}
	@When("user enters hour")
	public void userEntersHour() {
	   
	}
	@When("I check if the hour is correct")
	public void iCheckIfTheHourIsCorrect() {
	    
	}
	@When("i check if there is another appointment in the same time")
	public void iCheckIfThereIsAnotherAppointmentInTheSameTime() {
	    
	}*/
	
	@When("I type wrong service number")
	public void iTypeWrongServiceNumber() {
		reservation1.setNumber(wrongNum);
		
		for(int i=0;i<reservationsList.size();i++) {
			if(!reservation1.getNumber().equals(reservationsList.get(i).getNumber()))
				
		    dayF=0;
		    monthF=0;
		    yearF=0;
		    hourF=0;
				numF = 1;
			break;
			}
	}
	@Then("I should see wrong number")
	public void iShouldSeeWrongNumber() {
		if(numF == 1 && dayF==0 && yearF==0 && hourF==0 && monthF==0 ) {
			assertTrue(numF==1);
			assertTrue(hourF==0);
			assertTrue(monthF==0);
			assertTrue(dayF==0);
			assertTrue(yearF==0);
			System.out.println("wrong number for service");
		}
	}


	@When("I type wrong year")
	public void iTypeWrongYear() {
		reservation2.setNumber(Num);
		reservation2.setYear(wrongyear);
		reservation2.setMonth(month2);
		reservation2.setDay(day2);
		reservation2.setHour(hour2);
		
		for(int i=0;i<reservationsList.size();i++) {
			
			if(reservation2.getNumber().equals(reservationsList.get(i).getNumber()) && !reservation2.getYear().equals(reservationsList.get(i).getYear()) &&reservation2.getMonth().equals(reservationsList.get(i).getMonth())
					&&reservation2.getDay().equals(reservationsList.get(i).getDay())
					&& reservation2.getHour().equals(reservationsList.get(i).getHour())) {
				hourF=0;
				monthF=0;
				dayF=0;
				numF=0;
				yearF = 1;
			break;
			}
			}
	  
	}
	@Then("I should see wrong year")
	public void iShouldSeeWrongYear() {
		if(yearF == 1 && monthF == 0 && numF==0 &&dayF==0 && hourF==0) {
			
			assertTrue(hourF==0);
			assertTrue(monthF==0);
			assertTrue(dayF==0);
			assertTrue(numF==0);
			System.out.println("wrong year");
			
		}
	}

	

	@When("I type wrong month")
	public void iTypeWrongMonth() {
		reservation3.setMonth(Wrongmonth);
		reservation3.setDay(day3);
		reservation3.setHour(hour3);
		reservation3.setNumber(Num3);
		reservation3.setYear(year3);
		for(int i=0;i<reservationsList.size();i++) {
			if(reservation3.getNumber().equals(reservationsList.get(i).getNumber()) && reservation3.getYear().equals(reservationsList.get(i).getYear()) &&!reservation3.getMonth().equals(reservationsList.get(i).getMonth())
					&&reservation3.getDay().equals(reservationsList.get(i).getDay())
					&& reservation3.getHour().equals(reservationsList.get(i).getHour()))
				hourF=0;
			
			dayF=0;
			numF=0;
			yearF = 0;
				monthF = 1;
			break;
			}
	}
	@Then("I should see wrong month")
	public void iShouldSeeWrongMonth() {
		if(monthF == 1 && numF==0 && yearF==0 &&dayF==0 && hourF==0) {
			assertTrue(monthF==1);
			assertTrue(hourF==0);
			assertTrue(dayF==0);
			assertTrue(yearF==0);
			assertTrue(numF==0);
			System.out.println("wrong month");
			
		}
	}


	@When("I type wrong day")
	public void iTypeWrongDay() {
		reservation4.setDay(Wrongday);
		reservation4.setHour(hour4);
		reservation4.setMonth(month4);
		reservation4.setYear(year4);
		reservation4.setNumber(Num4);
		for(int i=0;i<reservationsList.size();i++) {
			if(reservation4.getNumber().equals(reservationsList.get(i).getNumber()) && reservation4.getYear().equals(reservationsList.get(i).getYear()) &&reservation4.getMonth().equals(reservationsList.get(i).getMonth())
					&&!(reservation4.getDay().equals(reservationsList.get(i).getDay()))
					&& reservation4.getHour().equals(reservationsList.get(i).getHour()))
				
				monthF=0;
				hourF=0;
				yearF=0;
				numF=0;
				dayF = 1;
			break;
			}
	}
	@Then("I should see wrong day")
	public void iShouldSeeWrongDay() {
		if(dayF == 1 && monthF == 0 && numF==0 && yearF==0 && hourF==0) {
			assertTrue(dayF==1);
			assertTrue(monthF==0);
			assertTrue(hourF==0);
			assertTrue(yearF==0);
			assertTrue(numF==0);
			System.out.println("wrong day");
		}
	}


	@When("I type wrong hour")
	public void iTypeWrongHour() {
		reservation5.setDay(Wronghour);
		reservation5.setDay(day5);
		reservation5.setMonth(month5);
		reservation5.setYear(year5);
		reservation5.setNumber(Num5);
		for(int i=0 ;i<reservationsList.size() ;i++) {
			if(reservation5.getNumber().equals(reservationsList.get(i).getNumber()) && reservation5.getYear().equals(reservationsList.get(i).getYear()) &&reservation5.getMonth().equals(reservationsList.get(i).getMonth())
					&&reservation5.getDay().equals(reservationsList.get(i).getDay())
					&& !reservation5.getHour().equals(reservationsList.get(i).getHour())) 
				monthF=0;
			    dayF=0;
			    yearF=0;
			    numF=0;
				hourF = 1;
			break;
			
			}
	}
	@Then("I should see wrong hour")
	public void iShouldSeeWrongHour() {
		if(hourF == 1 && dayF == 0 && monthF == 0 && numF==0 && yearF==0 ) {
			
			assertTrue(monthF==0);
			assertTrue(dayF==0);
			assertTrue(yearF==0);
			assertTrue(numF==0);
			assertTrue(hourF==1);
			System.out.println("wrong hour");
			
		}
	}


	@When("there is an appointment in the same time")
	public void thereIsAnAppointmentInTheSameTime() {
		reservation6.setNumber(Num6);
		reservation6.setYear(year6);
		reservation6.setMonth(month6);
		reservation6.setDay(day6);
		reservation6.setHour(hour6);
		for(int i=0;i<reservationsList.size();i++) {
			if(reservation6.getNumber().equals(reservationsList.get(i).getNumber()) && reservation6.getYear().equals(reservationsList.get(i).getYear()) &&reservation6.getMonth().equals(reservationsList.get(i).getMonth())
					&&reservation6.getDay().equals(reservationsList.get(i).getDay())
					&& reservation6.getHour().equals(reservationsList.get(i).getHour()))
				numF=0;
			    dayF=0;
			    monthF=0;
			    yearF=0;
			    hourF=0;
			    		
			
			break;
			}
	    
	}
	@Then("there is another apointment")
	public void thereIsAnotherApointment() {
		if(hourF == 0 && dayF==0 && monthF==0 && yearF==0 && numF==0) {
			assertTrue(hourF==0);
			assertTrue(monthF==0);
			assertTrue(dayF==0);
			assertTrue(yearF==0);
			assertTrue(numF==0);
			System.out.println("there is another apointment");
		}
	}


	@When("I type correct inputs")
	public void iTypeCorrectInputs() {
		reservation7.setNumber(Num7);
		reservation7.setYear(year7);
		reservation7.setMonth(month7);
		reservation7.setDay(day7);
		reservation7.setHour(hour7);
			
		for(int i=1;i<reservationsList.size();i++) {
			if(!reservation7.getNumber().equals(reservationsList.get(i).getNumber()) && !reservation7.getYear().equals(reservationsList.get(i).getYear()) && !reservation7.getMonth().equals(reservationsList.get(i).getMonth())
					&&!reservation7.getDay().equals(reservationsList.get(i).getDay())
					&& !reservation7.getHour().equals(reservationsList.get(i).getHour()))
				numF=0;
			    dayF=0;
			    monthF=0;
			    yearF=0;
			    hourF=0;
			    		
			
			break;
			}
	}
	@Then("i should see successful booking")
	public void iShouldSeeSuccessfulBooking() {
		if(hourF == 0 && dayF==0 && monthF==0 && yearF==0 && numF==0) {
			assertTrue(hourF==0);
			assertTrue(monthF==0);
			assertTrue(dayF==0);
			assertTrue(yearF==0);
			assertTrue(numF==0);
			System.out.println("successful booking ");
			System.out.println("/////////////////////////////////////////////////");
		}
	}









}
