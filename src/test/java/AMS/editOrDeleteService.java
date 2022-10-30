package AMS;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import mainClass.Admin;
import mainClass.service;

public class editOrDeleteService {

	static List<service> listOfServices = new ArrayList<service>();
	static List<List<String>> servicesList;

	Admin admin = new Admin("1", "leen", "12345678", "leen.ahmad@gmail.com");

	service ServiceCase1 = new service("9", "colouring hair", "2", 100, 2);
	service ServiceCase2 = new service("1", "colouring hair", "2", 100, 2);
	service ServiceCase3 = new service("5", "bride", "3", 4000, 8);

	static boolean case1 = false;
	static boolean case2 = false;
	static boolean case3 = false;
	
	static boolean edit = false;
	static boolean delete = false;

	static int newPrice = 5000;

	@Given("The data table for existing Services")
	public void theDataTableForExistingServices(io.cucumber.datatable.DataTable dataTable) {
		System.out.println("Deleting or Editing Service test cases");
		servicesList = dataTable.asLists();
		for (int i = 1; i < servicesList.size(); i++) {
			service temp = new service(servicesList.get(i).get(0).toString(), servicesList.get(i).get(1).toString(),
					servicesList.get(i).get(2).toString(), Integer.parseInt(servicesList.get(i).get(3)),
					Integer.parseInt(servicesList.get(i).get(4)));
			listOfServices.add(temp);
		}
	}

	@When("I type unexist service id")
	public void iTypeUnexistServiceId() {
		admin.addService(ServiceCase1);
		if (!admin.checkServiceIdInTheServiceList(
				admin.getServices().get(admin.getServices().size() - 1).getServiceId(), listOfServices)) {
			case1 = true;
		}
	}

	@Then("I should see the number for the service Id is incorrect")
	public void iShouldSeeTheNumberForTheServiceIdIsIncorrect() {
		if (case1) {
			System.out.println("Case1: The number for the service Id is incorrect");
			assertTrue(true);
		}
	}

	@When("I typed the right service id to delete specific service")
	public void iTypedTheRightServiceIdToDeleteSpecificService() {
		admin.addService(ServiceCase2);
		delete = true;
		
		if (admin.checkServiceIdInTheServiceList(admin.getServices().get(admin.getServices().size() - 1).getServiceId(),
				listOfServices) && delete) {
			case2 = true;
			admin.deleteServiceFromTheServiceList(
					admin.getServices().get(admin.getServices().size() - 1).getServiceId(), listOfServices);

		}
	
	}

	@When("I typed the right service id to edit specific service")
	public void iTypedTheRightServiceIdToEditSpecificService() {
		admin.addService(ServiceCase3);
		edit = true;
		if (admin.checkServiceIdInTheServiceList(admin.getServices().get(admin.getServices().size() - 1).getServiceId(),
				listOfServices) && edit) {
			case3 = true;
			admin.changeServicePrice(admin.getServices().get(admin.getServices().size() - 1).getServiceId(),
					listOfServices, newPrice);

		}
	
	}

	@Then("I should see successful deleting")
	public void iShouldSeeSuccessfulDeleting() {
		if (case2) {
			System.out.println("Case2: Successful deleting");
			assertTrue(true);
		}
	}

	@Then("I should see successful editing")
	public void iShouldSeeSuccessfulEditing() {
		if (case3) {
			System.out.println("Case3: Successful editing");
			assertTrue(true);
		}
	}

}
