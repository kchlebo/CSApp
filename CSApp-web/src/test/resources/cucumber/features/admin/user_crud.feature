Feature: User administration on the system
  Create, Read, Update, Delete a user

  Scenario: Add new user
    Given an admin user is on the Add user screen
    And an admin user has filled in all fields
    When an admin user clicks on the Add button
    Then create the user in the system
    And an admin user should get the message that user has been created

  Scenario: Read user
    Given an admin user has opened a user entry
    Then an admin user should get all details for the user entry

  Scenario: Update user
    Given an admin user has opened a user entry
    And an admin user has changed a field
    When an admin user clicks on the Save button
    Then update the user in the system
    And an admin user should get the message that user has been modified

  Scenario: Delete user
    Given an admin user has opened a user entry
    When an admin user clicks on the Delete button
    Then mark the user as deleted in the system
    And an admin user should get the message that user has been deleted
