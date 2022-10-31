package mainCode;

import java.time.Month;
import java.time.Year;
import java.util.Scanner;
import java.lang.Object.*;

import java.time.Month;
import java.time.Year;
import java.util.Scanner;
import java.lang.Object.*;

public class Appointment {
	private String appointmentId;
	private String customerId;
	private Service service;
	private int startingHour;
	private int year;
	private int month;
	

	private int day;
	
	
	//constructors
	public Appointment () {
		
	}
	
	public Appointment(String id, String customerId, Service service, int startingHour, int year, int month, int day) {
		this.appointmentId = id;
		this.customerId = customerId;
		this.service = service;
		this.startingHour = startingHour;
		this.year = year;
		this.month = month;
		this.day = day;
	}
	


	//getters and setters
	public String getId() {
		return appointmentId;
	}
	
	public void setId(String id) {
		this.appointmentId = id;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	
	public String getCustomerId() {
		return customerId;
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





	

}
