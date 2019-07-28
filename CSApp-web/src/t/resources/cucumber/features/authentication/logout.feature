@Logout
Feature: Logout user
  Logout an already logged in user

  @UI
  Scenario: Logout user via logout button
    Given a user is already logged in
    When a user clicks on the Logout button
    Then navigate the user to the login page

  @UI
  Scenario: Logged out user sanitation
    Given a user is already logged out
    But a user still has other CSApp pages left open
    When a user performs any activity on the pages
    Then show an error message, saying: The user is already logged out. Please login again.
    And navigate the user to the login page

  Scenario Outline: Logout user after timeout period
    Given a user didn't perform any activity on the application for <notactive> minutes
    Then a user <maybe> be logged out

    Examples: 
      | notactive | maybe      |
      |         5 | should not |
      |        31 | should     |
      |        30 | should not |
      |        45 | should     |
      |        15 | should not |
