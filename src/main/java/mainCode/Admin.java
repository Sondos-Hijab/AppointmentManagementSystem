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

public boolean addProvider(String ProviderId ,List <Providers> provider ) {
	
	for(int i=0; i<provider.size(); i++) 
	{
		if(ProviderId.equals(provider.get(i).getProviderId())) {
			return true;
		}
	}
	
	return false;
}
}