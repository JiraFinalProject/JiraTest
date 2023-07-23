@projectManagement
Feature: As an admin, I can create a Scrum project and ass user to it and I can create different epics as a team lead user
  Scenario Outline: Project management
    Given I create a user with <name>, <password>, <emailAddress>, <displayName>, and <applicationKeys> as an admin user
    When as an admin user, I create a scrum project with <projectKey>, <projectName>, <projectTypeKey>, <projectTemplateKey>, <description>, <lead>, <url>, <assigneeType>, and apply an existing permission scheme <permissionScheme>
    And as an admin user, I add user <userAccountId> to the current project <projectKey>
    And as a team lead user, I can create different epics such as <epic1>, <epic2>, <epic3>, <epic4>

    Examples:
      | name  | password | emailAddress        | displayName        | applicationKeys | userAccountId | projectKey | projectName     | projectTypeKey | projectTemplateKey                             | description                 | lead    | url                    | assigneeType   | permissionScheme | epic1          | epic2         | epic3          | epic4     |
      | "Eva" | "12345"  | "Eva@atlassian.com" | "Eva of Atlassian" | "jira-core"     | 10002         | "SCP"      | "Scrum Project" | "software"     | "com.pyxis.greenhopper.jira:gh-scrum-template" | "Scrum Project description" | "meina" | "http://atlassian.com" | "PROJECT_LEAD" | 10000            | "Frontend dev" | "Backend dev" | "UI/UX design" | "Testing" |

#Since its is difficult to get the user account id in jira, i set a default user account is as "10002" which the first user created in jira except admin user
  # since team lead is assign to the admin user, they share the same credentials