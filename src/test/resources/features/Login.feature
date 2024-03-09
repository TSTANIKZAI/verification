Feature: Library login feature

  User Story:
  As a user, I should be able to login  with correct credentials to different accounts. and dashboard should be
  displayed.
Scenario: Login as librarian
  Given user is on the login  page of the library application
  When  user enters librarian username
  And  user enters librarian password
  Then user should see the dashboard

  Scenario: Login as student
    Given user is on the login  page of the library application
    When  user enters student username
    And  user enters student password
    Then user should see the dashboard


  #This is for comment symbols