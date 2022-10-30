package mainCode;

public class Admin extends User{

	public static boolean generateCustomersReport(MainSystem mainsystem) {
		System.out.println("Customers' Report:");
		for(int i=0;i<mainsystem.getCustomers().size();i++) {
			Customer customer=  mainsystem.getCustomers().get(i);
			System.out.println("Customer's id: "+ customer.getId()+" name: "+customer.getUsername() + " email: "+customer.getEmail()+ " phone number: "+customer.getPhoneNumber());
		}
		System.out.println();
		return true;
	}

	public static boolean generateEmployeesReport(MainSystem mainsystem) {
		System.out.println("Employees' Report:");
		for(int i=0;i<mainsystem.getEmployees().size();i++) {
			Employee employee=  mainsystem.getEmployees().get(i);
			System.out.println("Employee's id: "+ employee.getId()+" name: "+employee.getUsername() + " email: "+employee.getEmail());
		}
		System.out.println();
		return true;
	}

	public static boolean generateAppointmentsReport(MainSystem mainsystem) {
		System.out.println("Appointments' Report:");
		for(int i=0;i<mainsystem.getSystemAppointments().size();i++) {
			Appointment appointment=  mainsystem.getSystemAppointments().get(i);
			System.out.println("Appointment's id: "+ appointment.getId()+"customer's id: "+appointment.getCustomerId() + " year: "+appointment.getYear()
			+ " month: "+appointment.getMonth() + " day: "+appointment.getDay() + " starting hour: "+appointment.getStartingHour() + " service: "+appointment.getService().getTitle());
		}
		System.out.println();
		return true;
	}

	public static boolean generateVisitsReport(MainSystem mainsystem) {
		System.out.println("Visits' Report:");
		for(int i=0;i<mainsystem.getVisits().size();i++) {
			Visit visit=  mainsystem.getVisits().get(i);
			System.out.println("Visit's (appointment's) id: "+ visit.getAppointment().getId()+" Visit's Feedback id: "+visit.getFeedback());
		}
		System.out.println();
		return true;
	}
	
	public static boolean generateServicesReport(MainSystem mainsystem) {
		System.out.println("Services' Report:");
		for(int i=0;i<mainsystem.getServices().size();i++) {
			Service service=  mainsystem.getServices().get(i);
			System.out.println("Service's id: "+ service.getId()+" Service's title: "+service.getTitle()
			+" Service's time: "+service.getTime() +" Service's price: "+service.getPrice());
		}
		System.out.println();
		return true;
	}

	public static boolean generateGeneralReport(MainSystem mainsystem) {
		System.out.println("General Report:");
		System.out.println("Customers' Total Number : " + mainsystem.getCustomers().size());
		System.out.println("Employees' Total Number : " + mainsystem.getEmployees().size());
		System.out.println("Appointments' Total Number : " + mainsystem.getSystemAppointments().size());
		System.out.println("Visits' Total Number : " + mainsystem.getVisits().size());
		System.out.println("Services' Total Number : " + mainsystem.getServices().size());
		
		System.out.println("\n\n\n");
		return true;
	}



}
