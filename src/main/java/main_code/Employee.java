package main_code;

import java.time.LocalDate;
import java.util.logging.Logger;




	public class Employee extends User {
		private static final Logger logger = Logger.getLogger(Employee.class.getName());

		public Employee (String userId, String username, String password, String email){
			super(userId, username, password, email);
			
		}
		public Employee(String username, String password) {
			super( username, password);

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


			
			if (!flagCustomerUsername || !flagAppointmentId) 
				{
				logger.info("The customer username or the appointment id or both are wrong!");
				return false;
				}
			if((appointment.getYear() != currentYear) || (appointment.getMonth() != currentMonth) || (appointment.getDay() != currentDay)) {
				logger.info("The appointment date isn't today!");
				return false;
			}
			else {
				Visit visit = new Visit(appointment, feedback);
				customer.getVisits().add(visit);
				logger.info("Visit added successfully!");
				return true;
			}
		}


	}
