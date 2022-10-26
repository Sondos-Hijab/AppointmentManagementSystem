package mainCode;

import java.time.Month;
import java.time.Year;
import java.util.Scanner;
import java.lang.Object.*;

public class Appointment {
	private int id;
	private int customerId;
	private Service service;
	private int startingHour;
	private int year;
	private int month;
	private int day;
	
	
	//constructors
	public Appointment () {
		
	}
	
	public Appointment(int id, int customerId, Service service, int startingHour, int year, int month, int day) {
		this.id = id;
		this.customerId = customerId;
		this.service = service;
		this.startingHour = startingHour;
		this.year = year;
		this.month = month;
		this.day = day;
	}
	

	public Appointment(int id, int customerId, Service service) {
		this.id = id;
		this.customerId = customerId;
		this.service = service;
	}
	
	//getters and setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public Service getService() {
		return service;
	}
	public void setService(Service service) {
		this.service = service;
	}
	public int getStartingHour() {
		return startingHour;
	}
	public void setStartingHour(int startingHour) {
		this.startingHour = startingHour;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int yearNumber) {
		this.year = yearNumber;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}

	public Appointment bookAnAppointment(MainSystem mainsystem, Customer customer) {
		
		Service chosenService = new Service();
		int serviceTime = chosenService.getTime();
		
		int chosenServiceNumber = this.handlingServiceNumber(mainsystem,chosenService);
		
		
		for(int i=0;i<mainsystem.getServices().size();i++) {
			if(mainsystem.getServices().get(i).getId() == chosenServiceNumber) {
				chosenService = mainsystem.getServices().get(i);
				serviceTime = chosenService.getTime();
			}
		}
		
		int chosenYear = this.handlingYearNumber(mainsystem);
		
		int chosenMonth = this.handlingMonthNumber(mainsystem, chosenYear);
		
		int chosenDay = this.handlingDayNumber(mainsystem, chosenMonth, chosenYear);
		
		int chosenHour = this.handlingHourNumber(mainsystem, chosenService);
		

		Appointment appointment = new Appointment();
		appointment.setService(chosenService);
		appointment.setCustomerId(customer.getId());
		appointment.setYear(chosenYear);
		appointment.setMonth(chosenMonth);
		appointment.setDay(chosenDay);
		appointment.setStartingHour(chosenHour);
		
		boolean customerHasAnAppointmentAtTheSameTime = checkIfTheCustomerHasAnAppointmentAtTheSameTime(customer,appointment);
		
		if (customerHasAnAppointmentAtTheSameTime) {
			System.out.println("You have an appointemtnat at the same time, please re-book your appointment");
			return bookAnAppointment( mainsystem,  customer);
		}
		
		boolean thereIsAConflict = checkIfThereIsAConflict(mainsystem, appointment);
		if(thereIsAConflict) {
			System.out.println("There is a conflict, please re-book your appointment");
			return bookAnAppointment( mainsystem,  customer);
		}
		
		return this;
	}
	




	//---------------------------helping functions
	Scanner sc = new Scanner(System.in);
	
	
	public int handlingServiceNumber (MainSystem mainsystem, Service chosenService) {
		int chosenServiceNumber ;
		mainsystem.showServices();
		chosenServiceNumber = this.askUserToChooseTheService();
		boolean serviceNumberIsWrong = this.checkIfTheEnteredServiceNumberIsWrong(mainsystem,chosenServiceNumber, chosenService);
		if(serviceNumberIsWrong)
		{
			this.showErrorMessageServiceNumberIsWrong();
			System.out.println("Can you please enter the service number again:");
			handlingServiceNumber(mainsystem,chosenService);

		}
		
		return chosenServiceNumber;
	}
	
	public int askUserToChooseTheService() {
		System.out.println("Please enter the service number that you want:");
	    int serviceNumber = sc.nextInt();
		return serviceNumber;
	}
	
	
	public boolean checkIfTheEnteredServiceNumberIsWrong(MainSystem mainSys, int chosenServiceNumber, Service chosenService) {
		for(int i=0;i<mainSys.getServices().size();i++) {
			if(mainSys.getServices().get(i).getId() == chosenServiceNumber) {
				chosenService = mainSys.getServices().get(i);
				return false;
			}
		}
		return true;
	}
	
	public void showErrorMessageServiceNumberIsWrong() {
		System.out.println("Error Message: The Service Number You chose is wrong");
	}
	
	
	
	//handling year
	private int handlingYearNumber(MainSystem mainsystem) {
		int yearNumber;
		mainsystem.showAvailableYears();
		yearNumber = this.askUserToChooseTheYear();
		boolean enteredYearNumberIsWrong = this.checkIfTheEnteredYearNumberIsWrong(yearNumber);
		if(enteredYearNumberIsWrong) {
			this.showErrorMessageYearNumberIsWrong();
			System.out.println("Can you please enter the year number again:");
			this.handlingYearNumber(mainsystem);
		}
			return yearNumber;

	}
	
	public int askUserToChooseTheYear() {
		int yearNumber = sc.nextInt();
		return yearNumber;
	}
	
	public boolean checkIfTheEnteredYearNumberIsWrong(int yearNumber) {
		if(yearNumber == 2022 || yearNumber == 2023) return false;
		else return true;
	}
	
	public void showErrorMessageYearNumberIsWrong() {
		System.out.println("Error Message: The Year Number You chose is wrong");
		
	}
	
	//handling month
	private int handlingMonthNumber(MainSystem mainsystem, int yearNumber) {
		int monthNumber;
		mainsystem.showAvailableMonths(yearNumber);
		monthNumber = this.askUserToChooseTheMonth();
		boolean enteredMonthNumberIsWrong = this.checkIfTheEnteredMonthNumberIsWrong(mainsystem,monthNumber);
		if(enteredMonthNumberIsWrong) {
			this.showErrorMessageMonthNumberIsWrong();
			System.out.println("Can you please enter the month number again:");
			this.handlingMonthNumber(mainsystem, yearNumber);
		}
			return monthNumber;
	}
	
	
	public int askUserToChooseTheMonth() {
		System.out.println("Please press the number of the month:");
		int monthNumber = sc.nextInt();
		return monthNumber;
	}


	public boolean checkIfTheEnteredMonthNumberIsWrong(MainSystem mainsystem, int month) {
		for(int i=0;i<mainsystem.months.size();i++) {
			if(month == mainsystem.months.get(i)) return false;
		}
		return true;
	}


	public void showErrorMessageMonthNumberIsWrong() {
		System.out.println("Error Message: The Month Number You chose is wrong");
	}
	
	
	
	//handling day
	private int handlingDayNumber(MainSystem mainsystem, int chosenMonth, int chosenYear) {
		int dayNumber;
		mainsystem.showAvailableDays(chosenMonth,chosenYear);
		dayNumber = this.askUserToChooseTheDay();
		boolean enteredDayNumberIsWrong = this.checkIfTheEnteredDayNumberIsWrong(mainsystem,dayNumber);
		if(enteredDayNumberIsWrong) {
			this.showErrorMessageDayNumberIsWrong();
			System.out.println("Can you please enter the day number again:");
			this.handlingDayNumber(mainsystem, chosenMonth, chosenYear);
		}
			return dayNumber;
	}
	
	public int askUserToChooseTheDay() {
		System.out.println("Please press the number of the Day:");
		int dayNumber = sc.nextInt();
		return dayNumber;
	}

	public boolean checkIfTheEnteredDayNumberIsWrong(MainSystem mainsystem, int dayNumber) {
		for(int i=0;i<mainsystem.days.size();i++) {
			if(dayNumber == mainsystem.days.get(i)) return false;
		}
		return true;
	}

	public void showErrorMessageDayNumberIsWrong() {
		System.out.println("Error Message: The Day Number You chose is wrong");
		
	}
	
	
	//handling hour
	private int handlingHourNumber(MainSystem mainsystem, Service chosenService) {
		int hourNumber;
		mainsystem.showAvailableHours(chosenService);
		hourNumber = this.askUserToChooseTheHour();
		boolean enteredHourNumberIsWrong = this.checkIfTheEnteredHourNumberIsWrong(mainsystem,hourNumber, chosenService);
		if(enteredHourNumberIsWrong) {
			this.showErrorMessageHourNumberIsWrong();
			System.out.println("Can you please enter the hour number again:");
			this.handlingHourNumber(mainsystem, chosenService);
		}
			return hourNumber;
	}

	private int askUserToChooseTheHour() {
		System.out.println("Please press the starting hour:");
		int hourNumber = sc.nextInt();
		return hourNumber;
	}

	public boolean checkIfTheEnteredHourNumberIsWrong(MainSystem mainsystem, int hourNumber ,Service chosenService ) {
		for(int i=mainsystem.startHour ; i<mainsystem.endHour; i+=chosenService.getTime()) {
			if(hourNumber == i) return false;
		}
		return true;
	}

	public void showErrorMessageHourNumberIsWrong() {
		System.out.println("Error Message: The Hour Number You chose is wrong");
		
	}


	//if customer has appointment at the same time
	public boolean checkIfTheCustomerHasAnAppointmentAtTheSameTime(Customer customer, Appointment appointment ) {
		for(int i=0;i<customer.getAppointments().size();i++) {
			if(customer.getAppointments().get(i).getYear() == appointment.getYear() && 
					customer.getAppointments().get(i).getMonth() == appointment.getMonth() &&
					customer.getAppointments().get(i).getDay() == appointment.getDay() &&
					customer.getAppointments().get(i).getStartingHour() == appointment.getStartingHour()
					)
				return true;
		}
		return false;
	}


	//if there is a conflict

	public boolean checkIfThereIsAConflict(MainSystem mainsystem, Appointment appointment) {
		for(int i=0;i<mainsystem.getSystemAppointments().size();i++) {
			if(mainsystem.getSystemAppointments().get(i).getYear() == appointment.getYear() && 
			mainsystem.getSystemAppointments().get(i).getMonth() == appointment.getMonth() &&
			mainsystem.getSystemAppointments().get(i).getDay() == appointment.getDay() &&
			mainsystem.getSystemAppointments().get(i).getStartingHour() == appointment.getStartingHour() &&
			mainsystem.getSystemAppointments().get(i).getService() == appointment.getService() &&
			mainsystem.getSystemAppointments().get(i).getStartingHour() == appointment.getStartingHour()
					)
				return true;
		}
		return false;
	}

	public void showErrorMessageServiceNumberIsEmpty() {
		System.out.println("Error Message: The Service Number Field is empty");
	}






	

}
