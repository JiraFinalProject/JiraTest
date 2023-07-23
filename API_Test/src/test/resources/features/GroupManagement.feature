Feature: I want to test Group Management of Jira

  Scenario Outline: Create groups, assign users, and filter based on roles
    Given I am an admin user with "MaxYang" and "MaxYang2023"
    When I create group <groupName>
    Then the group <groupName> is successfully created
    When I assign an existing user "MaxYang" to the newly created group <groupName>
    Then the assign is successfully performed
    And I can filter user "MaxYang" based on the group <groupName>
    Examples:
      | groupName |
      | "Example Group 00" |
