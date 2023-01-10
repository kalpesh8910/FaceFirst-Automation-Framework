@ClientLoginPage
Feature: Test Face-First client login functionality

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
	
  Scenario: Event Login with right username and password
    And click on event user
    Then verify Event text
    And click on logout button
