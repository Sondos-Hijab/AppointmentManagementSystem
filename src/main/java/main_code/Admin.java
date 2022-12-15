package main_code;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;



public class Admin extends User{
	List <Service> services = new ArrayList <Service>();
	List <Story> stories = new ArrayList <Story>();
	private static final Logger logger = Logger.getLogger(Admin.class.getName());
	
	
	public Admin (String userId, String username, String password, String email){
		super(userId, username, password, email);
		
	}
	public Admin(String username, String password) {
		super( username, password);
		

	}


	public Admin() {
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
		return services;
	}
	
	public void addService(Service serviceCase1) {
		services.add(serviceCase1);
		
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
		
		if(!listOfServices.isEmpty()) {
			for(int i=listOfServices.size()-1; i>=0; i--) 
			{
				if(listOfServices.get(i).getServiceId().equals(serviceId)) {
					listOfServices.remove(i);
				}
	
			}
		}
				
	
}
	
	public static boolean generateCustomersReport(MainSystem mainsystem) {
		logger.info("Customers' Report:");
		for(int i=0;i<mainsystem.getCustomers().size();i++) {
			Customer customer=  mainsystem.getCustomers().get(i);
			logger.info("Customer's id: "+ customer.getId()+" name: "+customer.getUsername() + " email: "+customer.getEmail()+ " phone number: "+customer.getPhoneNumber()+"\n");
		}
		
		return true;
	}

	public static boolean generateEmployeesReport(MainSystem mainsystem) {
		logger.info("Employees' Report:");
		for(int i=0;i<mainsystem.getEmployees().size();i++) {
			Employee employee=  mainsystem.getEmployees().get(i);
			logger.info("Employee's id: "+ employee.getId()+" name: "+employee.getUsername() + " email: "+employee.getEmail()+"\n");
		}
		
		return true;
	}

	public static boolean generateAppointmentsReport(MainSystem mainsystem) {
		logger.info("Appointments' Report:");
		for(int i=0;i<mainsystem.getSystemAppointments().size();i++) {
			Appointment appointment=  mainsystem.getSystemAppointments().get(i);
			logger.info("Appointment's id: "+ appointment.getId()+"customer's id: "+appointment.getCustomerId() + " year: "+appointment.getYear()
			+ " month: "+appointment.getMonth() + " day: "+appointment.getDay() + " starting hour: "+appointment.getStartingHour() + " Service: "+appointment.getService().getServiceName() + "\n");
		}
		
		return true;
	}

	public static boolean generateVisitsReport(MainSystem mainsystem) {
		logger.info("Visits' Report:");
		for(int i=0;i<mainsystem.getVisits().size();i++) {
			Visit visit=  mainsystem.getVisits().get(i);
			logger.info("Visit's (appointment's) id: "+ visit.getAppointment().getId()+" Visit's Feedback id: "+visit.getFeedback()+"\n");
		}
		
		return true;
	}
	
	public static boolean generateServicesReport(MainSystem mainsystem) {
		logger.info("Services' Report:");
		for(int i=0;i<mainsystem.getServices().size();i++) {
			Service service=  mainsystem.getServices().get(i);
			logger.info("Service's id: "+ service.getServiceId()+" Service's title: "+service.getServiceName()
			+" Service's time: "+service.getTime() +" Service's price: "+service.getPrice()+"\n");
		}
		
		return true;
	}

	public static boolean generateGeneralReport(MainSystem mainsystem) {
		logger.info("General Report:");
		String s1 = "Customers' Total Number : " + mainsystem.getCustomers().size();
		logger.info(s1);
		String s2 = "Employees' Total Number : " + mainsystem.getEmployees().size();
		logger.info(s2);
		String s3 = "Appointments' Total Number : " + mainsystem.getSystemAppointments().size();
		logger.info(s3);
		String s4 = "Visits' Total Number : " + mainsystem.getVisits().size();
		logger.info(s4);
		String s5 = "Services' Total Number : " + mainsystem.getServices().size();
		logger.info(s5);
		
		
		return true;
	}
	
	public boolean addProvider(String providerId ,MainSystem main ) {
		
		for(int i=0;i<main.getProvider().size();i++) 
		{
			if(main.getProvider().get(i).getProviderId().equals(providerId)) {
				return true;
			}
		}
		
		return false;
	}

	
	public static boolean deleteCustomerHelper(String id, MainSystem main) {
		for(int i=0;i<main.getCustomers().size();i++) {
			if(main.getCustomers().get(i).getId().equals(id) ) {
				
				return true;
			}
		}
		return false;
	}
	public static boolean deleteCustomer(String id, MainSystem main){
		
	      return deleteCustomerHelper(id, main);
	    }


}
