@Ignore
Feature: Create incident manually
  In order to respond to customers calling the helpdesk via phone
  As a frontline helpdesk agent
  I want to manually create incident references in the application



  Scenario: Submit incident
    Given a frontline agent has filled in all of the following fields:
    |customer name|priority|description|group|owner|
    |Jeff Long|Critical|Printer has run out of ink|Frontline|Unassigned|
    
    When a frontline agent clicks on the Save button
    Then a frontline agent should receive a message about success
    And a frontline agent should receive a new inciden reference number
    And the incident status should change to Assigned
