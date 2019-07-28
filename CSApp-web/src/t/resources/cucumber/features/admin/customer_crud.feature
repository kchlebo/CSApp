@Ignore
Feature: Customer administration on the system
  Create, Read, Update, Delete a customer

  Scenario: Add new customer
    Given an admin user is on the Add user screen
    And an admin user has filled in all fields
    When an admin user clicks on the Add button
    Then create the customer in the system
    And an admin user should get the message that customer has been created

  Scenario: Read customer
    Given an admin user has opened a customer entry
    Then an admin user should get all details for the customer entry

  Scenario: Update customer
    Given an admin user has opened a customer entry
    And an admin user has changed a field
    When an admin user clicks on the Save button
    Then update the customer in the system
    And an admin user should get the message that customer has been modified

  Scenario: Delete customer
    Given an admin user has opened a customer entry
    When an admin user clicks on the Delete button
    Then mark the customer as deleted in the system
    And an admin user should get the message that customer has been deleted
