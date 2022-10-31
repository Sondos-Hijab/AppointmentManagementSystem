package mainClass;

import java.util.ArrayList;
import java.util.List;

import mainClass.Appointment;
import mainClass.Customer;
import mainClass.Employee;
import mainClass.MainSystem;
import mainClass.Service;
import mainClass.Visit;

public class Admin extends User{
	List <Service> Services = new ArrayList <Service>();
	List <Story> stories = new ArrayList <Story>();

	public Admin (String userId, String username, String password, String email){
		super(userId, username, password, email);
		
	}
	public Admin(String username, String password) {
		super( username, password);

	}

	public Admin (){
		super();
		
	}
	public boolean checkEmployeeIdInTheServiceList(String employeeId, List<Service> listOfServices) {
		
		for(int i=0; i<listOfServices.size(); i++) 
		{
			if(employeeId.equals(listOfServices.get(i).getEmployeeId()))
				return true;
				
		}
		return false;
		
	}
	public List<Service> getServices() {
		return Services;
	}
	
	public void addService(Service serviceCase1) {
		Services.add(serviceCase1);
		
	}
	public List<Story> getStory() {
		return stories;
	}
	public void addStory(Story myStory) {
		stories.add(myStory);
		
	}
	public boolean checkServiceNameInTheServiceList(String serviceName, List<Service> listOfServices) {
		for(int i=0; i<listOfServices.size(); i++) 
		{
			if(serviceName.equals(listOfServices.get(i).getServiceName()))
				return true;
				
		}
		return false;
	}
	public boolean checkEmployeeIdInTheEmployeeList(String employeeId, List<Employee> listOfEmployees) {
		for(int i=0; i<listOfEmployees.size(); i++) 
		{
			if(employeeId.equals(listOfEmployees.get(i).getId()))
				return true;		
		}		
		return false;
	}
	public boolean checkServiceIdInTheServiceList(String serviceId, List<Service> listOfServices) {
		for(int i=0; i<listOfServices.size(); i++) 
		{
			if(serviceId.equals(listOfServices.get(i).getServiceId()))
				return true;		
		}
		return false;
	}

	public void changeServicePrice(String serviceId, List<Service> listOfServices, int newPrice) {
		for(int i=0; i<listOfServices.size(); i++) 
		{
			if(serviceId.equals(listOfServices.get(i).getServiceId()))
			{
				listOfServices.get(i).setPrice(newPrice);
			}
		}		
	}
	public void deleteServiceFromTheServiceList(String serviceId, List<Service> listOfServices) {
		for(int i=0; i<listOfServices.size(); i++) 
		{
			if(serviceId.equals(listOfServices.get(i).getServiceId()))
			{
				listOfServices.remove(i);
			}
		}		
	}
	public static boolean generateCustomersReport(MainSystem mainsystem) {
		System.out.println("Customers' Report:");
		for(int i=0;i<mainsystem.getCustomers().size();i++) {
			Customer customer=  mainsystem.getCustomers().get(i);
			System.out.println("Customer's id: "+ customer.getId()+" name: "+customer.getUsername() + " email: "+customer.getEmail()+ " phone number: "+customer.getPhoneNumber());
		}
		System.out.println();
		return true;
	}

	public static boolean generateEmployeesReport(MainSystem mainsystem) {
		System.out.println("Employees' Report:");
		for(int i=0;i<mainsystem.getEmployees().size();i++) {
			Employee employee=  mainsystem.getEmployees().get(i);
			System.out.println("Employee's id: "+ employee.getId()+" name: "+employee.getUsername() + " email: "+employee.getEmail());
		}
		System.out.println();
		return true;
	}

	public static boolean generateAppointmentsReport(MainSystem mainsystem) {
		System.out.println("Appointments' Report:");
		for(int i=0;i<mainsystem.getSystemAppointments().size();i++) {
			Appointment appointment=  mainsystem.getSystemAppointments().get(i);
			System.out.println("Appointment's id: "+ appointment.getId()+"customer's id: "+appointment.getCustomerId() + " year: "+appointment.getYear()
			+ " month: "+appointment.getMonth() + " day: "+appointment.getDay() + " starting hour: "+appointment.getStartingHour() + " Service: "+appointment.getService().getServiceName());
		}
		System.out.println();
		return true;
	}

	public static boolean generateVisitsReport(MainSystem mainsystem) {
		System.out.println("Visits' Report:");
		for(int i=0;i<mainsystem.getVisits().size();i++) {
			Visit visit=  mainsystem.getVisits().get(i);
			System.out.println("Visit's (appointment's) id: "+ visit.getAppointment().getId()+" Visit's Feedback id: "+visit.getFeedback());
		}
		System.out.println();
		return true;
	}
	
	public static boolean generateServicesReport(MainSystem mainsystem) {
		System.out.println("Services' Report:");
		for(int i=0;i<mainsystem.getServices().size();i++) {
			Service service=  mainsystem.getServices().get(i);
			System.out.println("Service's id: "+ service.getServiceId()+" Service's title: "+service.getServiceName()
			+" Service's time: "+service.getTime() +" Service's price: "+service.getPrice());
		}
		System.out.println();
		return true;
	}

	public static boolean generateGeneralReport(MainSystem mainsystem) {
		System.out.println("General Report:");
		System.out.println("Customers' Total Number : " + mainsystem.getCustomers().size());
		System.out.println("Employees' Total Number : " + mainsystem.getEmployees().size());
		System.out.println("Appointments' Total Number : " + mainsystem.getSystemAppointments().size());
		System.out.println("Visits' Total Number : " + mainsystem.getVisits().size());
		System.out.println("Services' Total Number : " + mainsystem.getServices().size());
		
		System.out.println("\n\n\n");
		return true;
	}


}
