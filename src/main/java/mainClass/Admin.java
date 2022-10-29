package mainClass;

import java.util.ArrayList;
import java.util.List;

public class Admin extends user{
	List <service> Services = new ArrayList <service>();
	List <Story> stories = new ArrayList <Story>();

	public Admin (String userId, String username, String password, String email){
		super(userId, username, password, email);
		
	}
	public Admin(String username, String password) {
		super( username, password);

	}

	public Admin (){
		super();
		
	}
	public boolean checkEmployeeIdInTheServiceList(String employeeId, List<service> listOfServices) {
		
		for(int i=0; i<listOfServices.size(); i++) 
		{
			if(employeeId.equals(listOfServices.get(i).getEmployeeId()))
				return true;
				
		}
		return false;
		
	}
	public List<service> getServices() {
		return Services;
	}
	
	public void addService(service serviceCase1) {
		Services.add(serviceCase1);
		
	}
	public List<Story> getStory() {
		return stories;
	}
	public void addStory(Story myStory) {
		stories.add(myStory);
		
	}
	public boolean checkServiceNameInTheServiceList(String serviceName, List<service> listOfServices) {
		for(int i=0; i<listOfServices.size(); i++) 
		{
			if(serviceName.equals(listOfServices.get(i).getServiceName()))
				return true;
				
		}
		return false;
	}
	public boolean checkEmployeeIdInTheEmployeeList(String employeeId, List<employee> listOfEmployees) {
		for(int i=0; i<listOfEmployees.size(); i++) 
		{
			if(employeeId.equals(listOfEmployees.get(i).getId()))
				return true;		
		}		
		return false;
	}

}
