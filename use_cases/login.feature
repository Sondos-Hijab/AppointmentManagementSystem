Feature: Login 

	I want to login on Beauty Center Website

Scenario: Wrong password 
	Given the data table for existing Admins 
		|name   | password    |
		|Raghad | 1234ttttt   |
		|Sondos | yyyyhhh12   |
		|Sama   | sffhh1234   |
	And the data table for existing Employees 
		|name   | password    |
		|Ahmad  | 123456789   |
		|Reema  | yyyyhpp12   |
		|Lena   | sffhh12oo   |
	And the data table for existing Customers 
		|name   | password    |
		|Ali    | 111111111   |
		|Reem   | yyyyiiii2   |
		|Zaid   | pppiuy2oo   |
	When I type right username, wrong password  
	Then I should see password is incorrect 
	
Scenario: Wrong password and username 
	When I type wrong username, wrong password 
	Then I should see password and username are incorrect 
	
Scenario: Wrong username 
	When I type wrong username, right password
	Then I should see username is incorrect 
		
Scenario: Login successfully for admin 
	When I type right username, right password and the user type is an admin 
	Then I should see this message Login successful for admin 
	
Scenario: Login successfully for customer 
	When I type right username, right password and the user type is a customer 
	Then I should see this message Login successful for customer 
	
Scenario: Login successfully for employee 
	When I type right username, right password and the user type is an employee 
	Then I should see this message Login successful for employee