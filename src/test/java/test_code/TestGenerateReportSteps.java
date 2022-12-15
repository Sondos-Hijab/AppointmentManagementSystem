package test_code;

import static org.junit.Assert.*;

import java.util.logging.Logger;

import org.junit.Test;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import main_code.Admin;
import main_code.Appointment;
import main_code.Customer;
import main_code.Employee;
import main_code.MainSystem;
import main_code.Service;
import main_code.Visit;

public class TestGenerateReportSteps {


	boolean scenario1 = false, scenario2 = false, scenario3 = false, scenario4 = false, scenario5 = false, scenario6 = false;
	
	MainSystem mainsystem = new MainSystem();
		
	Service service1 = new Service("1", "makeup","1", 200, 2);
	Service service2 = new Service("2", "haircut","2", 30, 1);
	Service service3 = new Service("3", "hair coloring","3", 250, 3);
	Service service4 = new Service("4", "bride pacakge","4", 1000, 8);
	Service service5 = new Service("5", "nails","5", 120, 2);
	
	
	Employee employee1 = new Employee ("1", "Falak", "Falak1234", "Falak@gmail.com");
	Employee employee2 = new Employee ("2", "Alma", "Alma1234", "Alma@gmail.com");
	Employee employee3 = new Employee ("3", "Kareem", "Kareem1234", "Kareem@gmail.com");
	Employee employee4 = new Employee ("4", "Tareq", "Tareq1234", "Tareq@gmail.com");
	Employee employee5 = new Employee ("5", "Samar", "Samar1234", "Samar@gmail.com");
	
	Customer customer1 = new Customer ("1", "aseel", "aseel1234","aseel@gmail.com",8563);	
	Customer customer2 = new Customer ("2", "sajid", "sajid1234","sajid@gmail.com",4152);	
	Customer customer3 = new Customer ("3", "raghad", "raghad1234","raghad@gmail.com",1452);	
	Customer customer4 = new Customer ("4", "sondos", "sondos1234","sondos@gmail.com",1025);	
	Customer customer5 = new Customer ("5", "sama", "sama1234","sama@gmail.com",8596);	
	
	
	Appointment appointment1 = new Appointment ("1","1",service1,12, 2022, 11, 5);
	Appointment appointment2 = new Appointment ("2","1",service2,10, 2022, 10, 30);
	Appointment appointment3 = new Appointment ("3","1",service3,9, 2023, 10, 26);
	
	Visit visit1 = new Visit(appointment1, "good service!");
	Visit visit2 = new Visit(appointment2, "The Perfect center ever!");
	Visit visit3 = new Visit(appointment3, "Wow! My hair looks so good! please keep up the great work!");
	
	public void prepareMainSystem () {
		mainsystem.addEmployee(employee1);
		mainsystem.addEmployee(employee2);
		mainsystem.addEmployee(employee3);
		mainsystem.addEmployee(employee4);
		mainsystem.addEmployee(employee5);
		
		mainsystem.addCustomer(customer1);
		mainsystem.addCustomer(customer2);
		mainsystem.addCustomer(customer3);
		mainsystem.addCustomer(customer4);
		mainsystem.addCustomer(customer5);
		
		mainsystem.addService(service1);
		mainsystem.addService(service2);
		mainsystem.addService(service3);
		mainsystem.addService(service4);
		mainsystem.addService(service5);
		
		mainsystem.addAppointment(appointment1);
		mainsystem.addAppointment(appointment2);
		mainsystem.addAppointment(appointment3);
		
		mainsystem.addVisit(visit1);
		mainsystem.addVisit(visit2);
		mainsystem.addVisit(visit3);
	}
	
	@When("Admin asks to generate a report about the customers")
	public void adminAsksToGenerateAReportAboutTheCustomers() {
		prepareMainSystem();
		scenario1 = Admin.generateCustomersReport(mainsystem);
	}
	
	@Test
	@Then("The system will generate a report about the customers")
	public void theSystemWillGenerateAReportAboutTheCustomers() {
	    assertTrue(scenario1);
	}

	@When("Admin asks to generate a report about the employees")
	public void adminAsksToGenerateAReportAboutTheEmployees() {
		prepareMainSystem();
		scenario2 = Admin.generateEmployeesReport(mainsystem);
	}
	
	@Test
	@Then("The system will generate a report about the employees")
	public void theSystemWillGenerateAReportAboutTheEmployees() {
		assertTrue(scenario2);
	}

	@When("Admin asks to generate a report about the appointments")
	public void adminAsksToGenerateAReportAboutTheAppointments() {
		prepareMainSystem();
		scenario3 = Admin.generateAppointmentsReport(mainsystem);
	}
	
	@Test
	@Then("The system will generate a report about the appointments")
	public void theSystemWillGenerateAReportAboutTheAppointments() {
		assertTrue(scenario3);
	}
	
	@When("Admin asks to generate a report about the visits")
	public void adminAsksToGenerateAReportAboutTheVisits() {
		prepareMainSystem();
		scenario4 = Admin.generateVisitsReport(mainsystem);
	}
	
	@Test
	@Then("The system will generate a report about the visits")
	public void theSystemWillGenerateAReportAboutTheVisits() {
		assertTrue(scenario4);
	}
	

	@When("Admin asks to generate a report about the services")
	public void adminAsksToGenerateAReportAboutTheServices() {
		prepareMainSystem();
		scenario5 = Admin.generateServicesReport(mainsystem);
	}
	
	@Test
	@Then("The system will generate a report about the services")
	public void theSystemWillGenerateAReportAboutTheServices() {
		assertTrue(scenario5);
	}
	
	@When("Admin asks to generate a general report")
	public void adminAsksToGenerateAGeneralReport() {
		prepareMainSystem();
		scenario6 = Admin.generateGeneralReport(mainsystem);
	}
	
	@Test
	@Then("The system will generate a general report")
	public void theSystemWillGenerateAGeneralReport() {
		assertTrue(scenario6);
	}
}
