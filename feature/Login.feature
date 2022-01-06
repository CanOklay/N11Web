Feature: Login Test on n11

  Scenario: user should be able to login with correct username and password
    Given user is on the login page
    When user enters correct username and password
    Then user gets confirmation
