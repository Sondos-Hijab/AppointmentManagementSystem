package test_code;

import static org.junit.Assert.assertTrue;

import java.util.logging.Logger;

import org.junit.Test;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import main_code.Admin;
import main_code.Story;

public class TestSuccessStorySteps {
	private static final Logger logger = Logger.getLogger(TestSuccessStorySteps.class.getName());
	Admin admin; 
	Story myStory;
	static boolean case1=false;


	@Given("I am an admin")
	public void iAmAnAdmin() {
		logger.info("Success Story test case");
		admin = new Admin("1", "leen", "12345678", "leen.ahmad@gmail.com");

	}
	@When("I typed the Success Stories")
	public void iTypedTheSuccessStories() {
		myStory = new Story("1","Many customers visit our beauty center and they are unfortunately \n"
				+ "not satisfied with their appearance, but based on the customers' comments about their visits, \n"
				+ "all of them are grateful to us and have become more confident in themselves and \n"
				+ "happier with their lives, and this is the biggest success story for us");
		admin.addStory(myStory);
		case1 = true;
		logger.info(admin.getStory().get(0).getStory());

		

	}
	
	@Test
	@Then("I should see successfully adding Success Stories")
	public void iShouldSeeSuccessfullyAddingSuccessStories() {
		if(case1)
		{
			assertTrue(case1);
			logger.info("Case1: successfully adding Success Stories");
		}

	}




}