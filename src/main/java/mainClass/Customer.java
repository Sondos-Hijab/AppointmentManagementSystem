package mainClass;

import java.util.ArrayList;
import java.util.List;

import mainClass.Appointment;
import mainClass.Customer;
import mainClass.MainSystem;
import mainClass.Service;
import mainClass.Visit;

public class Customer extends User {
	private long phoneNumber;
	List <Appointment> appointments = new ArrayList <Appointment>();
	List <Visit> visits = new ArrayList <Visit>();

	public Customer (String userId, String username, String password, String email){
		super(userId, username, password, email);
		
	}
	public Customer(String username, String password) {
		super( username, password);

	}
	public Customer (){
		super();
		
	}
	
	public Customer(String userId, String username, String password, String email,long phoneNumber) {
		super(userId, username, password, email);
		this.phoneNumber = phoneNumber;
	}
	

	
	public List<Appointment> getAppointments() {
		return appointments;
	}




	 public long getPhoneNumber() {
		return phoneNumber;
	}






	public List<Visit> getVisits() { return visits; }
	 
	  
	 
	 //generating invoice

	public boolean generateAnInvoice() {
		if(this.getAppointments().size() == 0) {
			System.out.println("You don't have any appointments yet, "
					+ "add an appointment first and then ask to generate the invoice");
			return false;
		}
		else {
			int totalPrice = 0;
			for(int i=0;i<this.getAppointments().size();i++) {
				System.out.println("Appointment Id: " + this.getAppointments().get(i).getId()
						+ " Price: "+this.getAppointments().get(i).getService().getPrice());
				totalPrice += this.getAppointments().get(i).getService().getPrice();
			}
			System.out.println("Total Price: "+ totalPrice);
			return true;
		}
		
	}
	

	 

	public boolean checkIfTheEnteredServiceNumberIsWrong(MainSystem mainSys, String chosenServiceString) {
		for(int i=0;i<mainSys.getServices().size();i++) {
			if(mainSys.getServices().get(i).getServiceId().equals(chosenServiceString)) {
				return false;
			}
		}
		return true;
	}
	
	public boolean checkIfTheEnteredYearNumberIsWrong(int yearNumber, MainSystem mainsystem) {
		if(yearNumber == mainsystem.currentYear || yearNumber == mainsystem.currentYear+1) return false;
		else return true;
	}
	
	public boolean checkIfTheEnteredMonthNumberIsWrong(MainSystem mainsystem, int chosenYear, int month) {
		if(month>=1 && month<=12) {
			if(chosenYear == mainsystem.currentYear) {
				if(month<mainsystem.currentMonth) return true;
				else  return false;
			}
			else return false;
		}
		else return true;
	}

	public boolean checkIfTheEnteredDayNumberIsWrong(MainSystem mainsystem, int year, int month,int dayNumber) {
		int endday = 0;
		if(month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
			endday = 31;
		}
		else if(month == 2) endday=29;
		else {
			endday = 30;
		}
		
		
		if(mainsystem.currentYear == year && mainsystem.currentMonth == month) {
			if(dayNumber <= mainsystem.currentDay) return true;
			else {
				for(int i =mainsystem.currentDay+1;i<=endday;i++) {
					if(i == month)
						return false;
				}
				return true;
			}
		}
		else {
			for(int i =1;i<=endday;i++) {
				if(i == month)
					return false;
			}
			return true;
		}
	}
	
