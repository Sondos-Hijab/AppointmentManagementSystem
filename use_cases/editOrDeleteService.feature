Feature: Deleting or Editing Service 

	The Admins have the ability to delete and edit any service by deciding the id service  for it 
	
Scenario: Wrong number for the service Id 
	Given The data table for existing Services 
		|serviceId|serviceName   |employeeId|price|time|
		|1        |colouring hair|2         |100  |2   |
		|2        |cutting hair  |1         |30   |1   |
		|3        |skin care     |4         |100  |2   |
		|4        |nail care     |6         |100  |1   |
		|5        |bride         |3         |4000 |8   |
	When I type unexist service id number 
	Then I should see this message the number for the service Id is incorrect 
	
Scenario: Successful deleting 
	When I typed the right service id number to delete specific service 
	Then I should see successful deleting 
	
Scenario: Successful editing 
	When I typed the right service id number to edit specific service 
	Then I should see successful editing  