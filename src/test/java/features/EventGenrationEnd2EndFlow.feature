Feature: Test Face-First client login functionality

  @EventGenrationEnd2EndFlow
  Scenario: Verify Event Genration End 2 End flow
    Given user navigate to the FaceFirst Website
    When user logged in successfully and closed the pop-up
    And click on Portal URL
    
    And user login in clint login page
    Then verify user successful login
    
    When user click on visitors menu iteam
    Then visitor tab is opened
    When user click on criminal visitor photo
    Then visitor photo view tab is opened
    When user click on Identify within Enrollments
    Then Identify and Enroll tab is opened
    When visitor photo is no matches found then Add Details tab is opened
    And user enter all required and optional fields and save the deatils
    Then Enrollment success meassage is displyed
    
    When user navigate to events menu iteam
    Then Event tab is opened
    When same criminal is visiting again
    Then Event should be genrated
   
    
    
    
    
