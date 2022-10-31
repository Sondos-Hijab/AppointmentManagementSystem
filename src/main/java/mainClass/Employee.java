package mainClass;

import java.time.LocalDate;

import mainClass.Appointment;
import mainClass.Customer;
import mainClass.MainSystem;
import mainClass.Visit;

public class Employee extends User {
	
	public Employee (String userId, String username, String password, String email){
		super(userId, username, password, email);
		
	}
	public Employee(String username, String password) {
		super( username, password);

	}
	public Employee (){
		super();
		
	}
	
	public boolean convertAppointmentToVisit(String cuctomerUserName, String appointmentId, String feedback, MainSystem mainsystem) {
		
		
		LocalDate time = java.time.LocalDate.now();
		int currentMonth = time.getMonthValue();
		int currentDay = time.getDayOfMonth();
		int currentYear = time.getYear();
		
		
		boolean flagCustomerUsername = false;
		boolean flagAppointmentId = false;
		
		Customer customer = new Customer ();
		Appointment appointment = new Appointment ();
		
		for(Customer customer1 : mainsystem.getCustomers()) {
			if(cuctomerUserName.equals(customer1.getUsername())) 
			{
				flagCustomerUsername = true;
				customer = customer1;
				break;
			}
		}
		
		for(Appointment appointment1 : customer.getAppointments()) {
			if(appointmentId.equals(appointment1.getId())) 
			{
				appointment = appointment1;
				flagAppointmentId = true;
				break;
			}
		}


		if(!(appointment.getYear() == currentYear) && (appointment.getMonth() == currentMonth) && (appointment.getDay() == currentDay)) {
			System.out.println("The appointment date isn't today!");
			return false;
		}
		if (!flagCustomerUsername || !flagAppointmentId) 
			{
			System.out.println("The customer username or the appointment id or both are wrong!");
			return false;
			}
		else {
			Visit visit = new Visit(appointment, feedback);
			customer.getVisits().add(visit);
			System.out.println("Visit added successfully!");
			return true;
		}
	}


}
