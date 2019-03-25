Feature: Selendroid Tests
  I want to use this file to test the scenarios for Selendroid app
 	

  Scenario: Navigating to User Registration Screen
    Given I am on the "Selendroid Home" screen
    When I click on "User Registration" button on Home Screen
    Then I land on the "User Registration" screen

  Scenario Outline: User Registration
    Given I am on the "User Registration" screen
    When I fill all the details <username> <email> <password> <name> <language> <termcondition>
    And I click on "Register User" button on Register New User screen
    Then I validate user for <username> <email> <password> <name> <language> <termcondition>

    Examples: 
      | username | email            | password | name  | language | termcondition |
      | User1    | user1@wunder.com | user1    | Mr. user1 | Java     | yes           |
