Feature: Generating an invoice

  I want to generate an invoice for the customer's appointments


  Scenario: Customer doesn't have appointment yet
    When Customer asks for generating an invoice, and he/she doesn't have any appointments yet
    Then The system will tell him/her that he/she should add an appointment first
    
  Scenario: Customer just has one appointment
    Given the customer has an appointment  
    When the customer asks to generate an invoice for it
    Then the customer should see the generated invoice for the appointment
    
    
  Scenario: Customer just has one appointment
    Given the customer has multiple appointments  
    When the customer asks to generate an invoice for them
    Then the customer should see the generated invoice for the multiple appointment 