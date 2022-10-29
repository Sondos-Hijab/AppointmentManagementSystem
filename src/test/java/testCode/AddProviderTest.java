package testCode;

import java.util.ArrayList;
import java.util.List;
import io.cucumber.java.en.*;
import mainCode.Providers;
import static org.junit.Assert.*;
import mainCode.Admin;
public class AddProviderTest {
	static int addF=0;
	Providers provider=new Providers("1","sephora");
	List <Providers> provider1 = new ArrayList <Providers>();
	Providers provider2=new Providers();
	Admin admin= new Admin();
	@When("Admin enters wrong id for provider")
	public void adminEntersWrongIdForProvider() {
		provider1.add(provider);
	    String id="1";
	 if(!admin.addProvider(id, provider1)) {
		 addF=1;
	 }
	}
	@Then("Admin should see wrong id")
	public void adminShouldSeeWrongId() {
	   if(addF==1) {
		   assertTrue(addF==1);
		   System.out.println(" Provider is already added");
	   }
	}
	
	@When("Admin enters correct id for provider")
	public void adminEntersCorrectIdForProvider() {
		String id="2";
		provider1.add(provider);
		 if(!admin.addProvider(id, provider1)) {
			 provider2.setId(id);
			 provider2.setname("NYX");
			 addF=0;
		 }
		
		
	}
	@Then("Admin should see Provider added successfully")
	public void adminShouldSeeProviderAddedSuccessfully() {
		if(addF==0) {
			   assertTrue(addF==0);
			   System.out.println(" Provider added successfully");
		   }
	}





}
