Feature: Esty Search Functionality

  Scenario: Etsy Title Verification

    Given User is on the etsy home page
    Then User sees title is as expected.
#Expected: Etsy - Shop for handmade, vintage, custom, and unique gifts for everyone
#Note: Follow POM and BDD


  Scenario: Etsy Search Functionality Title Verification (without parameterization)
    Given User is on the etsy home page
    When User types Wooden Spoon in the search box
    And User clicks search button
    Then User sees Wooden Spoon is in the title
 #Note: Follow POM and BDD

  Scenario: Etsy Search Functionality Title Verification (with parameterization)
    Given User is on the etsy home page
    When User types "Wooden Spoon" in the search box
    And User clicks search button
    Then User sees "Wooden spoon - Etsy" is in the title