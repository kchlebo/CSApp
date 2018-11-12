@tag
Feature: Open incident
  In order to progress an incident
  As a helpdesk agent
  I want to get all relevant information for the incident

  @tag1
  Scenario: Open incident reference in new tab
    Given a helpdesk agent is logged in
    When a helpdesk agent double clicks on an incident result
    Then a helpdesk agent get the incident opened in a new tab
