Feature: Converting an appointment to a visit

  I want to convert the appointment of a customer to visit that will be save in the system and in the record of the customer


  Scenario: Wrong username
	Given the customer has an appointment and the employee wants to convert it to a visit
    When The employee types the username of the customer and the appointment id and the feedback and the username isn't in our record 
    Then The employee should see username is not found
    
  Scenario: Wrong appointment id
    Given the customer has an appointment and the employee wants to convert it to a visit
    When The employee types wrong appointment id
    Then the employee should see appointment id is wrong
    
    Scenario: The appointment is n't assigned for today
    Given the customer has an appointment and the employee wants to convert it to a visit but at a different day
    When The appointment date isn't today
    Then the employee should see can't convert it to a visit because it should be today
    
  Scenario: Converting went successfully
    Given the customer has an appointment and the employee wants to convert it to a visit
    When Employee types right customeer username, right appointment id
    Then A visit for the appointment will be added to the customer visits record and to the system visits record
    And The employee should see Converting appointment to a visit went successfully 