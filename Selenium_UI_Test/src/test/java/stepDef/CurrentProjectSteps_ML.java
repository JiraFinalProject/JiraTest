package stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import page_object_model.CurrentProjectPO_ML;

public class CurrentProjectSteps_ML {
    private final CurrentProjectPO_ML currentProjectPO = new CurrentProjectPO_ML();
    @And("I click users and roles in project settings side bar")
    public void iClickUsersAndRolesInProjectSettingsSideBar() {
        currentProjectPO.clickUsersAndRolesLink();
    }

    @And("I click add users to role button")
    public void iClickAddUsersToRoleButton() {
        currentProjectPO.clickAddUsersToARoleBtn();
    }

    @And("I enter user {string} and press return in search bar of add users to a role dialog")
    public void iEnterUserUsernameInSearchBarOfAddUsersToARoleWindow(String username) throws InterruptedException {
        currentProjectPO.enterUserOrGroupsInput(username);
    }

    @And("I enter a role {string} and press return")
    public void iEnterARoleRoleAndPressReturn(String role) {
        currentProjectPO.enterRoleInputAndPressReturn(role);
    }

    @And("I click add button in the add users to a role dialog")
    public void iClickAddButtonInTheAddUsersToARoleDialog() {
        currentProjectPO.clickAddBtnForAddingUser();
    }

    @When("as a team lead, I click create issue button on the top banner")
    public void iClickCreateButtonOnTheTopBanner() throws InterruptedException {
        currentProjectPO.clickIssueCreateLink();
    }

    @And("I enter project name {string} in the project name input field of create issue dialog")
    public void iEnterProjectNameProjectNameInTheProjectNameInputFieldOfCreateIssueDialog(String projectName) {
        currentProjectPO.enterProjectNameInputAndPressReturn(projectName);
    }

    @And("I enter epic name {string} in the epic name input")
    public void iEnterEpicNameEpicInTheEpicNameInput(String epicName) {
        currentProjectPO.enterEpicNameInput(epicName);
    }

    @And("I enter summary of this epic {string}")
    public void iEnterSummaryOfThisEpicEpicName(String epicName) {
        currentProjectPO.enterSummaryInput(epicName);
    }

    @And("I click create button on the create issue dialog")
    public void iClickCreateButtonOnTheCreateIssueDialog() {
        currentProjectPO.clickCreateIssueBtn();
    }


}
