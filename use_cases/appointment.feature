Feature: appointment 

	I would like to book an appointment (from 10am to 6pm)

Scenario: Empty field or fields 
	Given the data table for existing appointments 
		|serviceName|employeeId|userId|serviceId|price|time|start_time|end_time|day|month|year|
		|colouring hair|2|3|1|100 |2|10|12|1 |12|2022|
		|cutting hair  |1|2|2|30  |1|11|12|14|12|2022|
		|skin care     |4|5|3|100 |2|2 |4 |22|12|2022|
		|nail care     |6|7|4|100 |1|3 |4 |1 |1 |2023|
		|bride         |3|4|5|4000|8|10|6 |1 |2 |2023|
	When I miss typing the value of one field or more 
	Then I should see the value of one field or more is empty 
	
Scenario: Wrong number for the service 
	When I type wrong number for the service 
	Then I should see the number for the service is incorrect 
	
Scenario: Wrong number for the year 
	When I type wrong number for the year 
	Then I should see the number for the year is incorrect 
	
	
Scenario: Wrong number for the month 
	When I type  wrong number for the month 
	Then I should see the number for the month is incorrect 
	
Scenario: Wrong number for the day 
	When I type  wrong number for the day 
	Then I should see the number for the day is incorrect 

Scenario: Wrong number for the starting time 
	When I type  wrong number for the starting time 
	Then I should see the number for the starting time is incorrect  
		
Scenario: Wrong number for the ending time 
	When I type  correct number for the starting time but the ending time exceeded the close time 
	Then I should see the number for the starting time and ending time are incorrect  	

Scenario: Conflict in the booking (the appointment you are trying to book is already booked) 
	When I typed the right booking date but there is already another booking on that date
	Then I should see the appointment you are trying to book is already booked
		
Scenario: Another appointment in the same time for the same person 
	When I typed the right booking date but I already have another booking on that date
	Then I should see you already have another booking on that date
	
Scenario: Successful booking 
	When I typed the right booking date without any conflict in the booking and I don't  have another booking on that date 
	Then I should see successful booking 