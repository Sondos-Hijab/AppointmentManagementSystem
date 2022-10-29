package mainCode;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainSystem {

	List <Customer> customers = new ArrayList <Customer>();
	List <Employee> employees = new ArrayList <Employee>();
	List <Admin> admins = new ArrayList <Admin>();
	List <Service> services = new ArrayList <Service>();
	List <Appointment> systemAppointments = new ArrayList <Appointment>();

	int startHour = 10;
	int endHour = 18;
	
	
	LocalDate time = java.time.LocalDate.now();
	int currentMonth = time.getMonthValue();
	int currentDay = time.getDayOfMonth();
	int currentYear = time.getYear();
	//constructors
	public MainSystem() {
			
		}


	//getters and setters
	
	public void addCustomer (Customer c) {
		this.customers.add(c);
	}
	
	public void addEmployee (Employee e) {
		this.employees.add(e);
	}
	
	
	public void addAppointment (Appointment a) {
		this.systemAppointments.add(a);
	}
	
	public List<Customer> getCustomers() {
		return customers;
	}


	public List<Employee> getEmployees() {
		return employees;
	}


	public List<Service> getServices() {
		return services;
	}



	public List<Appointment> getSystemAppointments() {
		return systemAppointments;
	}



	

	


}
