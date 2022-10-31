Feature: Generating a report for the center 

  I want to generate a report to represent some info about the center


  Scenario: Admin asks to generate a report about the customers
    When Admin asks to generate a report about the customers
    Then The system will generate a report about the customers
    
 
   Scenario: Admin asks to generate a report about the employees
    When Admin asks to generate a report about the employees
    Then The system will generate a report about the employees
    
       
   Scenario: Admin asks to generate a report about the appointments
    When Admin asks to generate a report about the appointments
    Then The system will generate a report about the appointments
    
    
   Scenario: Admin asks to generate a report about the visits
    When Admin asks to generate a report about the visits
    Then The system will generate a report about the visits

   Scenario: Admin asks to generate a report about the services
    When Admin asks to generate a report about the services
    Then The system will generate a report about the services
    
   Scenario: Admin asks to generate a general report
    When Admin asks to generate a general report
    Then The system will generate a general report