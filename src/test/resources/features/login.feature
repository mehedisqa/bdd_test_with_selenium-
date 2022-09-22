@SmokeFeature
Feature: feature to test login functionality

  Scenario: Check login with valid credentials
    Given get to the login page
    When  enter username and password
    And   click on login button
    Then  navigate to the home page


