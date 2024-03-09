Feature: Web table app login functionality
  Agile story: User should be to login with correct credentials

  Background:

  @TB
  @web @TB
  Scenario:Positive Login scenario
    Given User is on the Web Table app login page
    When User Enter username: Test
    And User Enter password: Tester
    And User click the login button
    Then Verify URL:
  #Expected: URL should end with “orders”
#https://web-table-2.cydeo.com/login
  @Para @TB
  Scenario:Positive Login scenario (Parameterized)
    Given User is on the Web Table app login page
    When User Enter username "Test"
    And User Enter password "Tester"
    And User click the login button
    Then Verify URL:

  @new @TB
  Scenario: DropDown options verification
    Given user is already logged in to The Web table app
    When user is on the Order page
    Then user sees below options under product dropdown
      | MoneyCog   |
      | Familybea  |
      | Screenable |

#Note: Follow POM and BDD.
  @TB
  Scenario: Payment options verification
    Given user is already logged in to The Web table app
    When  user is on the Order page
    Then user sees Visa as enabled payment option
    Then user sees Mastercard as enabled payment option
    Then user sees American Express as enabled payment option

      #a. Visa
      #b. Mastercard
      #c. American Express
  @OrdPara @TB
  Scenario: Order placement scenario
    Given user is already logged in to The Web table app
    When user is on the Order page
    Then user select the Quantity "12"
    Then user calculate the total amount
    Then user enters Customer name "Huma"
    Then user enter the Street "4906 Beauregard st" City "Alexandria" State "VA" Zipcode "22312"
    Then user select the Payment option "MasterCard" and Card No "123456789122"
    Then user enters Expire date "12/28" of the card
    Then user clicks to Process Order
    Then user is see a new order "Huma" in the table on view all orders page
 # a. Product
 # b. Quantity
 # c. Customer name
 # d. Street
 # e. City
 # f. State
 # g. Zip
  #h. Payment info:
 # i. Card type: Visa/MasterCard/American Express
 # ii. Card No
 # iii. Expire date
  @outlineweb
  Scenario Outline: Order placement scenario
    Given user is already logged in to The Web table app
    When user is on the Order page
    Then user select the Quantity "<Quantity>"
    Then user calculate the total amount
    Then user enters Customer name "<customerName>"
    Then user enter the Street "<street>" City "<city>" State "<state>" Zipcode "<zip>"
    Then user select the Payment option "<cardType>" and Card No "<cardNo>"
    Then user enters Expire date "<expireDate>" of the card
    Then user clicks to Process Order
    Then user is see a new order "<expectedName>" in the table on view all orders page
    Examples:
      | Quantity | customerName | street             | city       | state | zip   | cardType    | cardNo       | expireDate | expectedName |
      | 12       | Huma         | 4906 Beauregard St | Alexandria | VA    | 22312 | Master Card | 123456789122 | 12/28      | Huma    |
    #  | 45       | Mohammad     | 4906 Beauregard St | Alexandria | VA    | 22312 | American express | 123456789552 | 12/26      | Mohammad  |
     # | 5        | Taha         | 4906 Beauregard St | Alexandria | VA    | 22312 | Visa Card        | 123456785532 | 12/28      | Taha      |
