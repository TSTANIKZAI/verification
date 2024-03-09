@DataTable
Feature: Cucumber Data Table implementation practices


  Scenario: List of fruits and vegetables i like
    Then User should see below list
      | orange |
      | apple  |
      | mango  |
      | kiwi   |
      | pear   |
      | peach  |

  Scenario: Officer reads data about driver
    Then officer is able to see any data he wants
      | name    | Mohammad     |
      | surname | Stanikzai    |
      | age     | 34           |
      | address | somewhere    |
      | state   | VA           |
      | zipCode | 22312        |
      | phone   | 571-508-9521 |