Feature: Open a new incdent refence via e-mail
  In order to get an incident reference automatically from the helpdesk 
  As a customer
  I want to send an e-mail to a mailbox

  Scenario Outline: E-mail intake
    Given a customer has e-mail address <customer_email>
    And a customer's registration status is <customer_registration>
    When a customer sent an e-mail to <helpdesk_mailbo>
    Then a customer should receive <outcome>

    Examples: Successful
      | customer_email                      | customer_registration | helpdesk_mailbox                | outcome |
      | cornerstone_testcustomer1@gmail.com | valid                 | cornerstone-frontline@gmail.com | success |
      | cornerstone_testcustomer2@gmail.com | valid                 | cornerstone-frontline@gmail.com | success |

    Examples: Fail - not registered
      | customer_email                      | customer_registration | helpdesk_mailbox                | outcome |
      | cornerstone_testcustomer3@gmail.com | invalid               | cornerstone-frontline@gmail.com | fail    |

  Scenario: Incident creation
    Given a customer mail is accepted
    Then an incident should be created

  Scenario: Incident customer details
    Given a customer mail is accepted
    Then the incident should have the customer detail automatically populated

  Scenario: Incident priority
    Given a customer mail is accepted
    Then the incident pririty should be Medium
    
     Scenario: Incident assigned group
    Given a customer mail is accepted
    Then the incident group should match the helpdesk mailbox
    
         Scenario: Incident worklog entry
    Given a customer mail is accepted
    Then the incident should be updated with the e-mail content
    
