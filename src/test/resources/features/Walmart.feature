Feature: Best Buy search functionality
  Agile story: As a user, when i am on the Best Buy search page. i should be able to search anything and
  see relevant results.
@Wal1
  Scenario: Search result title verification
    Given user is on the Bestbuy page
    When user should search for vacuum
    Then  user should see the bestbuy title