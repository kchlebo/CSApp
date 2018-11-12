Feature: Search for incidents
  In order to see specific incidents
  As a helpdesk agent
  I want to be able search for incidents using different parameters

  Scenario: Search using incident id
    Given a helpdesk agent has the search incident page open
    When a helpdesk agent provides an incident id in the search field
    Then a helpdesk agent receives the same incident id in the results table

  Scenario: Search using parameters
    Given the following incidents exist on the system
      | status      | customer_name | priority |
      | In progress | John Doe      | critical |
      | Resolved    | Joe Bloggs    | medium   |
      | Closed      | Barbara Hanna | high     |
    When a helpdesk agent searches with following parameters
      | status      | customer_name | priority |
      | In progress |               | critical |
      | Resolved    |               | high     |
    Then a helpdesk agent should see the following result
      | status      | customer_name | priority |
      | In progress | John Doe      | critical |
