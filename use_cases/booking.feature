Feature: booking

  I want to book an appointment in the beauty center


  Scenario: empty field
  	When The system asks to enter the service that I want 
    And I leave the service number field empty 
    Then I should see a required field is empty
    
  Scenario: wrong enetred service number
    When I type wrong service number
    Then I should see a message telling that the service number is wrong

    
  Scenario: wrong year number
    When I type wrong year number 
    Then I should see a message telling that the year number is wrong

 
    
  Scenario: wrong month number
    When I type wrong month number
    Then I should see a message telling that the month number is wrong
    
  Scenario: wrong day number
	When I type wrong day number
    Then I should see a message telling that the day number is wrong
    
  Scenario: wrong hour number
	When I type wrong hour number
    Then I should see a message telling that the hour number is wrong
    
    
   Scenario: another appointment in the same time for the same person
	When I type right appointment number but I have another appointment at the same time
    Then I should see a message telling that I have another appointment at the same time
    
    
   Scenario: there was a conflict in the booking
	When I type right appointment number and there was a conflict in the booking
    Then I should see a message telling that there is a conflict 
    
   Scenario: Successfull Booking
	When I type right appointment number 
    Then I should see a message telling that the appointment is confirmed
    And The system will book the appointment and will appear in the admin's and employee's calendar 
    And the appointment will be saved in the record of the customer's appointments
