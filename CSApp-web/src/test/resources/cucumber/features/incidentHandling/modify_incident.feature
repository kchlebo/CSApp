Feature: Modify an existing incident
  In order to reflect the changes in real life about a problem 
  As a frontline agent
  I want to modify details of the incident

  Background: Incident open
    Given a helpdesk agent has the Search Incident page open
    When a helpdesk agent opens a result
    Then a helpdesk agent should be navigated to the incident view

  Scenario Outline: Change field values
    Given a helpdesk agent has open an incident with reference <incident_id>
    When a helpdesk agent modifies the field <field_name> from <current_value> to <new_value>
    Then a helpdesk agent should receive outcome: <outcome>

    Examples: Change customer details
      | incident_id | field_name    | current_value | new_value  | outcome |
      | INC0000001  | Customer name | John Doe      | Joe Bloggs | success |

    Examples: Change priority
      | incident_id | field_name | current_value | new_value | outcome |
      | INC0000001  | Priority   | Critical      | Medium    | success |

    Examples: Change assignee
      | incident_id | field_name | current_value | new_value    | outcome |
      | INC0000001  | Assignee   | Alice Springs | John Wattson | success |

    Examples: Change status
      | incident_id | field_name | current_value | new_value   | outcome |
      | INC0000001  | Status     | Assigned      | In progress | success |

  Scenario: Add incident worklog
      Given a helpdesk agent has open an incident with reference <incident_id>
      When a helpdesk agent clicks on the Add incident worklog button
      And provides the following update:
      """
      The incident is rapdidly progressing.
      """
      Then a helpdesk agent should receive a feedback about the update
      And the incident worklog should be updated with the update message
