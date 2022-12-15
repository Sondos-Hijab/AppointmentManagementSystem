package main_code;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.regex.Pattern;

import main_code.Customer;


public class Customer extends User {
	private long phoneNumber;
	private static final Logger logger = Logger.getLogger(Customer.class.getName());



	List <Appointment> appointments = new ArrayList <Appointment>();
	List <Visit> visits = new ArrayList <Visit>();

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



	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	 public long getPhoneNumber() {
		return phoneNumber;
	}






	public List<Visit> getVisits() { return visits; }
	 
	  
	 
	 //generating invoice

	public boolean generateAnInvoice() {
		if(this.getAppointments().isEmpty()) {
			logger.info("You don't have any appointments yet, "
					+ "add an appointment first and then ask to generate the invoice");
			return false;
		}
		else {
			int totalPrice = 0;
			for(int i=0;i<this.getAppointments().size();i++) {
				logger.info("Appointment Id: " + this.getAppointments().get(i).getId()
						+ " Price: "+this.getAppointments().get(i).getService().getPrice());
				totalPrice += this.getAppointments().get(i).getService().getPrice();
			}
			String s1 = "Total Price: "+ totalPrice;
			logger.info(s1);
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
		boolean flag;
		if((yearNumber == mainsystem.currentYear) || (yearNumber == (mainsystem.currentYear+1))) flag = false;
		else flag = true;
	    
		return flag;
	}
	
	public boolean checkIfTheEnteredMonthNumberIsWrong(MainSystem mainsystem, int chosenYear, int month) {
		boolean flag;
		if(month>=1 && month<=12) {
			if(chosenYear == mainsystem.currentYear) {
				if(month<mainsystem.currentMonth) flag = true;
				else  flag = false;
			}
			else flag = false;
		}
		else flag = true;
		
		return flag;
	}


	
	public boolean miniHelper (MainSystem mainsystem, int month,int dayNumber, int endday) {
		if(dayNumber <= mainsystem.currentDay) return true;
		else {
			for(int i =mainsystem.currentDay+1;i<=endday;i++) {
				if(i == month)
					return false;
			}
			return true;
		}
	}
	public boolean helper (MainSystem mainsystem, int year, int month,int dayNumber, int endday) {
		if(mainsystem.currentYear == year && mainsystem.currentMonth == month) {
			return miniHelper(mainsystem,   month, dayNumber, endday);
		}
		else {
			for(int i =1;i<=endday;i++) {
				if(i == month)
					return false;
			}
			return true;
		}
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
		
		return helper( mainsystem,  year,  month, dayNumber, endday);
		
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
			logger.info("Chosen Service Number Is Wrong");
			return false;
		}
		
		for(int i=0;i<mainsystem.getServices().size();i++) {
			if(mainsystem.getServices().get(i).getServiceId().equals(chosenServiceString)) {
				chosenService = mainsystem.getServices().get(i);
			}
		}
		
        boolean chosenYearNumberIsWrong = checkIfTheEnteredYearNumberIsWrong(chosenYear,mainsystem);
		
		if(chosenYearNumberIsWrong) {
			logger.info("Chosen Year Number Is Wrong");
			return false;
		}
		
		boolean chosenMonthNumberIsWrong = checkIfTheEnteredMonthNumberIsWrong(mainsystem,chosenYear,chosenMonth);
		
		if(chosenMonthNumberIsWrong) {
			logger.info("Chosen Month Number Is Wrong");
			return false;
		}
		
        boolean chosenDayNumberIsWrong = checkIfTheEnteredDayNumberIsWrong(mainsystem,chosenYear,chosenMonth,chosenDay);
		
		if(chosenDayNumberIsWrong) {
			logger.info("Chosen Day Number Is Wrong");
			return false;
		}
		
		
        boolean chosenHourNumberIsWrong = checkIfTheEnteredHourNumberIsWrong(mainsystem,chosenService,chosenHour);
		
		if(chosenHourNumberIsWrong) {
			logger.info("Chosen Hour Number Is Wrong");
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
			logger.info("Customer has an appointemtnat at the same time");
			return false;
		}
		
		boolean thereIsAConflict = checkIfThereIsAConflict(mainsystem, appointment);
		if(thereIsAConflict) {
			logger.info("There is a conflict");
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
				logger.info("Deleted Successfully!\n");
				return true;
			}
		}
		logger.info("Can't delete, it's either wrong appointment id or you don't have appointments at all!");
		
