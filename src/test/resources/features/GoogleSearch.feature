@google
Feature: Google search functionality
  Agile story: As a user, when i am on the google search page. i should be able to search anything and
  see relevant results.

  Scenario: Search page default title verification
    When user is on the Google search page
    Then user should see title is Google



  #command+option+L
  Scenario: Search result title verification
    Given user is on the Google search page
    When user search for apple
    Then  user should see the title
@New
  Scenario: Search result title verification
    Given user is on the Google search page
    When user search for "apple"
    Then  user should see "apple" in the title


