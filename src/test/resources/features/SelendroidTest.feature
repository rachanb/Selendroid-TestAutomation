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
      | User1    | user1@wunder.com | pass1    | User1 | Java     | yes           |

	Scenario: Navigating to Web View Interaction
    Given I am on the "Selendroid Home" screen
    When I click on "Display Text View" button on Home Screen
    Then I get to see the text on screen

  Scenario: Navigating to Web View Interaction
    Given I am on the "Selendroid Home" screen
    When I click on "Start Web View" button on Home Screen
    Then I land on the "Web View" screen

  Scenario: Navigating to Webdriver Test File popup
    Given I am on the "Web View" screen
    When I click on "Start Web View" button on Web View
    Then I land on the "Webdriver Test File" pop on Web View
