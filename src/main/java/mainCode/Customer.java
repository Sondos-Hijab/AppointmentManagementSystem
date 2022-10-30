package mainCode;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Customer extends user {
	private long phoneNumber;
	//List <Appointment> appointments = new ArrayList <Appointment>();
	//List <Visit> visits = new ArrayList <Visit>();
	
	

	public Customer() {
		super();
	}
	
	public Customer(int phoneNumber) {
		super();
		this.phoneNumber = phoneNumber;
	}
	
	public Customer(String id, String username, String password, String email,long phoneNumber) {
		super();
		this.id= id;
		this.username = username;
		this.password = password;
		this.email=email;
		this.phoneNumber = phoneNumber;
	}
	
	
	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	 public static boolean isValidEmail(String email)
	    {
	        String emailRegex = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
	                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	                              
	        Pattern pat = Pattern.compile(emailRegex);
	       
	        return pat.matcher(email).matches();
	    }
	 
	 public static boolean isValidPassword(String password)
	    {
	      int digitsCount=0;
	      String Inputpassword= password;;
	      int Passlength=Inputpassword.length();
	      for(int i=0 ; i< Passlength ; i++) {
	    	  char c= Inputpassword.charAt(i);
	    	  if (Character.isDigit(c))
	    		  digitsCount++;
	      }
	      if (digitsCount>0 && Passlength >=8) 
	    	  return true;
	      else
		   return false;
	      
	    }
	 
	 public static boolean UsernameIsUsed(String username,MainSystem main){
	    {
		 for(int i=0;i<main.getCustomers().size();i++) {
				if(main.getCustomers().get(i).getUsername().equals(username)) {
					
					return true;
				}
			}
			return false;
		}
	      
	    }
	 
	 public static boolean EmailIsUsed(String email,MainSystem main){
		    {
			 for(int i=0;i<main.getCustomers().size();i++) {
					if(main.getCustomers().get(i).getEmail().equals(email)) {
						
						return true;
					}
				}
				return false;
			}
		      
		    }
	 
	 /*public static boolean EditPassword(String NewPassword, MainSystem main){
		    {
			 for(int i=0;i<main.getCustomers().size();i++) {
					if( ) {
						
						return true;
					}
				}
				return false;
			}*/


	public static boolean ValidPassword(String pass, MainSystem main) {
		for(int i=0;i<main.getCustomers().size();i++) {
			if(main.getCustomers().get(i).getPassword().equals(pass) ) {
				
				return true;
			}
		}
		return false;
	}
      
	
	 
	
	
	/*public List<Appointment> getAppointments() {
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
	}*/


}

