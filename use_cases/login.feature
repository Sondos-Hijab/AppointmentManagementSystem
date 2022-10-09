Feature: Login

  I want to login on Beauty Center Website


  Scenario: Wrong password
    When I type right username, wrong password and select the right user type
    Then I should see password is incorrect
    
  Scenario: Wrong password and username
    When I type wrong username, wrong password
    Then I should see password and username are incorrect
    
  Scenario: Wrong username
    When I type wrong username, right password and right user type
    Then I should see username is incorrect   
 
    
  Scenario: Login successfully for admin
    When I type right username, right password and the usertype is an admin
    Then I should be on the admins home page
    And I should see Login successful for admin
    
  Scenario: Login successfully for user 
    When I type right username, right password and the usertype is a user
    Then I should be on the users home page
    And I should see Login successful for user
    
  Scenario: Login successfully for employee 
    When I type right username, right password and the usertype is a employee
    Then I should be on the employees home page
    And I should see Login successful for employee