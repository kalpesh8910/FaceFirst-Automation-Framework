@ClientLoginPage
Feature: Test Face-First client login functionality

  Background: 
    Given user navigate to the FaceFirst Website
    When user logged in successfully and closed the pop-up
    And click on Portal URL

  @ClintLoginPostive
  Scenario: Client Login with right username and password
    And enter client username
    And enter client password
    And press enter button
    Then verify user successful login 

  @ClintLoginNegative
  Scenario: Client Login with wrong username and password
    And enter client wrong username
    And enter client wrong password
    And press enter button
    Then verify the validation message is displyed