		return false;
		
		
	}



	public boolean editAppointment(String appointmentId, int startingHour, int year, int month, int day, MainSystem mainsystem) {
		boolean yearFlag = true;
		boolean monthFlag = true;
		boolean dayFlag = true;
		boolean hourFlag = true;

		for(int i=0;i<this.getAppointments().size();i++) {

			Appointment appointment = this.getAppointments().get(i);
			if(appointment.getId().equals(appointmentId)) {
				if(this.checkIfTheEnteredYearNumberIsWrong(year, mainsystem)) {
					yearFlag = false;
				}
				if(this.checkIfTheEnteredMonthNumberIsWrong(mainsystem, year, month)) {
					monthFlag = false;
				}
				if(this.checkIfTheEnteredMonthNumberIsWrong(mainsystem, year, month)) {
					monthFlag = false;
				}
				if(this.checkIfTheEnteredDayNumberIsWrong(mainsystem, year, month, day)) {
					dayFlag = false;
				}
				Service service = new Service();
				//chosen service
				for(int j=0;j<mainsystem.getServices().size();j++) {
					if(mainsystem.getServices().get(j).getServiceId().equals(appointment.getService().getServiceId())) {
						service = mainsystem.getServices().get(j);
					}
				}
				if(this.checkIfTheEnteredHourNumberIsWrong(mainsystem, service, startingHour)) {
					hourFlag = false;
				}
				
				if(yearFlag && monthFlag && dayFlag && hourFlag) {
					appointment.setYear(year);
					appointment.setMonth(month);
					appointment.setDay(day);
					appointment.setStartingHour(startingHour);
					logger.info("edited Successfully!\n");
					return true;
				}
			}
			
			if(!yearFlag || !monthFlag || !dayFlag || !hourFlag) {
				break;
			}
			
			
		}
		
		if(!yearFlag) {
			logger.info("Wrong year number!");
		}
		if(!monthFlag) {
			logger.info("Wrong month number!");
		}
		if(!dayFlag) {
			logger.info("Wrong day number!");
		}
		if(!hourFlag) {
			logger.info("Wrong starting hour number!");
		}
		
		if(!yearFlag || !monthFlag || !dayFlag || !hourFlag) {
		   return false;
		}

		else {
			logger.info("Wrong appointment id! can't edit");
			return false;
		}
		
	}

	 public static boolean isValidEmail(String email)
	    {
		    String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
	                              
	        Pattern pat = Pattern.compile(emailRegex);
	        return pat.matcher(email).matches();
	    }
	 
	 public static boolean isValidPassword(String password)
	    {
		 boolean flag;
	      int digitsCount=0;
	      String inputPassword= password;
	      int passLength=inputPassword.length();
	      for(int i=0 ; i< passLength ; i++) {
	    	  char c= inputPassword.charAt(i);
	    	  if (Character.isDigit(c))
	    		  digitsCount++;
	      }
	      if (digitsCount>0 && passLength >=8) 
	    	  flag =  true;
	      else
	    	  flag = false;
	      
	      return flag;
	    }
	 
	 
	 public static boolean usernameIsUsedHelper (String username,MainSystem main) {
		 for(int i=0;i<main.getCustomers().size();i++) {
				if(main.getCustomers().get(i).getUsername().equals(username)) {
					
					return true;
				}
			}
			return false;
	 }
	 public static boolean usernameIsUsed(String username,MainSystem main){
		 return usernameIsUsedHelper(username, main);
	    }
	 
	 
	 
	 public static boolean emailIsUsedHelper(String email,MainSystem main) {
		 for(int i=0;i<main.getCustomers().size();i++) {
				if(main.getCustomers().get(i).getEmail().equals(email)) {
					
					return true;
				}
			}
			return false;
	 }
	 public static boolean emailIsUsed(String email,MainSystem main){
		 return emailIsUsedHelper(email, main);
		      
		    }
	 


	public static boolean validPassword(String pass, MainSystem main) {
		for(int i=0;i<main.getCustomers().size();i++) {
			if(main.getCustomers().get(i).getPassword().equals(pass) ) {
				
				return true;
			}
		}
		return false;
	}
   



}

