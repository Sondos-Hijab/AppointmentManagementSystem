
  package main_code;

import java.util.logging.Logger;

public class Visit { 
	  
	private static final Logger logger = Logger.getLogger(Visit.class.getName());
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
		String s = "Visit feedback --> "+ this.feedback;
		logger.info(s);
		
	}
	
	
	public Appointment getAppointment() {
		return appointment;
	}
	
	
	
	
	public String getFeedback() {
		return feedback;
	}

  
  }

