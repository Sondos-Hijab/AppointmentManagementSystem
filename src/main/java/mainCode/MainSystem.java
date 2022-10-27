
package mainCode;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainSystem {

	List <Customer> customers = new ArrayList <Customer>();
	//List <Employee> employees = new ArrayList <Employee>();
	//List <Admin> admins = new ArrayList <Admin>();
	List <Service> services = new ArrayList <Service>();
	//List <Appointment> systemAppointments = new ArrayList <Appointment>();

	int startHour = 10;
	int endHour = 18;
	
	//constructors
	public MainSystem() {
			
		}

	public MainSystem(List<Customer> customers) {
		super();
		this.customers = customers;
		//this.employees = employees;
		//this.admins = admins;
		//this.services = services;
		//this.systemAppointments = systemAppointments;
	}


	
	
	//getters and setters
	
	public void addCustomer (Customer c) {
		this.customers.add(c);
	}
	
	/*public void addEmployee (Employee e) {
		this.employees.add(e);
	}
	
	public void addAdmin (Admin a) {
		this.admins.add(a);
	}
	
	public void addService (Service s) {
		this.services.add(s);
	}
	
	public void addAppointment (Appointment a) {
		this.systemAppointments.add(a);
	}*/
	
	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

/*	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public List<Admin> getAdmins() {
		return admins;
	}

	public void setAdmins(List<Admin> admins) {
		this.admins = admins;
	}

	public List<Service> getServices() {
		return services;
	}

	public void setServices(List<Service> services) {
		this.services = services;
	}

	public List<Appointment> getSystemAppointments() {
		return systemAppointments;
	}

	public void setSystemAppointments(List<Appointment> systemAppointments) {
		this.systemAppointments = systemAppointments;
	}*/

	
	//--------------------------------------------helping functions--------------------------------------------//
	/*public void showServices() {
		System.out.println("The services that we have are:");
		for(int i=0;i<this.getServices().size();i++) {
				this.getServices().get(i).print();
		}
		
	}*/
	
	
	LocalDate time = java.time.LocalDate.now();
	int currentMonth = time.getMonthValue();
	int currentDay = time.getDayOfMonth();
	int currentYear = time.getYear();
	
	List <Integer> months = new ArrayList <Integer>(); 
	List <Integer> days = new ArrayList <Integer>();
	List <Integer> hours = new ArrayList <Integer>();
	
	public void showAvailableYears() {
		System.out.println("The years that you can book your appointment in are 2022 and 2023, please enter the year that you want:");
		
	}
	
	public void showAvailableMonths(int chosenYear) {
		System.out.println("You can book your appointment in the listed months, please enter the number of the month that you want:");
		if(chosenYear == currentYear) {
			for(int i = currentMonth;i<13;i++) {
				months.add(i);
				System.out.println("Month : "+i);
			}
		}
		else if (chosenYear > currentYear) {
			for(int i = 1;i<13;i++) {
				months.add(i);
				System.out.println("Month : "+i);
			}
		}
	}
	
	public void showAvailableDays(int chosenMonth, int chosenYear) {
		System.out.println("You can book your appointment in the listed days, please enter the number of the day that you want:");
		if(chosenMonth == currentMonth && chosenYear==currentYear) {
			for(int i = currentDay+1;i<=30;i++) {
				days.add(i);
				System.out.println("Day : "+i);
			}
		}
		else if (chosenMonth > currentMonth || chosenMonth == currentMonth) {
			for(int i = 1;i<=30;i++) {
				days.add(i);
				System.out.println("Day : "+i);
			}
		}

	}
	
	/*public void showAvailableHours(Service chosenService) {
		System.out.println("Please select the starting hour:");
		int serviceTime = chosenService.getTime();
		for(int i = startHour ; i<endHour ; i+=serviceTime) {
			hours.add(i);
			System.out.println("Starting hour: "+i);
		}
		
	}*/
//--------------------------------------------helping functions--------------------------------------------//
	public static void main(String[] args) {
		MainSystem mainsystem = new MainSystem();
		
		/*Service service1 = new Service(1, "makeup", 200, 1,2);
		Service service2 = new Service(2, "haircut", 30, 2,1);
		Service service3 = new Service(3, "hair coloring", 250, 3,3);
		Service service4 = new Service(4, "bride pacakge", 1000, 4,8);
		Service service5 = new Service(5, "nails", 120, 5,2);
		
		mainsystem.getServices().add(service1);
		mainsystem.getServices().add(service2);
		mainsystem.getServices().add(service3);
		mainsystem.getServices().add(service4);
		mainsystem.getServices().add(service5);
		
		Employee employee1 = new Employee (1, "Falak", "Falak1234", "Falak@gmail.com");
		Employee employee2 = new Employee (2, "Alma", "Alma1234", "Alma@gmail.com");
		Employee employee3 = new Employee (3, "Kareem", "Kareem1234", "Kareem@gmail.com");
		Employee employee4 = new Employee (4, "Tareq", "Tareq1234", "Tareq@gmail.com");
		Employee employee5 = new Employee (5, "Samar", "Samar1234", "Samar@gmail.com");
		
		
		mainsystem.getEmployees().add(employee1);
		mainsystem.getEmployees().add(employee2);
		mainsystem.getEmployees().add(employee3);
		mainsystem.getEmployees().add(employee4);
		mainsystem.getEmployees().add(employee5);*/
		
		Customer customer = new Customer ("1", "saba", "saba2007","saba2007@gmail.com",598667006);
		//Appointment appointment = customer.addAnAppointment(mainsystem);
		//mainsystem.getSystemAppointments().add(appointment);
		//System.out.println("Appointment added to the system successfully!");

		
	}
		


}
