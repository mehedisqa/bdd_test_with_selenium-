Feature: features to test google search functionality

  Scenario: Validate google search is working
    Given browser is open
    And   user is on search page
    When  user enters a search text in the search box
    And   hit enter
    Then  user is navigated to search results

