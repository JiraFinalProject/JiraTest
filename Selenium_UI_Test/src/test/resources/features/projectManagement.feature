@projectManagement
Feature: As an admin user, I can create a scrum project and add user to the current project and I can create different epics as a team lead user
  Scenario Outline: Testing Project Management
    Given I visit the landing page
    When I enter the username <adminUsername>
    And I enter the password <adminPassword>
    And I click the login button on the login page
    When I click projects tab in the top banner
    And I click create project link
    And I select scrum software development for a software project
    And I click next button in the create project window
    And I click select button in the create project window
    And I enter project name <projectName> in the project name input field
  #  And I enter lead <adminUsername> in the project lead input field
  #<--- jira website new update?? no lead input anymore, default to the user who is creating this project as lead
    And I click submit button to to submit project creation

    When I click administrator setting link at the top banner
    And I click the issues in the drop down menu
    When I enter the admin password <adminPassword>
    And I click confirm button for authentication

    And I click issue type schemes link at the side bar
    And I click associate link of the first existing issue type schemes
    And I select the new project <projectName> in the projects list
    And I click associate button to complete association of current scheme to the new project

    When I click projects link in administration
    And I click the new project <projectName> in projects list
    And I click users and roles in project settings side bar
    And I click add users to role button
    And I enter user <username> and press return in search bar of add users to a role dialog
    And I enter a role <role> and press return
    And I click add button in the add users to a role dialog

    When as a team lead, I click create issue button on the top banner
    #And I enter project name <projectName> in the project name input field of create issue dialog
    #And I enter epic name <epic1> in the epic name input
    And I enter summary of this epic <epic1>
    And I click create button on the create issue dialog

    When as a team lead, I click create issue button on the top banner
    #And I enter project name <projectName> in the project name input field of create issue dialog
    #And I enter epic name <epic2> in the epic name input
    And I enter summary of this epic <epic2>
    And I click create button on the create issue dialog

    When as a team lead, I click create issue button on the top banner
    #And I enter project name <projectName> in the project name input field of create issue dialog
    #And I enter epic name <epic3> in the epic name input
    And I enter summary of this epic <epic3>
    And I click create button on the create issue dialog

    When as a team lead, I click create issue button on the top banner
    #And I enter project name <projectName> in the project name input field of create issue dialog
    #And I enter epic name <epic4> in the epic name input
    And I enter summary of this epic <epic4>
    And I click create button on the create issue dialog


    Examples:
      | adminUsername | adminPassword     | projectName     | leadUsername    | username  | role            | epic1          | epic2         | epic3          | epic4     |
      | "Junyu Deng"       | "12345678" | "Scrum Project" | "Junyu Deng"         | "Charlie" | "Administrator" | "Frontend dev" | "Backend dev" | "UI/UX design" | "Testing" |


#    pre-condition: the user "Charlie" already exist, by doing the "User Management" scenario first