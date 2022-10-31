Feature: Deleting an appointment

  Scenario: Appointment id is wrong
    When Customer asks to delete an appointment and enters wrong id
    Then The system will give a message telling that the id is wrong
    
  Scenario: Appointment id is right and the deletion went successfully
    When Customer asks to delete an appointment and enters right id
    Then The system will give a message telling that the appointment is deleted successfully