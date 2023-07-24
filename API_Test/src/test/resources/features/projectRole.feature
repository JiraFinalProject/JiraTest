@ProjectRole
Feature: I want to test Project Role management of Jira

  Scenario: After I create a project, I can manage the roles
    When I log in as an admin user
    Then I can create team lead project roles
    Then I can create developer project roles
    Then I can create qa project roles
    When I add existing user to a project role
    Then I check the status code
    When I filter users in a project based on their roles
    Then I print out all users
    When I create the permission scheme
    Then I get all permission scheme to validate
    When I assign the scheme to project
    Then I get the scheme of the project