	private boolean checkIfTheEnteredHourNumberIsWrong(MainSystem mainsystem, Service chosenService, int chosenHour) {
		for(int i=mainsystem.startHour ; i<mainsystem.endHour; i+=chosenService.getTime()) {
			if(chosenHour == i) return false;
		}
		return true;
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
	
	
	public boolean checkIfThereIsAConflict(MainSystem mainsystem, Appointment appointment) {
		for(int i=0;i<mainsystem.getSystemAppointments().size();i++) {
			if(mainsystem.getSystemAppointments().get(i).getYear() == appointment.getYear() && 
			mainsystem.getSystemAppointments().get(i).getMonth() == appointment.getMonth() &&
			mainsystem.getSystemAppointments().get(i).getDay() == appointment.getDay() &&
			mainsystem.getSystemAppointments().get(i).getStartingHour() == appointment.getStartingHour() &&
			mainsystem.getSystemAppointments().get(i).getService() == appointment.getService() 
					)
				return true;
		}
		return false;
	}
	
	
	public boolean bookAppointment(MainSystem mainsystem, int chosenServiceNumber, int chosenYear, int chosenMonth, int chosenDay,
			int chosenHour) {

		Service chosenService = new Service();
		
		String chosenServiceString = Integer.toString(chosenServiceNumber);
		
		boolean chosenServiceNumberIsWrong = checkIfTheEnteredServiceNumberIsWrong(mainsystem,chosenServiceString);
		
		if(chosenServiceNumberIsWrong) {
			System.out.println("Chosen Service Number Is Wrong");
			return false;
		}
		
		for(int i=0;i<mainsystem.getServices().size();i++) {
			if(mainsystem.getServices().get(i).getServiceId().equals(chosenServiceString)) {
				chosenService = mainsystem.getServices().get(i);
			}
		}
		
        boolean chosenYearNumberIsWrong = checkIfTheEnteredYearNumberIsWrong(chosenYear,mainsystem);
		
		if(chosenYearNumberIsWrong) {
			System.out.println("Chosen Year Number Is Wrong");
			return false;
		}
		
		boolean chosenMonthNumberIsWrong = checkIfTheEnteredMonthNumberIsWrong(mainsystem,chosenYear,chosenMonth);
		
		if(chosenMonthNumberIsWrong) {
			System.out.println("Chosen Month Number Is Wrong");
			return false;
		}
		
        boolean chosenDayNumberIsWrong = checkIfTheEnteredDayNumberIsWrong(mainsystem,chosenYear,chosenMonth,chosenDay);
		
		if(chosenDayNumberIsWrong) {
			System.out.println("Chosen Day Number Is Wrong");
			return false;
		}
		
		
        boolean chosenHourNumberIsWrong = checkIfTheEnteredHourNumberIsWrong(mainsystem,chosenService,chosenHour);
		
		if(chosenHourNumberIsWrong) {
			System.out.println("Chosen Hour Number Is Wrong");
			return false;
		}
		
		Appointment appointment = new Appointment();
		
		appointment.setService(chosenService);
		appointment.setCustomerId(this.getId());
		appointment.setYear(chosenYear);
		appointment.setMonth(chosenMonth);
		appointment.setDay(chosenDay);
		appointment.setStartingHour(chosenHour);
		
		boolean customerHasAnAppointmentAtTheSameTime = checkIfTheCustomerHasAnAppointmentAtTheSameTime(this,appointment);
		
		if (customerHasAnAppointmentAtTheSameTime) {
			System.out.println("Customer has an appointemtnat at the same time");
			return false;
		}
		
		boolean thereIsAConflict = checkIfThereIsAConflict(mainsystem, appointment);
		if(thereIsAConflict) {
			System.out.println("There is a conflict");
			return false;
		}
		
		mainsystem.addAppointment(appointment);
		this.getAppointments().add(appointment);
		return true;
	
	}



	public boolean deleteAppointment(String enteredAppointmentId) {
		for(int i=0;i<this.getAppointments().size();i++) {
			if(this.getAppointments().get(i).getId().equals(enteredAppointmentId)) {
				this.getAppointments().remove(this.getAppointments().get(i));
				System.out.println("Deleted Successfully!\n");
				return true;
			}
		}
		System.out.println("Can't delete, it's either wrong appointment id or you don't have appointments at all!");
		
		return false;
		
		
	}

}
