@userManagement
Feature: As an admin, I want to create a user and deactivate the user
  Scenario Outline: User management API Test
    When I create a user with <name>, <password>, <emailAddress>, <displayName>, and <applicationKeys> as an admin user
    And I deactivate a user <name>
    And I apply the user status filter on user <name>
    Then I should view the user <name> in the deactivated users result set
    When I add a user <name> to a group <groupName>
    And I apply the group filter <groupName>
    Then I should view the user <name> in the result set

    Examples:
      | name      | password      | emailAddress            | displayName            | applicationKeys | groupName             |
      | "Charlie" | "abracadabra" | "charlie@atlassian.com" | "Charlie of Atlassian" | "jira-core"     | "jira-software-users" |