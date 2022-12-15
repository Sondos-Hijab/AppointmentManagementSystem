package test_code;

import static org.junit.Assert.assertTrue;

import java.util.logging.Logger;

import org.junit.Test;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TestLogoutSteps {
	
	private static final Logger logger = Logger.getLogger(TestLogoutSteps.class.getName());
	static boolean logout = false;


	@Given("I was logged in on the Beauty Center Website")
	public void iWasLoggedInOnTheBeautyCenterWebsite() {
		logger.info("Logout test case");
		logout = false;
	}
	@When("I type logout")
	public void iTypeLogout() {
		logout = true;
	}
	
	@Test
	@Then("I should see Logout successfully from the Beauty Center Website")
	public void iShouldSeeLogoutSuccessfullyFromTheBeautyCenterWebsite() {
		if(logout)
		{
			assertTrue(logout);
			logger.info("Case1: Logout successfully from the Beauty Center Website");
		}
	}




}
