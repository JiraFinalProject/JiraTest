@userManagement
Feature: As an admin user I can create a user, deactivate a user, and assign user to a user group
  Scenario Outline: Testing User Management
    Given I visit the landing page
    When I enter the username <adminUsername>
    And I enter the password <adminPassword>
    And I click the login button on the login page
    When I click administrator setting link at the top banner
    And I click the user management in the drop down menu
    Then I should view the user browser page for authentication
    When I enter the admin password <adminPassword>
    And I click confirm button for authentication
    And I click create user button on the authentication page
    Then I should view the add user page
    When I enter email address <emailAddress>, full name <displayName>, username <name>, password <password>
    And I click create user button on the user creation page
    And I click the edit link of the new user <name> on the user browser page
    And I click the active checkbox to uncheck active status
    And I click update button of the edit user profile form to submit status change
    And I click the status filter menu
    And I click inactive status
    And I press enter on filter text input
    Then I should view the user <name> in the result set
    When I reset the user filter
    And I reactivate the user <name> status
    And I click the full name of user <name> in the users list
    And I click the manage groups button on view user page
    And I enter group name <groupName> in the search bar and press return
    And I click join selected groups button
    And I click the user management button to go back to user management page
    And I apply the group filter <groupName> and return the search
    Then I should view the user <name> in the result set

    Examples:
      | adminUsername | adminPassword     | name      | password      | emailAddress            | displayName            | applicationKeys | groupName             |
      | "meina"       | "bEW$4@Aue3AGkG3" | "Charlie" | "abracadabra" | "charlie@atlassian.com" | "Charlie of Atlassian" | "jira-core"     | "jira-administrators" |

#    run "User Management" scenario before "Project Management" scenario