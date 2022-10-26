package mainCode;

import java.time.LocalDate;

public class Employee extends User {
	
	
	//constructors

	public Employee (int id, String username, String password, String email){
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
	}
	public boolean convertAppointmentToVisit(String cuctomerUserName, int appointmentId, String feedback, MainSystem mainsystem) {
		int i = 0;
		
		
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
			if(appointmentId == appointment1.getId()) 
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