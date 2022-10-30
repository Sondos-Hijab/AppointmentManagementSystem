Feature: delete an account

Scenario: the id doesn't exist
 When i type wrong id
 Then i should see the id doesn't exisit
 
 Scenario: valid id
 When i type valid id
 Then deleted successfully