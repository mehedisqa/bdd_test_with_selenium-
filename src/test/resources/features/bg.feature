@sanity
Feature: Check home screen functionalities

  Background: user is logged in
    Given user in the login screen
    When  user enters username and password
    And   clicks on login button
    Then  user is navigated to the home screen

  Scenario: check logout link
    When  user click on welcome link
    Then  logout option is visible

  Scenario: check the quick launch toolbar is present
    When  user click on dashboard screen






