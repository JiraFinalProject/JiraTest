@GroupManagement
Feature: I want to test Group Management of Jira

  Scenario Outline: Create groups, assign users, and filter based on roles
    Given I am an admin user with "Junyu Deng" and "12345678"
    When I create group <groupName>
    Then the group <groupName> is successfully created
    When I assign an existing user "Junyu Deng" to the newly created group <groupName>
    Then the assign is successfully performed
    And I can filter user "Junyu Deng" based on the group <groupName>
    Examples:
      | groupName |
      | "Example Group 00" |
