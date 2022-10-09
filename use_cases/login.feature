Feature: Login 

	I want to login into the Beauty Center Application

Scenario: 
	Given I am in a login page 
	And the data table for existing username 
		| 0|name | 
		| 1|raghad | 
		| 2|sondos | 
		| 3|sama |  
		| 4|amal |  
	And the user password table for these users in sequence 
		| 0| password | 
		| 1|123456 | 
		| 2| 123456 | 
		| 3| 123456 | 
		| 4|123456 |  
	When user enters username 
	And user enters password 
	And I check the username and password 
	
Scenario: Login successfully 
	When I type correct username and password 
	Then I should see Welcome to your account 
	
Scenario: Wrong username and password 
	When I type wrong username and password 
	Then I should see username and password are incorrect 
	
Scenario: Wrong username 
	When I type wrong username 
	Then I should see username is incorrect 
	
	
Scenario: Wrong password 
	When I type wrong password 
	Then I should see password is incorrect 
	
