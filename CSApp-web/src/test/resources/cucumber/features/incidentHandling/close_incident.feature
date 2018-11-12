Feature: Close incident
  In order to close completed incidents
  As a helpdesk agent
  I want to close an incident

  Background: helpdesk agent logged in and incident is open
    Given a helpdesk agent is logged in
    When a helpdesk agent is on home page
    Then open an incident reference

  Scenario Outline: Close incident
    Given incident is open with status <incident_status>
    When a helpdesk agent changes the incident status to closed
    And a helpdesk agent clicks on Save button
    Then a helpdesk agent should receive <outcome>

    Examples: Positive
      | incident_status | outcome |
      | Resolved        | success |

    Examples: Wrong status to close
      | incident_status | outcome |
      | In Progress     | fail    |
      | Peding          | fail    |
      | Assigned        | fail    |

  Scenario Outline: Send customer update
    Given incident is closed
    Then a customer should receive an e-mail message about the closure of the incident