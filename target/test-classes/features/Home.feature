@HomePage
Feature: Test license key is displayed or not

  Background: 
    Given user navigate to the FaceFirst Website

  Scenario: Login with right username and password
    When user logged in successfully and closed the pop-up
    Then verify if user have no license key then user will enter license key
      
    

 
