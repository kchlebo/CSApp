Feature: Modify user profile details
  It should be possible to modify personal details by the user for his/her data and reset the password

  Background: User logged in
    Given a user is logged in
    Then open the User Profile page

  @tag2
  Scenario Outline: Modify personal data
    Given a user selected <field> field
    And the field contains <current_value>
    When a user enter the new value <new_value>
    And a user clicks on the Save button
    Then a user should receive a message, that Save <outcome>

    Examples: 
      | field        | current_value   | new_value        | outcome       |
      | First name   | John            | Joe              | is successful |
      | First name   | John            | J1423oe          | has failed    |
      | Last name    | Doe             | Bloggs           | is successful |
      | Phone number | +44 123 4556789 | telephone        | has failed    |
      | Phone number | +44 123 4556789 | +44 123 98765432 | is successful |

  @tag1
  Scenario Outline: Reset password
    Given a user has entered <new_password> as new password
    And a user has enter <retype_password> as retyped password
    When a user clicks on reset password button
    Then the password reset outcome is <outcome>

    Examples: OK outcome
      | new_password | retype_password | outcome |
      | C00lP3ssw0rd | C00lP3ssw0rd    | ok      |

    Examples: incorrect characters
      | new_password       | retype_password    | outcome |
      | ?.:                | ?.:                | fail    |
      | ;arbitrary command | ;arbitrary command | fail    |

    Examples: retype failure
      | new_password | retype_password | outcome |
      | test         | test1           | fail    |
