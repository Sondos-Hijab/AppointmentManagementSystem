package mainCode;


import java.util.ArrayList;
import java.util.List;

public class Admin {
	//List <Providers> provider = new ArrayList <Providers>();
	public Admin() {
		super();
	}
	
	public Admin(String id, String username, String password, String email,long phoneNumber) {
		super();
	
	}

public boolean addProvider(String ProviderId ,MainSystem main ) {
	
	for(int i=0;i<main.getProvider().size();i++) 
	{
		if(main.getProvider().get(i).getProviderId().equals(ProviderId)) {
			return true;
		}
	}
	
	return false;
}


public static boolean DeleteCustomer(String id, MainSystem main){
    {
	 for(int i=0;i<main.getCustomers().size();i++) {
			if(main.getCustomers().get(i).getId().equals(id) ) {
				
				return true;
			}
		}
		return false;
	}
      
    }

}