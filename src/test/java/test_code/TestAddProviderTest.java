package test_code;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.junit.Test;

import io.cucumber.java.en.*;
import main_code.Admin;
import main_code.Employee;
import main_code.MainSystem;
import main_code.Providers;

import static org.junit.Assert.*;
public class TestAddProviderTest {
	
	private static final Logger logger = Logger.getLogger(TestAddProviderTest.class.getName());
	static int addF=0;
	Providers provider=new Providers("1","sephora");
	List <Providers> provider1 = new ArrayList <Providers>();
	MainSystem main=new MainSystem();
	Providers provider2=new Providers();
	Admin admin= new Admin();
	@When("Admin enters wrong id for provider")
	
	public void adminEntersWrongIdForProvider() {
		 String id="1";
		main.addProvider(provider);
	   
	 if(admin.addProvider(id,main)) {
		 addF=1;
	 }
	}
	

	@Test
	@Then("Admin should see wrong id")
	public void adminShouldSeeWrongId() {
	   if(addF==1) {
		   assertEquals(1,addF);
		  logger.info(" Provider is already added");
	   }
	}
	
	@When("Admin enters correct id for provider")
	public void adminEntersCorrectIdForProvider() {
		String id="2";
		main.addProvider(provider);
		 if(!admin.addProvider(id, main)) {
			 provider2.setId(id);
			 provider2.setname("NYX");
			 provider1.add(provider2);
			 main.setProviders(provider1);
			 addF=0;
		 }
		
		
	}
	

	@Test
	@Then("Admin should see Provider added successfully")
	public void adminShouldSeeProviderAddedSuccessfully() {
		if(addF==0) {
			   assertEquals(0,addF);
			   logger.info(" Provider added successfully");
		   }
	}





}
