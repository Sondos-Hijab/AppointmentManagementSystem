Feature: Edit customer's Information

 
Scenario: the customer enters wrong password
Given the customer is logged in
 When the customer enters wrong password
 Then the customer should see incorrect password
 
 Scenario: the customer wants to edit his email
 When user enters right password and wants to edit the email
 Then the customer should see the email has been edited
 
 Scenario: the customer wants to edit his password
 When user enters right password and wants to edit the password
 Then the customer should see the password has been edited
 
 Scenario: the customer wants to edit his phone number
 When user enters right password and wants to edit the phone number
 Then the customer should see the phone number has been edited
 
