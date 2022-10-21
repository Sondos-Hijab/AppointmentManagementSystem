Feature: booking

	reserve a service

Scenario: 
	Given the user is logged in
	And the data table for services 
		|number|name |
		|1     |hair cut |
		|2     |hair coloring |
		|3     |nails | 
	    |4     |bride | 
	    |5     |skin care|
	And the data table for reservations 
		|number|name |       hour| day|month|year|
		|1     |hair cut |    2  |12   |12  |2022|
		|2     |hair coloring | 5  |1|11|2022|
		|3     |nails |  2  |1|1|2023|
	    |4     |bride |  3 |2|12|2022|
	    |5     |skin care| 4  |3|6|2023|
		 
	#When user enters number of service
	#And I check if the number exists
	#And user enters year
    # And I check if the year is correct
     #And user enters month
      # And I check if the month is correct
       #And user enters day
        #And I check if the day is correct
        #And user enters hour
	#And I check if the hour is correct
	#And i check if there is another appointment in the same time
	
Scenario: wrong number for service
	When I type wrong service number
	Then I should see wrong number
	
Scenario: wrong number for year
	When I type wrong year
	Then I should see wrong year
	
Scenario: wrong number for month
	When I type wrong month
	Then I should see wrong month
	
	
Scenario: wrong number for day
	When I type wrong day
	Then I should see wrong day
	
Scenario: wrong number for hour
	When I type wrong hour
	Then I should see wrong hour
	
Scenario: another appointment in the same time
	When there is an appointment in the same time
	Then there is another apointment	

Scenario: succesful booking
	When I type correct inputs
	Then i should see successful booking
	
	
	