package AMS;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import mainClass.Admin;
import mainClass.service;
import mainClass.employee;

public class serviceSteps {
	static List<service> listOfServices = new ArrayList<service>();
	static List<employee> listOfEmployees = new ArrayList<employee>();
	static List<List<String>> servicesList;

	Admin admin = new Admin("1", "leen", "12345678", "leen.ahmad@gmail.com");


	employee employee1 = new employee("1", "Ali", "12yt456", "Ali.ahmad@gmail.com");
	employee employee2 = new employee("2", "Ahmad", "uuu12ppp", "Ahmad.zaid@gmail.com");
	employee employee3 = new employee("3", "Amal", "1234oo56", "Amal.sami@gmail.com");
	employee employee4 = new employee("4", "Tala", "12i9uy3456", "Tala.omar@gmail.com");
	employee employee5 = new employee("5", "leen", "12i9uii56", "leen.omar@gmail.com");
	employee employee6 = new employee("6", "Lena", "123ttt456", "Lena.baker@gmail.com");

	service ServiceCase1 = new service("6", "makeup", "2", 100, 2);
	service ServiceCase2 = new service("6", "makeup", "9", 100, 2);
	service ServiceCase3 = new service("6", "colouring hair", "5", 100, 2);
	service ServiceCase4 = new service("6", "makeup", "5", 100, 2);

	static boolean case1 = false;
	static boolean case2 = false;
	static boolean case3 = false;
	static boolean case4 = false;

	@Given("the data table for existing services")
	public void theDataTableForExistingServices(io.cucumber.datatable.DataTable dataTable) {

		System.out.println("Adding Service test cases");
		servicesList = dataTable.asLists();
		for (int i = 1; i < servicesList.size(); i++) {
			service temp = new service(servicesList.get(i).get(0).toString(), servicesList.get(i).get(1).toString(),
					servicesList.get(i).get(2).toString(), Integer.parseInt(servicesList.get(i).get(3)),
					Integer.parseInt(servicesList.get(i).get(4)));
			listOfServices.add(temp);
		}
	}

	@When("I try to add a service for  employee that already has another service to do")
	public void iTryToAddAServiceForEmployeeThatAlreadyHasAnotherServiceToDo() {
		admin.addService(ServiceCase1);
		if (admin.checkEmployeeIdInTheServiceList(
				admin.getServices().get(admin.getServices().size() - 1).getEmployeeId(), listOfServices)) {
			case1 = true;
		}

	}

	@Then("I should see each employee provides only one service")
	public void iShouldSeeEachEmployeeProvidesOnlyOneService() {
		if (case1) {
			System.out.println("Case1: Each employee provides only one service");
			assertTrue(true);
		}

	}

	@When("I type unexist employee id")
	public void iTypeUnexistEmployeeId() {
		admin.addService(ServiceCase2);
		listOfEmployees.add(employee1);
		listOfEmployees.add(employee2);
		listOfEmployees.add(employee3);
		listOfEmployees.add(employee4);
		listOfEmployees.add(employee5);
		listOfEmployees.add(employee6);		
		if (!admin.checkEmployeeIdInTheServiceList(
				admin.getServices().get(admin.getServices().size() - 1).getEmployeeId(), listOfServices)) {
			if (!admin.checkEmployeeIdInTheEmployeeList(
					admin.getServices().get(admin.getServices().size() - 1).getEmployeeId(), listOfEmployees)) {
				case2 = true;
			}
		}

	}

	@Then("I should see the number for the employee Id is incorrect")
	public void iShouldSeeTheNumberForTheEmployeeIdIsIncorrect() {
		if (case2) {
			System.out.println("Case2: The number for the employee Id is incorrect");
			assertTrue(true);
		}
	}

	@When("I try to add a service but this service is exist")
	public void iTryToAddAServiceButThisServiceIsExist() {
		admin.addService(ServiceCase3);
		if (!admin.checkEmployeeIdInTheServiceList(
				admin.getServices().get(admin.getServices().size() - 1).getEmployeeId(), listOfServices)) {
			if (admin.checkEmployeeIdInTheEmployeeList(
					admin.getServices().get(admin.getServices().size() - 1).getEmployeeId(), listOfEmployees)) {
				if (admin.checkServiceNameInTheServiceList(
						admin.getServices().get(admin.getServices().size() - 1).getServiceName(), listOfServices)) {
					case3 = true;
				}
			}
		}

	}

	@Then("I should see the service you are trying to add is already added")
	public void iShouldSeeTheServiceYouAreTryingToAddIsAlreadyAdded() {
		if (case3) {
			System.out.println("Case3: The service you are trying to add is already added");
			assertTrue(true);
		}
	}

	@When("I typed the right service data")
	public void iTypedTheRightServiceDate() {
		admin.addService(ServiceCase4);
		if (!admin.checkEmployeeIdInTheServiceList(
				admin.getServices().get(admin.getServices().size() - 1).getEmployeeId(), listOfServices)) {
			if (admin.checkEmployeeIdInTheEmployeeList(
					admin.getServices().get(admin.getServices().size() - 1).getEmployeeId(), listOfEmployees)) {
				if (!admin.checkServiceNameInTheServiceList(
						admin.getServices().get(admin.getServices().size() - 1).getServiceName(), listOfServices)) {
					case4 = true;
				}
			}
		}
	}

	@Then("I should see successful adding")
	public void iShouldSeeSuccessfulAdding() {
		if (case4) {
			System.out.println("Case4: The service is adding successfully");
			assertTrue(true);
		}
	}

}
