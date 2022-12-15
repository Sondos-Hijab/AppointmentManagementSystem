package testCode;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import mainCode.Admin;
import mainCode.Service;
import mainCode.Employee;

public class serviceSteps {
	static List<Service> listOfServices = new ArrayList<Service>();
	static List<Employee> listOfEmployees = new ArrayList<Employee>();
	static List<List<String>> servicesList;

	Admin admin = new Admin("1", "leen", "12345678", "leen.ahmad@gmail.com");


	Employee employee1 = new Employee("1", "Ali", "12yt456", "Ali.ahmad@gmail.com");
	Employee employee2 = new Employee("2", "Ahmad", "uuu12ppp", "Ahmad.zaid@gmail.com");
	Employee employee3 = new Employee("3", "Amal", "1234oo56", "Amal.sami@gmail.com");
	Employee employee4 = new Employee("4", "Tala", "12i9uy3456", "Tala.omar@gmail.com");
	Employee employee5 = new Employee("5", "leen", "12i9uii56", "leen.omar@gmail.com");
	Employee employee6 = new Employee("6", "Lena", "123ttt456", "Lena.baker@gmail.com");

	Service ServiceCase1 = new Service("6", "makeup", "2", 100, 2);
	Service ServiceCase2 = new Service("6", "makeup", "9", 100, 2);
	Service ServiceCase3 = new Service("6", "colouring hair", "5", 100, 2);
	Service ServiceCase4 = new Service("6", "makeup", "5", 100, 2);

	static boolean case1 = false;
	static boolean case2 = false;
	static boolean case3 = false;
	static boolean case4 = false;

	@Given("the data table for existing services")
	public void theDataTableForExistingServices(io.cucumber.datatable.DataTable dataTable) {

		System.out.println("Adding Service test cases");
		servicesList = dataTable.asLists();
		for (int i = 1; i < servicesList.size(); i++) {
			Service temp = new Service(servicesList.get(i).get(0).toString(), servicesList.get(i).get(1).toString(),
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
	
	@Test
	@Then("I should see each employee provides only one service")
	public void iShouldSeeEachEmployeeProvidesOnlyOneService() {
		if (case1) {
			System.out.println("Case1: Each Employee provides only one Service");
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
	
	@Test
	@Then("I should see the number for the employee Id is incorrect")
	public void iShouldSeeTheNumberForTheEmployeeIdIsIncorrect() {
		if (case2) {
			System.out.println("Case2: The number for the Employee Id is incorrect");
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
	
	@Test
	@Then("I should see the service you are trying to add is already added")
	public void iShouldSeeTheServiceYouAreTryingToAddIsAlreadyAdded() {
		if (case3) {
			System.out.println("Case3: The Service you are trying to add is already added");
			assertTrue(true);
		}
	}




	@When("I typed the right service data")
	public void iTypedTheRightServiceData() {
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



	@Test
	@Then("I should see successful adding service")
	public void iShouldSeeSuccessfulAddingService() {
		if (case4) {
			System.out.println("Case4: The Service is adding successfully");
			assertTrue(true);
		}
	}




}