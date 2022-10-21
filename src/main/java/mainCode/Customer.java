package mainCode;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Customer extends User {
	private long phoneNumber;
	List <Appointment> appointments = new ArrayList <Appointment>();
	List <Visit> visits = new ArrayList <Visit>();
	
	
	//constructors
	public Customer() {
		super();
	}
	
	public Customer(int phoneNumber) {
		super();
		this.phoneNumber = phoneNumber;
	}
	
	public Customer(int id, String username, String password, String email,long phoneNumber) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email=email;
		this.phoneNumber = phoneNumber;
	}
	//getters and setters
	
	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public List<Appointment> getAppointments() {
		return appointments;
	}


	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}


	public List<Visit> getVisits() {
		return visits;
	}


	public void setVisits(List<Visit> visits) {
		this.visits = visits;
	}

	public Appointment addAnAppointment (MainSystem mainsystem) {
		Appointment appointment = new Appointment();
		appointment.bookAnAppointment(mainsystem, this);
		this.getAppointments().add(appointment);
		System.out.println("Appointment Booked Successfully!");
		return appointment;
	}


}
/*int serviceNumber;
int yearNumber;
int monthNumber;
int dayNumber;
int appointmentNumber;

Service chosenService;
int serviceTime;

Appointment chosenAppointment;

Scanner sc = new Scanner (System.in);




public int askUserToChooseTheService() {
	System.out.println("Please enter the service number that you want:");
	serviceNumber = 0;
	String s = sc.next();
	if (s.trim() == "") return 0;
	else serviceNumber = Integer.parseInt(s);
	return serviceNumber;
}


public boolean checkIfTheEnteredServiceIsEmpty() {
	if(serviceNumber == 0) return true;
	else return false;
}


public boolean checkIfTheEnteredServiceNumberIsWrong() {
	for(int i=0;i<mainSystem.getServices().size();i++) {
		if(mainSystem.getServices().get(i).getId() == serviceNumber) {
			chosenService = mainSystem.getServices().get(i);
			serviceTime = mainSystem.getServices().get(i).getTime();
			return false;
		}
	}
	return true;
}


public void showErrorMessageServiceNumberIsWrong() {
	System.out.println("Error Message: The Service Number You chose is wrong");
}


public void showErrorMessageServiceNumberIsEmpty() {
	System.out.println("Error Message: Empty Service Number Field");
}





public int askUserToChooseTheYear() {
	System.out.println("Please press 1 for 2022 and 2 for 2023:");
	yearNumber = sc.nextInt();
	return yearNumber;
}


public boolean checkIfTheEnteredYearNumberIsWrong() {
	if(yearNumber == 1 || yearNumber == 2) return true;
	else return false;
}


public void showErrorMessageYearNumberIsWrong() {
	System.out.println("Error Message: The Year Number You chose is wrong");
	
}





public int askUserToChooseTheMonth() {
	System.out.println("Please press the number of the month:");
	monthNumber = sc.nextInt();
	return monthNumber;
}


public boolean checkIfTheEnteredMonthNumberIsWrong() {
	for(int i=0;i<months.size();i++) {
		if(monthNumber == months.get(i)) return false;
	}
	return true;
}


public void showErrorMessageMonthNumberIsWrong() {
	System.out.println("Error Message: The Month Number You chose is wrong");
}






public int askUserToChooseTheDay() {
	System.out.println("Please press the number of the Day:");
	dayNumber = sc.nextInt();
	return dayNumber;
}

public boolean checkIfTheEnteredDayNumberIsWrong() {
	for(int i=0;i<days.size();i++) {
		if(dayNumber == days.get(i)) return false;
	}
	return true;
}

public void showErrorMessageDayNumberIsWrong() {
	System.out.println("Error Message: The Day Number You chose is wrong");
	
}




public int askUserToChooseTheAppointment() {
	System.out.println("Please press the number of the Appointment:");
	appointmentNumber = sc.nextInt();
	return appointmentNumber;
}


public boolean checkIfTheEnteredAppointmentNumberIsWrong() {
	for(int i=0;i<availableAppointmentsNumbers.size();i++) {
		if(appointmentNumber == availableAppointmentsNumbers.get(i).getId()) 
			{
			chosenAppointment = availableAppointmentsNumbers.get(i);
			chosenAppointment.setYear(yearNumber);
			chosenAppointment.setMonth(monthNumber);
			chosenAppointment.setDay(dayNumber);
			chosenAppointment.setId(mainSystem.getSystemAppointments().size());
			return false;
			}
	}
	return true;
}


public void showErrorMessageAppointmentNumberIsWrong() {
	System.out.println("Error Message: The Appointment Number You chose is wrong");
}


public boolean checkIfTheCustomerHasAnAppointmentAtTheSameTime() {
	for(int i=0;i<this.getAppointments().size();i++) {
		if(this.getAppointments().get(i).getYear() == yearNumber && 
				this.getAppointments().get(i).getMonth() == monthNumber &&
				this.getAppointments().get(i).getDay() == dayNumber &&
				this.getAppointments().get(i).getStartingHour() == chosenAppointment.getStartingHour()
				)
			return true;
	}
	return false;
}


public void showErrorMessageCustomerHasAppointmentAtTheSameTime() {
	System.out.println("Error Message: You have an appointment at the same time");
	
}





public boolean checkIfThereIsAConflict() {
	for(int i=0;i<mainSystem.getSystemAppointments().size();i++) {
		if(mainSystem.getSystemAppointments().get(i).getYear() == chosenAppointment.getYear() && 
				mainSystem.getSystemAppointments().get(i).getMonth() == chosenAppointment.getMonth() &&
				mainSystem.getSystemAppointments().get(i).getDay() == chosenAppointment.getDay() &&
				mainSystem.getSystemAppointments().get(i).getStartingHour() == chosenAppointment.getStartingHour() &&
				mainSystem.getSystemAppointments().get(i).getService() == chosenAppointment.getService() &&
				mainSystem.getSystemAppointments().get(i).getStartingHour() == chosenAppointment.getStartingHour()
				)
			return true;
	}
	return false;
}


public void showErrorMessageThereIsAConflict() {
	System.out.println("Error Message: There is a conflict in the appointments, someone else took this appointment");
}



public Appointment bookAnAppointment() {
	mainSystem.getSystemAppointments().add(chosenAppointment);
	this.getAppointments().add(chosenAppointment);
	return chosenAppointment;
	
}

public void showSuccessMessageForBookingAnAppointement() {
	System.out.println("Success Message: Your Appointment has been booked successfully");
	
}*/

