@DeployPage
Feature: Test Face-First deployment wizerd functionality

  Background: 
    Given user navigate to the FaceFirst Website

  @Deploy
  Scenario: Login with right username and password
  	When user logged in successfully and closed the pop-up
    When click on deployment wizerd
    And user select all in one deployment type
    And click on next button
    Then user should be navigated to select cameras tab
    And click on next button
    Then user should be navigated to Enter portal settings
    And enter username, password and confirm password
    And enter email address
    And select timezone
    And click on next button
    Then user should be navigated to Enter system settings
    And enter name
		And select timezone
		And click on next button
		And click on deploy
      
    

 
