
#Feature: I want to test Project Role management of Jira
#
#  Scenario: After I create a project, I can manage the roles
#    When I log in as an admin user
#    Then I can create three project roles team lead, developer, QA

@Workflow
Feature: I want to test Workflow Management 3 & 4
  Scenario:
    When I am a developer
    Then I can move issues from To Do to In Progress
    Then I can move issues from In Progress to Resolved
    When I am a QA
    Then I can move issues from Resolved to Closed