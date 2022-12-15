
  package main_code;
  
  public class Visit { 
	  
	private Appointment appointment; 
	private String feedback;
  
  public Visit(Appointment appointment, String feedback) 
	  { 
	  this.appointment =appointment; 
	  this.feedback = feedback; 
	  } 
  

  
  public Visit() {
  super(); 
  } 
  

	public void printVisit() {
		System.out.println("Visit feedback --> "+ this.feedback);
		
	}
	
	
	public Appointment getAppointment() {
		return appointment;
	}
	
	
	
	
	public String getFeedback() {
		return feedback;
	}

  
  }

