@ProjectRole
Feature: Login functionality
  Scenario Outline: Valid login
    Given I am on the login page
    When I enter <username> and <password>
    Then I click login button
    When I click setting button
    And I click system menu
    And I enter <password>
    Then I click confirm
    When I click project role setting
    And I create lead role with <roleName1> and <roleDescript1>
    Then I click add lead role button
    And I create qa role with <roleName2> and <roleDescript2>
    Then I click add qa role button
    And I create dev role with <roleName3> and <roleDescript3>
    Then I click add dev role button
    When I manage member of a developer role
    Then I add user to dev role

    Examples:
      |     username        |    password     |    roleName1    |     roleDescript1               |    roleName2    |     roleDescript2              |    roleName3    |     roleDescript3              |
      |     "Junyu Deng"    |    "12345678"   |    "team lead"  | "The leader of development team"|  "developer"    | "Role for all developers"      |        "QA"     |  "Role Quality Engineer"       |