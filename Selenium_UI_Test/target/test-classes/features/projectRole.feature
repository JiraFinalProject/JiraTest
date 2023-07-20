Feature: Login functionality
  Scenario Outline: Valid login
    Given I am on the login page
    When I enter <username> and <password>
    Then I click login button

    Examples:
      |     username              |    password     |
      |     "Junyu Deng"          |    "12345678"   |