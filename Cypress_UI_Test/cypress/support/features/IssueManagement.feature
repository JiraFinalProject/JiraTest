Feature: I want to test Issue Management of Jira Software

    // Background:
        Given I am logged in as an "admin" user with username "MaxYang" and password "MaxYang2023"
        When I create a blocking "Story" type of issue with the summary "This is a blcoking Story issue"
        Then store the key of this issue
        And I create an "Epic" type of issue with the name "Epic-2" and summary "This is the Epic issue"
        And I log out

    Scenario: Manage Issues
        //Given I am logged in as an "team lead" user with username "MaxYang" and password "MaxYang2023"
        //Then I can create a "Story" issue with epic link to "Epic-2", priority 1, and summary "This is the new issue"
        //And I can specify the issue has the relationship "is blocked by" with the blocking issue
        //And I can assign this issue to the user "Charlie"
        //And I log out

        Given I am logged in as an "developer" user with username "Charlie" and password "abracadabra"
        Then I can view the issues assigned to me "Charlie"
        And I can add a comment "This is the comment" to the issue
        //And I can update the comment "This is the updated comment"
        //And I reply to the comment with "This is the reply to the comment"



        
