@ClientLoginPageOptions
Feature: Test Face-First client login options functionality

  Background: 
    Given user navigate to the FaceFirst Website
    When user logged in successfully and closed the pop-up
    And click on Portal URL
    And enter client username
    And enter client password

  @UserLogin
  Scenario: Client Login with right username and password
    And click on users button
    Then verify Users text and Enabled text should be displayed
    And click on logout button
	
	@EventLogin
  Scenario: Event Login with right username and password
    And click on event user
    Then verify Event text
    And click on logout button
    
  @Identify&EnrollLogin
  Scenario: Identify & Enroll Login with right username and password
    And click on Identify & Enroll
    Then verify Identify & Enroll text
    And click on logout button
    
  @AccountLogin
  Scenario: Account Login with right username and password
    And click on Account
    Then verify Account text
    And click on logout button
    
 
