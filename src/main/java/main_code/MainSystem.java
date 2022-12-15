package main_code;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class MainSystem {

	
	List <Customer> customers = new ArrayList <Customer>();
	List <Employee> employees = new ArrayList <Employee>();
	List <Admin> admins = new ArrayList <Admin>();
	List <Service> services = new ArrayList <Service>();
	List <Appointment> systemAppointments = new ArrayList <Appointment>();
	List <Visit> visits = new ArrayList <Visit>();
	List <Providers> providers = new ArrayList <Providers>();




	int startHour = 10;
	int endHour = 18;
	
	
	LocalDate time = java.time.LocalDate.now();
	int currentMonth = time.getMonthValue();
	int currentDay = time.getDayOfMonth();
	int currentYear = time.getYear();
	//constructors
	

	public MainSystem() {
		super();
	}


	//getters and setters
	
	public List<Visit> getVisits() {
		return visits;
	}

	
	public void addCustomer (Customer c) {
		this.customers.add(c);
	}
	
	public void addProvider (Providers p) {
		this.providers.add(p);
	}
	
	public void addVisit (Visit c) {
		this.visits.add(c);
	}
	
	public void addService (Service c) {
		this.services.add(c);
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


	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}


	public List<Employee> getEmployees() {
		return employees;
	}


	public List<Service> getServices() {
		return services;
	}



	public List<Providers> getProvider() {
		return providers;
	}

	public void setProviders(List<Providers> providers) {
		this.providers = providers;
	}

	
	public List<Appointment> getSystemAppointments() {
		return systemAppointments;
	}



	

	


}
