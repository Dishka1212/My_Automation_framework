Feature: User Authentication

  Scenario: Successful login with standard user
    Given the user is on the login page
    When the user logs in with username "standard_user" and password "secret_sauce"
    Then the user should see the products page
