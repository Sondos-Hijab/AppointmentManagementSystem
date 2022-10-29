Feature: Adding Service 

	Each employee can provide only one service and the service cannot be repeated

Scenario: Another service for the same employee 
	Given the data table for existing services 
		|serviceId|serviceName   |employeeId|price|time|
		|1        |colouring hair|2         |100  |2   |
		|2        |cutting hair  |1         |30   |1   |
		|3        |skin care     |4         |100  |2   |
		|4        |nail care     |6         |100  |1   |
		|5        |bride         |3         |4000 |8   |
	When I try to add a service for  employee that already has another service to do 
	Then I should see each employee provides only one service 
	
Scenario: Wrong number for the employee Id 
	When I type unexist employee id 
	Then I should see the number for the employee Id is incorrect 
	
Scenario: Duplicate in the name of the service (the service you are trying to add is already added) 
	When I try to add a service but this service is exist 
	Then I should see the service you are trying to add is already added 
	 	
Scenario: Successful adding 
	When I typed the right service data 
	Then I should see successful adding 