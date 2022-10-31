Feature: Edit Appointment

  
   Scenario: wrong entered id for appointment or the customer doesn't have any
    When customer wants to edit the appointment
    And customer enters wrong appointment id
    Then the appointment will not be edited and it will give a message telling the appointment number enetred is wrong
   
  Scenario: wrong year number scenario
    When customer enters wrong year
    Then the appointment will not be edited and it will give a message telling the year number enetred is wrong
 
   Scenario: wrong month number scenario
    When customer enters wrong month
    Then the appointment will not be edited and it will give a message telling the month number enetred is wrong

   Scenario: wrong day number scenario
    When customer enters wrong day
    Then the appointment will not be edited and it will give a message telling the day number enetred is wrong

  
    Scenario: wrong staring hour scenario
    When customer enters wrong starting hour
    Then the appointment will not be edited and it will give a message telling the staring hour number enetred is wrong


   Scenario: right starting hour, right date scenario
    When customer enters right starting hour
    Then the appointment will be edited and it will give a message telling the appointment is edited successfully
 