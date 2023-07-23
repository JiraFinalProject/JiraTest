#Feature: Login functionality
#  Scenario Outline: Valid login
#    Given I am on the login page
#    When I enter <username> and <password>
#    Then I click login button
#
#    Examples:
#      |     username              |    password     |
#      |     "Junyu Deng"          |    "12345678"   |

  Feature: Workflow Management 1 & 2
    Scenario Outline:
      Given I am on the login page
      When I enter <username> and <password>
      And I click login button
      And I click the Administration icon
      And I click on Issues
      And I put in <password>
      And I click on confirm button
      And I click on Workflows on the left
      And I click on Add workflow
      And I type in the name of the workflow <workflowName>
      And I click Add button
      And I click on Add Status button
      And I type in To Do
      And I select the To Do item in the drop down menu
      And I click on Confirm Add Button
      And I click on Add Status button for in progress
      And I type in In Progress
      And I select the In Progress item in the drop down menu
      And I click on Confirm Add Button
      And I click on Add Status button for resolved
      And I type in Resolved
      And I select the In Resolved item in the drop down menu
      And I click on Confirm Add Button
      And I click on Add Status button for closed
      And I type in Closed
      And I select the In Closed item in the drop down menu
      And I click on Confirm Add Button

      And I click on Add Transition Button
      And I choose From Status to be Open
      And I choose To Status to be To Do
      And I name the transition transition 1
      And I click Transition Add button

      And I click on Add Transition Button
      And I choose From Status to be To Do
      And I choose To Status to be In Progress
      And I name the transition transition 2
      And I click Transition Add button

      And I click on Add Transition Button
      And I choose From Status to be In Progress
      And I choose To Status to be Resolved
      And I name the transition transition 3
      And I click Transition Add button

      And I click on Add Transition Button
      And I choose From Status to be Resolved
      And I choose To Status to be Closed
      And I name the transition transition 4
      And I click Transition Add button



      When I click on profile icon

      And click on Boards

      And click on Board drop down menu

      And click on Create Board
#    //a[@role='menuitem'][normalize-space()='Create board']
      And click on Create a Scrum board button
#    //button[@id='ghx-wizard-methodology-scrum']
      And select board from an existing project
#    //label[@for='ghx-wizard-method-existing-project']
      And click Next
#    //button[@class='button-panel-button aui-button aui-button-primary js-wizard-button-next']
      And enter the name of the board <boardName>
#    //input[@id='ghx-wizard-project-board-name']

#      And enter the project name
#      //hit enter
#    //textarea[@id='ghx-wizard-choose-project-textarea']
      And click the Create board button
#      ////button[@class='button-panel-button aui-button aui-button-primary js-wizard-button-complete']
      And click on Board drop down menu
      And click on Configure
#    //a[normalize-space()='Configure']
      And click on Columns
#    //a[normalize-space()='Columns']
      And click on Add Column button
#    //button[@id='ghx-config-addcolumn']
      And type in the column name Resolved
#    //input[@id='ghx-column-name']
      And click the column add button
#    //button[@class='button-panel-button aui-button']



#      And update the column name from Done to Closed
#    //h3[@title='Done']

      And click on Add Column button
#    //button[@id='ghx-config-addcolumn']
      And type in the column name Closed
#    //input[@id='ghx-column-name']
      And click the column add button

      And delete Done Column



      And I can drag an issue from To Do to In Progress
#      to perform drag and drop (to do to in progress)
#      drag
#    //div[@data-statusid=10000]
#      drop
#    (//ul[@data-column-id="16"])



      And I can drag an issue from In Progress to Resolved
#(in progress to resolved)
#drag
#    //div[@data-statusid=10000]
#      drop
#    (//ul[@data-column-id="18"])

      And I can drag an issue from Resolved to Closed
#    drag
#    //div[@data-statusid=10000]
#    drop
#    (//ul[@data-column-id="17"])



      Examples:
      |   username         |   password         |   workflowName  |   boardName      |
      |   "usernameyang"   |   "passwordyang"   |   "workflow89"   |   "boardName67"   |
