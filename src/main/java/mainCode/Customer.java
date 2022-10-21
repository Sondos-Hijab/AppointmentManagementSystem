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

