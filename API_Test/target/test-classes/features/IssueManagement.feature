@IssueManagement
Feature: I want to test Issue Management of Jira
  Background:
    Given I am an admin user with "Junyu Deng" and "12345678"
    When Create an epic
    Then the epic is successfully created
    And store the key to this epic
    When Create a blocking issue
    Then the issue is successfully created
    And store the blocking issue

  Scenario: Manage Issues
    Given I am an admin user with "Junyu Deng" and "12345678"

    When I create an issue with priority "2" and epic link to the epic created before
    Then the issue is successfully created

    When I specify that the new issue is blocked by the blocking issues
    Then the dependency is set successfully

    When I assign the new issue to the user "Junyu Deng"
    Then the assign is successfully created

    Given I am a developer user with "Junyu Deng" and "12345678"

    When I view all the issues assigned to me "Junyu Deng"
    Then view all my issues successfully

    When I add a comment "This is the comment from Junyu Deng" to the issue
    Then the comment is successfully created by me "Junyu Deng"
    And store the id of the comment

    When I edit the comment "This is the updated comment from Junyu Deng" of the issue
    Then the comment is successfully updated

    When I reply to the updated comment "This is the reply to the updated comment from Junyu Deng"
    Then the reply is successfully created

