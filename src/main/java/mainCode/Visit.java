package mainCode;

public class Visit {
	private Appointment appointment;
	private String feedback;
	
	public Visit(Appointment appointment, String feedback) {
		this.appointment = appointment;
		this.feedback = feedback;
	}
	public Visit(Appointment appointment) {
		super();
		this.appointment = appointment;
	}
	public Visit() {
		super();
	}
	public Appointment getAppointment() {
		return appointment;
	}
	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	
}
