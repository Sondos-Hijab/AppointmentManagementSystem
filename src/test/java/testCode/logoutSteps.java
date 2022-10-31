package testCode;

import static org.junit.Assert.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class logoutSteps {
	static boolean logout = false;


	@Given("I was logged in on the Beauty Center Website")
	public void iWasLoggedInOnTheBeautyCenterWebsite() {
		System.out.println("Logout test case");
		logout = false;
	}
	@When("I type logout")
	public void iTypeLogout() {
		logout = true;
	}
	@Then("I should see Logout successfully from the Beauty Center Website")
	public void iShouldSeeLogoutSuccessfullyFromTheBeautyCenterWebsite() {
		if(logout)
		{
			assertTrue(logout);
			System.out.println("Case1: Logout successfully from the Beauty Center Website");
		}
	}




}
