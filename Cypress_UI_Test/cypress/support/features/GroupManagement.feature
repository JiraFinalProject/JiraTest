Feature: I want to test Group Management of Jira Software

    Scenario: Admin User Can Create Groups, Assign Users, and Filter by the group
        
        Given I am logged in as an admin user with username "MaxYang" and password "MaxYang2023"

        When I navigate to the group management page with password "MaxYang2023"
        And I create the group "TestGroup"
        Then the "TestGroup" group should be created successfully

        When I assign the user "MaxYang" to the "TestGroup" group
        Then the user "MaxYang" should be assigned to the "TestGroup" group successfully
        And I can select users based on the group "TestGroup"


