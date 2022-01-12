Feature: Login Test on n11

  Scenario: user should be able to login with correct username and password

    Given user is on login page
    When user enters username and password
    And clicks on login button
    Then user is navigated to the homepage

