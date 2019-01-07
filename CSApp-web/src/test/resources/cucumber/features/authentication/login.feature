@Login @UI
Feature: Login via the homepage
  Description: Login using the UI

  Background: 
    Given user opens a browser
    When user enters the Cornerstone webapplication url
    Then user should be navigated to the login page


  Scenario: Login as Guest
    When user clicks on the Login as Guest button
    Then user should be navigated to the homepage

  Scenario Outline: Login with credentials
    Given user has entered <username> username
    And user has entered <password> password
    When user clicks on the Login button
    Then user <maybe> be navigated to the homepage

    Examples: 
      | username | password | maybe      |
      | test     | test     | should     |
      |          |          | should not |
      | test     |          | should not |
      |          | test     | should not |
