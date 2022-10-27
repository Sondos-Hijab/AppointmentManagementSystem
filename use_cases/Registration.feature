Feature: Register
 the customer wants to create an account 
 
Scenario: 
	Given the customer in Registration page
	And the data table for customers is
	    |id | username | email |password|phone number|
		|1  | saba | saba2007@gmail.com|saba2007|598667006|
		
		
    Scenario: username  is used before
	When customer enters used  username
	Then the customer should see the user name is already used
	
	Scenario: email is used before
	When customer enters used  email
	Then the customer should see the user e is already used
	
Scenario: wrong email syntax
	When customer enters wrong  email
	Then the customer should see wrong email syntax
	
Scenario: weak password(strong password should contain at least 8 chars and one of them is number)
	When customer enters wrong password
	Then the customer should see weak password
	
	
Scenario: successful registration
	When  customer enters valid input
	Then the customer account is created