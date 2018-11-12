Feature: Show my and my group's incidents
  In order to see relevant incidents quickly
  As a helpdesk agent
  I want to see all incidents assigned to my name or to the group I belong

  Background: Helpdesk agent is logged in

  Scenario: Show all incidents assigned to the user
    Given a helpdesk agent is logged in
    When a helpdesk agent opens the Home page
    Then a helpdesk agent should get all incidents assigned
    And a helpdesk agent should get all their groups incidents
